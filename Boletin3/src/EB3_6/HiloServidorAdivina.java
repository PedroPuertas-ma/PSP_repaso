/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EB3_6;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gandalfvaro
 */
class HiloServidorAdivina extends Thread {

    ObjectInputStream in;
    ObjectOutputStream out;
    Socket socket;

    ObjetoCompartido objeto;
    int id;
    int intentos = 0;

    public HiloServidorAdivina(Socket socket, ObjetoCompartido objeto, int id) {
        this.socket = socket;
        this.objeto = objeto;
        this.id = id;

        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            System.out.println("Cliente conectado: " + id);

            Datos datos = new Datos("Adivina un numero entre 1 y 25", intentos, id);
            
            if (objeto.seAcabo()) {
                datos.setCadena("Lo sentimos, el número ya ha sido adivinado");
                datos.setJuega(false);
            }
            
            out.reset();
            out.writeObject(datos);

            while (!objeto.seAcabo() || !(datos.getIntentos() == 5)) {

                int numecli = 0;

                Datos d = (Datos) in.readObject();
                numecli = Integer.parseInt(d.getCadena());

                String cad = objeto.nuevaJugada(id, numecli);
                intentos++;
                datos = new Datos(cad, intentos, id);

                if (objeto.seAcabo()) {
                    datos.setJuega(false);
                    if (id == objeto.getGanador()) {
                        datos.setGana(true);
                    }
                }
                out.reset();
                out.writeObject(datos);

            }

            if (objeto.seAcabo()) {
                System.out.println("Fin del juego");
                System.out.println("\t Desconectando al juegador " + id);
            }
            out.close();
            in.close();
            socket.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}

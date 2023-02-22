/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EB3_6;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author gandalfvaro
 */
public class JugadorAdivina {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String Host = "localhost";
        int Puerto = 6001;
        
        Socket Cliente = new Socket(Host, Puerto);
        ObjectOutputStream out = new ObjectOutputStream(Cliente.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(Cliente.getInputStream());
        

        Scanner sc = new Scanner(System.in);
        String cadena = "";
        
        Datos datos = (Datos) in.readObject();
        int identificador = datos.getIdentificador();
        System.out.println("Id jugador: " + identificador);
        System.out.println(datos.getCadena());
        
        if (!datos.isJuega()) {
            cadena = "*";
        }
        
        while (datos.isJuega() && !cadena.trim().equals("*")) {
            System.out.print("Intento: " + (datos.getIntentos() + 1) + " Introduce número: ");
            cadena = sc.nextLine();
            Datos d = new Datos();
            
            if (!validarCadena(cadena)) {
                continue;
            }
            
            d.setCadena(cadena);
            out.reset();
            out.writeObject(d);
            datos = (Datos) in.readObject();
            System.out.println("\t" + datos.getCadena());
            if (datos.getIntentos() >= 5) {
                System.out.println("\t Juego acabado, no le quedan más intentos");
                cadena = "*";
            }
            if (datos.isGana()) {
                System.out.println("¡Ha ganado! Juego finalizado ");
                cadena = "*";
            } else if (!(datos.isJuega())) {
                System.out.println("Otro jugador ha adivinado el número, juego finalizado");
                cadena = "*";
            }
        }
        out.close();
        in.close();
        sc.close();
        Cliente.close();
    }
    

    private static boolean validarCadena(String cadena) {
        boolean valor = false;
        try {
            Integer.parseInt(cadena);
            valor = true;
        } catch (NumberFormatException e) {
        }
        return valor;
    }
}

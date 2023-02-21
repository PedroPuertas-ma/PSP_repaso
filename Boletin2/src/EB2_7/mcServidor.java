/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EB2_7;

import java.io.*;
import java.net.*;

/**
 *
 * @author gandalfvaro
 */
public class mcServidor {

    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        MulticastSocket servidor = new MulticastSocket();
        String msj;
        byte [] paquete;
        do{
            System.out.println("Envia un mensaje: ");
            msj = teclado.readLine();
            paquete = msj.getBytes();
            DatagramPacket dp = new DatagramPacket(paquete, 0, paquete.length, InetAddress.getByName("224.0.0.4"), 12345);
            servidor.send(dp);
        }while(!msj.equals("*"));
        
        servidor.close();
    }

}

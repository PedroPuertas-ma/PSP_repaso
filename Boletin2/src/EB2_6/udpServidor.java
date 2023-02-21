/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EB2_6;

import java.io.*;
import java.net.*;

/**
 *
 * @author gandalfvaro
 */
public class udpServidor {

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {

        DatagramSocket servidor = new DatagramSocket(12345);

        byte[] paquete = new byte[2048];

        DatagramPacket dpRecivo = new DatagramPacket(paquete, paquete.length);

        servidor.receive(dpRecivo);

        String msj = new String(dpRecivo.getData(), 0, dpRecivo.getLength(), "UTF-8");

        char[] msj_arry = msj.toCharArray();

        int veces = 0;

        for (char car : msj_arry) {

            if (car == 'a' || car == 'A') {
                veces++;
            }
        }
        
        byte [] paquete_envio = String.valueOf(veces).getBytes();

        DatagramPacket dp_envio = new DatagramPacket(paquete_envio, 0, paquete_envio.length, dpRecivo.getAddress(), dpRecivo.getPort());
        
        servidor.send(dp_envio);
        servidor.close(); 
    }

}

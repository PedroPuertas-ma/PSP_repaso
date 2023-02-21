/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EB2_7;

import java.net.*;
import java.io.*;

/**
 *
 * @author gandalfvaro
 */
public class mcCliente {

    public static void main(String[] args) throws IOException {
        MulticastSocket cliente = new MulticastSocket(12345);

        cliente.joinGroup(InetAddress.getByName("224.0.0.4"));

        byte[] pq = new byte[2048];
        String msj;

        do {
            DatagramPacket paquete = new DatagramPacket(pq, pq.length);

            cliente.receive(paquete);

            msj = new String(paquete.getData(), 0, paquete.getLength(), "UTF-8");
            
            System.out.println(msj);
        }while(!msj.equals("*"));
        
        cliente.close();
        
    
    }

}

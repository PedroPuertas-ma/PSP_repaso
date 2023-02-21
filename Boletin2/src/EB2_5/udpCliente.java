/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EB2_5;

import java.io.*;
import java.net.*;

/**
 *
 * @author gandalfvaro
 */
public class udpCliente {
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        
       InetAddress ip = InetAddress.getByName("localhost");
       
       DatagramSocket cliente = new DatagramSocket();
       
       byte [] paquete;
       
       String msj = "Hola, soy el ejercicio anterior basicamente";
       
       paquete = msj.getBytes();
       
       DatagramPacket dp = new DatagramPacket(paquete, 0, paquete.length, ip, 12345);
       
       cliente.send(dp);
       cliente.close();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EB2_5;

import java.net.*;
import java.io.*;
/**
 *
 * @author gandalfvaro
 */
public class udpServidor {
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        InetAddress ip = InetAddress.getByName("localhost");
        
        DatagramSocket servidor = new DatagramSocket(12345, ip);
        
        byte [] paquete = new byte[2048];
        
        DatagramPacket dp = new DatagramPacket(paquete, paquete.length);
        
        servidor.receive(dp);
        servidor.close();
        
        String msj = new String(dp.getData(), 0, dp.getLength(), "UTF-8");
        
        System.out.println("Nº de bytes: "+dp.getLength());
        System.out.println("Contenido: "+msj);
        System.out.println("Puerto: "+dp.getPort());
        System.out.println("Ip cliente:"+dp.getAddress().getHostAddress());        
    }

}

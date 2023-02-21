/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EB2_6;

import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author gandalfvaro
 */
public class udpCliente {
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        
        InetAddress ip = InetAddress.getByName("localhost");
        Scanner in = new Scanner(System.in);
        
        System.out.println("Escribe un Mensaje: ");
        String msj = in.nextLine();
        
        DatagramSocket cliente = new DatagramSocket();
        
        byte [] pq_envio = msj.getBytes();
        
        DatagramPacket paquete_envio = new DatagramPacket(pq_envio, 0, pq_envio.length, ip, 12345);
        
        cliente.send(paquete_envio);
        
        byte [] pq_recibo = new byte[2048];
        
        DatagramPacket paquete_recibo = new DatagramPacket(pq_recibo, pq_recibo.length);
        
        cliente.receive(paquete_recibo);
        cliente.close();
        
        String nLetra = new String(paquete_recibo.getData(), 0, paquete_recibo.getLength(), "UTF-8");
        
        System.out.println("La letra a aparece "+ nLetra+" veces ");
        
        
    }

}

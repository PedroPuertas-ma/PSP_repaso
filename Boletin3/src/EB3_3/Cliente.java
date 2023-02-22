/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE3_3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author gandalfvaro
 */
public class Cliente {
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException, ClassNotFoundException {
        int puerto = 6000;
        InetAddress host = InetAddress.getByName("localHost");
        DatagramSocket client = new DatagramSocket();
        byte [] paquete;
        
        Persona p1 = new Persona(25, "Ximo");
        System.out.println(p1.getEdad());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(p1);
        paquete = baos.toByteArray();
        
        DatagramPacket pq_envio = new DatagramPacket(paquete, 0, paquete.length, host, puerto);
        client.send(pq_envio);
        
        DatagramPacket pq_recibo = new DatagramPacket(paquete, paquete.length);
        client.receive(pq_envio);
        
        ByteArrayInputStream bais = new ByteArrayInputStream(pq_recibo.getData());
        ObjectInputStream in = new ObjectInputStream(bais);
        
        p1 = (Persona) in.readObject();
        
        System.out.println(p1.getEdad());
        
        
        
    }
    
}

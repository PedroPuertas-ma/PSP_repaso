/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE3_3;

import java.net.*;
import java.io.*;
/**
 *
 * @author gandalfvaro
 */
public class Servidor {
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException, ClassNotFoundException {
        
        int puerto = 6000;
        InetAddress host = InetAddress.getByName("localhost");
        byte [] paquete = new byte[1024];
        
        DatagramSocket server = new DatagramSocket(puerto, host);
        DatagramPacket dp = new DatagramPacket(paquete, paquete.length);
        server.receive(dp);
        
        ByteArrayInputStream bais = new ByteArrayInputStream(dp.getData());
        ObjectInputStream in = new ObjectInputStream(bais);
        
        Persona p1 = (Persona) in.readObject();
        
        p1.setEdad(45);
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(p1);
        paquete = baos.toByteArray();
        
        dp = new DatagramPacket(paquete, 0, paquete.length, dp.getAddress(), dp.getPort());
        server.send(dp);
        
        out.close();
        baos.close();
        in.close();
        bais.close();
        server.close();
    }
    
}

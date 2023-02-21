/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE3_4;

import java.net.*;
import java.io.*;
/**
 *
 * @author gandalfvaro
 */
public class Servidor {
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException, ClassNotFoundException {
        int port = 6000;
        InetAddress host = InetAddress.getByName("localhost");
        DatagramSocket server = new DatagramSocket(port, host);
        int x;
        byte [] paquete = new byte[1024];
        DatagramPacket pq_recibo;
        DatagramPacket pq_envio = null;
        Numeros num;
        
        do{
            pq_recibo = new DatagramPacket(paquete, paquete.length);
            server.receive(pq_recibo);
            ByteArrayInputStream bais = new ByteArrayInputStream(pq_recibo.getData());
            ObjectInputStream in = new ObjectInputStream(bais);
            num = (Numeros) in.readObject();
            
            x = num.getX();
            num.setX2((int) Math.pow(x, 2));
            num.setX3((int) Math.pow(x, 3));
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(baos);
            out.writeObject(num);
            paquete = baos.toByteArray();
            
            pq_envio = new DatagramPacket(paquete, 0 ,paquete.length, pq_recibo.getAddress(), pq_recibo.getPort());
            server.send(pq_envio);
            
        }while(x > 0);
        
    }
    
}

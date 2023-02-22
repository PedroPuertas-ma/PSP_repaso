/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE3_4;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author gandalfvaro
 */
public class Cliente {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        Numeros num = new Numeros();
        int port = 6000;
        InetAddress host = InetAddress.getByName("localhost");
        DatagramSocket client = new DatagramSocket();
        DatagramPacket pq_envio;
        DatagramPacket pq_recibo;
        byte [] paquete;
        int x;
        
        do{
            System.out.println("Introduce un número: ");
            x = input.nextInt();
            num.setX(x);
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(baos);
            out.writeObject(num);
            paquete = baos.toByteArray();
            pq_envio = new DatagramPacket(paquete, 0, paquete.length, host, port);
            client.send(pq_envio);
            
            pq_recibo = new DatagramPacket(paquete, paquete.length);
            client.receive(pq_recibo);
            ByteArrayInputStream bais = new ByteArrayInputStream(pq_recibo.getData());
            ObjectInputStream in = new ObjectInputStream(bais);
            
            num = (Numeros) in.readObject();
            System.out.println("Cuadrado: "+num.getX2());
            System.out.println("Cubo: "+num.getX3());
        }while(x > 0);
    }
    
}

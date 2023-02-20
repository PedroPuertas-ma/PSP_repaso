/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EB1_1;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author gandalfvaro
 */
public class main {
    
    public static void main(String[] args) throws UnknownHostException {
        
        InetAddress dir = InetAddress.getLocalHost();
        
        System.out.println("pruebaMétodos con mi dirección");
        pruebaMétodos(dir);
        
        System.out.println("\npruebaMétodos con google.es");
        pruebaMétodos(InetAddress.getByName("www.google.es"));
        
        System.out.println("\nTodas las direcciones asignadas a la máquina: "+InetAddress.getAllByName("www.google.es").toString());
    }

    private static void pruebaMétodos(InetAddress dir) throws UnknownHostException {
        System.out.println("Nombre host: "+dir.getHostName());
        System.out.println("Dirección host: "+dir.getHostAddress());
        System.out.println("Dirección canóniga del host: "+ dir.getCanonicalHostName());
        System.out.println("Nombre: "+ InetAddress.getByName("localhost"));
        System.out.println("Host: "+InetAddress.getLocalHost());
        System.out.println("To String: "+ dir.toString());
    }
}

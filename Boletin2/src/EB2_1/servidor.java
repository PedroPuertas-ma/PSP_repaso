/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EB2_1;

import java.io.IOException;
import java.net.*;
/**
 *
 * @author gandalfvaro
 */
public class servidor {
    public static void main(String[] args) throws IOException {
        
        //Creamos el servidor en el puerto 6000
        ServerSocket servidor = new ServerSocket(6000);
        System.out.println("Servidor escuchando en el puerto: "+ servidor.getLocalPort());
        
        //Aceptamos un cliente
        Socket cliente = servidor.accept();
        
        System.out.println("Puerto local: "+cliente.getPort());
        System.out.println("Puerto remoto: "+cliente.getLocalPort());
        System.out.println("Nombre host/IP: "+cliente.getLocalAddress().toString());
        System.out.println("Host: "+cliente.getLocalAddress().getHostName());
        System.out.println("IP: "+cliente.getLocalAddress().getHostAddress());
        
        cliente.close();
        
        //Aceptamos otro cliente
        Socket cliente2 = servidor.accept();
        
        System.out.println("Puerto local: "+cliente2.getPort());
        System.out.println("Puerto remoto: "+cliente2.getLocalPort());
        System.out.println("Nombre host/IP: "+cliente2.getLocalAddress().toString());
        System.out.println("Host: "+cliente2.getLocalAddress().getHostName());
        System.out.println("IP: "+cliente2.getLocalAddress().getHostAddress());
        
        cliente2.close();
        
        servidor.close();
    }

}

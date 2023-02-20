/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EB2_2;

import java.io.*;
import java.net.*;
/**
 *
 * @author gandalfvaro
 */
public class servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(6000);
        
        System.out.println("Esperando al cliente...");
        Socket cliente = servidor.accept();
        System.out.println("Recibiendo del cliente: ");
        DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
        
        System.out.println(flujoEntrada.readUTF());
        
        DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
        flujoSalida.writeUTF("Saludos desde el Servidor");
        
        cliente.close();
        servidor.close();
    }

}

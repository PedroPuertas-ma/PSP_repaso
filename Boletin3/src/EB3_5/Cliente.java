/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EB3_5;
import java.net.*;
import java.io.*;

/**
 *
 * @author gandalfvaro
 */
public class Cliente {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int puerto = 6000;
        String host = "localhost";
        
        Socket client = new Socket(host, puerto);
        
        String mensaje = "hola soy un mensaje en minusculas que pasará a mayusculas";
        System.out.println(mensaje);
        
        ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
        out.writeObject(mensaje);
        
        ObjectInputStream in = new ObjectInputStream(client.getInputStream());
        mensaje = (String) in.readObject();
        
        System.out.println(mensaje);
        
        in.close();
        out.close();
        client.close();
    }

}

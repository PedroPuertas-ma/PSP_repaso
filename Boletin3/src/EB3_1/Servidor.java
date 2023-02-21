/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EB3_1;

import java.io.*;
import java.net.*;

/**
 *
 * @author gandalfvaro
 */
public class Servidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket servidor = new ServerSocket(6000);
        
        Persona p1 = new Persona("Juan", 17);
        System.out.println(p1.getNombre() + " / " + p1.getEdad());
        
        Socket cliente = servidor.accept();
        ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
        oos.writeObject(p1);
        
        ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
        p1 = (Persona) ois.readObject();
        System.out.println(p1.getNombre() + " / " + p1.getEdad());
        
        ois.close();
        oos.close();
        cliente.close();
        servidor.close();
                
    }

}

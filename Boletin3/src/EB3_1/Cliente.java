/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EB3_1;

import java.net.*;
import java.io.*;

/**
 *
 * @author gandalfvaro
 */
public class Cliente {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket cliente = new Socket("localhost", 6000);
        
        ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
        Persona p1 = (Persona) ois.readObject();
        
        p1.setEdad(18);
        
        ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
        oos.writeObject(p1);
        
        oos.close();
        ois.close();
        cliente.close();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EB3_2;

import java.io.*;
import java.net.*;

/**
 *
 * @author gandalfvaro
 */
public class Servidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket server = new ServerSocket(6000);
        Numeros num;
        int x;
        Socket client = server.accept();
        
        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        
        do{
            num = (Numeros) ois.readObject();
            
            x = num.getNumero();
            num.setCuadrado((long) Math.pow(x, 2));
            num.setCubo((long) Math.pow(x, 3));
            
            oos.writeObject(num);
        }while(x > 0);
        
        oos.close();
        ois.close();
        client.close();
        server.close();        
    }

}

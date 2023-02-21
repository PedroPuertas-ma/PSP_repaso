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
public class Cliente {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket client = new Socket("localhost", 6000);
        Numeros num = new Numeros(0, 0, 0);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ObjectOutputStream oss = new ObjectOutputStream(client.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        
        int x;
        
        do{
            System.out.println("Introduce un numero: ");
            x = Integer.parseInt(br.readLine());
            num.setNumero(x);
            oss.writeObject(num);
            num = (Numeros) ois.readObject();
            System.out.println("Cuadrado del numero: "+ num.getCuadrado());
            System.out.println("Cubo del numero: "+num.getCubo());
            System.out.println("---------------------------------");
        }while(x > 0);
        
        ois.close();
        oss.close();
        br.close();
        client.close();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EB1_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.*;

/**
 *
 * @author gandalfvaro
 */
public class main {
     /*
    Este ejercicio no funciona 
    porque no tengo instalado 
    el servidor web apache
    */
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = new URL("http://localhost/2018/vernombre.php");
        URLConnection urlC = url.openConnection();
        urlC.setDoOutput(true);
        
        PrintWriter pw = new PrintWriter(urlC.getOutputStream());
        
        String cadena = "nombre=Juan&apellidos=Ramos Martín";
        
        pw.write(cadena);
        
        pw.close();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlC.getInputStream()));
        
        while ((cadena = reader.readLine()) != null){
            System.out.println(cadena);
        }
        
        reader.close();
    }

}

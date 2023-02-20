/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EB1_3;

import java.io.*;
import java.net.*;

/**
 *
 * @author gandalfvaro
 */
public class main {
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = new URL("http://www.elaltozano.es/");
        
        InputStream is = url.openStream();
        int c;
        
        while ((c = is.read()) != -1){
            System.out.print((char) c);
        }
    }

}

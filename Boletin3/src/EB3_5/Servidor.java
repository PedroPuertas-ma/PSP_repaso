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
public class Servidor {
    public static void main(String[] args) throws IOException {
        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);
        
        while(true){
            Socket cliente = servidor.accept();
            HiloServidor hilo = new HiloServidor(cliente);
            
            hilo.start();
        }
    }

}

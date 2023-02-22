/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EB3_6;

import java.io.*;
import java.net.*;

/**
 *
 * @author gandalfvaro
 */
public class ServidorAdivina {

    public static void main(String args[]) throws IOException {
        ServerSocket servidor = new ServerSocket(6001);
        
        int numero = (int) (1 + 25 * Math.random());
        System.out.println("numero a adivinar: " + numero);
        ObjetoCompartido objeto = new ObjetoCompartido(numero);
        int id = 0;
        
        while (true) {
            Socket cliente = servidor.accept();
            id++; 
            HiloServidorAdivina hilo = new HiloServidorAdivina(cliente, objeto, id);
            hilo.start();
        }
    }
}

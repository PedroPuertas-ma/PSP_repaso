/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EB3_5;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gandalfvaro
 */
public class HiloServidor extends Thread{
    
    private Socket cliente;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public HiloServidor(Socket cliente) throws IOException {
        this.cliente = cliente;
        this.out = new ObjectOutputStream(cliente.getOutputStream());
        this.in = new ObjectInputStream(cliente.getInputStream());
    }

    @Override
    public void run() {
        try {
            
            String cadena = (String) this.in.readObject();
            cadena = cadena.toUpperCase();
            this.out.writeObject(cadena);
            
            this.out.close();
            this.in.close();
            this.cliente.close();
            
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}

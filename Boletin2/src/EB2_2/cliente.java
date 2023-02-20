/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EB2_2;

import java.io.*;
import java.net.*;
/**
 *
 * @author gandalfvaro
 */
public class cliente {
    public static void main(String[] args) throws IOException {
        Socket cliente = new Socket("localhost", 6000);
        
        DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
        flujoSalida.writeUTF("Saludos desde el cliente");
        
        DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
        System.out.println(flujoEntrada.readUTF());
        
        cliente.close();
    }
}

/*El ejercicio 3 no está porque es esencialmente este pero cambiando localhost por la ip de un compañero*/

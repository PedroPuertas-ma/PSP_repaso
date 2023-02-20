/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EB2_4;

import java.net.*;
import java.io.*;

/**
 *
 * @author gandalfvaro
 */
public class udpEnvio {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        
        //Creamos un DatagramSocket
        DatagramSocket cliente = new DatagramSocket();
        
        //Creamos un InetAddress con la ip en la que vamos a realizar los intercambios de datagramas
        InetAddress ip = InetAddress.getByName("localhost"); //Aquí cambiaríamos localhost por la ip del compañero que sea

        //Mensaje que vamos a enviar y creamos un array de bytes para almacenarlo
        String mensaje = "Saludos de Álvaro";
        byte [] buff = mensaje.getBytes();
        
        //Creamos el DatagramPacket que vamos a enviar, pasandole el buffer, la longitud del buffer,
        // la ip a la que la vamos a enviar y el puerto
        DatagramPacket paquete = new DatagramPacket(buff, buff.length, ip, 6000);
        
        //Conectamos el cliente a la ip y al puerto, enviamos el paquete y nos desconectamos
        cliente.connect(ip, 6000);
        cliente.send(paquete);
        cliente.close();
        
    }

}

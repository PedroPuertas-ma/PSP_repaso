/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EB2_4;

import java.io.*;
import java.net.*;

/**
 *
 * @author gandalfvaro
 */
public class udpRecivo {
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        
        //Creamos el InetAddress que nos conecta a la ip donde se realizará 
        // el envío para poder recibirlo.
        
        InetAddress ip = InetAddress.getByName("localHost"); 
        
        //Creamos el DatagramSocket para poder recibir el envio 
        // y lo conectamos a la ip y al puerto correspondiente
        DatagramSocket cliente = new DatagramSocket(6000, ip);
        
        //Creamos el buffer para recibir el paquete
        byte [] buff = new byte[2048]; //lo inicializamos con el máximo de bytes, si no sabes cuanto pon un numero gordo, en este ejemplo podemos recibir un mensaje de hasta 2mb pa' texto es mucho
        
        //Creamos un DatagramPacket para almaenar el paquete recibido
        DatagramPacket paquete = new DatagramPacket(buff, buff.length);
        
        //Recibimos el paquete
        cliente.receive(paquete);
        cliente.close();
        
        //Reconstruimos el mensaje del paquete de la siguiente manera
        //Pasamos los datos, el 0 indica que empieze a leer desde el ppio, la longitud y la codificación del mensaje
        String msj = new String(paquete.getData(), 0, paquete.getLength(), "UTF-8");
        
        //Mostramos los datos del paquete 
        System.out.println("Nº de bytes: "+paquete.getLength());
        System.out.println("Contenido del paquete: "+msj);
        System.out.println("Ip de origen: "+paquete.getAddress().getHostAddress());
        System.out.println("Puerto de destino: "+paquete.getPort());
    }

}

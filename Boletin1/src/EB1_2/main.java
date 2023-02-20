/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EB1_2;

import java.net.*;

/**
 *
 * @author gandalfvaro
 */
public class main {

    public static void main(String[] args) throws MalformedURLException {
        URL url;
        System.out.println("Constructor simple para una URL:");
        url = new URL("http://docs.oracle.com/");
        visualizar(url);
        System.out.println("\nOtro constructor simple para una URL:");
        url = new URL("http://localhost/PFC/gest/cli_gestion.php?S=3");
        visualizar(url);
        System.out.println("\nConst. para protocolo +URL + directorio:");
        url = new URL("http", "docs.oracle.com", "/javase/9");
        visualizar(url);
        System.out.println("\nConstructor para protocolo + URL + puerto + directorio:");
        url = new URL("http", "localhost", 8084, "/WebApp/Controlador?accion=modificar");
        visualizar(url);
        System.out.println("\nConstructor para un objeto URL en un contexto:");
        url = new URL(new URL("https://docs.oracle.com/"), "/javase/9/docs/api/java/net/URL.html");
        visualizar(url);
    }

    private static void visualizar(URL url) {
        System.out.println("to string: "+ url.toString());
        System.out.println("getProtocol(): "+url.getProtocol());
        System.out.println("getHost(): "+url.getHost());
        System.out.println("getPort(): "+url.getPort());
        System.out.println("getFile(): "+url.getFile());
        System.out.println("getUserInfo(): "+url.getUserInfo());
        System.out.println("getPath(): "+url.getPath());
        System.out.println("getAuthority(): "+url.getAuthority());
        System.out.println("getQuery(): "+url.getQuery());
        System.out.println("getDefaultPort(): "+url.getDefaultPort());
    }
}

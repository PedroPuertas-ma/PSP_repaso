/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EB3_6;

import java.io.*;

/**
 *
 * @author gandalfvaro
 */
public class Datos implements Serializable {

    String cadena; 
    int intentos; 
    int id; 
    boolean gana;
    boolean juega; 

    public Datos(String cadena, int intentos, int id) {
        this.cadena = cadena;
        this.intentos = intentos;
        this.id = id;
        this.gana = false;
        this.juega = true;
    }

    public Datos() {
        super();
    }

    public boolean isJuega() {
        return juega;
    }

    public void setJuega(boolean juega) {
        this.juega = juega;
    }

    public boolean isGana() {
        return gana;
    }

    public void setGana(boolean gana) {
        this.gana = gana;
    }

    public int getIdentificador() {
        return id;
    }

    public void setIdentificador(int identificador) {
        this.id = identificador;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
}

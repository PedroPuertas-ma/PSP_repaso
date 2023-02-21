/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EB3_2;

import java.io.Serializable;

/**
 *
 * @author gandalfvaro
 */
public class Numeros implements Serializable{
    int numero;
    long cubo;
    long cuadrado;

    public Numeros() {
    }

    public Numeros(int numero, long cubo, long cuadrado) {
        this.numero = numero;
        this.cubo = cubo;
        this.cuadrado = cuadrado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public long getCubo() {
        return cubo;
    }

    public void setCubo(long cubo) {
        this.cubo = cubo;
    }

    public long getCuadrado() {
        return cuadrado;
    }

    public void setCuadrado(long cuadrado) {
        this.cuadrado = cuadrado;
    }
    
    
}

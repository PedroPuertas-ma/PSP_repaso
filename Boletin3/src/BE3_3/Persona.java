/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE3_3;

import java.io.Serializable;

/**
 *
 * @author gandalfvaro
 */
public class Persona implements Serializable{
    
    private int edad;
    private String nombre;

    public Persona(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }    
    
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

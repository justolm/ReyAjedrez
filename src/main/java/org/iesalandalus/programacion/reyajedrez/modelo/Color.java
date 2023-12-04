/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package org.iesalandalus.programacion.reyajedrez.modelo;

/**
 *
 * @author Justo
 */
public enum Color {
    BLANCO("Blanco"), NEGRO("Negro");
    private final String cadenaAMostrar;
   
    private Color (String cadenaAMostrar){
        this.cadenaAMostrar = cadenaAMostrar;
    }

    @Override
    public String toString() {
        return cadenaAMostrar;
    }
}

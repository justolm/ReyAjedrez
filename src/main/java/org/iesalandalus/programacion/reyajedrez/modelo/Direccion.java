/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package org.iesalandalus.programacion.reyajedrez.modelo;

/**
 *
 * @author Justo
 */
public enum Direccion {
    NORTE ("Norte"),
    NORESTE("Noreste"),
    ESTE("Este"),
    SURESTE("Sureste"),
    SUR("Sur"),
    SUROESTE("Suroeste"),
    OESTE("Oeste"),
    NOROESTE("Noroeste"),
    ENROQUE_CORTO("Enroque corto"),
    ENROQUE_LARGO("Enroque largo");
    private final String direccionAMostrar;

    Direccion(String direccionAMostrar) {
        this.direccionAMostrar = direccionAMostrar;
    }

    @Override
    public String toString() {
        return direccionAMostrar;
    }
}

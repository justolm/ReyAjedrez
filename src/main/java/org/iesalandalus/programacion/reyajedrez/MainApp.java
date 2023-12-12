package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Color;
import org.iesalandalus.programacion.reyajedrez.modelo.Direccion;
import org.iesalandalus.programacion.reyajedrez.modelo.Posicion;
import org.iesalandalus.programacion.reyajedrez.modelo.Rey;

import javax.naming.OperationNotSupportedException;

import static org.iesalandalus.programacion.reyajedrez.Consola.*;

public class MainApp {
    public void main(String[] args) {
        try{
            ejecutarOpcion();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static class rey {
        private static Color color;
        private Posicion posicion;
        private int totalMovimientos;
    }
    public void ejecutarOpcion(){
        int opcion = elegirOpcionMenu();
        switch (opcion){
            case 1 -> crearReyDefecto();
            case 2 -> System.out.println("Pendiente de crear");// Crear el rey eligiendo el color
            case 3 -> mover();
            case 4 -> despedirse();
            default -> throw new IllegalStateException("Ha elegido una opción no válida: " + opcion);
        }
    }
    private void crearReyDefecto(){
        new Rey();
        return;
    }

    private void crearReyColor(Color color){
        new Rey(color);
    }
    private void mover(){
        Direccion direccion = null;
        direccion = Consola.elegirDireccion();

        try {
            //Rey.mover(direccion);
        } catch (OperationNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    private void mostrarRey (Rey rey){
        try{
            Rey.getColor();
            Rey.getPosicion();
        }catch (OperationNotSupportedException e) {
            throw new RuntimeException("El rey no está creado.");
        }
    }
}

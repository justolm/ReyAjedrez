package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Color;
import org.iesalandalus.programacion.reyajedrez.modelo.Direccion;
import org.iesalandalus.programacion.reyajedrez.modelo.Posicion;
import org.iesalandalus.programacion.reyajedrez.modelo.Rey;

import javax.naming.OperationNotSupportedException;

import static org.iesalandalus.programacion.reyajedrez.Consola.elegirDireccion;
import static org.iesalandalus.programacion.reyajedrez.Consola.elegirOpcionMenu;

public class MainApp {
    public static void main(String[] args) {

    }
    public static class rey {
        private static Color color;
        private Posicion posicion;
        private int totalMovimientos;
    }
    public int ejecutarOpcion(){
        elegirOpcionMenu();
        switch (opcion){
            case 1 -> // Crear el rey por defecto
            case 2 -> // Crear el rey eligiendo el color
            case 3 -> // Mover
            case 4 -> // Salir
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
            Rey.mover(direccion);
        } catch (OperationNotSupportedException e) {
            throw new RuntimeException(e);
        }

    }
}

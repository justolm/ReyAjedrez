package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Color;
import org.iesalandalus.programacion.reyajedrez.modelo.Direccion;
import org.iesalandalus.programacion.reyajedrez.modelo.Rey;

import javax.naming.OperationNotSupportedException;

import static org.iesalandalus.programacion.reyajedrez.Consola.*;

public class MainApp {
    private static Rey rey;
    public static void main(String[] args) {
        int opcion=0;
        do {
            try{
                Consola.mostrarMenu();
                opcion = elegirOpcionMenu();
                ejecutarOpcion(opcion);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (opcion != 4);

    }

    public static void ejecutarOpcion(int opcion)  throws NullPointerException, IllegalArgumentException {
        switch (opcion){
            case 1 -> {
                if (rey == null) {
                    crearReyDefecto();
                }
                else System.out.println("ERROR: Ya se ha creado el rey.");
            }
            case 2 -> {
                if (rey == null) {
                    Color colorElegido;
                    colorElegido = elegirColor();
                    crearReyColor(colorElegido);
                }
                else System.out.println("ERROR: Ya se ha creado el rey.");
            }
            case 3 -> {
                if (rey == null){
                    throw new IllegalArgumentException("ERROR: No existe ningún rey para mover.");
                }
                mover();
                System.out.println(rey.toString());
            }
            case 4 -> despedirse();
            default -> throw new IllegalStateException("Ha elegido una opción no válida: " + opcion);
        }
    }

    private static void crearReyDefecto(){
        try {
            rey = new Rey();
            System.out.println("Rey creado con éxito.");
            mostrarRey();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void crearReyColor(Color color){
        rey = new Rey(color);
        System.out.println("Rey creado con éxito.");
        mostrarRey();
    }

    private static void mover(){
        Direccion direccion;
        Consola.mostrarMenuDirecciones();
        direccion = Consola.elegirDireccion();

        try {
            rey.mover(direccion);
        } catch (NullPointerException | OperationNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarRey (){
        try{
            System.out.println(rey.getColor());
            System.out.println(rey.getPosicion());
        }catch (Exception e) {
            System.out.println("El rey no está creado.");
        }
    }
}

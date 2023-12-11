package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Color;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.util.Arrays;

public class Consola {
    private Consola() {
    }
    public static void mostrarMenu(){
        System.out.println("Opciones del menú:");
        System.out.println("1. Crear rey por defecto.");
        System.out.println("2. Crear rey eligiendo color.");
        System.out.println("3. Mover.");
        System.out.println("4. Salir.");
    }
    public static int elegirOpcionMenu(){
        int opcion;
        mostrarMenu();
        do{
            System.out.println("Elija una opción (entre 1 y 4)");
            opcion = Entrada.entero();
        }while (opcion < 1 || opcion > 4);
        return opcion;
    }
    public static Color color; Color elegirColor(){
        do{
            System.out.println("Elige un color (Blanco o Negro): ");
            System.out.println(Arrays.toString(Color.values()));
            color = Color.valueOf("Blanco");
            return color;

            //for para las opciones
            //switch para devolver las opciones
        }while (!color.equals("Blanco"));

    }
}

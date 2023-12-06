package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
    private Consola() {
    }
    public void mostrarMenu(){
        System.out.println("Opciones del menú:");
        System.out.println("1. Crear rey por defecto.");
        System.out.println("2. Crear rey eligiendo color.");
        System.out.println("3. Mover.");
        System.out.println("4. Salir.");
    }
    public int elegirOpcionMenu(int opcion){
        mostrarMenu();
        do{
            System.out.println("Elija una opción (entre 1 y 4)");
            opcion = Entrada.entero();
        }while (opcion < 1 || opcion > 4);
        return opcion;
    }
}

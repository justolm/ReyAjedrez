package org.iesalandalus.programacion.reyajedrez;

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
}

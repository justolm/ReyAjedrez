package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Color;
import org.iesalandalus.programacion.reyajedrez.modelo.Direccion;
import org.iesalandalus.programacion.utilidades.Entrada;


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
    public static Color elegirColor(){
        Color color = null;
        do{
            System.out.println("Elige un color: ");
            int num = 1;
            for (Color col : Color.values()){
                System.out.println("Opción "+ num + ": " + col);
                num++;
            }
            int colorElegido=Entrada.entero();
            switch (colorElegido){
                case 1 -> color=Color.BLANCO;
                case 2 -> color=Color.NEGRO;
            }
        }while (!color.equals(Color.NEGRO)&&!color.equals(Color.BLANCO));
        return color;
    }
    private static void mostrarMenuDirecciones (){
        int num = 1;
        for (Direccion dir : Direccion.values()){
            System.out.println("Dirección "+ num + ": " + dir);
            num++;
        }
    }

    public static Direccion elegirDireccion(){
        int dirElegida=0;
        Direccion direccion = null;
        do{
            System.out.println("Elige una dirección de las siguientes opciones:");
            mostrarMenuDirecciones();
            System.out.print("Introduce el número de la dirección que deseas elegir: ");
            dirElegida=Entrada.entero();
        }while (dirElegida > 0 && dirElegida < 11);
        switch (dirElegida){
            case 1 -> direccion = Direccion.NORTE;
            case 2 -> direccion = Direccion.NORESTE;
            case 3 -> direccion = Direccion.ESTE;
            case 4 -> direccion = Direccion.SURESTE;
            case 5 -> direccion = Direccion.SUR;
            case 6 -> direccion = Direccion.SUROESTE;
            case 7 -> direccion = Direccion.OESTE;
            case 8 -> direccion = Direccion.NOROESTE;
            case 9 -> direccion = Direccion.ENROQUE_CORTO;
            case 10 -> direccion = Direccion.ENROQUE_LARGO;
        }
        return direccion;
    }
    public static void despedirse (){
        System.out.println("Gracias por haber jugado con nosotros. Vuelva pronto.");
    }
}

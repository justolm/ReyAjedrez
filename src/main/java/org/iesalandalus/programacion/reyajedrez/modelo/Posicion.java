package org.iesalandalus.programacion.reyajedrez.modelo;

public class Posicion {
    private int fila;
    private char columna;

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        if (fila < 1 || fila > 8){
            throw new IllegalArgumentException("ERROR: Fila no válida.")
        }
        this.fila = fila;
    }

    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna) {
        if (columna < 'a' || columna > 'h'){
            throw new IllegalArgumentException("ERROR: Columna no válida.")
        }
        this.columna = columna;
    }

    public Posicion(int fila, char columna) {
        setFila(fila);
        setColumna(columna);
    }
}

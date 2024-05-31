package org.iesalandalus.programacion.reyajedrez.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Posicion {
    private int fila;
    private char columna;

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) throws OperationNotSupportedException {
        if (fila < 1 || fila > 8){
            throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
        }
        this.fila = fila;
    }

    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna) throws OperationNotSupportedException {
        if (columna < 'a' || columna > 'h'){
            throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
        }
        this.columna = columna;
    }

    public Posicion(int fila, char columna) {
        try {
            setFila(fila);
            setColumna(columna);
        } catch (OperationNotSupportedException e) {
            System.out.println("ERROR: Movimiento no válido (se sale del tablero).");
        }
    }

    public Posicion(Posicion posicion) {
        if (posicion==null){
            throw new NullPointerException("ERROR: No es posible copiar una posición nula.");
        }
        this.fila=posicion.fila;
        this.columna=posicion.columna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicion posicion = (Posicion) o;
        return fila == posicion.fila && columna == posicion.columna;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fila, columna);
    }

    @Override
    public String toString() {
        return "fila=" + fila +
                ", columna=" + columna;
    }
}

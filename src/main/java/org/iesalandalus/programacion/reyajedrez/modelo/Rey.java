package org.iesalandalus.programacion.reyajedrez.modelo;

import javax.naming.OperationNotSupportedException;

public class Rey {
    public Color color;
    public Posicion posicion;
    private int totalMovimientos;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        if (color==null){
            throw new RuntimeException("ERROR: El color no puede ser nulo.");
        }
        if (!color.equals(Color.BLANCO)  && !color.equals(Color.NEGRO)){
            throw new IllegalArgumentException("El color no es el esperado.");
        }
        this.color = color;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        if (posicion==null){
            throw new RuntimeException("La posición no es la esperada.");
        }
        this.posicion = new Posicion(posicion);
    }

    public int getTotalMovimientos() {
        return totalMovimientos;
    }

    public void setTotalMovimientos(int totalMovimientos) {
        if (totalMovimientos<0){
            throw new RuntimeException("ERROR: El rey no está en su posición inicial.");
        }
        this.totalMovimientos = totalMovimientos;
    }

    public Rey() {
        setColor(Color.BLANCO);
        setPosicion(new Posicion(1, 'e'));
        this.totalMovimientos = 0;
    }

    public Rey(Color color) {
        if (color==null){
            throw new NullPointerException("ERROR: El color no puede ser nulo.");
        }
        if (color.equals(Color.BLANCO)){
            setColor(Color.BLANCO);
            setPosicion(new Posicion(1, 'e'));
        }
        else if (color.equals(Color.NEGRO)){
            setColor(Color.NEGRO);
            setPosicion(new Posicion(8, 'e'));
        }
        this.totalMovimientos = 0;
    }

    @Override
    public String toString() {
        return "Rey{" +
                "color=" + color +
                ", posicion=" + posicion +
                '}';
    }

    public void mover (Direccion direccion) throws OperationNotSupportedException {
        if (direccion == null){
            throw new NullPointerException("ERROR: La dirección no puede ser nula.");
        }
        if (direccion.equals(Direccion.ENROQUE_LARGO) || direccion.equals(Direccion.ENROQUE_CORTO)){
            if (totalMovimientos==0){
                totalMovimientos++;
                if (direccion.equals(Direccion.ENROQUE_CORTO)){
                    posicion.setColumna('g');
                }
                else {
                    posicion.setColumna('c');
                }
            }
            else {
                throw new OperationNotSupportedException("ERROR: El rey ya se ha movido antes.");
            }
        }
        switch (direccion){
            case SUR -> posicion.setFila(-1);
            case SURESTE -> {
                posicion.setFila(-1);
                posicion.setColumna((char) +1);
            }
            case SUROESTE -> {
                posicion.setFila(-1);
                posicion.setColumna((char) -1);
            }
            case NORTE -> posicion.setFila(+1);
            case NORESTE -> {
                posicion.setFila(+1);
                posicion.setColumna((char) +1);
            }
            case NOROESTE -> {
                posicion.setFila(+1);
                posicion.setColumna((char) -1);
            }
            case ESTE -> posicion.setColumna((char) +1);
            case OESTE -> posicion.setColumna((char) -1);
        }
        // Falta crear el error si el rey se intenta mover fuera del tablero.

    }
}

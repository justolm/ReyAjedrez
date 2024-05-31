package org.iesalandalus.programacion.reyajedrez.modelo;

import javax.naming.OperationNotSupportedException;

public class Rey {
    private Color color;
    private Posicion posicion;
    private int totalMovimientos;

    public Color getColor() {
        return color;
    }

    private void setColor(Color color) throws NullPointerException, IllegalArgumentException {
        if (color == null){
            throw new NullPointerException("ERROR: El color no puede ser nulo.");
        }
        if (!color.equals(Color.BLANCO)  && !color.equals(Color.NEGRO)){
            throw new IllegalArgumentException("El color no es el esperado.");
        }
        this.color = color;
    }

    public Posicion getPosicion() {
        return new Posicion(posicion);
    }

    private void setPosicion(Posicion posicion) throws NullPointerException {
        if (posicion == null){
            throw new NullPointerException("La posición no es la esperada.");
        }
        this.posicion = new Posicion(posicion);
    }

    public int getTotalMovimientos() {
        return totalMovimientos;
    }

    public void setTotalMovimientos(int totalMovimientos) throws IllegalArgumentException {
        if (totalMovimientos<0){
            throw new IllegalArgumentException("ERROR: El rey no está en su posición inicial.");
        }
        this.totalMovimientos = totalMovimientos;
    }

    public Rey() {
        setColor(Color.BLANCO);
        setPosicion(new Posicion(1, 'e'));
        totalMovimientos=0;
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
        setTotalMovimientos(0);
    }

    @Override
    public String toString() {
        return "color=" + color +
                ", posicion=(" + posicion +
                ')';
    }

    public void mover (Direccion direccion) throws NullPointerException, OperationNotSupportedException {
        if (direccion == null){
            throw new NullPointerException("ERROR: La dirección no puede ser nula.");
        }
        int posFila = posicion.getFila();
        char posCol = posicion.getColumna();
        switch (direccion){
            case ENROQUE_CORTO, ENROQUE_LARGO -> {
                if ((posicion.getFila() != 1 && posicion.getFila() != 8) || posicion.getColumna()!='e') {
                    throw new OperationNotSupportedException("ERROR: El rey no está en su posición inicial.");
                } else {
                    if (getTotalMovimientos() == 0) {
                        if (direccion.equals(Direccion.ENROQUE_CORTO)) {
                            posicion.setColumna('g');
                        } else {
                            posicion.setColumna('c');
                        }
                    }
                    else {
                        throw new OperationNotSupportedException("ERROR: El rey ya se ha movido antes.");
                    }
                }
            }
            case SUR -> posicion.setFila(posFila-1);
            case SURESTE -> {
                posicion.setFila(posFila-1);
                posicion.setColumna((char) (posCol+1));
            }
            case SUROESTE -> {
                posicion.setFila(posFila-1);
                posicion.setColumna((char) (posCol-1));
            }
            case NORTE -> posicion.setFila(posFila+1);
            case NORESTE -> {
                posicion.setFila(posFila+1);
                posicion.setColumna((char) (posCol+1));
            }
            case NOROESTE -> {
                posicion.setFila(posFila+1);
                posicion.setColumna((char) (posCol-1));
            }
            case ESTE -> posicion.setColumna((char) (posCol+1));
            case OESTE -> posicion.setColumna((char) (posCol-1));
        }
        totalMovimientos++;
    }
}

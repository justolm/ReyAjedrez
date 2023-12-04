package org.iesalandalus.programacion.reyajedrez.modelo;

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
        if (!color.equals("Blanco")  && !color.equals("Negro")){
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
}

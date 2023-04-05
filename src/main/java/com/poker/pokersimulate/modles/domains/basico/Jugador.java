package com.poker.pokersimulate.modles.domains.basico;

public class Jugador {
    private Integer posicion;

    public Jugador() {
    }

    public Jugador(Jugador jugador) {
        this.posicion=jugador.posicion;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }



}

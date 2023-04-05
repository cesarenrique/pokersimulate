package com.poker.pokersimulate.modles.domains.basico;

public class Ganador {
    private Jerarquia5 jerarquia5;
    private Integer posicion;
    private Jugador jugador;

    public Ganador() {
    }

    public Ganador(Ganador otro) {
        this.jerarquia5=new Jerarquia5(otro.jerarquia5);
        this.posicion=otro.posicion;
        this.jugador=new Jugador(otro.jugador);
    }

    public Jerarquia5 getJerarquia5() {
        return jerarquia5;
    }

    public void setJerarquia5(Jerarquia5 jerarquia5) {
        this.jerarquia5 = jerarquia5;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }


}

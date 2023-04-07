package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.comeCiegas;

import java.util.ArrayList;

public class ComeCiegas {
    private ArrayList<Integer> jugadoresQueComo;
    private Integer apuesta;
    public ComeCiegas() {
        super();
        this.jugadoresQueComo=new ArrayList<>();
    }

    public ArrayList<Integer> getJugadoresQueComo() {
        return jugadoresQueComo;
    }

    public void setJugadoresQueComo(ArrayList<Integer> jugadoresQueComo) {
        this.jugadoresQueComo = jugadoresQueComo;
    }

    public Integer getApuesta() {
        return apuesta;
    }

    public void setApuesta(Integer apuesta) {
        this.apuesta = apuesta;
    }
}

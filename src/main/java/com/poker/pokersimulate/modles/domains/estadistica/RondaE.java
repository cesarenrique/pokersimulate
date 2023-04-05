package com.poker.pokersimulate.modles.domains.estadistica;

import com.poker.pokersimulate.modles.domains.basico.Ronda;

public class RondaE extends Ronda {
    private Estadistica estadistica;

    public RondaE() {
        super();
        setTipo(20);
    }


    public Estadistica getEstadistica() {
        return estadistica;
    }

    public void setEstadistica(Estadistica estadistica) {
        this.estadistica = estadistica;

    }

}

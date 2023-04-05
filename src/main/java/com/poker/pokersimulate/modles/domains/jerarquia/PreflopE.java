package com.poker.pokersimulate.modles.domains.jerarquia;

import com.poker.pokersimulate.modles.domains.basico.Pareja;
import com.poker.pokersimulate.modles.domains.estadistica.Estadistica;

public class PreflopE {
    private Estadistica estadistica;
    private Pareja pareja;

    public PreflopE() {
    }

    public Estadistica getEstadistica() {
        return estadistica;
    }

    public void setEstadistica(Estadistica estadistica) {
        this.estadistica = estadistica;
    }

    public Pareja getPareja() {
        return pareja;
    }

    public void setPareja(Pareja pareja) {
        this.pareja = pareja;
    }


}

package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.comeCiegas;

import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.ciegas.SimulacionSTC;

import java.util.ArrayList;

public class SimulacionSTCC extends SimulacionSTC {
    private ArrayList<ComeCiegas> comeCiegas;

    public SimulacionSTCC() {
        super();
    }

    public ArrayList<ComeCiegas> getComeCiegas() {
        return comeCiegas;
    }

    public void setComeCiegas(ArrayList<ComeCiegas> comeCiegas) {
        this.comeCiegas = comeCiegas;
    }

    @Override
    public void inyectarPartida() {
        setPartida(new PartidaEAllPreflopSTCC());
    }

    @Override
    public void prepararPartida() {
        super.prepararPartida();
        ((PartidaEAllPreflopSTCC)getPartida()).setComeCiegas(comeCiegas);
        ((PartidaEAllPreflopSTCC)getPartida()).limpiarAllin();
    }


}

package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.escalonado.Uniforme.nivel.golpe;

import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.comeCiegasSupra.SimulacionSTCCS;

public class SimulacionSTCCSENG extends SimulacionSTCCS {
    public SimulacionSTCCSENG() {
        super();
    }

    @Override
    public void inyectarPartida() {
        setPartida(new PartidaEAllPreflopSTCCSENG());

    }

    @Override
    public void prepararPartida() {
        super.prepararPartida();
        ((PartidaEAllPreflopSTCCSENG) getPartida()).limpiarNoIr();
    }
}

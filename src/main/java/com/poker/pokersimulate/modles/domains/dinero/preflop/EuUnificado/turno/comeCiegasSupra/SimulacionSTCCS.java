package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.comeCiegasSupra;

import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.comeCiegas.SimulacionSTCC;

public class SimulacionSTCCS extends SimulacionSTCC {
    public SimulacionSTCCS() {
        super();
    }

    @Override
    public void inyectarPartida() {
        setPartida(new PartidaEAllPreflopSTCCS());
    }
}

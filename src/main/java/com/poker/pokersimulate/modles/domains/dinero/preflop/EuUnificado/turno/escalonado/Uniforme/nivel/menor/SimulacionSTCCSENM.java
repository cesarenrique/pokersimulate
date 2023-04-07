package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.escalonado.Uniforme.nivel.menor;

import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.escalonado.Uniforme.nivel.golpe.SimulacionSTCCSENG;

public class SimulacionSTCCSENM extends SimulacionSTCCSENG {
    public SimulacionSTCCSENM() {
        super();
    }
    @Override
    public void inyectarPartida() {
        setPartida(new PartidaEAllPreflopSTCCSENM());
    }
}

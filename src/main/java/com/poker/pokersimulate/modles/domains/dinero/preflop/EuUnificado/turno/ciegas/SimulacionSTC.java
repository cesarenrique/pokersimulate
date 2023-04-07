package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.ciegas;

import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.basico.PartidaEAllPreflopST;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.basico.SimulacionST;

public class SimulacionSTC extends SimulacionST {
    public SimulacionSTC() {
        super();
        setRepeticiones(10000);
    }

    @Override
    public void inyectarPartida() {
        setPartida(new PartidaEAllPreflopSTC());
    }

    @Override
    public void prepararPartida() {
        super.prepararPartida();
        ((PartidaEAllPreflopSTC)getPartida()).cambiarTurnoPrincipal();
    }
}

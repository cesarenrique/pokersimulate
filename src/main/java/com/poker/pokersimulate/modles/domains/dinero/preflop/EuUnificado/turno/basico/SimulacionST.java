package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.basico;

import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.PartidaEAllPreflopS;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.SimulacionS;

public class SimulacionST extends SimulacionS {
    public SimulacionST() {
        super();
        setRepeticiones(10000);
    }
    @Override
    public void inyectarPartida() {
        setPartida(new PartidaEAllPreflopST());
    }

}

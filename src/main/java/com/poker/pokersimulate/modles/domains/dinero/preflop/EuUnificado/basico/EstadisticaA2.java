package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico;

import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.EstadisticaA;

public class EstadisticaA2 extends EstadisticaA {
    public EstadisticaA2() {
        super();
        getGanados().add(0);
        getGanados().add(0);
        getPreflopSeguir().add(0);
        getPreflopSeguir().add(0);
        getSaldos().add(0);
        getSaldos().add(0);
        getGanadosPreflop().add(0);
        getGanadosPreflop().add(0);
        getGanadosPostflop().add(0);
        getGanadosPostflop().add(0);
    }
}

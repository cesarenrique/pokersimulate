package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico;

import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.EstadisticaA;

public class EstadisticaA6 extends EstadisticaA {
    public EstadisticaA6() {
        super();
        for(int i=0;i<6;i++) {
            getGanados().add(0);
            getPreflopSeguir().add(0);
            getSaldos().add(0);
            getGanadosPreflop().add(0);
            getGanadosPostflop().add(0);
        }
    }
}

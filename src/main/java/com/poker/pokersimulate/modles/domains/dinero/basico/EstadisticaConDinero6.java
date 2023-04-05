package com.poker.pokersimulate.modles.domains.dinero.basico;

import com.poker.pokersimulate.modles.domains.dinero.basico.EstadisticaConDinero;

public class EstadisticaConDinero6 extends EstadisticaConDinero {
    public EstadisticaConDinero6() {
        super();
        for (int i=0;i<6;i++) {
            getGanados().add(0);
            getSaldos().add(0);
        }
    }
}

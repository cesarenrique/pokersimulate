package com.poker.pokersimulate.modles.domains.dinero.basico;

import com.poker.pokersimulate.modles.domains.dinero.basico.EstadisticaConDinero;

public class EstadisticaConDinero2 extends EstadisticaConDinero {

    public EstadisticaConDinero2() {
        super();
        getGanados().add(0);
        getGanados().add(0);

        getSaldos().add(0);
        getSaldos().add(0);
    }
}

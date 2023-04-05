package com.poker.pokersimulate.modles.domains.dinero.postflop.basico;

public class EstadisticaAB2 extends EstadisticaAB{
    public EstadisticaAB2() {
        super();
        getGanados().add(0);
        getGanados().add(0);
        getPreflopSeguir().add(0);
        getPreflopSeguir().add(0);
        getPostflopSeguir().add(0);
        getPostflopSeguir().add(0);
        getSaldos().add(0);
        getSaldos().add(0);
    }
}

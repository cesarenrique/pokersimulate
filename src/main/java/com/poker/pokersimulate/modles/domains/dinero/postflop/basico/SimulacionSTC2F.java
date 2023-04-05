package com.poker.pokersimulate.modles.domains.dinero.postflop.basico;

import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.ciegas.SimulacionSTC;

public class SimulacionSTC2F  extends SimulacionSTC {
    public SimulacionSTC2F() {
        super();
        //setRepeticiones(20);
    }
    /*
    @Override
    public void generarPartida(Ronda ronda) {
        PartidaESTCPrePostflop partida = new PartidaESTCPrePostflop();
        partida.setEuristicas(getEuristicas());
        partida.setRonda(ronda);
        setPartida(partida);
    }

    @Override
    public Ronda injectarRondaOportuna() {
        Ronda ronda=new RondaESPrePostflop();
        return ronda;
    }
    @Override
    public Ronda inyectarEstadisticaOportuna(Ronda ronda) {
        Estadistica estadistica=new EstadisticaAB2();
        ((RondaE)ronda).setEstadistica(estadistica);
        return ronda;
    }

    @Override
    public void simularPartida() {
        super.simularPartida();
        ((PartidaESTCPrePostflop)getPartida()).generarInforme("Fin simulacion");
    }*/
}

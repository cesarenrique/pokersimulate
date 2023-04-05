package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.ciegas;

import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.basico.SimulacionST;

public class SimulacionSTC extends SimulacionST {
    public SimulacionSTC() {
        super();
        //setRepeticiones(100000);
    }/*
    @Override
    public void generarPartida(Ronda ronda) {
        PartidaEAllPreflopSTC partida = new PartidaEAllPreflopSTC();
        partida.setEuristicas(getEuristicas());
        partida.setRonda(ronda);
        setPartida(partida);
    }

    @Override
    public Ronda injectarRondaOportuna() {
        Ronda ronda=new RondaESTCPreflop();
        return ronda;
    }

    @Override
    public void prepararPartida() {
        super.prepararPartida();
        ((RondaESTCPreflop)getPartida().getRonda()).limpiarSigueCiega();
    }*/
}

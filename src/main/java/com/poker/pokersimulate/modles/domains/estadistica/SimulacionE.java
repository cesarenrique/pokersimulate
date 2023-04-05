package com.poker.pokersimulate.modles.domains.estadistica;

import com.poker.pokersimulate.modles.domains.basico.*;


public class SimulacionE extends Simulacion{

    public SimulacionE() {
        super();
        setRepeticiones(1000);
    }

    @Override
    public void inyectarPartida() {
        setPartida(new PartidaE());
    }


    @Override
    public void prepararPartida() {
        inyectarPartida();
        injectarRondaOportuna();
        inyectarBaraja();
        inyectarMesaOportuna();
        prepararMesa();
        inyectarEstadisticaOportuna();
    }


    public void inyectarEstadisticaOportuna(){
        ((RondaE)getPartida().getRonda()).setEstadistica(new Estadistica2());
    }

    @Override
    public void  injectarRondaOportuna(){
         getPartida().setRonda(new RondaE());
    }

}

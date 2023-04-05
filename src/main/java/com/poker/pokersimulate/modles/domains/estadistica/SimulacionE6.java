package com.poker.pokersimulate.modles.domains.estadistica;

import com.poker.pokersimulate.modles.domains.basico.*;

public class SimulacionE6 extends SimulacionE{

    public SimulacionE6() {

        setRepeticiones(1000);
    }

    @Override
    public void inyectarEstadisticaOportuna(){
        ((RondaE)getPartida().getRonda()).setEstadistica(new Estadistica6());
    }

    @Override
    public void inyectarMesaOportuna() {
        getPartida().getRonda().setMesa(new Mesa6());
    }
}

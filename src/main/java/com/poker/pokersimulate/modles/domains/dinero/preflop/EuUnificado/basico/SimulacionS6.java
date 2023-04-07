package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico;

import com.poker.pokersimulate.modles.domains.dinero.basico.MesaConDinero6;
import com.poker.pokersimulate.modles.domains.estadistica.RondaE;

public class SimulacionS6 extends SimulacionS {
    public SimulacionS6() {
        super();
    }
    @Override
    public void inyectarEstadisticaOportuna(){
        ((RondaE)getPartida().getRonda()).setEstadistica(new EstadisticaA6());
    }

    @Override
    public void inyectarMesaOportuna() {
        getPartida().getRonda().setMesa(new MesaConDinero6());
    }
}

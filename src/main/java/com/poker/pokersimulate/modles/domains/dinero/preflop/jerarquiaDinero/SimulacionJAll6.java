package com.poker.pokersimulate.modles.domains.dinero.preflop.jerarquiaDinero;

import com.poker.pokersimulate.modles.domains.dinero.basico.EstadisticaConDinero6;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.EstadisticaA6;
import com.poker.pokersimulate.modles.domains.estadistica.RondaE;
import com.poker.pokersimulate.modles.domains.dinero.basico.MesaConDinero6;

public class SimulacionJAll6 extends SimulacionJAll {
    public SimulacionJAll6() {
        super();
    }

    @Override
    public void inyectarEstadisticaOportuna(){
        ((RondaE)getPartida().getRonda()).setEstadistica(new EstadisticaConDinero6());
    }

    @Override
    public void inyectarMesaOportuna() {
        getPartida().getRonda().setMesa(new MesaConDinero6());
    }
}

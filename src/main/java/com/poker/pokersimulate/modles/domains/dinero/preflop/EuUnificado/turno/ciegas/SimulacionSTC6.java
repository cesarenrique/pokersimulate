package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.ciegas;

import com.poker.pokersimulate.modles.domains.dinero.basico.MesaConDinero6;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.EstadisticaA6;
import com.poker.pokersimulate.modles.domains.estadistica.RondaE;

public class SimulacionSTC6  extends SimulacionSTC{
    public SimulacionSTC6() {
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

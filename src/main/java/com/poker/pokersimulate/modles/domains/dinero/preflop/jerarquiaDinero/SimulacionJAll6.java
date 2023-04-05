package com.poker.pokersimulate.modles.domains.dinero.preflop.jerarquiaDinero;

import com.poker.pokersimulate.modles.domains.basico.Mesa6;
import com.poker.pokersimulate.modles.domains.estadistica.Estadistica;
import com.poker.pokersimulate.modles.domains.basico.Mesa;
import com.poker.pokersimulate.modles.domains.basico.Ronda;
import com.poker.pokersimulate.modles.domains.estadistica.Estadistica6;
import com.poker.pokersimulate.modles.domains.estadistica.RondaE;
import com.poker.pokersimulate.modles.domains.dinero.basico.MesaConDinero6;

public class SimulacionJAll6 extends SimulacionJAll {
    public SimulacionJAll6() {
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

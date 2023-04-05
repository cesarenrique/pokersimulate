package com.poker.pokersimulate.modles.domains.jerarquia;

import com.poker.pokersimulate.modles.domains.basico.Mesa;
import com.poker.pokersimulate.modles.domains.basico.Mesa6;
import com.poker.pokersimulate.modles.domains.basico.Ronda;
import com.poker.pokersimulate.modles.domains.estadistica.Estadistica;
import com.poker.pokersimulate.modles.domains.estadistica.Estadistica6;
import com.poker.pokersimulate.modles.domains.estadistica.RondaE;
import com.poker.pokersimulate.modles.domains.jerarquia.SimulacionJ;

public class SimulacionJ6 extends SimulacionJ {
    public SimulacionJ6() {
        super();
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

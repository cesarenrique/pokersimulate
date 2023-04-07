package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.escalonado.Uniforme.nivel.menor;

import com.poker.pokersimulate.modles.domains.dinero.basico.MesaConDinero6;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.EstadisticaA6;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.escalonado.Uniforme.nivel.golpe.SimulacionSTCCSENG;
import com.poker.pokersimulate.modles.domains.estadistica.RondaE;

public class SimulacionSTCCSENM6 extends SimulacionSTCCSENG {
    public SimulacionSTCCSENM6() {
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

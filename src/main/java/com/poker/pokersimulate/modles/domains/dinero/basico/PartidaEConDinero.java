package com.poker.pokersimulate.modles.domains.dinero.basico;

import com.poker.pokersimulate.modles.domains.basico.Asiento;
import com.poker.pokersimulate.modles.domains.basico.Ganador;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.EstadisticaA;
import com.poker.pokersimulate.modles.domains.estadistica.PartidaE;
import com.poker.pokersimulate.modles.domains.basico.Ronda;
import com.poker.pokersimulate.modles.domains.estadistica.RondaE;

import java.util.ArrayList;

public class PartidaEConDinero extends PartidaE {


    public PartidaEConDinero() {
        super();

    }

    @Override
    public void ejercerEstadistica() {

        super.ejercerEstadistica();
        ejercerEstadisticaFinalizar();

    }

    public void ejercerEstadisticaFinalizar() {

        for(Asiento asiento:getRonda().getMesa().getAsientos()){
            ((EstadisticaConDinero) ((RondaEConDinero) getRonda()).getEstadistica()).getSaldos().set(asiento.getPosicion(),((JugadorNormal) asiento.getJugador()).getSaldo());
        }


    }

    public Integer preCheck(){
        Integer sumar=0;
        for(int i=0;i<getRonda().getMesa().getTamanyo();i++){
            sumar+=((AsientoConFichas) getRonda().getMesa().getAsientos().get(i)).getFichas();
        }
        return sumar;
    }


}

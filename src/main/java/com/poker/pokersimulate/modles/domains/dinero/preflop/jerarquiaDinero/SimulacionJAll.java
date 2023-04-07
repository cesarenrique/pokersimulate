package com.poker.pokersimulate.modles.domains.dinero.preflop.jerarquiaDinero;

import com.poker.pokersimulate.modles.domains.basico.*;
import com.poker.pokersimulate.modles.domains.dinero.basico.*;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.EstadisticaA2;
import com.poker.pokersimulate.modles.domains.estadistica.RondaE;
import com.poker.pokersimulate.modles.domains.jerarquia.SimulacionJ;

public class SimulacionJAll extends SimulacionJ {
    public SimulacionJAll() {
        super();
        setRepeticiones(1000);
    }


    @Override
    public void inyectarEstadisticaOportuna() {
        ((RondaE)getPartida().getRonda()).setEstadistica(new EstadisticaConDinero2());
    }

    @Override
    public void inyectarPartida() {
        setPartida(new PartidaEAllPreflop());
    }

    @Override
    public void simularPartida() {
        getPartida().iterarRondas(getRepeticiones());
        extrearDatosPartida();
        ((PartidaEAllPreflop)getPartida()).finalizarPartida();
    }

    @Override
    public void inyectarMesaOportuna() {
        getPartida().getRonda().setMesa(new MesaConDinero2());
    }

    @Override
    public void prepararPartida() {
        inyectarPartida();
        injectarRondaOportuna();
        inyectarBaraja();
        inyectarMesaOportuna();
        prepararMesa();
        inyectarEstadisticaOportuna();
        ((RondaEConDinero) getPartida().getRonda()).limpiarMesa();
        ((RondaEConDinero) getPartida().getRonda()).limpiarSigue();
    }

    @Override
    public void prepararMesa(){

        getPartida().getRonda().getMesa().generarAsientos();
        Integer contador2 = 0;
        for (Asiento asiento : getPartida().getRonda().getMesa().getAsientos()) {
            asiento.setJugador(new JugadorNormal());
            ((JugadorNormal)asiento.getJugador()).setSaldo(-200);
            asiento.setCombinacion7(new Combinacion7());
            asiento.setPareja(new Pareja());
            asiento.setPosicion(contador2);
            ((AsientoConFichas) asiento).setFichas(100);
            contador2++;
        }

    }


    @Override
    public void injectarRondaOportuna(){
        getPartida().setRonda(new RondaEConDinero());
    }


}

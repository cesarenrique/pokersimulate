package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico;

import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.EuristicaPreflopLinealExpand;
import com.poker.pokersimulate.modles.domains.estadistica.SimulacionE;

import java.util.ArrayList;

public class SimulacionS extends SimulacionE {

    private ArrayList<EuristicaPreflopLinealExpand> euristicas;

    public SimulacionS() {
        super();
        setRepeticiones(100000);
    }

/*
    public ArrayList<EuristicaPreflopLinealExpand> getEuristicas() {
        return euristicas;
    }

    public void setEuristicas(ArrayList<EuristicaPreflopLinealExpand> euristicas) {
        this.euristicas = euristicas;
    }

    @Override
    public Mesa generarAsientos(Mesa mesa) {
        mesa.generarAsientos();
        return mesa;
    }

    @Override
    public Ronda inyectarEstadisticaOportuna(Ronda ronda) {
        Estadistica estadistica=new EstadisticaA2();
        ((RondaE)ronda).setEstadistica(estadistica);
        return ronda;
    }

    @Override
    public void generarPartida(Ronda ronda) {
        PartidaEAllPreflopS partida = new PartidaEAllPreflopS();
        partida.setEuristicas(euristicas);
        partida.setRonda(ronda);
        setPartida(partida);
    }

    @Override
    public void simularPartida() {
        PartidaEAllPreflopS partida=(PartidaEAllPreflopS) getPartida();
        partida.iterarRondas(getRepeticiones());
        partida.finalizarPartida();
    }

    @Override
    public Ronda inyectarMesaOportuna(Ronda ronda) {
        Mesa mesa = new MesaConDinero2();
        ronda.setMesa(mesa);
        return ronda;
    }

    @Override
    public Ronda prepararMesa(Ronda ronda){
        Mesa mesa = generarAsientos(ronda.getMesa());
        ArrayList<Asiento> asientos = mesa.getAsientos();
        Integer contador = 0;
        for (Asiento asiento : asientos) {
            Jugador j = new JugadorNormal();
            ((JugadorNormal) j).setSaldo(0);
            Combinacion7 combinacion7 = new Combinacion7();
            Pareja p = new Pareja();
            asiento.setJugador(j);
            asiento.setCombinacion7(combinacion7);
            asiento.setPosicion(contador);
            asiento.setPareja(p);
            ((AsientosConFichas) asiento).setFichas(100);
            contador++;
        }
        return ronda;
    }

    @Override
    public Ronda injectarRondaOportuna() {
        Ronda ronda=new RondaEPreflop();
        return ronda;
    }

    @Override
    public void prepararPartida() {
        super.prepararPartida();
        ((RondaEConDinero) getPartida().getRonda()).limpiarApuestasyBote();
        ((RondaEConDinero) getPartida().getRonda()).limpiarSigue();
    }
*/

}

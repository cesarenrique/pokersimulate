package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico;

import com.poker.pokersimulate.modles.domains.basico.Asiento;
import com.poker.pokersimulate.modles.domains.basico.Combinacion7;
import com.poker.pokersimulate.modles.domains.basico.Pareja;
import com.poker.pokersimulate.modles.domains.dinero.basico.AsientoConFichas;
import com.poker.pokersimulate.modles.domains.dinero.basico.JugadorNormal;
import com.poker.pokersimulate.modles.domains.dinero.basico.MesaConDinero2;
import com.poker.pokersimulate.modles.domains.dinero.basico.RondaEConDinero;
import com.poker.pokersimulate.modles.domains.estadistica.RondaE;
import com.poker.pokersimulate.modles.domains.estadistica.SimulacionE;

import java.util.ArrayList;

public class SimulacionS extends SimulacionE {

    private ArrayList<EuristicaPreflopLinealExpand> euristicas;

    public SimulacionS() {
        super();
        setRepeticiones(10000);
    }

    public ArrayList<EuristicaPreflopLinealExpand> getEuristicas() {
        return euristicas;
    }

    public void setEuristicas(ArrayList<EuristicaPreflopLinealExpand> euristicas) {
        this.euristicas = euristicas;
    }

    @Override
    public void injectarRondaOportuna(){
        getPartida().setRonda(new RondaEPreflop());
    }

    @Override
    public void inyectarEstadisticaOportuna() {
        ((RondaE)getPartida().getRonda()).setEstadistica(new EstadisticaA2());
    }

    @Override
    public void inyectarPartida() {
        setPartida(new PartidaEAllPreflopS());
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
        ((PartidaEAllPreflopS)getPartida()).setEuristicas(euristicas);
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
    public void simularPartida() {
        getPartida().iterarRondas(getRepeticiones());
        ((PartidaEAllPreflopS)getPartida()).finalizarPartida();
    }



}

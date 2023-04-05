package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico;

import com.poker.pokersimulate.modles.domains.basico.Asiento;
import com.poker.pokersimulate.modles.domains.dinero.basico.AsientoConFichas;
import com.poker.pokersimulate.modles.domains.dinero.basico.PartidaEConDinero;
import com.poker.pokersimulate.modles.domains.dinero.basico.RondaEConDinero;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.EuristicaPreflopLinealExpand;
import com.poker.pokersimulate.modles.domains.dinero.preflop.jerarquiaDinero.EstadisticaA;
import com.poker.pokersimulate.modles.domains.dinero.preflop.jerarquiaDinero.PartidaEAllPreflop;

import java.util.ArrayList;

public class PartidaEAllPreflopS extends PartidaEConDinero {


    private ArrayList<EuristicaPreflopLinealExpand> euristicas;
    public PartidaEAllPreflopS() {
        super();
    }


    public ArrayList<EuristicaPreflopLinealExpand> getEuristicas() {
        return euristicas;
    }

    public void setEuristicas(ArrayList<EuristicaPreflopLinealExpand> euristicas) {
        this.euristicas = euristicas;
    }

    @Override
    public void iterarRonda() {

        setSeguir(true);
        getRonda().clear();
        partidaPreflop();
        if (isSeguir()) {
            //partidaPostflop();
        }else{
            //terminarPartidaEnPreflop();
        }

    }

    public void partidaPreflop() {
        getRonda().repartirCartasJugadores();
        hacerApuestas();
        /*
        //rondaApuestasTerminada();
        Integer intensionSeguir=((RondaEConDinero) getRonda()).intencionSeguir();
        if(intensionSeguir>1) {
            ArrayList<Integer> quienes=((RondaEConDinero) getRonda()).getSigue();
            int tam=quienes.size();
            for(int i=0;i<tam;i++) {
                if (quienes.get(i)==1) {
                    ((EstadisticaA) ((RondaEConDinero) getRonda()).getEstadistica()).preflopSeguirMasUno(i);
                }
            }

            setSeguir(true);
        }else if(intensionSeguir==1){
            Integer quien=((RondaEConDinero) getRonda()).intencionSeguirQuien();
            ((EstadisticaA) ((RondaEConDinero) getRonda()).getEstadistica()).preflopSeguirMasUno(quien);
            setSeguir(false);
        }else{
            setSeguir(false);
        }*/
    }


    public void hacerApuestas(){
        ArrayList<Asiento> asientos = getRonda().getMesa().getAsientos();
        int tam=asientos.size();
        for(int i=0;i<tam;i++){
            if(euristicas.get(i).dentroEuristica(asientos.get(i).getPareja())) {
                Integer allin = ((AsientoConFichas) asientos.get(i)).getFichas();
                ((RondaEPreflop)getRonda()).apuestaPreFlop(asientos.get(i).getPosicion(), allin);
                ((RondaEPreflop)getRonda()).getSigue().set(i,1);
            }
        }
    }

    /*
    public void terminarPartidaEnPreflop() {

        ((RondaEPreflop) getRonda()).generarGanadoresPreflop();
        ejercerEstadistica();
        recompensaGanadores();
        opcionRecompraFichas();
        ((RondaEConDinero) getRonda()).limpiarApuestasyBote();
        ((RondaEConDinero) getRonda()).limpiarSigue();

    }

    public void partidaPostflop(){
        getRonda().repartirComunitarias();
        getRonda().evaluarJugadores();
        getRonda().generarGanadores();
        ejercerEstadistica();
        recompensaGanadores();
        ((RondaEConDinero) getRonda()).limpiarApuestasyBote();
        ((RondaEConDinero) getRonda()).limpiarSigue();
        opcionRecompraFichas();

    }



    @Override
    public void hacerApuestas(){
        ArrayList<Asiento> asientos = getRonda().getMesa().getAsientos();
        int tam=asientos.size();
        for(int i=0;i<tam;i++){
            if(euristicas.get(i).dentroEuristica(asientos.get(i).getPareja())) {
                Integer allin = ((AsientosConFichas) asientos.get(i)).getFichas();
                ((RondaEPreflop)getRonda()).apuestaPreFlop(asientos.get(i).getPosicion(), allin);
            }
        }
    }
    */

}

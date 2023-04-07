package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.comeCiegasSupra;

import com.poker.pokersimulate.modles.domains.basico.Asiento;
import com.poker.pokersimulate.modles.domains.dinero.basico.AsientoConFichas;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.EstadisticaA;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.RondaEPreflop;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.comeCiegas.PartidaEAllPreflopSTCC;

import java.util.ArrayList;

public class PartidaEAllPreflopSTCCS extends PartidaEAllPreflopSTCC {
    public PartidaEAllPreflopSTCCS() {
        super();
    }

    @Override
    public void hacerApuestas(){
        ArrayList<Asiento> asientos = getRonda().getMesa().getAsientos();
        setTurnoPreflop(getTurnoPrincipal());
        setUltimo(getTurnoPrincipal());
        cambiarTurnoPrincipal();

        do {
            if(!apostoAlQueComoCiegas(getTurnoPreflop())) {
                if (getRankingPreflopEuristicas().get(getTurnoPreflop()).getEuristicas().get(0).dentroEuristica(asientos.get(getTurnoPreflop()).getPareja())) {
                    Integer tope = ((AsientoConFichas) asientos.get(getTurnoPreflop())).getFichas();
                    Integer apuesta;
                    if (getRankingPreflopEuristicas().get(getTurnoPreflop()).getApuestas().get(0) == 0) apuesta = tope;
                    else if (tope >getRankingPreflopEuristicas().get(getTurnoPreflop()).getApuestas().get(0) -((RondaEPreflop)getRonda()).getApuestas().get(getTurnoPreflop()))
                        apuesta =getRankingPreflopEuristicas().get(getTurnoPreflop()).getApuestas().get(0) -((RondaEPreflop)getRonda()).getApuestas().get(getTurnoPreflop());
                    else apuesta = tope;
                    Integer meta2 = metaIgualar();
                    if (meta2 <= apuesta && apuesta!=tope) {
                        if(meta2<apuesta) anularPreflopSeguirOtros();
                        ((RondaEPreflop) getRonda()).apuesta(asientos.get(getTurnoPreflop()).getPosicion(), apuesta);
                        ((RondaEPreflop) getRonda()).getSigue().set(getTurnoPreflop(), 1);
                    }else if(apuesta==tope){
                        if(meta2<apuesta) anularPreflopSeguirOtros();
                        ((RondaEPreflop) getRonda()).apuesta(asientos.get(getTurnoPreflop()).getPosicion(), apuesta);
                        ((RondaEPreflop) getRonda()).getSigue().set(getTurnoPreflop(), 1);
                        getAllin().set(getTurnoPreflop(),1);
                    }
                }else{
                    Integer tope = ((AsientoConFichas) asientos.get(getTurnoPreflop())).getFichas();
                    Integer apuesta;
                    if (getComeCiegas().get(getTurnoPreflop()).getApuesta() == -1) apuesta = tope;
                    else if (tope >getComeCiegas().get(getTurnoPreflop()).getApuesta()-((RondaEPreflop)getRonda()).getApuestas().get(getTurnoPreflop()))
                        apuesta = getComeCiegas().get(getTurnoPreflop()).getApuesta()-((RondaEPreflop)getRonda()).getApuestas().get(getTurnoPreflop());
                    else apuesta = tope;
                    Integer meta2 = metaIgualar();
                    if (meta2 <= apuesta && apuesta!=tope) {
                        if(meta2<apuesta) anularPreflopSeguirOtros();
                        ((RondaEPreflop) getRonda()).apuesta(asientos.get(getTurnoPreflop()).getPosicion(), apuesta);
                        ((RondaEPreflop) getRonda()).getSigue().set(getTurnoPreflop(), 1);
                    }else if(apuesta==tope){
                        if(meta2<apuesta) anularPreflopSeguirOtros();
                        ((RondaEPreflop) getRonda()).apuesta(asientos.get(getTurnoPreflop()).getPosicion(), apuesta);
                        ((RondaEPreflop) getRonda()).getSigue().set(getTurnoPreflop(), 1);
                        getAllin().set(getTurnoPreflop(),1);
                    }
                }
            }
            cambiarTurnoPreflop();
        }while(!getTurnoPreflop().equals(getUltimo()));
        Integer intencionSeguir=((RondaEPreflop)getRonda()).intencionSeguir();
        if(intencionSeguir==0){
            ((RondaEPreflop) getRonda()).getSigue().set(getTurnoPreflop(), 1);
            Integer estAnt = ((EstadisticaA) ((RondaEPreflop) getRonda()).getEstadistica()).getPreflopSeguir().get(getTurnoPreflop());
            estAnt++;
            ((EstadisticaA) ((RondaEPreflop) getRonda()).getEstadistica()).getPreflopSeguir().set(getTurnoPreflop(), estAnt);
        }
    }
}

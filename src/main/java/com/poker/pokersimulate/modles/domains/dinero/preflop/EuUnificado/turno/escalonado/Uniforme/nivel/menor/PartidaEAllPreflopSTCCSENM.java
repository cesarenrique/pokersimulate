package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.escalonado.Uniforme.nivel.menor;

import com.poker.pokersimulate.modles.domains.basico.Asiento;
import com.poker.pokersimulate.modles.domains.dinero.basico.AsientoConFichas;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.EstadisticaA;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.RondaEPreflop;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.escalonado.Uniforme.nivel.golpe.PartidaEAllPreflopSTCCSENG;

import java.util.ArrayList;

public class PartidaEAllPreflopSTCCSENM extends PartidaEAllPreflopSTCCSENG {
    public PartidaEAllPreflopSTCCSENM() {
        super();
    }

    @Override
    public void hacerApuestas(){
        ArrayList<Asiento> asientos = getRonda().getMesa().getAsientos();
        setTurnoPreflop(getTurnoPrincipal());
        setUltimo(getTurnoPrincipal());
        cambiarTurnoPrincipal();

        do {
            if(getNoIr().get(getTurnoPreflop())==0){
                if(!apostoAlQueComoCiegas(getTurnoPreflop())) {
                    if (getRankingPreflopEuristicas().get(getTurnoPreflop()).getEuristicas().get(0).dentroEuristica(asientos.get(getTurnoPreflop()).getPareja())) {
                        Integer tope = ((AsientoConFichas) asientos.get(getTurnoPreflop())).getFichas();
                        Integer apuesta;
                        Integer pos=getRankingPreflopEuristicas().get(getTurnoPreflop()).getPosicion();
                        getRankingPreflopEuristicas().get(getTurnoPreflop()).retrocederUnaPosicion();
                        if (getRankingPreflopEuristicas().get(getTurnoPreflop()).getApuestas().get(pos) == 0)
                            apuesta = tope;
                        else if (tope > getRankingPreflopEuristicas().get(getTurnoPreflop()).getApuestas().get(pos) - ((RondaEPreflop) getRonda()).getApuestas().get(getTurnoPreflop()))
                            apuesta = getRankingPreflopEuristicas().get(getTurnoPreflop()).getApuestas().get(pos) - ((RondaEPreflop) getRonda()).getApuestas().get(getTurnoPreflop());
                        else apuesta = tope;
                        Integer meta2 = metaIgualar();
                        if (meta2 <= apuesta && apuesta != tope) {
                            if (meta2 < apuesta) {
                                anularPreflopSeguirOtros();
                                setUltimo(getTurnoPreflop());
                            }
                            ((RondaEPreflop) getRonda()).apuesta(asientos.get(getTurnoPreflop()).getPosicion(), apuesta);
                            ((RondaEPreflop) getRonda()).getSigue().set(getTurnoPreflop(), 1);
                        } else if (apuesta == tope) {
                            if (meta2 < apuesta) {
                                anularPreflopSeguirOtros();
                                setUltimo(getTurnoPreflop());
                            }
                            ((RondaEPreflop) getRonda()).apuesta(asientos.get(getTurnoPreflop()).getPosicion(), apuesta);
                            ((RondaEPreflop) getRonda()).getSigue().set(getTurnoPreflop(), 1);
                            getAllin().set(getTurnoPreflop(), 1);
                        } else {
                            getNoIr().set(getTurnoPreflop(), 1);
                        }
                    } else if (getRankingPreflopEuristicas().get(getTurnoPreflop()).getEuristicas().get(1).dentroEuristica(asientos.get(getTurnoPreflop()).getPareja())) {
                        Integer tope = ((AsientoConFichas) asientos.get(getTurnoPreflop())).getFichas();
                        Integer apuesta;
                        Integer pos=getRankingPreflopEuristicas().get(getTurnoPreflop()).getPosicion();
                        getRankingPreflopEuristicas().get(getTurnoPreflop()).retrocederUnaPosicion();
                        if (getRankingPreflopEuristicas().get(getTurnoPreflop()).getApuestas().get(pos) == 0)
                            apuesta = tope;
                        else if (tope > getRankingPreflopEuristicas().get(getTurnoPreflop()).getApuestas().get(pos) - ((RondaEPreflop) getRonda()).getApuestas().get(getTurnoPreflop()))
                            apuesta = getRankingPreflopEuristicas().get(getTurnoPreflop()).getApuestas().get(pos) - ((RondaEPreflop) getRonda()).getApuestas().get(getTurnoPreflop());
                        else apuesta = tope;
                        Integer meta2 = metaIgualar();
                        if (meta2 <= apuesta && apuesta != tope) {
                            if (meta2 < apuesta) {
                                anularPreflopSeguirOtros();
                                setUltimo(getTurnoPreflop());
                            }
                            ((RondaEPreflop) getRonda()).apuesta(asientos.get(getTurnoPreflop()).getPosicion(), apuesta);
                            ((RondaEPreflop) getRonda()).getSigue().set(getTurnoPreflop(), 1);
                        } else if (apuesta == tope) {
                            if (meta2 < apuesta) {
                                anularPreflopSeguirOtros();
                                setUltimo(getTurnoPreflop());
                            }
                            ((RondaEPreflop) getRonda()).apuesta(asientos.get(getTurnoPreflop()).getPosicion(), apuesta);
                            ((RondaEPreflop) getRonda()).getSigue().set(getTurnoPreflop(), 1);
                            getAllin().set(getTurnoPreflop(), 1);
                        } else {
                            getNoIr().set(getTurnoPreflop(), 1);
                        }
                    } else {
                        Integer tope = ((AsientoConFichas) asientos.get(getTurnoPreflop())).getFichas();
                        Integer apuesta;
                        if (getComeCiegas().get(getTurnoPreflop()).getApuesta() == -1) apuesta = tope;
                        else if (tope > getComeCiegas().get(getTurnoPreflop()).getApuesta() - ((RondaEPreflop) getRonda()).getApuestas().get(getTurnoPreflop()))
                            apuesta = getComeCiegas().get(getTurnoPreflop()).getApuesta() - ((RondaEPreflop) getRonda()).getApuestas().get(getTurnoPreflop());
                        else apuesta = tope;
                        Integer meta2 = metaIgualar();
                        if (meta2 <= apuesta && apuesta != tope) {
                            if (meta2 < apuesta) {
                                anularPreflopSeguirOtros();
                                setUltimo(getTurnoPreflop());
                            }
                            ((RondaEPreflop) getRonda()).apuesta(asientos.get(getTurnoPreflop()).getPosicion(), apuesta);
                            ((RondaEPreflop) getRonda()).getSigue().set(getTurnoPreflop(), 1);
                        } else if (apuesta == tope) {
                            if (meta2 < apuesta) {
                                anularPreflopSeguirOtros();
                                setUltimo(getTurnoPreflop());
                            }
                            ((RondaEPreflop) getRonda()).apuesta(asientos.get(getTurnoPreflop()).getPosicion(), apuesta);
                            ((RondaEPreflop) getRonda()).getSigue().set(getTurnoPreflop(), 1);
                            getAllin().set(getTurnoPreflop(), 1);
                        } else {
                            getNoIr().set(getTurnoPreflop(), 1);
                        }
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

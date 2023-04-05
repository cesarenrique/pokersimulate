package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.basico;

import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.PartidaEAllPreflopS;

public class PartidaEAllPreflopST extends PartidaEAllPreflopS {
    private Integer turnoPrincipal;
    private Integer turnoPreflop;
    private Integer turnoPrincipalAnterior;
    public PartidaEAllPreflopST() {
        super();
        turnoPreflop=0;
        turnoPrincipal=0;
        turnoPrincipalAnterior=1;
    }
    /*


    public Integer getTurnoPrincipalAnterior() {
        return turnoPrincipalAnterior;
    }

    public void setTurnoPrincipalAnterior(Integer turnoPrincipalAnterior) {
        this.turnoPrincipalAnterior = turnoPrincipalAnterior;
    }

    public Integer getTurnoPrincipal() {
        return turnoPrincipal;
    }

    public void setTurnoPrincipal(Integer turnoPrincipal) {
        this.turnoPrincipal = turnoPrincipal;
    }

    public Integer getTurnoPreflop() {
        return turnoPreflop;
    }

    public void setTurnoPreflop(Integer turnoPreflop) {
        this.turnoPreflop = turnoPreflop;
    }

    @Override
    public void partidaPreflop() {


        getRonda().repartirCartasJuegadores();
        turnoPreflop=turnoPrincipal;
        cambiarTurnoPrincipal();

        int tam=getRonda().getMesa().getTamanyo();
        for(int i=0;i<tam;i++) {
            hacerApuestas();
            cambiarTurnoPreflop();
        }

        rondaApuestasTerminada();
        Integer intensionSeguir=((RondaEConDinero)getRonda()).intencionSeguir();
        if(intensionSeguir>1) {
            ArrayList<Integer> quienes=((RondaEConDinero)getRonda()).getSigue();
            tam=quienes.size();
            for(int i=0;i<tam;i++) {
                if (quienes.get(i)==1) {
                    ((EstadisticaA) ((RondaEConDinero) getRonda()).getEstadistica()).preflopSeguirMasUno(i);
                }
            }
            setSeguir(true);
        }else if(intensionSeguir==1){
            Integer quien=((RondaEConDinero)getRonda()).intencionSeguirQuien();
            ((EstadisticaA) ((RondaEConDinero) getRonda()).getEstadistica()).preflopSeguirMasUno(quien);
            setSeguir(false);
        }else{
            setSeguir(false);
        }
    }

    @Override
    public void hacerApuestas() {
        ArrayList<Asiento> asientos = getRonda().getMesa().getAsientos();

        if (getEuristicas().get(turnoPreflop).dentroEuristica(asientos.get(turnoPreflop).getPareja())) {
            Integer allin = ((AsientosConFichas) asientos.get(turnoPreflop)).getFichas();
            ((RondaEConDinero) getRonda()).apuestaPreFlop(asientos.get(turnoPreflop).getPosicion(), allin);
        }

    }

    public void cambiarTurnoPreflop(){
        turnoPreflop++;
        if(turnoPreflop==getRonda().getMesa().getTamanyo()){
            turnoPreflop=0;
        }

    }

    public void cambiarTurnoPrincipal(){
        turnoPrincipalAnterior=turnoPrincipal;

        turnoPrincipal++;
        if(turnoPrincipal==getRonda().getMesa().getTamanyo()){
            turnoPrincipal=0;
        }

    }
*/

}

package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.comeCiegas;

import com.poker.pokersimulate.modles.domains.basico.Asiento;
import com.poker.pokersimulate.modles.domains.dinero.basico.AsientoConFichas;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.EstadisticaA;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.RondaEPreflop;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.ciegas.PartidaEAllPreflopSTC;

import java.util.ArrayList;

public class PartidaEAllPreflopSTCC extends PartidaEAllPreflopSTC {
    private ArrayList<ComeCiegas > comeCiegas;
    private ArrayList<Integer> allin;
    public PartidaEAllPreflopSTCC() {
        super();
        this.allin=new ArrayList<>();
    }

    public ArrayList<ComeCiegas> getComeCiegas() {
        return comeCiegas;
    }

    public void setComeCiegas(ArrayList<ComeCiegas> comeCiegas) {
        this.comeCiegas = comeCiegas;
    }

    public ArrayList<Integer> getAllin() {
        return allin;
    }

    public void setAllin(ArrayList<Integer> allin) {
        this.allin = allin;
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
                    if (comeCiegas.get(getTurnoPreflop()).getApuesta() == 0) apuesta = tope;
                    else if (tope > comeCiegas.get(getTurnoPreflop()).getApuesta()-((RondaEPreflop)getRonda()).getApuestas().get(getTurnoPreflop()))
                        apuesta = comeCiegas.get(getTurnoPreflop()).getApuesta()-((RondaEPreflop)getRonda()).getApuestas().get(getTurnoPreflop());
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
                        allin.set(getTurnoPreflop(),1);
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

    public boolean apostoAlQueComoCiegas(Integer actual){
        boolean aposto=false;
        int i=0;
        while(i<getRonda().getMesa().getTamanyo() && !aposto){
            if(((RondaEPreflop) getRonda()).getApuestas().get(i)>20 && comeCiegas.get(actual).getJugadoresQueComo().get(i)==1){
                aposto=true;
            }
            i++;
        }
        return aposto;
    }

    public Integer metaIgualar(){
        int mayor=0;
        for(int i=0;i<getRonda().getMesa().getTamanyo();i++) {
            if(mayor<((RondaEPreflop)getRonda()).getApuestas().get(i)){
                mayor=((RondaEPreflop)getRonda()).getApuestas().get(i);
            }
        }
        return mayor;
    }

    public void anularPreflopSeguirOtros(){
        for(int i=0;i<getRonda().getMesa().getTamanyo();i++) {
            if(allin.get(i)==0) ((RondaEPreflop) getRonda()).getSigue().set(i, 0);
        }
    }

    public void limpiarAllin(){
        allin.clear();
        for(int i=0;i<getRonda().getMesa().getTamanyo();i++) {
            allin.add(0);
        }
    }

    @Override
    public void iterarRonda() {
        super.iterarRonda();
        limpiarAllin();
    }
}

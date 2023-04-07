package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.ciegas;

import com.poker.pokersimulate.modles.domains.dinero.basico.AsientoConFichas;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.RondaEPreflop;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.basico.PartidaEAllPreflopST;

public class PartidaEAllPreflopSTC extends PartidaEAllPreflopST {
    public PartidaEAllPreflopSTC() {
        super();
    }

    @Override
    public void iterarRonda() {
        Integer check1=preCheck();
        setSeguir(0);
        getRonda().clear();
        apuestaObligatoria();
        partidaPreflop();
        if (getSeguir()==1) {
            partidaPostflop();
        }else{
            terminarPartidaEnPreflop();
        }
        Integer check2=preCheck();
        opcionRecompraFichas();
        if(getDebug()==1){
            setInforme(getInforme()+generarInforme("Fin Ronda"));
        }else if(getDebug()==2 && !check1.equals(check2)){
            setInforme(getInforme()+"\nAlerta: Se esperaba "+check1+" se obtuvo: "+check2+"\n");
            setInforme(getInforme()+generarInforme("Fin Ronda"));
        }
        setContador(getContador()+1);

    }



    public void apuestaObligatoria(){
        Integer total = ((AsientoConFichas) getRonda().getMesa().getAsientos().get(getTurnoPrincipal())).getFichas();
        Integer ciegaGrande=2;
        if(total<=2) ciegaGrande=total;
        ((RondaEPreflop) getRonda()).apuesta(getRonda().getMesa().getAsientos().get(getTurnoPrincipal()).getPosicion(), ciegaGrande);
        total = ((AsientoConFichas) getRonda().getMesa().getAsientos().get(getTurnoPrincipalAnterior())).getFichas();
        Integer ciegaPeque=1;
        if(total<=1) ciegaPeque=total;
        ((RondaEPreflop) getRonda()).apuesta(getRonda().getMesa().getAsientos().get(getTurnoPrincipalAnterior()).getPosicion(), ciegaPeque);
    }

}

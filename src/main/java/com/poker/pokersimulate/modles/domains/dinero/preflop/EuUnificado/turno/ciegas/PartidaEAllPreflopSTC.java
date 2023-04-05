package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.ciegas;

import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.basico.PartidaEAllPreflopST;

public class PartidaEAllPreflopSTC extends PartidaEAllPreflopST {
    public PartidaEAllPreflopSTC() {
        super();
    }
/*
    @Override
    public void iterarRonda() {

        setSeguir(true);
        Ronda ronda = getRonda();
        ronda.clear();
        ronda = apuestaObligatoria(ronda);
        ronda = partidaPreflop(ronda);
        if (isSeguir()) {
            ronda=partidaPostflop(ronda);
        }else{
            ronda=terminarPartidaEnPreflop(ronda);
        }
        ((RondaESTCPreflop)ronda).limpiarSigueCiega();
        setRonda(ronda);
    }

    public Ronda apuestaObligatoria(Ronda ronda) {
        RondaESTCPreflop rondaE2ConDinero = (RondaESTCPreflop) ronda;

        Integer total = ((AsientosConFichas) getRonda().getMesa().getAsientos().get(getTurnoPrincipal())).getFichas();
        Integer ciegaGrande=2;
        if(total<=2) ciegaGrande=total;
        rondaE2ConDinero.apuestaCiegas(getRonda().getMesa().getAsientos().get(getTurnoPrincipal()).getPosicion(), ciegaGrande);
        rondaE2ConDinero.getSigueCiega().set(getTurnoPrincipal(),1);
        total = ((AsientosConFichas) getRonda().getMesa().getAsientos().get(getTurnoPrincipalAnterior())).getFichas();
        Integer ciegaPeque=1;
        if(total<=1) ciegaPeque=total;
        rondaE2ConDinero.apuestaCiegas(getRonda().getMesa().getAsientos().get(getTurnoPrincipalAnterior()).getPosicion(), ciegaPeque);

        return rondaE2ConDinero;
    }

*/
}

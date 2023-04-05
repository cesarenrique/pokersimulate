package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.ciegas;

import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.RondaEPreflop;

import java.util.ArrayList;

public class RondaESTCPreflop extends RondaEPreflop {

    private ArrayList<Integer> sigueCiega;

    public RondaESTCPreflop() {
        super();
        sigueCiega=new ArrayList<>();
    }
/*
    public ArrayList<Integer> getSigueCiega() {
        return sigueCiega;
    }

    public void setSigueCiega(ArrayList<Integer> sigueCiega) {
        this.sigueCiega = sigueCiega;
    }

    @Override
    public void generarGanadoresPreflop() {
        super.generarGanadoresPreflop();
        Integer intencionSeguir=intencionSeguir();
        if(intencionSeguir==0){
            Integer quien=intencionSeguirCiegaQuien();
            getRanking().clear();
            Ganador ganador = new Ganador();
            ganador.setPosicion(getMesa().getAsientos().get(quien).getPosicion());
            ganador.setJerarquia5(null);
            ganador.setJugador(getMesa().getAsientos().get(quien).getJugador());
            PosRanking posRanking=new PosRanking();
            posRanking.getGanadores().add(ganador);
            getRanking().getPosRankings().add(posRanking);
        }
    }

    public Integer intencionSeguirCiegaQuien() {
        Integer quien = 0;
        int tam = sigueCiega.size();
        for (int i = 0; i < tam; i++) {
            if (sigueCiega.get(i) > 0) quien = i;
        }
        return quien;

    }

    public void limpiarSigueCiega(){
        sigueCiega.clear();
        int tam = getMesa().getTamanyo();
        for (int i = 0; i < tam; i++) {
            sigueCiega.add(0);
        }
    }
    public void apuestaCiegas(Integer posicion, Integer apuesta) {

        Integer fichas = ((AsientosConFichas) getMesa().getAsientos().get(posicion)).getFichas();
        Integer queda = fichas - apuesta;
        getApuestas().set(posicion, apuesta);
        ((AsientosConFichas) getMesa().getAsientos().get(posicion)).setFichas(queda);
    }
*/
}

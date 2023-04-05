package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico;

import com.poker.pokersimulate.modles.domains.basico.Ganador;
import com.poker.pokersimulate.modles.domains.basico.PosRanking;
import com.poker.pokersimulate.modles.domains.basico.Ranking;
import com.poker.pokersimulate.modles.domains.dinero.basico.RondaEConDinero;


public class RondaEPreflop extends RondaEConDinero {
    public RondaEPreflop() {
        super();
        setTipo(40);
    }

    public void generarGanadoresPreflop(){
        Integer intensionSeguir=intencionSeguir();
        if(intensionSeguir==1) {

            Integer quien=intencionSeguirQuien();
            getRankings().clear();
            Ganador ganador = new Ganador();
            ganador.setPosicion(getMesa().getAsientos().get(quien).getPosicion());
            ganador.setJerarquia5(null);
            ganador.setJugador(getMesa().getAsientos().get(quien).getJugador());
            PosRanking posRanking=new PosRanking();
            posRanking.getGanadores().add(ganador);
            Ranking ranking=new Ranking();
            ranking.getPosRankings().add(posRanking);
            getRankings().add(ranking);
        }

    }


}

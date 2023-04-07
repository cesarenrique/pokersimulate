package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.escalonado.basico;

import com.poker.pokersimulate.models.entity.SegmentacionFormal;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.EuristicaPreflopLineal;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.EuristicaPreflopLinealExpand;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.RankingPreflopEuristicas;

import java.util.ArrayList;

public class GeneradorRankingsEuristicos {
    private ArrayList<RankingPreflopEuristicas> rankingEuristicas;
    private ArrayList<SemillaRankingEuristico> semillasRankings;

    public GeneradorRankingsEuristicos() {
        rankingEuristicas=new ArrayList<>();
        semillasRankings=new ArrayList<>();
    }

    public ArrayList<RankingPreflopEuristicas> getRankingEuristicas() {
        return rankingEuristicas;
    }

    public void setRankingEuristicas(ArrayList<RankingPreflopEuristicas> rankingEuristicas) {
        this.rankingEuristicas = rankingEuristicas;
    }

    public ArrayList<SemillaRankingEuristico> getSemillasRankings() {
        return semillasRankings;
    }

    public void setSemillasRankings(ArrayList<SemillaRankingEuristico> semillasRankings) {
        this.semillasRankings = semillasRankings;
    }

    public void generarEuristicas(ArrayList<SegmentacionFormal> formal){
        rankingEuristicas.clear();

        for(SemillaRankingEuristico semillaRanking:semillasRankings){
            RankingPreflopEuristicas ranking = new RankingPreflopEuristicas();

            for(Integer semilla:semillaRanking.getSemillas()) {
                EuristicaPreflopLineal eu = new EuristicaPreflopLineal();
                eu.retructurarDatos(formal);
                eu.setProfundidad(semilla);

                EuristicaPreflopLinealExpand euE = new EuristicaPreflopLinealExpand();
                euE.expandir(eu);

                ranking.getEuristicas().add(euE);

            }
            ranking.setApuestas(semillaRanking.getApuestas());
            ranking.setPosicion(semillaRanking.getApuestas().size()-1);
            rankingEuristicas.add(ranking);

        }

    }



}

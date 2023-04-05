package com.poker.pokersimulate.modles.domains.basico;

import java.util.ArrayList;

public class Ranking {

    ArrayList<PosRanking> posRankings;
    public Ranking() {
        posRankings=new ArrayList<>();
    }

    public Ranking(Ranking otro) {
        posRankings=new ArrayList<>();
        for(PosRanking posRanking:otro.getPosRankings()){
            PosRanking nuevo=new PosRanking(posRanking);
            posRankings.add(nuevo);
        }
    }

    public ArrayList<PosRanking> getPosRankings() {
        return posRankings;
    }

    public void setPosRankings(ArrayList<PosRanking> posRankings) {
        this.posRankings = posRankings;
    }

    public void clear(){
        posRankings.clear();
    }

    public void eliminarLista(ArrayList<Integer> posiciones){
        for(Integer eliminar:posiciones){
            eliminarUno(eliminar);
        }
    }

    public void eliminarUno(Integer eliminar){
        int x=-1;
        int y=-1;
        int i=0;
        int j=0;
        for(PosRanking buscadoY:posRankings){
            for(Ganador buscadoX: buscadoY.getGanadores()){
                if(buscadoX.getPosicion().equals(eliminar)){
                    x=j;
                    y=i;
                }
                j++;
            }
            i++;
        }
        if(x!=-1){
            if(posRankings.get(y).getGanadores().size()==1){
                posRankings.remove(posRankings.get(y));
            }else{
                posRankings.get(y).getGanadores().remove(posRankings.get(y).getGanadores().get(x));
            }
        }

    }
}

package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico;

import java.util.ArrayList;

public class RankingPreflopEuristicas {
    private ArrayList<EuristicaPreflopLinealExpand> euristicas;
    private ArrayList<Integer> apuestas;
    private Integer posicion;
    public RankingPreflopEuristicas() {
        this.euristicas=new ArrayList<>();
        this.apuestas=new ArrayList<>();
    }

    public ArrayList<EuristicaPreflopLinealExpand> getEuristicas() {
        return euristicas;
    }

    public void setEuristicas(ArrayList<EuristicaPreflopLinealExpand> euristicas) {
        this.euristicas = euristicas;
    }

    public ArrayList<Integer> getApuestas() {
        return apuestas;
    }

    public void setApuestas(ArrayList<Integer> apuestas) {
        this.apuestas = apuestas;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public void retrocederUnaPosicion(){
        if(posicion<=0) posicion=0;
        else posicion--;
    }
}

package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico;

import com.poker.pokersimulate.modles.domains.dinero.basico.EstadisticaConDinero;

import java.util.ArrayList;

public class EstadisticaA extends EstadisticaConDinero {

    private ArrayList<Integer> preflopSeguir;
    private ArrayList<Integer> ganadosPreflop;
    private ArrayList<Integer> ganadosPostflop;
    public EstadisticaA() {
        super();
        preflopSeguir=new ArrayList<>();
        ganadosPreflop=new ArrayList<>();
        ganadosPostflop=new ArrayList<>();
    }

    public ArrayList<Integer> getPreflopSeguir() {
        return preflopSeguir;
    }

    public void setPreflopSeguir(ArrayList<Integer> preflopSeguir) {
        this.preflopSeguir = preflopSeguir;
    }

    public ArrayList<Integer> getGanadosPreflop() {
        return ganadosPreflop;
    }

    public void setGanadosPreflop(ArrayList<Integer> ganadosPreflop) {
        this.ganadosPreflop = ganadosPreflop;
    }

    public ArrayList<Integer> getGanadosPostflop() {
        return ganadosPostflop;
    }

    public void setGanadosPostflop(ArrayList<Integer> ganadosPostflop) {
        this.ganadosPostflop = ganadosPostflop;
    }

    public void preflopSeguirMasUno(Integer pos){
        Integer aux=preflopSeguir.get(pos);
        aux++;
        preflopSeguir.set(pos,aux);
    }

    public void ganadosPreflopMasUno(Integer pos){
        Integer aux=ganadosPreflop.get(pos);
        aux++;
        ganadosPreflop.set(pos,aux);
    }

    public void ganadosPostflopMasUno(Integer pos){
        Integer aux=ganadosPostflop.get(pos);
        aux++;
        ganadosPostflop.set(pos,aux);
    }
}

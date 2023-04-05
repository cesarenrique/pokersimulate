package com.poker.pokersimulate.modles.domains.dinero.preflop.jerarquiaDinero;

import com.poker.pokersimulate.modles.domains.dinero.basico.EstadisticaConDinero;

import java.util.ArrayList;

public class EstadisticaA extends EstadisticaConDinero {

    private ArrayList<Integer> preflopSeguir;
    public EstadisticaA() {
        super();
        preflopSeguir=new ArrayList<>();
    }

    public ArrayList<Integer> getPreflopSeguir() {
        return preflopSeguir;
    }

    public void setPreflopSeguir(ArrayList<Integer> preflopSeguir) {
        this.preflopSeguir = preflopSeguir;
    }

    public void preflopSeguirMasUno(Integer pos){
        Integer aux=preflopSeguir.get(pos);
        aux++;
        preflopSeguir.set(pos,aux);
    }
}

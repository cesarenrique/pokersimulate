package com.poker.pokersimulate.modles.domains.dinero.postflop.basico;

import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.EstadisticaA;

import java.util.ArrayList;

public class EstadisticaAB extends EstadisticaA {
    private ArrayList<Integer> postflopSeguir;
    public EstadisticaAB() {
        super();
        postflopSeguir=new ArrayList<>();
    }

    public ArrayList<Integer> getPostflopSeguir() {
        return postflopSeguir;
    }

    public void setPostflopSeguir(ArrayList<Integer> postflopSeguir) {
        this.postflopSeguir = postflopSeguir;
    }

    public void postflopSeguirMasUno(Integer pos){
        Integer aux=postflopSeguir.get(pos);
        aux++;
        postflopSeguir.set(pos,aux);
    }
}

package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico;

import com.poker.pokersimulate.models.entity.SegmentacionFormal;
import com.poker.pokersimulate.modles.domains.basico.Carta;
import com.poker.pokersimulate.modles.domains.basico.Pareja;

import java.util.ArrayList;

public class EuristicaPreflopLineal {

    private ArrayList<Pareja> parejas;
    private Integer profundidad;

    public EuristicaPreflopLineal() {
        parejas=new ArrayList<>();
    }

    public ArrayList<Pareja> getParejas() {
        return parejas;
    }

    public void setParejas(ArrayList<Pareja> parejas) {
        this.parejas = parejas;
    }

    public Integer getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(Integer profundidad) {
        this.profundidad = profundidad;
    }

    public void retructurarDatos(ArrayList<SegmentacionFormal> segmentacionFormals){

        for(SegmentacionFormal segmentacionFormal: segmentacionFormals){
            Carta c1=new Carta(segmentacionFormal.getNumero1(),segmentacionFormal.getPalo1());
            Carta c2=new Carta(segmentacionFormal.getNumero2(),segmentacionFormal.getPalo2());
            Pareja p1=new Pareja();
            p1.anyadirCartas(c1);
            p1.anyadirCartas(c2);
            parejas.add(p1);
        }
    }
}

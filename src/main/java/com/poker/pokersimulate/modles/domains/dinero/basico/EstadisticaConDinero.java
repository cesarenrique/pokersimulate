package com.poker.pokersimulate.modles.domains.dinero.basico;

import com.poker.pokersimulate.modles.domains.basico.Asiento;
import com.poker.pokersimulate.modles.domains.estadistica.Estadistica;

import java.util.ArrayList;

public class EstadisticaConDinero extends Estadistica {

    private ArrayList<Integer> saldos;
    public EstadisticaConDinero() {
        super();
        saldos=new ArrayList<>();
    }

    public ArrayList<Integer> getSaldos() {
        return saldos;
    }

    public void setSaldos(ArrayList<Integer> saldos) {
        this.saldos = saldos;
    }


}

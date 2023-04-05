package com.poker.pokersimulate.modles.domains.basico;

import java.util.ArrayList;

public class PosRanking {

    ArrayList<Ganador> ganadores;
    public PosRanking() {
        ganadores=new ArrayList<>();

    }

    public PosRanking(PosRanking otro) {
        ganadores=new ArrayList<>();

        for(Ganador ganador:otro.getGanadores()){
            Ganador nuevo=new Ganador(ganador);
            ganadores.add(nuevo);
        }
    }

    public ArrayList<Ganador> getGanadores() {
        return ganadores;
    }

    public void setGanadores(ArrayList<Ganador> ganadores) {
        this.ganadores = ganadores;
    }
}

package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.escalonado.basico;

import java.util.ArrayList;

public class SemillaRankingEuristico {
    private ArrayList<Integer> semillas;
    private ArrayList<Integer> apuestas;
    public SemillaRankingEuristico() {
        semillas=new ArrayList<>();
        apuestas=new ArrayList<>();
    }

    public SemillaRankingEuristico(ArrayList<Integer> semillas, ArrayList<Integer> apuestas) {
        this.semillas = semillas;
        this.apuestas = apuestas;
    }

    public ArrayList<Integer> getSemillas() {
        return semillas;
    }

    public void setSemillas(ArrayList<Integer> semillas) {
        this.semillas = semillas;
    }

    public ArrayList<Integer> getApuestas() {
        return apuestas;
    }

    public void setApuestas(ArrayList<Integer> apuestas) {
        this.apuestas = apuestas;
    }
}

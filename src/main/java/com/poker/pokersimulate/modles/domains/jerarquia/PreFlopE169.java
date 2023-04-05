package com.poker.pokersimulate.modles.domains.jerarquia;

import java.util.ArrayList;

public class PreFlopE169 {

    private ArrayList<PreflopE> preflopE169;

    public PreFlopE169() {
        preflopE169 = new ArrayList<>();
    }

    public ArrayList<PreflopE> getPreflopE169() {
        return preflopE169;
    }

    public void setPreflopE169(ArrayList<PreflopE> preflopE169) {
        this.preflopE169 = preflopE169;
    }

    public void anyadirPreFlopE(PreflopE preflopE) {
        preflopE169.add(preflopE);
    }

    public void ordenar() {
        Integer tam = preflopE169.size();
        for (int i = 0; i < tam; i++) {
            for (int j = i + 1; j < tam; j++) {
                if (preflopE169.get(i).getEstadistica().getGanados().get(0) <
                        preflopE169.get(j).getEstadistica().getGanados().get(0)) {
                    PreflopE aux = preflopE169.get(i);
                    PreflopE aux2 = preflopE169.get(j);
                    preflopE169.set(i, aux2);
                    preflopE169.set(j, aux);
                }
            }
        }
    }

    public void porcentajes() {

        for (PreflopE preFlopE: preflopE169) {
            preFlopE.getEstadistica().generarPorcentaje();
        }
    }
}

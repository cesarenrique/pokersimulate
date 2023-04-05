package com.poker.pokersimulate.modles.domains.dinero.basico;

import com.poker.pokersimulate.modles.domains.basico.Asiento;

public class AsientoConFichas extends Asiento {

    private Integer fichas;

    public AsientoConFichas() {
        super();
    }

    public Integer getFichas() {
        return fichas;
    }

    public void setFichas(Integer fichas) {
        this.fichas = fichas;
    }
}

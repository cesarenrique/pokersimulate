package com.poker.pokersimulate.modles.domains.dinero.basico;

import com.poker.pokersimulate.modles.domains.basico.Mesa;

public class MesaConDinero extends Mesa {
    public MesaConDinero() {
        super();
    }

    @Override
    public void generarAsientos() {
        getAsientos().clear();
        for(int i=0;i<getTamanyo();i++) {
            getAsientos().add(new AsientoConFichas());
        }
    }
}

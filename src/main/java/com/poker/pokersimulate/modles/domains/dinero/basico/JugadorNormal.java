package com.poker.pokersimulate.modles.domains.dinero.basico;

import com.poker.pokersimulate.modles.domains.basico.Jugador;

public class JugadorNormal extends Jugador {

    private Integer Saldo;

    public JugadorNormal() {
        super();
    }

    public Integer getSaldo() {
        return Saldo;
    }

    public void setSaldo(Integer saldo) {
        Saldo = saldo;
    }
}

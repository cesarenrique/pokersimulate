package com.poker.pokersimulate.models.data;

import com.poker.pokersimulate.modles.domains.basico.Pareja;

public class PreFlopEData {
    private Pareja pareja;
    private String porcentaje;
    private Integer saldo;
    private Long id;

    public Pareja getPareja() {
        return pareja;
    }

    public void setPareja(Pareja pareja) {
        this.pareja = pareja;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

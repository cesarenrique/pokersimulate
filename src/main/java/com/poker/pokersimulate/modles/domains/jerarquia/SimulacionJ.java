package com.poker.pokersimulate.modles.domains.jerarquia;

import com.poker.pokersimulate.modles.domains.basico.Baraja;
import com.poker.pokersimulate.modles.domains.basico.Partida;
import com.poker.pokersimulate.modles.domains.basico.Ronda;
import com.poker.pokersimulate.modles.domains.estadistica.Estadistica;
import com.poker.pokersimulate.modles.domains.estadistica.RondaE;
import com.poker.pokersimulate.modles.domains.estadistica.SimulacionE;


public class SimulacionJ extends SimulacionE {

    private PreFlopE169 preFlop;
    private SupraSegmentacion supra;
    private Integer posicion;

    public SimulacionJ() {
        super();
        posicion=0;
    }


    public PreFlopE169 getPreFlop() {
        return preFlop;
    }

    public void setPreFlop(PreFlopE169 preFlop) {
        this.preFlop = preFlop;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public SupraSegmentacion getSupra() {
        return supra;
    }

    public void setSupra(SupraSegmentacion supra) {
        this.supra = supra;
    }

    @Override
    public void simularPartida() {
        super.simularPartida();
        extrearDatosPartida();

    }

    public void extrearDatosPartida(){
        Estadistica estadistica=((RondaE)getPartida().getRonda()).getEstadistica();
        PreflopE preflopE=new PreflopE();
        preflopE.setEstadistica(estadistica);
        preflopE.setPareja(supra.getSupra().get(posicion));
        preFlop.anyadirPreFlopE(preflopE);
    }

    public void prepararResultado(){
        preFlop.porcentajes();
        preFlop.ordenar();
    }



    public void simulacionGeneral(){
        int tam=supra.getSupra().size();
        posicion=0;
        for(int i=0;i<tam;i++){
            prepararPartida();
            simularPartida();
            posicion++;
        }
        prepararResultado();
    }

    public void inyectarBaraja(){
        Trucada2 baraja = new Trucada2();
        baraja.setPareja(supra.getSupra().get(posicion));
        baraja.generarBaraja();
        getPartida().getRonda().setBaraja(baraja);
    }


}

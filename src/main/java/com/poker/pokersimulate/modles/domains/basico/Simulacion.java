package com.poker.pokersimulate.modles.domains.basico;


import java.util.ArrayList;

public class Simulacion {

    private Partida partida;
    private Integer repeticiones;
    public Simulacion() {
        repeticiones=1000;
    }

    public Integer getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(Integer repeticiones) {
        this.repeticiones = repeticiones;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public void prepararPartida() {
        inyectarPartida();
        injectarRondaOportuna();
        inyectarBaraja();
        inyectarMesaOportuna();
        prepararMesa();
    }

    public void inyectarBaraja(){
        Baraja baraja = new Baraja();
        baraja.generarBaraja();
        getPartida().getRonda().setBaraja(baraja);
    }

    public void inyectarPartida(){
        partida = new Partida();
    }


    public void injectarRondaOportuna(){
        getPartida().setRonda(new Ronda());
    }

    public void inyectarMesaOportuna() {
        getPartida().getRonda().setMesa(new Mesa2());
    }

    public void prepararMesa(){
        getPartida().getRonda().getMesa().generarAsientos();
        Integer contador2 = 0;
        for (Asiento asiento : getPartida().getRonda().getMesa().getAsientos()) {
            asiento.setJugador(new Jugador());
            asiento.setCombinacion7(new Combinacion7());
            asiento.setPareja(new Pareja());
            asiento.setPosicion(contador2);
            contador2++;
        }
    }

    public void simularPartida() {
        partida.iterarRondas(repeticiones);
    }

}

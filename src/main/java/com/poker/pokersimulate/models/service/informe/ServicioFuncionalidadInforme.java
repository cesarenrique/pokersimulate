package com.poker.pokersimulate.models.service.informe;

import com.poker.pokersimulate.modles.domains.basico.*;
import com.poker.pokersimulate.modles.domains.dinero.preflop.jerarquiaDinero.PartidaEAllPreflop;
import com.poker.pokersimulate.modles.domains.dinero.preflop.jerarquiaDinero.SimulacionJAll;
import com.poker.pokersimulate.modles.domains.dinero.preflop.jerarquiaDinero.SimulacionJAll6;
import com.poker.pokersimulate.modles.domains.estadistica.*;
import com.poker.pokersimulate.modles.domains.jerarquia.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ServicioFuncionalidadInforme {


    public Ronda rondaTerminada01(){
        Baraja baraja = new Baraja();
        baraja.generarBaraja();
        Mesa2 mesa = new Mesa2();
        Ronda ronda = new Ronda();
        ronda.setBaraja(baraja);
        ronda.setMesa(mesa);
        mesa.generarAsientos();
        ArrayList<Asiento> asientos = mesa.getAsientos();
        Integer contador=0;
        for (Asiento asiento : asientos) {
            Jugador j = new Jugador();
            Combinacion7 combinacion7=new Combinacion7();
            Pareja p=new Pareja();
            asiento.setJugador(j);
            asiento.setCombinacion7(combinacion7);
            asiento.setPosicion(contador);
            asiento.setPareja(p);
            contador++;
        }
        ronda.repartirCartasJugadores();
        ronda.repartirComunitarias();
        return ronda;
    }


    public Ronda rondaTerminada02(){
        Baraja baraja = new Baraja();
        baraja.generarBaraja();
        Mesa2 mesa = new Mesa2();
        Ronda ronda = new Ronda();
        ronda.setBaraja(baraja);
        ronda.setMesa(mesa);
        mesa.generarAsientos();
        ArrayList<Asiento> asientos = mesa.getAsientos();
        Integer contador=0;
        for (Asiento asiento : asientos) {
            Jugador j = new Jugador();
            Combinacion7 combinacion7=new Combinacion7();
            Pareja p=new Pareja();
            asiento.setJugador(j);
            asiento.setCombinacion7(combinacion7);
            asiento.setPosicion(contador);
            asiento.setPareja(p);
            contador++;
        }
        ronda.repartirCartasJugadores();
        ronda.repartirComunitarias();
        ronda.evaluarJugadores();
        ArrayList<ArrayList<Integer> > igualadas=new ArrayList<>();
        ArrayList<Integer> igualo=new ArrayList<>();
        for(int i=0;i<ronda.getMesa().getTamanyo();i++){
            igualo.add(i);
        }
        igualadas.add(igualo);
        ronda.setIgualadas(igualadas);
        ronda.generarGanadores();
        return ronda;
    }


    public Ronda rondaTerminada03(){
        Baraja baraja = new Baraja();
        baraja.generarBaraja();
        Mesa2 mesa = new Mesa2();
        Ronda ronda = new Ronda();
        ronda.setBaraja(baraja);
        ronda.setMesa(mesa);
        mesa.generarAsientos();
        ArrayList<Asiento> asientos = mesa.getAsientos();
        Integer contador=0;
        for (Asiento asiento : asientos) {
            Jugador j = new Jugador();
            Combinacion7 combinacion7=new Combinacion7();
            Pareja p=new Pareja();
            asiento.setJugador(j);
            asiento.setCombinacion7(combinacion7);
            asiento.setPosicion(contador);
            asiento.setPareja(p);
            contador++;
        }
        ronda.repartirCartasJugadores();
        ronda.repartirComunitarias();
        ronda.evaluarJugadores();
        ArrayList<ArrayList<Integer> > igualadas=new ArrayList<>();
        ArrayList<Integer> igualo=new ArrayList<>();
        for(int i=0;i<ronda.getMesa().getTamanyo();i++){
            igualo.add(i);
        }
        igualadas.add(igualo);
        ronda.setIgualadas(igualadas);
        ronda.generarGanadores();
        return ronda;
    }



    public Ronda rondaTerminada04(){
        Baraja baraja = new Baraja();
        baraja.generarBaraja();
        Mesa6 mesa = new Mesa6();
        Ronda ronda = new Ronda();
        ronda.setBaraja(baraja);
        ronda.setMesa(mesa);
        mesa.generarAsientos();
        ArrayList<Asiento> asientos = mesa.getAsientos();
        Integer contador=0;
        for (Asiento asiento : asientos) {
            Jugador j = new Jugador();
            Combinacion7 combinacion7=new Combinacion7();
            Pareja p=new Pareja();
            asiento.setJugador(j);
            asiento.setCombinacion7(combinacion7);
            asiento.setPosicion(contador);
            asiento.setPareja(p);
            contador++;
        }
        ronda.repartirCartasJugadores();
        ronda.repartirComunitarias();
        ronda.evaluarJugadores();
        ArrayList<ArrayList<Integer> > igualadas=new ArrayList<>();
        ArrayList<Integer> igualo=new ArrayList<>();
        for(int i=0;i<ronda.getMesa().getTamanyo();i++){
            igualo.add(i);
        }
        igualadas.add(igualo);
        ronda.setIgualadas(igualadas);
        ronda.generarGanadores();
        return ronda;
    }


    public Simulacion generarSimulacion(){

        Simulacion simulacion=new Simulacion();
        simulacion.setRepeticiones(30);
        simulacion.prepararPartida();
        simulacion.getPartida().setDebug(1);
        simulacion.simularPartida();


        return simulacion;

    }

    public SimulacionE generarSimulacionE(){

        SimulacionE simulacionE=new SimulacionE();
        simulacionE.setRepeticiones(30);
        simulacionE.prepararPartida();
        simulacionE.getPartida().setDebug(1);
        simulacionE.simularPartida();

        return simulacionE;
    }


    public SimulacionE6 generarSimulacionE6(){

        SimulacionE6 simulacionE=new SimulacionE6();
        simulacionE.setRepeticiones(30);
        simulacionE.prepararPartida();
        simulacionE.getPartida().setDebug(1);
        simulacionE.simularPartida();

        return simulacionE;
    }


    public SimulacionE6 generarSimulacionE6Alt2(){

        SimulacionE6 simulacionE=new SimulacionE6();
        simulacionE.setRepeticiones(10000);
        simulacionE.prepararPartida();
        simulacionE.simularPartida();

        return simulacionE;
    }


    public SimulacionJ simulacionJ(){
        SupraSegmentacion supra=new SupraSegmentacion();
        supra.generarSupra();

        PreFlopE169 preFlopE169=new PreFlopE169();

        SimulacionJ simulacion=new SimulacionJ();
        simulacion.setPreFlop(preFlopE169);
        simulacion.setSupra(supra);
        simulacion.setRepeticiones(30);
        simulacion.setPosicion(0);
        simulacion.prepararPartida();
        simulacion.getPartida().setDebug(1);
        simulacion.simularPartida();

        return simulacion;
    }


    public SimulacionJ simulacionJ2General(){

        SupraSegmentacion supra=new SupraSegmentacion();
        supra.generarSupra();
        PreFlopE169 preFlopE169=new PreFlopE169();
        SimulacionJ simulacion=new SimulacionJ();
        simulacion.setPreFlop(preFlopE169);
        simulacion.setSupra(supra);
        simulacion.simulacionGeneral();

        return simulacion;
    }

    public SimulacionJ6 simulacionJ6General(){

        SupraSegmentacion supra=new SupraSegmentacion();
        supra.generarSupra();
        PreFlopE169 preFlopE169=new PreFlopE169();
        SimulacionJ6 simulacion=new SimulacionJ6();
        simulacion.setPreFlop(preFlopE169);
        simulacion.setSupra(supra);
        simulacion.simulacionGeneral();

        return simulacion;
    }


    public SimulacionJAll simulacionJ2All(){

        SupraSegmentacion supra=new SupraSegmentacion();
        supra.generarSupra();
        PreFlopE169 preFlopE169=new PreFlopE169();
        SimulacionJAll simulacion=new SimulacionJAll();
        simulacion.setRepeticiones(30);
        simulacion.setPreFlop(preFlopE169);
        simulacion.setSupra(supra);
        simulacion.setPosicion(0);
        simulacion.prepararPartida();
        simulacion.getPartida().setDebug(1);
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionJAll6 simulacionJAll6(){

        SupraSegmentacion supra=new SupraSegmentacion();
        supra.generarSupra();
        PreFlopE169 preFlopE169=new PreFlopE169();
        SimulacionJAll6 simulacion=new SimulacionJAll6();
        simulacion.setRepeticiones(30);
        simulacion.setPreFlop(preFlopE169);
        simulacion.setSupra(supra);
        simulacion.setPosicion(0);
        simulacion.prepararPartida();
        simulacion.getPartida().setDebug(1);
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionJAll simulacionJ2AllGeneral(){

        SupraSegmentacion supra=new SupraSegmentacion();
        supra.generarSupra();
        PreFlopE169 preFlopE169=new PreFlopE169();
        SimulacionJAll simulacion=new SimulacionJAll();
        simulacion.setPreFlop(preFlopE169);
        simulacion.setSupra(supra);
        simulacion.simulacionGeneral();

        return simulacion;
    }

    public SimulacionJAll6 simulacionJAll6General(){

        SupraSegmentacion supra=new SupraSegmentacion();
        supra.generarSupra();
        PreFlopE169 preFlopE169=new PreFlopE169();
        SimulacionJAll6 simulacion=new SimulacionJAll6();
        simulacion.setPreFlop(preFlopE169);
        simulacion.setSupra(supra);
        simulacion.simulacionGeneral();

        return simulacion;
    }
}

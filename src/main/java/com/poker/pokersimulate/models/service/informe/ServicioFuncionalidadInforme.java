package com.poker.pokersimulate.models.service.informe;

import com.poker.pokersimulate.models.entity.SegmentacionFormal;
import com.poker.pokersimulate.modles.domains.basico.*;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.EuristicaPreflopLineal;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.EuristicaPreflopLinealExpand;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.SimulacionS;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.SimulacionS6;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.basico.SimulacionST;
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


    public SimulacionJAll simulacionJAllcheck(){

        SupraSegmentacion supra=new SupraSegmentacion();
        supra.generarSupra();
        PreFlopE169 preFlopE169=new PreFlopE169();
        SimulacionJAll simulacion=new SimulacionJAll();
        simulacion.setRepeticiones(200);
        simulacion.setPreFlop(preFlopE169);
        simulacion.setSupra(supra);
        simulacion.setPosicion(0);
        simulacion.prepararPartida();
        simulacion.getPartida().setDebug(2);
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionJAll6 simulacionJAll6check(){

        SupraSegmentacion supra=new SupraSegmentacion();
        supra.generarSupra();
        PreFlopE169 preFlopE169=new PreFlopE169();
        SimulacionJAll6 simulacion=new SimulacionJAll6();
        simulacion.setRepeticiones(200);
        simulacion.setPreFlop(preFlopE169);
        simulacion.setSupra(supra);
        simulacion.setPosicion(0);
        simulacion.prepararPartida();
        simulacion.getPartida().setDebug(2);
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionS simulacionS(ArrayList<SegmentacionFormal> formal){

        EuristicaPreflopLineal eu1=new EuristicaPreflopLineal();
        eu1.retructurarDatos(formal);
        eu1.setProfundidad(50);

        EuristicaPreflopLineal eu2=new EuristicaPreflopLineal();
        eu2.retructurarDatos(formal);
        eu2.setProfundidad(100);

        EuristicaPreflopLinealExpand eu1E = new EuristicaPreflopLinealExpand();
        eu1E.expandir(eu1);

        EuristicaPreflopLinealExpand eu2E = new EuristicaPreflopLinealExpand();
        eu2E.expandir(eu2);

        ArrayList<EuristicaPreflopLinealExpand> euristicas=new ArrayList<>();
        euristicas.add(eu1E);
        euristicas.add(eu2E);

        SimulacionS simulacion=new SimulacionS();
        simulacion.setEuristicas(euristicas);
        simulacion.prepararPartida();
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionS simulacionSInforme(ArrayList<SegmentacionFormal> formal){

        EuristicaPreflopLineal eu1=new EuristicaPreflopLineal();
        eu1.retructurarDatos(formal);
        eu1.setProfundidad(50);

        EuristicaPreflopLineal eu2=new EuristicaPreflopLineal();
        eu2.retructurarDatos(formal);
        eu2.setProfundidad(100);

        EuristicaPreflopLinealExpand eu1E = new EuristicaPreflopLinealExpand();
        eu1E.expandir(eu1);

        EuristicaPreflopLinealExpand eu2E = new EuristicaPreflopLinealExpand();
        eu2E.expandir(eu2);

        ArrayList<EuristicaPreflopLinealExpand> euristicas=new ArrayList<>();
        euristicas.add(eu1E);
        euristicas.add(eu2E);

        SimulacionS simulacion=new SimulacionS();
        simulacion.setRepeticiones(200);
        simulacion.setEuristicas(euristicas);
        simulacion.prepararPartida();
        simulacion.getPartida().setDebug(1);
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionS6 simulacionS6Informe(ArrayList<SegmentacionFormal> formal){

        EuristicaPreflopLineal eu1=new EuristicaPreflopLineal();
        eu1.retructurarDatos(formal);
        eu1.setProfundidad(190);

        EuristicaPreflopLineal eu2=new EuristicaPreflopLineal();
        eu2.retructurarDatos(formal);
        eu2.setProfundidad(130);

        EuristicaPreflopLineal eu3=new EuristicaPreflopLineal();
        eu3.retructurarDatos(formal);
        eu3.setProfundidad(90);

        EuristicaPreflopLineal eu4=new EuristicaPreflopLineal();
        eu4.retructurarDatos(formal);
        eu4.setProfundidad(50);

        EuristicaPreflopLineal eu5=new EuristicaPreflopLineal();
        eu5.retructurarDatos(formal);
        eu5.setProfundidad(30);

        EuristicaPreflopLineal eu6=new EuristicaPreflopLineal();
        eu6.retructurarDatos(formal);
        eu6.setProfundidad(20);

        EuristicaPreflopLinealExpand eu1E = new EuristicaPreflopLinealExpand();
        eu1E.expandir(eu1);

        EuristicaPreflopLinealExpand eu2E = new EuristicaPreflopLinealExpand();
        eu2E.expandir(eu2);

        EuristicaPreflopLinealExpand eu3E = new EuristicaPreflopLinealExpand();
        eu3E.expandir(eu3);

        EuristicaPreflopLinealExpand eu4E = new EuristicaPreflopLinealExpand();
        eu4E.expandir(eu4);

        EuristicaPreflopLinealExpand eu5E = new EuristicaPreflopLinealExpand();
        eu5E.expandir(eu5);

        EuristicaPreflopLinealExpand eu6E = new EuristicaPreflopLinealExpand();
        eu6E.expandir(eu6);

        ArrayList<EuristicaPreflopLinealExpand> euristicas=new ArrayList<>();
        euristicas.add(eu1E);
        euristicas.add(eu2E);
        euristicas.add(eu3E);
        euristicas.add(eu4E);
        euristicas.add(eu5E);
        euristicas.add(eu6E);

        SimulacionS6 simulacion=new SimulacionS6();
        simulacion.setRepeticiones(50);
        simulacion.setEuristicas(euristicas);
        simulacion.prepararPartida();
        simulacion.getPartida().setDebug(1);
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionS6 simulacionS6(ArrayList<SegmentacionFormal> formal){

        EuristicaPreflopLineal eu1=new EuristicaPreflopLineal();
        eu1.retructurarDatos(formal);
        eu1.setProfundidad(90);

        EuristicaPreflopLineal eu2=new EuristicaPreflopLineal();
        eu2.retructurarDatos(formal);
        eu2.setProfundidad(80);

        EuristicaPreflopLineal eu3=new EuristicaPreflopLineal();
        eu3.retructurarDatos(formal);
        eu3.setProfundidad(70);

        EuristicaPreflopLineal eu4=new EuristicaPreflopLineal();
        eu4.retructurarDatos(formal);
        eu4.setProfundidad(60);

        EuristicaPreflopLineal eu5=new EuristicaPreflopLineal();
        eu5.retructurarDatos(formal);
        eu5.setProfundidad(40);

        EuristicaPreflopLineal eu6=new EuristicaPreflopLineal();
        eu6.retructurarDatos(formal);
        eu6.setProfundidad(20);

        EuristicaPreflopLinealExpand eu1E = new EuristicaPreflopLinealExpand();
        eu1E.expandir(eu1);

        EuristicaPreflopLinealExpand eu2E = new EuristicaPreflopLinealExpand();
        eu2E.expandir(eu2);

        EuristicaPreflopLinealExpand eu3E = new EuristicaPreflopLinealExpand();
        eu3E.expandir(eu3);

        EuristicaPreflopLinealExpand eu4E = new EuristicaPreflopLinealExpand();
        eu4E.expandir(eu4);

        EuristicaPreflopLinealExpand eu5E = new EuristicaPreflopLinealExpand();
        eu5E.expandir(eu5);

        EuristicaPreflopLinealExpand eu6E = new EuristicaPreflopLinealExpand();
        eu6E.expandir(eu6);

        ArrayList<EuristicaPreflopLinealExpand> euristicas=new ArrayList<>();
        euristicas.add(eu1E);
        euristicas.add(eu2E);
        euristicas.add(eu3E);
        euristicas.add(eu4E);
        euristicas.add(eu5E);
        euristicas.add(eu6E);

        SimulacionS6 simulacion=new SimulacionS6();
        simulacion.setEuristicas(euristicas);
        simulacion.prepararPartida();
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionST simulacionSTInforme(ArrayList<SegmentacionFormal> formal){

        EuristicaPreflopLineal eu1=new EuristicaPreflopLineal();
        eu1.retructurarDatos(formal);
        eu1.setProfundidad(190);

        EuristicaPreflopLineal eu2=new EuristicaPreflopLineal();
        eu2.retructurarDatos(formal);
        eu2.setProfundidad(20);

        EuristicaPreflopLinealExpand eu1E = new EuristicaPreflopLinealExpand();
        eu1E.expandir(eu1);

        EuristicaPreflopLinealExpand eu2E = new EuristicaPreflopLinealExpand();
        eu2E.expandir(eu2);

        ArrayList<EuristicaPreflopLinealExpand> euristicas=new ArrayList<>();
        euristicas.add(eu1E);
        euristicas.add(eu2E);

        SimulacionST simulacion=new SimulacionST();
        simulacion.setRepeticiones(50);
        simulacion.setEuristicas(euristicas);
        simulacion.prepararPartida();
        simulacion.getPartida().setDebug(1);
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionST simulacionST(ArrayList<SegmentacionFormal> formal){

        EuristicaPreflopLineal eu1=new EuristicaPreflopLineal();
        eu1.retructurarDatos(formal);
        eu1.setProfundidad(50);

        EuristicaPreflopLineal eu2=new EuristicaPreflopLineal();
        eu2.retructurarDatos(formal);
        eu2.setProfundidad(100);

        EuristicaPreflopLinealExpand eu1E = new EuristicaPreflopLinealExpand();
        eu1E.expandir(eu1);

        EuristicaPreflopLinealExpand eu2E = new EuristicaPreflopLinealExpand();
        eu2E.expandir(eu2);

        ArrayList<EuristicaPreflopLinealExpand> euristicas=new ArrayList<>();
        euristicas.add(eu1E);
        euristicas.add(eu2E);

        SimulacionST simulacion=new SimulacionST();
        simulacion.setEuristicas(euristicas);
        simulacion.prepararPartida();
        simulacion.simularPartida();

        return simulacion;
    }

}

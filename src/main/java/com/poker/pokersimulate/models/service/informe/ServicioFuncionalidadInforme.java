package com.poker.pokersimulate.models.service.informe;

import com.poker.pokersimulate.models.entity.SegmentacionFormal;
import com.poker.pokersimulate.modles.domains.basico.*;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.*;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.basico.SimulacionST;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.basico.SimulacionST6;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.ciegas.SimulacionSTC;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.ciegas.SimulacionSTC6;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.comeCiegas.ComeCiegas;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.comeCiegas.SimulacionSTCC;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.comeCiegas.SimulacionSTCC6;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.comeCiegasSupra.SimulacionSTCCS;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.comeCiegasSupra.SimulacionSTCCS6;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.escalonado.Uniforme.nivel.golpe.SimulacionSTCCSENG;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.escalonado.Uniforme.nivel.golpe.SimulacionSTCCSENG6;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.escalonado.Uniforme.nivel.menor.SimulacionSTCCSENM;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.escalonado.Uniforme.nivel.menor.SimulacionSTCCSENM6;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.escalonado.basico.GeneradorRankingsEuristicos;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.escalonado.basico.SemillaRankingEuristico;
import com.poker.pokersimulate.modles.domains.dinero.preflop.jerarquiaDinero.SimulacionJAll;
import com.poker.pokersimulate.modles.domains.dinero.preflop.jerarquiaDinero.SimulacionJAll6;
import com.poker.pokersimulate.modles.domains.estadistica.*;
import com.poker.pokersimulate.modles.domains.jerarquia.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

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

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop1=new ArrayList<>();
        euristicasPreflop1.add(eu1E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop2=new ArrayList<>();
        euristicasPreflop2.add(eu2E);

        RankingPreflopEuristicas ranking1=new RankingPreflopEuristicas();
        ranking1.setEuristicas(euristicasPreflop1);

        RankingPreflopEuristicas ranking2=new RankingPreflopEuristicas();
        ranking2.setEuristicas(euristicasPreflop2);

        ArrayList<RankingPreflopEuristicas> rankingPreflopEuristicas=new ArrayList<>();
        rankingPreflopEuristicas.add(ranking1);
        rankingPreflopEuristicas.add(ranking2);

        SimulacionS simulacion=new SimulacionS();
        simulacion.setRankingPreflopEuristicas(rankingPreflopEuristicas);
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

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop1=new ArrayList<>();
        euristicasPreflop1.add(eu1E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop2=new ArrayList<>();
        euristicasPreflop2.add(eu2E);

        RankingPreflopEuristicas ranking1=new RankingPreflopEuristicas();
        ranking1.setEuristicas(euristicasPreflop1);

        RankingPreflopEuristicas ranking2=new RankingPreflopEuristicas();
        ranking2.setEuristicas(euristicasPreflop2);

        ArrayList<RankingPreflopEuristicas> rankingPreflopEuristicas=new ArrayList<>();
        rankingPreflopEuristicas.add(ranking1);
        rankingPreflopEuristicas.add(ranking2);


        SimulacionS simulacion=new SimulacionS();
        simulacion.setRepeticiones(200);
        simulacion.setRankingPreflopEuristicas(rankingPreflopEuristicas);
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

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop1=new ArrayList<>();
        euristicasPreflop1.add(eu1E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop2=new ArrayList<>();
        euristicasPreflop2.add(eu2E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop3=new ArrayList<>();
        euristicasPreflop3.add(eu3E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop4=new ArrayList<>();
        euristicasPreflop4.add(eu4E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop5=new ArrayList<>();
        euristicasPreflop5.add(eu5E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop6=new ArrayList<>();
        euristicasPreflop6.add(eu6E);

        RankingPreflopEuristicas ranking1=new RankingPreflopEuristicas();
        ranking1.setEuristicas(euristicasPreflop1);

        RankingPreflopEuristicas ranking2=new RankingPreflopEuristicas();
        ranking2.setEuristicas(euristicasPreflop2);

        RankingPreflopEuristicas ranking3=new RankingPreflopEuristicas();
        ranking3.setEuristicas(euristicasPreflop3);

        RankingPreflopEuristicas ranking4=new RankingPreflopEuristicas();
        ranking4.setEuristicas(euristicasPreflop4);

        RankingPreflopEuristicas ranking5=new RankingPreflopEuristicas();
        ranking5.setEuristicas(euristicasPreflop5);

        RankingPreflopEuristicas ranking6=new RankingPreflopEuristicas();
        ranking6.setEuristicas(euristicasPreflop6);

        ArrayList<RankingPreflopEuristicas> rankingPreflopEuristicas=new ArrayList<>();
        rankingPreflopEuristicas.add(ranking1);
        rankingPreflopEuristicas.add(ranking2);
        rankingPreflopEuristicas.add(ranking3);
        rankingPreflopEuristicas.add(ranking4);
        rankingPreflopEuristicas.add(ranking5);
        rankingPreflopEuristicas.add(ranking6);

        SimulacionS6 simulacion=new SimulacionS6();
        simulacion.setRepeticiones(50);
        simulacion.setRankingPreflopEuristicas(rankingPreflopEuristicas);
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

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop1=new ArrayList<>();
        euristicasPreflop1.add(eu1E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop2=new ArrayList<>();
        euristicasPreflop2.add(eu2E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop3=new ArrayList<>();
        euristicasPreflop3.add(eu3E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop4=new ArrayList<>();
        euristicasPreflop4.add(eu4E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop5=new ArrayList<>();
        euristicasPreflop5.add(eu5E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop6=new ArrayList<>();
        euristicasPreflop6.add(eu6E);

        RankingPreflopEuristicas ranking1=new RankingPreflopEuristicas();
        ranking1.setEuristicas(euristicasPreflop1);

        RankingPreflopEuristicas ranking2=new RankingPreflopEuristicas();
        ranking2.setEuristicas(euristicasPreflop2);

        RankingPreflopEuristicas ranking3=new RankingPreflopEuristicas();
        ranking3.setEuristicas(euristicasPreflop3);

        RankingPreflopEuristicas ranking4=new RankingPreflopEuristicas();
        ranking4.setEuristicas(euristicasPreflop4);

        RankingPreflopEuristicas ranking5=new RankingPreflopEuristicas();
        ranking5.setEuristicas(euristicasPreflop5);

        RankingPreflopEuristicas ranking6=new RankingPreflopEuristicas();
        ranking6.setEuristicas(euristicasPreflop6);

        ArrayList<RankingPreflopEuristicas> rankingPreflopEuristicas=new ArrayList<>();
        rankingPreflopEuristicas.add(ranking1);
        rankingPreflopEuristicas.add(ranking2);
        rankingPreflopEuristicas.add(ranking3);
        rankingPreflopEuristicas.add(ranking4);
        rankingPreflopEuristicas.add(ranking5);
        rankingPreflopEuristicas.add(ranking6);


        SimulacionS6 simulacion=new SimulacionS6();
        simulacion.setRankingPreflopEuristicas(rankingPreflopEuristicas);
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

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop1=new ArrayList<>();
        euristicasPreflop1.add(eu1E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop2=new ArrayList<>();
        euristicasPreflop2.add(eu2E);

        RankingPreflopEuristicas ranking1=new RankingPreflopEuristicas();
        ranking1.setEuristicas(euristicasPreflop1);

        RankingPreflopEuristicas ranking2=new RankingPreflopEuristicas();
        ranking2.setEuristicas(euristicasPreflop2);

        ArrayList<RankingPreflopEuristicas> rankingPreflopEuristicas=new ArrayList<>();
        rankingPreflopEuristicas.add(ranking1);
        rankingPreflopEuristicas.add(ranking2);

        SimulacionST simulacion=new SimulacionST();
        simulacion.setRepeticiones(50);
        simulacion.setRankingPreflopEuristicas(rankingPreflopEuristicas);
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

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop1=new ArrayList<>();
        euristicasPreflop1.add(eu1E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop2=new ArrayList<>();
        euristicasPreflop2.add(eu2E);

        RankingPreflopEuristicas ranking1=new RankingPreflopEuristicas();
        ranking1.setEuristicas(euristicasPreflop1);

        RankingPreflopEuristicas ranking2=new RankingPreflopEuristicas();
        ranking2.setEuristicas(euristicasPreflop2);

        ArrayList<RankingPreflopEuristicas> rankingPreflopEuristicas=new ArrayList<>();
        rankingPreflopEuristicas.add(ranking1);
        rankingPreflopEuristicas.add(ranking2);

        SimulacionST simulacion=new SimulacionST();
        simulacion.setRankingPreflopEuristicas(rankingPreflopEuristicas);
        simulacion.prepararPartida();
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionST6 simulacionST6Informe(ArrayList<SegmentacionFormal> formal){

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

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop1=new ArrayList<>();
        euristicasPreflop1.add(eu1E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop2=new ArrayList<>();
        euristicasPreflop2.add(eu2E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop3=new ArrayList<>();
        euristicasPreflop3.add(eu3E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop4=new ArrayList<>();
        euristicasPreflop4.add(eu4E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop5=new ArrayList<>();
        euristicasPreflop5.add(eu5E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop6=new ArrayList<>();
        euristicasPreflop6.add(eu6E);

        RankingPreflopEuristicas ranking1=new RankingPreflopEuristicas();
        ranking1.setEuristicas(euristicasPreflop1);

        RankingPreflopEuristicas ranking2=new RankingPreflopEuristicas();
        ranking2.setEuristicas(euristicasPreflop2);

        RankingPreflopEuristicas ranking3=new RankingPreflopEuristicas();
        ranking3.setEuristicas(euristicasPreflop3);

        RankingPreflopEuristicas ranking4=new RankingPreflopEuristicas();
        ranking4.setEuristicas(euristicasPreflop4);

        RankingPreflopEuristicas ranking5=new RankingPreflopEuristicas();
        ranking5.setEuristicas(euristicasPreflop5);

        RankingPreflopEuristicas ranking6=new RankingPreflopEuristicas();
        ranking6.setEuristicas(euristicasPreflop6);

        ArrayList<RankingPreflopEuristicas> rankingPreflopEuristicas=new ArrayList<>();
        rankingPreflopEuristicas.add(ranking1);
        rankingPreflopEuristicas.add(ranking2);
        rankingPreflopEuristicas.add(ranking3);
        rankingPreflopEuristicas.add(ranking4);
        rankingPreflopEuristicas.add(ranking5);
        rankingPreflopEuristicas.add(ranking6);

        SimulacionST6 simulacion=new SimulacionST6();
        simulacion.setRepeticiones(50);
        simulacion.setRankingPreflopEuristicas(rankingPreflopEuristicas);
        simulacion.prepararPartida();
        simulacion.getPartida().setDebug(1);
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionST6 simulacionST6(ArrayList<SegmentacionFormal> formal){

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

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop1=new ArrayList<>();
        euristicasPreflop1.add(eu1E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop2=new ArrayList<>();
        euristicasPreflop2.add(eu2E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop3=new ArrayList<>();
        euristicasPreflop3.add(eu3E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop4=new ArrayList<>();
        euristicasPreflop4.add(eu4E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop5=new ArrayList<>();
        euristicasPreflop5.add(eu5E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop6=new ArrayList<>();
        euristicasPreflop6.add(eu6E);

        RankingPreflopEuristicas ranking1=new RankingPreflopEuristicas();
        ranking1.setEuristicas(euristicasPreflop1);

        RankingPreflopEuristicas ranking2=new RankingPreflopEuristicas();
        ranking2.setEuristicas(euristicasPreflop2);

        RankingPreflopEuristicas ranking3=new RankingPreflopEuristicas();
        ranking3.setEuristicas(euristicasPreflop3);

        RankingPreflopEuristicas ranking4=new RankingPreflopEuristicas();
        ranking4.setEuristicas(euristicasPreflop4);

        RankingPreflopEuristicas ranking5=new RankingPreflopEuristicas();
        ranking5.setEuristicas(euristicasPreflop5);

        RankingPreflopEuristicas ranking6=new RankingPreflopEuristicas();
        ranking6.setEuristicas(euristicasPreflop6);

        ArrayList<RankingPreflopEuristicas> rankingPreflopEuristicas=new ArrayList<>();
        rankingPreflopEuristicas.add(ranking1);
        rankingPreflopEuristicas.add(ranking2);
        rankingPreflopEuristicas.add(ranking3);
        rankingPreflopEuristicas.add(ranking4);
        rankingPreflopEuristicas.add(ranking5);
        rankingPreflopEuristicas.add(ranking6);


        SimulacionST6 simulacion=new SimulacionST6();
        simulacion.setRankingPreflopEuristicas(rankingPreflopEuristicas);
        simulacion.prepararPartida();
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionSTC simulacionSTCInforme(ArrayList<SegmentacionFormal> formal){

        EuristicaPreflopLineal eu1=new EuristicaPreflopLineal();
        eu1.retructurarDatos(formal);
        eu1.setProfundidad(40);

        EuristicaPreflopLineal eu2=new EuristicaPreflopLineal();
        eu2.retructurarDatos(formal);
        eu2.setProfundidad(20);

        EuristicaPreflopLinealExpand eu1E = new EuristicaPreflopLinealExpand();
        eu1E.expandir(eu1);

        EuristicaPreflopLinealExpand eu2E = new EuristicaPreflopLinealExpand();
        eu2E.expandir(eu2);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop1=new ArrayList<>();
        euristicasPreflop1.add(eu1E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop2=new ArrayList<>();
        euristicasPreflop2.add(eu2E);

        RankingPreflopEuristicas ranking1=new RankingPreflopEuristicas();
        ranking1.setEuristicas(euristicasPreflop1);

        RankingPreflopEuristicas ranking2=new RankingPreflopEuristicas();
        ranking2.setEuristicas(euristicasPreflop2);

        ArrayList<RankingPreflopEuristicas> rankingPreflopEuristicas=new ArrayList<>();
        rankingPreflopEuristicas.add(ranking1);
        rankingPreflopEuristicas.add(ranking2);

        SimulacionSTC simulacion=new SimulacionSTC();
        simulacion.setRepeticiones(50);
        simulacion.setRankingPreflopEuristicas(rankingPreflopEuristicas);
        simulacion.prepararPartida();
        simulacion.getPartida().setDebug(1);
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionSTC simulacionSTC(ArrayList<SegmentacionFormal> formal){

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

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop1=new ArrayList<>();
        euristicasPreflop1.add(eu1E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop2=new ArrayList<>();
        euristicasPreflop2.add(eu2E);

        RankingPreflopEuristicas ranking1=new RankingPreflopEuristicas();
        ranking1.setEuristicas(euristicasPreflop1);

        RankingPreflopEuristicas ranking2=new RankingPreflopEuristicas();
        ranking2.setEuristicas(euristicasPreflop2);

        ArrayList<RankingPreflopEuristicas> rankingPreflopEuristicas=new ArrayList<>();
        rankingPreflopEuristicas.add(ranking1);
        rankingPreflopEuristicas.add(ranking2);

        SimulacionSTC simulacion=new SimulacionSTC();
        simulacion.setRankingPreflopEuristicas(rankingPreflopEuristicas);
        simulacion.prepararPartida();
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionSTC6 simulacionSTC6Informe(ArrayList<SegmentacionFormal> formal){

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

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop1=new ArrayList<>();
        euristicasPreflop1.add(eu1E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop2=new ArrayList<>();
        euristicasPreflop2.add(eu2E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop3=new ArrayList<>();
        euristicasPreflop3.add(eu3E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop4=new ArrayList<>();
        euristicasPreflop4.add(eu4E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop5=new ArrayList<>();
        euristicasPreflop5.add(eu5E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop6=new ArrayList<>();
        euristicasPreflop6.add(eu6E);

        RankingPreflopEuristicas ranking1=new RankingPreflopEuristicas();
        ranking1.setEuristicas(euristicasPreflop1);

        RankingPreflopEuristicas ranking2=new RankingPreflopEuristicas();
        ranking2.setEuristicas(euristicasPreflop2);

        RankingPreflopEuristicas ranking3=new RankingPreflopEuristicas();
        ranking3.setEuristicas(euristicasPreflop3);

        RankingPreflopEuristicas ranking4=new RankingPreflopEuristicas();
        ranking4.setEuristicas(euristicasPreflop4);

        RankingPreflopEuristicas ranking5=new RankingPreflopEuristicas();
        ranking5.setEuristicas(euristicasPreflop5);

        RankingPreflopEuristicas ranking6=new RankingPreflopEuristicas();
        ranking6.setEuristicas(euristicasPreflop6);

        ArrayList<RankingPreflopEuristicas> rankingPreflopEuristicas=new ArrayList<>();
        rankingPreflopEuristicas.add(ranking1);
        rankingPreflopEuristicas.add(ranking2);
        rankingPreflopEuristicas.add(ranking3);
        rankingPreflopEuristicas.add(ranking4);
        rankingPreflopEuristicas.add(ranking5);
        rankingPreflopEuristicas.add(ranking6);


        SimulacionSTC6 simulacion=new SimulacionSTC6();
        simulacion.setRepeticiones(50);
        simulacion.setRankingPreflopEuristicas(rankingPreflopEuristicas);
        simulacion.prepararPartida();
        simulacion.getPartida().setDebug(1);
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionSTC6 simulacionSTC6(ArrayList<SegmentacionFormal> formal){

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

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop1=new ArrayList<>();
        euristicasPreflop1.add(eu1E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop2=new ArrayList<>();
        euristicasPreflop2.add(eu2E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop3=new ArrayList<>();
        euristicasPreflop3.add(eu3E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop4=new ArrayList<>();
        euristicasPreflop4.add(eu4E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop5=new ArrayList<>();
        euristicasPreflop5.add(eu5E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop6=new ArrayList<>();
        euristicasPreflop6.add(eu6E);

        RankingPreflopEuristicas ranking1=new RankingPreflopEuristicas();
        ranking1.setEuristicas(euristicasPreflop1);

        RankingPreflopEuristicas ranking2=new RankingPreflopEuristicas();
        ranking2.setEuristicas(euristicasPreflop2);

        RankingPreflopEuristicas ranking3=new RankingPreflopEuristicas();
        ranking3.setEuristicas(euristicasPreflop3);

        RankingPreflopEuristicas ranking4=new RankingPreflopEuristicas();
        ranking4.setEuristicas(euristicasPreflop4);

        RankingPreflopEuristicas ranking5=new RankingPreflopEuristicas();
        ranking5.setEuristicas(euristicasPreflop5);

        RankingPreflopEuristicas ranking6=new RankingPreflopEuristicas();
        ranking6.setEuristicas(euristicasPreflop6);

        ArrayList<RankingPreflopEuristicas> rankingPreflopEuristicas=new ArrayList<>();
        rankingPreflopEuristicas.add(ranking1);
        rankingPreflopEuristicas.add(ranking2);
        rankingPreflopEuristicas.add(ranking3);
        rankingPreflopEuristicas.add(ranking4);
        rankingPreflopEuristicas.add(ranking5);
        rankingPreflopEuristicas.add(ranking6);


        SimulacionSTC6 simulacion=new SimulacionSTC6();
        simulacion.setRankingPreflopEuristicas(rankingPreflopEuristicas);
        simulacion.prepararPartida();
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionSTCC simulacionSTCCInforme(ArrayList<SegmentacionFormal> formal){

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

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop1=new ArrayList<>();
        euristicasPreflop1.add(eu1E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop2=new ArrayList<>();
        euristicasPreflop2.add(eu2E);

        RankingPreflopEuristicas ranking1=new RankingPreflopEuristicas();
        ranking1.setEuristicas(euristicasPreflop1);

        RankingPreflopEuristicas ranking2=new RankingPreflopEuristicas();
        ranking2.setEuristicas(euristicasPreflop2);

        ArrayList<RankingPreflopEuristicas> rankingPreflopEuristicas=new ArrayList<>();
        rankingPreflopEuristicas.add(ranking1);
        rankingPreflopEuristicas.add(ranking2);

        ArrayList<ComeCiegas>  listaComeCiegas=new ArrayList<>();

        ArrayList<Integer> comeCiegasJug1=new ArrayList<>();
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(1);

        ArrayList<Integer> comeCiegasJug2=new ArrayList<>();
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);

        ComeCiegas comeCiegas1=new ComeCiegas();
        comeCiegas1.setJugadoresQueComo(comeCiegasJug1);
        comeCiegas1.setApuesta(20);

        ComeCiegas comeCiegas2=new ComeCiegas();
        comeCiegas2.setJugadoresQueComo(comeCiegasJug2);
        comeCiegas2.setApuesta(0);

        listaComeCiegas.add(comeCiegas1);
        listaComeCiegas.add(comeCiegas2);

        SimulacionSTCC simulacion=new SimulacionSTCC();
        simulacion.setRepeticiones(50);
        simulacion.setRankingPreflopEuristicas(rankingPreflopEuristicas);
        simulacion.setComeCiegas(listaComeCiegas);
        simulacion.prepararPartida();
        simulacion.getPartida().setDebug(1);
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionSTCC simulacionSTCC(ArrayList<SegmentacionFormal> formal){

        EuristicaPreflopLineal eu1=new EuristicaPreflopLineal();
        eu1.retructurarDatos(formal);
        eu1.setProfundidad(190);

        EuristicaPreflopLineal eu2=new EuristicaPreflopLineal();
        eu2.retructurarDatos(formal);
        eu2.setProfundidad(30);

        EuristicaPreflopLinealExpand eu1E = new EuristicaPreflopLinealExpand();
        eu1E.expandir(eu1);

        EuristicaPreflopLinealExpand eu2E = new EuristicaPreflopLinealExpand();
        eu2E.expandir(eu2);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop1=new ArrayList<>();
        euristicasPreflop1.add(eu1E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop2=new ArrayList<>();
        euristicasPreflop2.add(eu2E);

        RankingPreflopEuristicas ranking1=new RankingPreflopEuristicas();
        ranking1.setEuristicas(euristicasPreflop1);

        RankingPreflopEuristicas ranking2=new RankingPreflopEuristicas();
        ranking2.setEuristicas(euristicasPreflop2);

        ArrayList<RankingPreflopEuristicas> rankingPreflopEuristicas=new ArrayList<>();
        rankingPreflopEuristicas.add(ranking1);
        rankingPreflopEuristicas.add(ranking2);

        ArrayList<ComeCiegas>  listaComeCiegas=new ArrayList<>();

        ArrayList<Integer> comeCiegasJug1=new ArrayList<>();
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(1);

        ArrayList<Integer> comeCiegasJug2=new ArrayList<>();
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);

        ComeCiegas comeCiegas1=new ComeCiegas();
        comeCiegas1.setJugadoresQueComo(comeCiegasJug1);
        comeCiegas1.setApuesta(6);

        ComeCiegas comeCiegas2=new ComeCiegas();
        comeCiegas2.setJugadoresQueComo(comeCiegasJug2);
        comeCiegas2.setApuesta(0);

        listaComeCiegas.add(comeCiegas1);
        listaComeCiegas.add(comeCiegas2);

        SimulacionSTCC simulacion=new SimulacionSTCC();
        simulacion.setRankingPreflopEuristicas(rankingPreflopEuristicas);
        simulacion.setComeCiegas(listaComeCiegas);
        simulacion.prepararPartida();
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionSTCC6 simulacionSTCC6Informe(ArrayList<SegmentacionFormal> formal){

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

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop1=new ArrayList<>();
        euristicasPreflop1.add(eu1E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop2=new ArrayList<>();
        euristicasPreflop2.add(eu2E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop3=new ArrayList<>();
        euristicasPreflop3.add(eu3E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop4=new ArrayList<>();
        euristicasPreflop4.add(eu4E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop5=new ArrayList<>();
        euristicasPreflop5.add(eu5E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop6=new ArrayList<>();
        euristicasPreflop6.add(eu6E);

        RankingPreflopEuristicas ranking1=new RankingPreflopEuristicas();
        ranking1.setEuristicas(euristicasPreflop1);

        RankingPreflopEuristicas ranking2=new RankingPreflopEuristicas();
        ranking2.setEuristicas(euristicasPreflop2);

        RankingPreflopEuristicas ranking3=new RankingPreflopEuristicas();
        ranking3.setEuristicas(euristicasPreflop3);

        RankingPreflopEuristicas ranking4=new RankingPreflopEuristicas();
        ranking4.setEuristicas(euristicasPreflop4);

        RankingPreflopEuristicas ranking5=new RankingPreflopEuristicas();
        ranking5.setEuristicas(euristicasPreflop5);

        RankingPreflopEuristicas ranking6=new RankingPreflopEuristicas();
        ranking6.setEuristicas(euristicasPreflop6);

        ArrayList<RankingPreflopEuristicas> rankingPreflopEuristicas=new ArrayList<>();
        rankingPreflopEuristicas.add(ranking1);
        rankingPreflopEuristicas.add(ranking2);
        rankingPreflopEuristicas.add(ranking3);
        rankingPreflopEuristicas.add(ranking4);
        rankingPreflopEuristicas.add(ranking5);
        rankingPreflopEuristicas.add(ranking6);

        ArrayList<ComeCiegas> listaComeCiegas=new ArrayList<>();

        ArrayList<Integer> comeCiegasJug1=new ArrayList<>();
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(1);
        comeCiegasJug1.add(1);
        comeCiegasJug1.add(1);

        ArrayList<Integer> comeCiegasJug2=new ArrayList<>();
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(1);
        comeCiegasJug2.add(1);
        comeCiegasJug2.add(1);

        ArrayList<Integer> comeCiegasJug3=new ArrayList<>();
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(1);
        comeCiegasJug3.add(1);
        comeCiegasJug3.add(1);

        ArrayList<Integer> comeCiegasJug4=new ArrayList<>();
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);

        ArrayList<Integer> comeCiegasJug5=new ArrayList<>();
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);

        ArrayList<Integer> comeCiegasJug6=new ArrayList<>();
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);

        ComeCiegas comeCiegas1=new ComeCiegas();
        comeCiegas1.setJugadoresQueComo(comeCiegasJug1);
        comeCiegas1.setApuesta(6);

        ComeCiegas comeCiegas2=new ComeCiegas();
        comeCiegas2.setJugadoresQueComo(comeCiegasJug2);
        comeCiegas2.setApuesta(6);

        ComeCiegas comeCiegas3=new ComeCiegas();
        comeCiegas3.setJugadoresQueComo(comeCiegasJug3);
        comeCiegas3.setApuesta(6);

        ComeCiegas comeCiegas4=new ComeCiegas();
        comeCiegas4.setJugadoresQueComo(comeCiegasJug4);
        comeCiegas4.setApuesta(0);

        ComeCiegas comeCiegas5=new ComeCiegas();
        comeCiegas5.setJugadoresQueComo(comeCiegasJug5);
        comeCiegas5.setApuesta(0);

        ComeCiegas comeCiegas6=new ComeCiegas();
        comeCiegas6.setJugadoresQueComo(comeCiegasJug6);
        comeCiegas6.setApuesta(0);

        listaComeCiegas.add(comeCiegas1);
        listaComeCiegas.add(comeCiegas2);
        listaComeCiegas.add(comeCiegas3);
        listaComeCiegas.add(comeCiegas4);
        listaComeCiegas.add(comeCiegas5);
        listaComeCiegas.add(comeCiegas6);

        SimulacionSTCC6 simulacion=new SimulacionSTCC6();
        simulacion.setRepeticiones(50);
        simulacion.setRankingPreflopEuristicas(rankingPreflopEuristicas);
        simulacion.setComeCiegas(listaComeCiegas);
        simulacion.prepararPartida();
        simulacion.getPartida().setDebug(1);
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionSTCC6 simulacionSTCC6(ArrayList<SegmentacionFormal> formal){

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

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop1=new ArrayList<>();
        euristicasPreflop1.add(eu1E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop2=new ArrayList<>();
        euristicasPreflop2.add(eu2E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop3=new ArrayList<>();
        euristicasPreflop3.add(eu3E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop4=new ArrayList<>();
        euristicasPreflop4.add(eu4E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop5=new ArrayList<>();
        euristicasPreflop5.add(eu5E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop6=new ArrayList<>();
        euristicasPreflop6.add(eu6E);

        RankingPreflopEuristicas ranking1=new RankingPreflopEuristicas();
        ranking1.setEuristicas(euristicasPreflop1);

        RankingPreflopEuristicas ranking2=new RankingPreflopEuristicas();
        ranking2.setEuristicas(euristicasPreflop2);

        RankingPreflopEuristicas ranking3=new RankingPreflopEuristicas();
        ranking3.setEuristicas(euristicasPreflop3);

        RankingPreflopEuristicas ranking4=new RankingPreflopEuristicas();
        ranking4.setEuristicas(euristicasPreflop4);

        RankingPreflopEuristicas ranking5=new RankingPreflopEuristicas();
        ranking5.setEuristicas(euristicasPreflop5);

        RankingPreflopEuristicas ranking6=new RankingPreflopEuristicas();
        ranking6.setEuristicas(euristicasPreflop6);

        ArrayList<RankingPreflopEuristicas> rankingPreflopEuristicas=new ArrayList<>();
        rankingPreflopEuristicas.add(ranking1);
        rankingPreflopEuristicas.add(ranking2);
        rankingPreflopEuristicas.add(ranking3);
        rankingPreflopEuristicas.add(ranking4);
        rankingPreflopEuristicas.add(ranking5);
        rankingPreflopEuristicas.add(ranking6);

        ArrayList<ComeCiegas> listaComeCiegas=new ArrayList<>();

        ArrayList<Integer> comeCiegasJug1=new ArrayList<>();
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(1);
        comeCiegasJug1.add(1);
        comeCiegasJug1.add(1);

        ArrayList<Integer> comeCiegasJug2=new ArrayList<>();
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(1);
        comeCiegasJug2.add(1);
        comeCiegasJug2.add(1);

        ArrayList<Integer> comeCiegasJug3=new ArrayList<>();
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(1);
        comeCiegasJug3.add(1);
        comeCiegasJug3.add(1);

        ArrayList<Integer> comeCiegasJug4=new ArrayList<>();
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);

        ArrayList<Integer> comeCiegasJug5=new ArrayList<>();
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);

        ArrayList<Integer> comeCiegasJug6=new ArrayList<>();
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);

        ComeCiegas comeCiegas1=new ComeCiegas();
        comeCiegas1.setJugadoresQueComo(comeCiegasJug1);
        comeCiegas1.setApuesta(4);

        ComeCiegas comeCiegas2=new ComeCiegas();
        comeCiegas2.setJugadoresQueComo(comeCiegasJug2);
        comeCiegas2.setApuesta(6);

        ComeCiegas comeCiegas3=new ComeCiegas();
        comeCiegas3.setJugadoresQueComo(comeCiegasJug3);
        comeCiegas3.setApuesta(6);

        ComeCiegas comeCiegas4=new ComeCiegas();
        comeCiegas4.setJugadoresQueComo(comeCiegasJug4);
        comeCiegas4.setApuesta(0);

        ComeCiegas comeCiegas5=new ComeCiegas();
        comeCiegas5.setJugadoresQueComo(comeCiegasJug5);
        comeCiegas5.setApuesta(0);

        ComeCiegas comeCiegas6=new ComeCiegas();
        comeCiegas6.setJugadoresQueComo(comeCiegasJug6);
        comeCiegas6.setApuesta(0);

        listaComeCiegas.add(comeCiegas1);
        listaComeCiegas.add(comeCiegas2);
        listaComeCiegas.add(comeCiegas3);
        listaComeCiegas.add(comeCiegas4);
        listaComeCiegas.add(comeCiegas5);
        listaComeCiegas.add(comeCiegas6);

        SimulacionSTCC6 simulacion=new SimulacionSTCC6();
        simulacion.setRankingPreflopEuristicas(rankingPreflopEuristicas);
        simulacion.setComeCiegas(listaComeCiegas);
        simulacion.prepararPartida();
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionSTCCS simulacionSTCCSInforme(ArrayList<SegmentacionFormal> formal){

        EuristicaPreflopLineal eu1=new EuristicaPreflopLineal();
        eu1.retructurarDatos(formal);
        eu1.setProfundidad(20);

        EuristicaPreflopLineal eu2=new EuristicaPreflopLineal();
        eu2.retructurarDatos(formal);
        eu2.setProfundidad(20);

        EuristicaPreflopLinealExpand eu1E = new EuristicaPreflopLinealExpand();
        eu1E.expandir(eu1);

        EuristicaPreflopLinealExpand eu2E = new EuristicaPreflopLinealExpand();
        eu2E.expandir(eu2);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop1=new ArrayList<>();
        euristicasPreflop1.add(eu1E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop2=new ArrayList<>();
        euristicasPreflop2.add(eu2E);

        RankingPreflopEuristicas ranking1=new RankingPreflopEuristicas();
        ranking1.setEuristicas(euristicasPreflop1);
        ranking1.getApuestas().add(0);

        RankingPreflopEuristicas ranking2=new RankingPreflopEuristicas();
        ranking2.setEuristicas(euristicasPreflop2);
        ranking2.getApuestas().add(0);

        ArrayList<RankingPreflopEuristicas> rankingPreflopEuristicas=new ArrayList<>();
        rankingPreflopEuristicas.add(ranking1);
        rankingPreflopEuristicas.add(ranking2);

        ArrayList<ComeCiegas>  listaComeCiegas=new ArrayList<>();

        ArrayList<Integer> comeCiegasJug1=new ArrayList<>();
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(1);

        ArrayList<Integer> comeCiegasJug2=new ArrayList<>();
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);

        ComeCiegas comeCiegas1=new ComeCiegas();
        comeCiegas1.setJugadoresQueComo(comeCiegasJug1);
        comeCiegas1.setApuesta(10);

        ComeCiegas comeCiegas2=new ComeCiegas();
        comeCiegas2.setJugadoresQueComo(comeCiegasJug2);
        comeCiegas2.setApuesta(0);

        listaComeCiegas.add(comeCiegas1);
        listaComeCiegas.add(comeCiegas2);

        SimulacionSTCCS simulacion=new SimulacionSTCCS();
        simulacion.setRepeticiones(50);
        simulacion.setRankingPreflopEuristicas(rankingPreflopEuristicas);
        simulacion.setComeCiegas(listaComeCiegas);
        simulacion.prepararPartida();
        simulacion.getPartida().setDebug(1);
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionSTCCS simulacionSTCCS(ArrayList<SegmentacionFormal> formal){

        EuristicaPreflopLineal eu1=new EuristicaPreflopLineal();
        eu1.retructurarDatos(formal);
        eu1.setProfundidad(20);

        EuristicaPreflopLineal eu2=new EuristicaPreflopLineal();
        eu2.retructurarDatos(formal);
        eu2.setProfundidad(30);

        EuristicaPreflopLinealExpand eu1E = new EuristicaPreflopLinealExpand();
        eu1E.expandir(eu1);

        EuristicaPreflopLinealExpand eu2E = new EuristicaPreflopLinealExpand();
        eu2E.expandir(eu2);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop1=new ArrayList<>();
        euristicasPreflop1.add(eu1E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop2=new ArrayList<>();
        euristicasPreflop2.add(eu2E);

        RankingPreflopEuristicas ranking1=new RankingPreflopEuristicas();
        ranking1.setEuristicas(euristicasPreflop1);
        ranking1.getApuestas().add(0);

        RankingPreflopEuristicas ranking2=new RankingPreflopEuristicas();
        ranking2.setEuristicas(euristicasPreflop2);
        ranking2.getApuestas().add(0);

        ArrayList<RankingPreflopEuristicas> rankingPreflopEuristicas=new ArrayList<>();
        rankingPreflopEuristicas.add(ranking1);
        rankingPreflopEuristicas.add(ranking2);

        ArrayList<ComeCiegas>  listaComeCiegas=new ArrayList<>();

        ArrayList<Integer> comeCiegasJug1=new ArrayList<>();
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(1);

        ArrayList<Integer> comeCiegasJug2=new ArrayList<>();
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);

        ComeCiegas comeCiegas1=new ComeCiegas();
        comeCiegas1.setJugadoresQueComo(comeCiegasJug1);
        comeCiegas1.setApuesta(6);

        ComeCiegas comeCiegas2=new ComeCiegas();
        comeCiegas2.setJugadoresQueComo(comeCiegasJug2);
        comeCiegas2.setApuesta(0);

        listaComeCiegas.add(comeCiegas1);
        listaComeCiegas.add(comeCiegas2);

        SimulacionSTCCS simulacion=new SimulacionSTCCS();
        simulacion.setRankingPreflopEuristicas(rankingPreflopEuristicas);
        simulacion.setComeCiegas(listaComeCiegas);
        simulacion.prepararPartida();
        simulacion.simularPartida();

        return simulacion;
    }


    public SimulacionSTCCS6 simulacionSTCCS6Informe(ArrayList<SegmentacionFormal> formal){

        EuristicaPreflopLineal eu1=new EuristicaPreflopLineal();
        eu1.retructurarDatos(formal);
        eu1.setProfundidad(50);

        EuristicaPreflopLineal eu2=new EuristicaPreflopLineal();
        eu2.retructurarDatos(formal);
        eu2.setProfundidad(40);

        EuristicaPreflopLineal eu3=new EuristicaPreflopLineal();
        eu3.retructurarDatos(formal);
        eu3.setProfundidad(30);

        EuristicaPreflopLineal eu4=new EuristicaPreflopLineal();
        eu4.retructurarDatos(formal);
        eu4.setProfundidad(30);

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

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop1=new ArrayList<>();
        euristicasPreflop1.add(eu1E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop2=new ArrayList<>();
        euristicasPreflop2.add(eu2E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop3=new ArrayList<>();
        euristicasPreflop3.add(eu3E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop4=new ArrayList<>();
        euristicasPreflop4.add(eu4E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop5=new ArrayList<>();
        euristicasPreflop5.add(eu5E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop6=new ArrayList<>();
        euristicasPreflop6.add(eu6E);

        RankingPreflopEuristicas ranking1=new RankingPreflopEuristicas();
        ranking1.setEuristicas(euristicasPreflop1);
        ranking1.getApuestas().add(0);

        RankingPreflopEuristicas ranking2=new RankingPreflopEuristicas();
        ranking2.setEuristicas(euristicasPreflop2);
        ranking2.getApuestas().add(0);

        RankingPreflopEuristicas ranking3=new RankingPreflopEuristicas();
        ranking3.setEuristicas(euristicasPreflop3);
        ranking3.getApuestas().add(0);

        RankingPreflopEuristicas ranking4=new RankingPreflopEuristicas();
        ranking4.setEuristicas(euristicasPreflop4);
        ranking4.getApuestas().add(0);

        RankingPreflopEuristicas ranking5=new RankingPreflopEuristicas();
        ranking5.setEuristicas(euristicasPreflop5);
        ranking5.getApuestas().add(0);

        RankingPreflopEuristicas ranking6=new RankingPreflopEuristicas();
        ranking6.setEuristicas(euristicasPreflop6);
        ranking6.getApuestas().add(0);

        ArrayList<RankingPreflopEuristicas> rankingPreflopEuristicas=new ArrayList<>();
        rankingPreflopEuristicas.add(ranking1);
        rankingPreflopEuristicas.add(ranking2);
        rankingPreflopEuristicas.add(ranking3);
        rankingPreflopEuristicas.add(ranking4);
        rankingPreflopEuristicas.add(ranking5);
        rankingPreflopEuristicas.add(ranking6);

        ArrayList<ComeCiegas> listaComeCiegas=new ArrayList<>();

        ArrayList<Integer> comeCiegasJug1=new ArrayList<>();
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(1);
        comeCiegasJug1.add(1);
        comeCiegasJug1.add(1);

        ArrayList<Integer> comeCiegasJug2=new ArrayList<>();
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(1);
        comeCiegasJug2.add(1);
        comeCiegasJug2.add(1);

        ArrayList<Integer> comeCiegasJug3=new ArrayList<>();
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(1);
        comeCiegasJug3.add(1);
        comeCiegasJug3.add(1);

        ArrayList<Integer> comeCiegasJug4=new ArrayList<>();
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);

        ArrayList<Integer> comeCiegasJug5=new ArrayList<>();
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);

        ArrayList<Integer> comeCiegasJug6=new ArrayList<>();
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);

        ComeCiegas comeCiegas1=new ComeCiegas();
        comeCiegas1.setJugadoresQueComo(comeCiegasJug1);
        comeCiegas1.setApuesta(6);

        ComeCiegas comeCiegas2=new ComeCiegas();
        comeCiegas2.setJugadoresQueComo(comeCiegasJug2);
        comeCiegas2.setApuesta(6);

        ComeCiegas comeCiegas3=new ComeCiegas();
        comeCiegas3.setJugadoresQueComo(comeCiegasJug3);
        comeCiegas3.setApuesta(6);

        ComeCiegas comeCiegas4=new ComeCiegas();
        comeCiegas4.setJugadoresQueComo(comeCiegasJug4);
        comeCiegas4.setApuesta(0);

        ComeCiegas comeCiegas5=new ComeCiegas();
        comeCiegas5.setJugadoresQueComo(comeCiegasJug5);
        comeCiegas5.setApuesta(0);

        ComeCiegas comeCiegas6=new ComeCiegas();
        comeCiegas6.setJugadoresQueComo(comeCiegasJug6);
        comeCiegas6.setApuesta(0);

        listaComeCiegas.add(comeCiegas1);
        listaComeCiegas.add(comeCiegas2);
        listaComeCiegas.add(comeCiegas3);
        listaComeCiegas.add(comeCiegas4);
        listaComeCiegas.add(comeCiegas5);
        listaComeCiegas.add(comeCiegas6);

        SimulacionSTCCS6 simulacion=new SimulacionSTCCS6();
        simulacion.setRepeticiones(50);
        simulacion.setRankingPreflopEuristicas(rankingPreflopEuristicas);
        simulacion.setComeCiegas(listaComeCiegas);
        simulacion.prepararPartida();
        simulacion.getPartida().setDebug(1);
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionSTCCS6 simulacionSTCCS6(ArrayList<SegmentacionFormal> formal){

        EuristicaPreflopLineal eu1=new EuristicaPreflopLineal();
        eu1.retructurarDatos(formal);
        eu1.setProfundidad(20);

        EuristicaPreflopLineal eu2=new EuristicaPreflopLineal();
        eu2.retructurarDatos(formal);
        eu2.setProfundidad(30);

        EuristicaPreflopLineal eu3=new EuristicaPreflopLineal();
        eu3.retructurarDatos(formal);
        eu3.setProfundidad(30);

        EuristicaPreflopLineal eu4=new EuristicaPreflopLineal();
        eu4.retructurarDatos(formal);
        eu4.setProfundidad(30);

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

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop1=new ArrayList<>();
        euristicasPreflop1.add(eu1E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop2=new ArrayList<>();
        euristicasPreflop2.add(eu2E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop3=new ArrayList<>();
        euristicasPreflop3.add(eu3E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop4=new ArrayList<>();
        euristicasPreflop4.add(eu4E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop5=new ArrayList<>();
        euristicasPreflop5.add(eu5E);

        ArrayList<EuristicaPreflopLinealExpand> euristicasPreflop6=new ArrayList<>();
        euristicasPreflop6.add(eu6E);

        RankingPreflopEuristicas ranking1=new RankingPreflopEuristicas();
        ranking1.setEuristicas(euristicasPreflop1);
        ranking1.getApuestas().add(0);

        RankingPreflopEuristicas ranking2=new RankingPreflopEuristicas();
        ranking2.setEuristicas(euristicasPreflop2);
        ranking2.getApuestas().add(0);

        RankingPreflopEuristicas ranking3=new RankingPreflopEuristicas();
        ranking3.setEuristicas(euristicasPreflop3);
        ranking3.getApuestas().add(0);

        RankingPreflopEuristicas ranking4=new RankingPreflopEuristicas();
        ranking4.setEuristicas(euristicasPreflop4);
        ranking4.getApuestas().add(0);

        RankingPreflopEuristicas ranking5=new RankingPreflopEuristicas();
        ranking5.setEuristicas(euristicasPreflop5);
        ranking5.getApuestas().add(0);

        RankingPreflopEuristicas ranking6=new RankingPreflopEuristicas();
        ranking6.setEuristicas(euristicasPreflop6);
        ranking6.getApuestas().add(0);

        ArrayList<RankingPreflopEuristicas> rankingPreflopEuristicas=new ArrayList<>();
        rankingPreflopEuristicas.add(ranking1);
        rankingPreflopEuristicas.add(ranking2);
        rankingPreflopEuristicas.add(ranking3);
        rankingPreflopEuristicas.add(ranking4);
        rankingPreflopEuristicas.add(ranking5);
        rankingPreflopEuristicas.add(ranking6);

        ArrayList<ComeCiegas> listaComeCiegas=new ArrayList<>();

        ArrayList<Integer> comeCiegasJug1=new ArrayList<>();
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(1);
        comeCiegasJug1.add(1);
        comeCiegasJug1.add(1);

        ArrayList<Integer> comeCiegasJug2=new ArrayList<>();
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(1);
        comeCiegasJug2.add(1);
        comeCiegasJug2.add(1);

        ArrayList<Integer> comeCiegasJug3=new ArrayList<>();
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(1);
        comeCiegasJug3.add(1);
        comeCiegasJug3.add(1);

        ArrayList<Integer> comeCiegasJug4=new ArrayList<>();
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);

        ArrayList<Integer> comeCiegasJug5=new ArrayList<>();
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);

        ArrayList<Integer> comeCiegasJug6=new ArrayList<>();
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);

        ComeCiegas comeCiegas1=new ComeCiegas();
        comeCiegas1.setJugadoresQueComo(comeCiegasJug1);
        comeCiegas1.setApuesta(6);

        ComeCiegas comeCiegas2=new ComeCiegas();
        comeCiegas2.setJugadoresQueComo(comeCiegasJug2);
        comeCiegas2.setApuesta(6);

        ComeCiegas comeCiegas3=new ComeCiegas();
        comeCiegas3.setJugadoresQueComo(comeCiegasJug3);
        comeCiegas3.setApuesta(4);

        ComeCiegas comeCiegas4=new ComeCiegas();
        comeCiegas4.setJugadoresQueComo(comeCiegasJug4);
        comeCiegas4.setApuesta(0);

        ComeCiegas comeCiegas5=new ComeCiegas();
        comeCiegas5.setJugadoresQueComo(comeCiegasJug5);
        comeCiegas5.setApuesta(0);

        ComeCiegas comeCiegas6=new ComeCiegas();
        comeCiegas6.setJugadoresQueComo(comeCiegasJug6);
        comeCiegas6.setApuesta(0);

        listaComeCiegas.add(comeCiegas1);
        listaComeCiegas.add(comeCiegas2);
        listaComeCiegas.add(comeCiegas3);
        listaComeCiegas.add(comeCiegas4);
        listaComeCiegas.add(comeCiegas5);
        listaComeCiegas.add(comeCiegas6);

        SimulacionSTCCS6 simulacion=new SimulacionSTCCS6();
        simulacion.setRankingPreflopEuristicas(rankingPreflopEuristicas);
        simulacion.setComeCiegas(listaComeCiegas);
        simulacion.setRepeticiones(100000);
        simulacion.prepararPartida();
        simulacion.simularPartida();

        return simulacion;
    }


    public SimulacionSTCCSENG simulacionSTCCSEN2GInforme(ArrayList<SegmentacionFormal> formal){

        SemillaRankingEuristico semillaRankingEuristico1=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(20,50)),
                        new ArrayList<Integer>(Arrays.asList(0,20))
                );
        SemillaRankingEuristico semillaRankingEuristico2=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(10,100)),
                        new ArrayList<Integer>(Arrays.asList(0,20))
                );

        GeneradorRankingsEuristicos generadorRankingsEuristicos=new GeneradorRankingsEuristicos();

        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico1);
        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico2);

        generadorRankingsEuristicos.generarEuristicas(formal);

        ArrayList<ComeCiegas>  listaComeCiegas=new ArrayList<>();

        ArrayList<Integer> comeCiegasJug1=new ArrayList<>();
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(1);

        ArrayList<Integer> comeCiegasJug2=new ArrayList<>();
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);

        ComeCiegas comeCiegas1=new ComeCiegas();
        comeCiegas1.setJugadoresQueComo(comeCiegasJug1);
        comeCiegas1.setApuesta(6);

        ComeCiegas comeCiegas2=new ComeCiegas();
        comeCiegas2.setJugadoresQueComo(comeCiegasJug2);
        comeCiegas2.setApuesta(0);

        listaComeCiegas.add(comeCiegas1);
        listaComeCiegas.add(comeCiegas2);

        SimulacionSTCCSENG simulacion=new SimulacionSTCCSENG();
        simulacion.setRepeticiones(50);
        simulacion.setRankingPreflopEuristicas(generadorRankingsEuristicos.getRankingEuristicas());
        simulacion.setComeCiegas(listaComeCiegas);
        simulacion.prepararPartida();
        simulacion.getPartida().setDebug(1);
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionSTCCSENG simulacionSTCCSEN2G(ArrayList<SegmentacionFormal> formal){

        SemillaRankingEuristico semillaRankingEuristico1=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(15,30)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );
        SemillaRankingEuristico semillaRankingEuristico2=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(15,50)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );

        GeneradorRankingsEuristicos generadorRankingsEuristicos=new GeneradorRankingsEuristicos();

        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico1);
        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico2);

        generadorRankingsEuristicos.generarEuristicas(formal);

        ArrayList<ComeCiegas>  listaComeCiegas=new ArrayList<>();

        ArrayList<Integer> comeCiegasJug1=new ArrayList<>();
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);

        ArrayList<Integer> comeCiegasJug2=new ArrayList<>();
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);

        ComeCiegas comeCiegas1=new ComeCiegas();
        comeCiegas1.setJugadoresQueComo(comeCiegasJug1);
        comeCiegas1.setApuesta(0);

        ComeCiegas comeCiegas2=new ComeCiegas();
        comeCiegas2.setJugadoresQueComo(comeCiegasJug2);
        comeCiegas2.setApuesta(0);

        listaComeCiegas.add(comeCiegas1);
        listaComeCiegas.add(comeCiegas2);

        SimulacionSTCCSENG simulacion=new SimulacionSTCCSENG();
        simulacion.setRankingPreflopEuristicas(generadorRankingsEuristicos.getRankingEuristicas());
        simulacion.setComeCiegas(listaComeCiegas);
        simulacion.setRepeticiones(100000);
        simulacion.prepararPartida();
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionSTCCSENG6 simulacionSTCCSEN2G6Informe(ArrayList<SegmentacionFormal> formal){

        SemillaRankingEuristico semillaRankingEuristico1=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(15,30)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );
        SemillaRankingEuristico semillaRankingEuristico2=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(15,50)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );
        SemillaRankingEuristico semillaRankingEuristico3=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(20,70)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );
        SemillaRankingEuristico semillaRankingEuristico4=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(20,70)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );
        SemillaRankingEuristico semillaRankingEuristico5=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(30,50)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );
        SemillaRankingEuristico semillaRankingEuristico6=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(30,100)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );


        GeneradorRankingsEuristicos generadorRankingsEuristicos=new GeneradorRankingsEuristicos();

        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico1);
        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico2);
        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico3);
        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico4);
        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico5);
        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico6);

        generadorRankingsEuristicos.generarEuristicas(formal);

        ArrayList<ComeCiegas> listaComeCiegas=new ArrayList<>();

        ArrayList<Integer> comeCiegasJug1=new ArrayList<>();
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);

        ArrayList<Integer> comeCiegasJug2=new ArrayList<>();
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);

        ArrayList<Integer> comeCiegasJug3=new ArrayList<>();
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);

        ArrayList<Integer> comeCiegasJug4=new ArrayList<>();
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);

        ArrayList<Integer> comeCiegasJug5=new ArrayList<>();
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);

        ArrayList<Integer> comeCiegasJug6=new ArrayList<>();
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);

        ComeCiegas comeCiegas1=new ComeCiegas();
        comeCiegas1.setJugadoresQueComo(comeCiegasJug1);
        comeCiegas1.setApuesta(0);

        ComeCiegas comeCiegas2=new ComeCiegas();
        comeCiegas2.setJugadoresQueComo(comeCiegasJug2);
        comeCiegas2.setApuesta(0);

        ComeCiegas comeCiegas3=new ComeCiegas();
        comeCiegas3.setJugadoresQueComo(comeCiegasJug3);
        comeCiegas3.setApuesta(0);

        ComeCiegas comeCiegas4=new ComeCiegas();
        comeCiegas4.setJugadoresQueComo(comeCiegasJug4);
        comeCiegas4.setApuesta(0);

        ComeCiegas comeCiegas5=new ComeCiegas();
        comeCiegas5.setJugadoresQueComo(comeCiegasJug5);
        comeCiegas5.setApuesta(0);

        ComeCiegas comeCiegas6=new ComeCiegas();
        comeCiegas6.setJugadoresQueComo(comeCiegasJug6);
        comeCiegas6.setApuesta(0);

        listaComeCiegas.add(comeCiegas1);
        listaComeCiegas.add(comeCiegas2);
        listaComeCiegas.add(comeCiegas3);
        listaComeCiegas.add(comeCiegas4);
        listaComeCiegas.add(comeCiegas5);
        listaComeCiegas.add(comeCiegas6);

        SimulacionSTCCSENG6 simulacion=new SimulacionSTCCSENG6();
        simulacion.setRepeticiones(50);
        simulacion.setRankingPreflopEuristicas(generadorRankingsEuristicos.getRankingEuristicas());
        simulacion.setComeCiegas(listaComeCiegas);
        simulacion.prepararPartida();
        simulacion.getPartida().setDebug(1);
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionSTCCSENG6 simulacionSTCCSEN2G6(ArrayList<SegmentacionFormal> formal){

        SemillaRankingEuristico semillaRankingEuristico1=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(15,30)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );
        SemillaRankingEuristico semillaRankingEuristico2=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(15,50)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );
        SemillaRankingEuristico semillaRankingEuristico3=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(20,70)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );
        SemillaRankingEuristico semillaRankingEuristico4=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(20,70)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );
        SemillaRankingEuristico semillaRankingEuristico5=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(30,50)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );
        SemillaRankingEuristico semillaRankingEuristico6=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(30,100)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );


        GeneradorRankingsEuristicos generadorRankingsEuristicos=new GeneradorRankingsEuristicos();

        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico1);
        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico2);
        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico3);
        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico4);
        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico5);
        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico6);

        generadorRankingsEuristicos.generarEuristicas(formal);

        ArrayList<ComeCiegas> listaComeCiegas=new ArrayList<>();

        ArrayList<Integer> comeCiegasJug1=new ArrayList<>();
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);

        ArrayList<Integer> comeCiegasJug2=new ArrayList<>();
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);

        ArrayList<Integer> comeCiegasJug3=new ArrayList<>();
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);

        ArrayList<Integer> comeCiegasJug4=new ArrayList<>();
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);

        ArrayList<Integer> comeCiegasJug5=new ArrayList<>();
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);

        ArrayList<Integer> comeCiegasJug6=new ArrayList<>();
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);

        ComeCiegas comeCiegas1=new ComeCiegas();
        comeCiegas1.setJugadoresQueComo(comeCiegasJug1);
        comeCiegas1.setApuesta(0);

        ComeCiegas comeCiegas2=new ComeCiegas();
        comeCiegas2.setJugadoresQueComo(comeCiegasJug2);
        comeCiegas2.setApuesta(0);

        ComeCiegas comeCiegas3=new ComeCiegas();
        comeCiegas3.setJugadoresQueComo(comeCiegasJug3);
        comeCiegas3.setApuesta(0);

        ComeCiegas comeCiegas4=new ComeCiegas();
        comeCiegas4.setJugadoresQueComo(comeCiegasJug4);
        comeCiegas4.setApuesta(0);

        ComeCiegas comeCiegas5=new ComeCiegas();
        comeCiegas5.setJugadoresQueComo(comeCiegasJug5);
        comeCiegas5.setApuesta(0);

        ComeCiegas comeCiegas6=new ComeCiegas();
        comeCiegas6.setJugadoresQueComo(comeCiegasJug6);
        comeCiegas6.setApuesta(0);

        listaComeCiegas.add(comeCiegas1);
        listaComeCiegas.add(comeCiegas2);
        listaComeCiegas.add(comeCiegas3);
        listaComeCiegas.add(comeCiegas4);
        listaComeCiegas.add(comeCiegas5);
        listaComeCiegas.add(comeCiegas6);

        SimulacionSTCCSENG6 simulacion=new SimulacionSTCCSENG6();
        simulacion.setRankingPreflopEuristicas(generadorRankingsEuristicos.getRankingEuristicas());
        simulacion.setComeCiegas(listaComeCiegas);
        simulacion.setRepeticiones(100000);
        simulacion.prepararPartida();
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionSTCCSENM simulacionSTCCSEN2MInforme(ArrayList<SegmentacionFormal> formal){

        SemillaRankingEuristico semillaRankingEuristico1=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(20,50)),
                        new ArrayList<Integer>(Arrays.asList(0,20))
                );
        SemillaRankingEuristico semillaRankingEuristico2=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(10,100)),
                        new ArrayList<Integer>(Arrays.asList(0,20))
                );

        GeneradorRankingsEuristicos generadorRankingsEuristicos=new GeneradorRankingsEuristicos();

        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico1);
        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico2);

        generadorRankingsEuristicos.generarEuristicas(formal);

        ArrayList<ComeCiegas>  listaComeCiegas=new ArrayList<>();

        ArrayList<Integer> comeCiegasJug1=new ArrayList<>();
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(1);

        ArrayList<Integer> comeCiegasJug2=new ArrayList<>();
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);

        ComeCiegas comeCiegas1=new ComeCiegas();
        comeCiegas1.setJugadoresQueComo(comeCiegasJug1);
        comeCiegas1.setApuesta(6);

        ComeCiegas comeCiegas2=new ComeCiegas();
        comeCiegas2.setJugadoresQueComo(comeCiegasJug2);
        comeCiegas2.setApuesta(0);

        listaComeCiegas.add(comeCiegas1);
        listaComeCiegas.add(comeCiegas2);

        SimulacionSTCCSENM simulacion=new SimulacionSTCCSENM();
        simulacion.setRepeticiones(50);
        simulacion.setRankingPreflopEuristicas(generadorRankingsEuristicos.getRankingEuristicas());
        simulacion.setComeCiegas(listaComeCiegas);
        simulacion.prepararPartida();
        simulacion.getPartida().setDebug(1);
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionSTCCSENM simulacionSTCCSEN2M(ArrayList<SegmentacionFormal> formal){

        SemillaRankingEuristico semillaRankingEuristico1=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(15,30)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );
        SemillaRankingEuristico semillaRankingEuristico2=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(15,50)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );

        GeneradorRankingsEuristicos generadorRankingsEuristicos=new GeneradorRankingsEuristicos();

        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico1);
        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico2);

        generadorRankingsEuristicos.generarEuristicas(formal);

        ArrayList<ComeCiegas>  listaComeCiegas=new ArrayList<>();

        ArrayList<Integer> comeCiegasJug1=new ArrayList<>();
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);

        ArrayList<Integer> comeCiegasJug2=new ArrayList<>();
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);

        ComeCiegas comeCiegas1=new ComeCiegas();
        comeCiegas1.setJugadoresQueComo(comeCiegasJug1);
        comeCiegas1.setApuesta(0);

        ComeCiegas comeCiegas2=new ComeCiegas();
        comeCiegas2.setJugadoresQueComo(comeCiegasJug2);
        comeCiegas2.setApuesta(0);

        listaComeCiegas.add(comeCiegas1);
        listaComeCiegas.add(comeCiegas2);

        SimulacionSTCCSENM simulacion=new SimulacionSTCCSENM();
        simulacion.setRankingPreflopEuristicas(generadorRankingsEuristicos.getRankingEuristicas());
        simulacion.setComeCiegas(listaComeCiegas);
        simulacion.setRepeticiones(100000);
        simulacion.prepararPartida();
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionSTCCSENM6 simulacionSTCCSEN2M6Informe(ArrayList<SegmentacionFormal> formal){

        SemillaRankingEuristico semillaRankingEuristico1=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(15,30)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );
        SemillaRankingEuristico semillaRankingEuristico2=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(15,50)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );
        SemillaRankingEuristico semillaRankingEuristico3=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(20,70)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );
        SemillaRankingEuristico semillaRankingEuristico4=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(20,70)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );
        SemillaRankingEuristico semillaRankingEuristico5=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(30,50)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );
        SemillaRankingEuristico semillaRankingEuristico6=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(30,100)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );


        GeneradorRankingsEuristicos generadorRankingsEuristicos=new GeneradorRankingsEuristicos();

        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico1);
        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico2);
        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico3);
        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico4);
        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico5);
        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico6);

        generadorRankingsEuristicos.generarEuristicas(formal);

        ArrayList<ComeCiegas> listaComeCiegas=new ArrayList<>();

        ArrayList<Integer> comeCiegasJug1=new ArrayList<>();
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);

        ArrayList<Integer> comeCiegasJug2=new ArrayList<>();
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);

        ArrayList<Integer> comeCiegasJug3=new ArrayList<>();
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);

        ArrayList<Integer> comeCiegasJug4=new ArrayList<>();
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);

        ArrayList<Integer> comeCiegasJug5=new ArrayList<>();
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);

        ArrayList<Integer> comeCiegasJug6=new ArrayList<>();
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);

        ComeCiegas comeCiegas1=new ComeCiegas();
        comeCiegas1.setJugadoresQueComo(comeCiegasJug1);
        comeCiegas1.setApuesta(0);

        ComeCiegas comeCiegas2=new ComeCiegas();
        comeCiegas2.setJugadoresQueComo(comeCiegasJug2);
        comeCiegas2.setApuesta(0);

        ComeCiegas comeCiegas3=new ComeCiegas();
        comeCiegas3.setJugadoresQueComo(comeCiegasJug3);
        comeCiegas3.setApuesta(0);

        ComeCiegas comeCiegas4=new ComeCiegas();
        comeCiegas4.setJugadoresQueComo(comeCiegasJug4);
        comeCiegas4.setApuesta(0);

        ComeCiegas comeCiegas5=new ComeCiegas();
        comeCiegas5.setJugadoresQueComo(comeCiegasJug5);
        comeCiegas5.setApuesta(0);

        ComeCiegas comeCiegas6=new ComeCiegas();
        comeCiegas6.setJugadoresQueComo(comeCiegasJug6);
        comeCiegas6.setApuesta(0);

        listaComeCiegas.add(comeCiegas1);
        listaComeCiegas.add(comeCiegas2);
        listaComeCiegas.add(comeCiegas3);
        listaComeCiegas.add(comeCiegas4);
        listaComeCiegas.add(comeCiegas5);
        listaComeCiegas.add(comeCiegas6);

        SimulacionSTCCSENM6 simulacion=new SimulacionSTCCSENM6();
        simulacion.setRepeticiones(50);
        simulacion.setRankingPreflopEuristicas(generadorRankingsEuristicos.getRankingEuristicas());
        simulacion.setComeCiegas(listaComeCiegas);
        simulacion.prepararPartida();
        simulacion.getPartida().setDebug(1);
        simulacion.simularPartida();

        return simulacion;
    }

    public SimulacionSTCCSENM6 simulacionSTCCSEN2M6(ArrayList<SegmentacionFormal> formal){

        SemillaRankingEuristico semillaRankingEuristico1=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(15,30)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );
        SemillaRankingEuristico semillaRankingEuristico2=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(15,50)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );
        SemillaRankingEuristico semillaRankingEuristico3=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(20,70)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );
        SemillaRankingEuristico semillaRankingEuristico4=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(20,70)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );
        SemillaRankingEuristico semillaRankingEuristico5=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(30,50)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );
        SemillaRankingEuristico semillaRankingEuristico6=
                new SemillaRankingEuristico(
                        new ArrayList<Integer>(Arrays.asList(30,100)),
                        new ArrayList<Integer>(Arrays.asList(0,10))
                );


        GeneradorRankingsEuristicos generadorRankingsEuristicos=new GeneradorRankingsEuristicos();

        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico1);
        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico2);
        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico3);
        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico4);
        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico5);
        generadorRankingsEuristicos.getSemillasRankings().add(semillaRankingEuristico6);

        generadorRankingsEuristicos.generarEuristicas(formal);

        ArrayList<ComeCiegas> listaComeCiegas=new ArrayList<>();

        ArrayList<Integer> comeCiegasJug1=new ArrayList<>();
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);
        comeCiegasJug1.add(0);

        ArrayList<Integer> comeCiegasJug2=new ArrayList<>();
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);
        comeCiegasJug2.add(0);

        ArrayList<Integer> comeCiegasJug3=new ArrayList<>();
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);
        comeCiegasJug3.add(0);

        ArrayList<Integer> comeCiegasJug4=new ArrayList<>();
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);
        comeCiegasJug4.add(0);

        ArrayList<Integer> comeCiegasJug5=new ArrayList<>();
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);
        comeCiegasJug5.add(0);

        ArrayList<Integer> comeCiegasJug6=new ArrayList<>();
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);
        comeCiegasJug6.add(0);

        ComeCiegas comeCiegas1=new ComeCiegas();
        comeCiegas1.setJugadoresQueComo(comeCiegasJug1);
        comeCiegas1.setApuesta(0);

        ComeCiegas comeCiegas2=new ComeCiegas();
        comeCiegas2.setJugadoresQueComo(comeCiegasJug2);
        comeCiegas2.setApuesta(0);

        ComeCiegas comeCiegas3=new ComeCiegas();
        comeCiegas3.setJugadoresQueComo(comeCiegasJug3);
        comeCiegas3.setApuesta(0);

        ComeCiegas comeCiegas4=new ComeCiegas();
        comeCiegas4.setJugadoresQueComo(comeCiegasJug4);
        comeCiegas4.setApuesta(0);

        ComeCiegas comeCiegas5=new ComeCiegas();
        comeCiegas5.setJugadoresQueComo(comeCiegasJug5);
        comeCiegas5.setApuesta(0);

        ComeCiegas comeCiegas6=new ComeCiegas();
        comeCiegas6.setJugadoresQueComo(comeCiegasJug6);
        comeCiegas6.setApuesta(0);

        listaComeCiegas.add(comeCiegas1);
        listaComeCiegas.add(comeCiegas2);
        listaComeCiegas.add(comeCiegas3);
        listaComeCiegas.add(comeCiegas4);
        listaComeCiegas.add(comeCiegas5);
        listaComeCiegas.add(comeCiegas6);

        SimulacionSTCCSENM6 simulacion=new SimulacionSTCCSENM6();
        simulacion.setRankingPreflopEuristicas(generadorRankingsEuristicos.getRankingEuristicas());
        simulacion.setComeCiegas(listaComeCiegas);
        simulacion.setRepeticiones(100000);
        simulacion.prepararPartida();
        simulacion.simularPartida();

        return simulacion;
    }
}

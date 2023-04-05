package com.poker.pokersimulate.models.service;

import org.springframework.stereotype.Component;

@Component
public class ServicioFuncionalidad {
/*
    public Baraja barajaSinBarajar(){
        Baraja baraja=new Baraja();
        baraja.generarBaraja();
        return baraja;
    }

    public Baraja bararaBarajada(){
        Baraja baraja=new Baraja();
        baraja.generarBaraja();
        baraja.barajar();
        return baraja;
    }

    public Ronda RondaIniciada(){
        Baraja baraja=new Baraja();
        baraja.generarBaraja();
        Mesa2 mesa=new Mesa2();
        Ronda ronda=new Ronda();
        ronda.setBaraja(baraja);
        ronda.setMesa(mesa);

        mesa.generarAsientos();
        Integer contador=0;
        ArrayList<Asiento> asientos=mesa.getAsientos();
        for(Asiento asiento: asientos){
            Jugador j=new Jugador();
            Pareja p=new Pareja();
            asiento.setJugador(j);
            asiento.setPosicion(contador);
            asiento.setPareja(p);
        }
        ronda.repartirCartasJuegadores();

        return ronda;
    }

    public Ronda RondaIniciada2(){
        Baraja baraja=new Baraja();
        baraja.generarBaraja();
        Mesa2 mesa=new Mesa2();
        Ronda ronda=new Ronda();
        ronda.setBaraja(baraja);
        ronda.setMesa(mesa);

        mesa.generarAsientos();
        Integer contador=0;
        ArrayList<Asiento> asientos=mesa.getAsientos();
        for(Asiento asiento: asientos){
            Jugador j=new Jugador();
            Pareja p=new Pareja();
            asiento.setJugador(j);
            asiento.setPosicion(contador);
            asiento.setPareja(p);
        }
        ronda.repartirCartasJuegadores();
        ronda.repartirComunitarias();


        return ronda;
    }

    public Ronda RondaTerminada(){
        Baraja baraja = new Baraja();
        baraja.generarBaraja();
        Mesa2 mesa = new Mesa2();
        RondaE ronda = new RondaE();
        ronda.setBaraja(baraja);
        ronda.setMesa(mesa);
        Estadistica estadistica=new Estadistica2();
        ronda.setEstadistica(estadistica);
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
        ronda.repartirCartasJuegadores();
        ronda.repartirComunitarias();
        ronda.evaluarJugadores();
        ronda.compararJerarquias();
        ronda.generarGanadores();
        return ronda;
    }


    public Partida partidaLarga(){
        Carta c1=new Carta(14,1);
        Carta c2=new Carta(14,2);
        Pareja p1=new Pareja();
        p1.anyadirCartas(c1);
        p1.anyadirCartas(c2);
        Trucada2 baraja = new Trucada2();
        baraja.setPareja(p1);
        baraja.generarBaraja();
        Mesa2 mesa = new Mesa2();
        RondaE ronda = new RondaE();
        ronda.setBaraja(baraja);
        ronda.setMesa(mesa);
        Estadistica estadistica=new Estadistica2();
        ronda.setEstadistica(estadistica);
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

        PartidaE partida = new PartidaE();
        partida.setRonda(ronda);


        partida.iterarRondas(1000);

        return partida;
    }

    public SupraSegmentacion revisionSupra(){
        SupraSegmentacion supra=new SupraSegmentacion();
        supra.generarSupra();

        return supra;
    }

    public SimulacionJ simulacionJ2General(){
        SupraSegmentacion supra=new SupraSegmentacion();
        supra.generarSupra();

        PreFlopE169 preFlopE169=new PreFlopE169();

        PartidaE partida = new PartidaE();

        SimulacionJ simulacionJ2=new SimulacionJ();

        simulacionJ2.setPartida(partida);
        simulacionJ2.setPreFlop(preFlopE169);
        simulacionJ2.setSupra(supra);

        simulacionJ2.simulacionGeneral();
        simulacionJ2.prepararResultado();


        return simulacionJ2;
    }

    public SimulacionJ simulacionJ6General(){
        SupraSegmentacion supra=new SupraSegmentacion();
        supra.generarSupra();

        PreFlopE169 preFlopE169=new PreFlopE169();

        PartidaE partida = new PartidaE();

        SimulacionJ6 simulacionJ6=new SimulacionJ6();

        simulacionJ6.setPartida(partida);
        simulacionJ6.setPreFlop(preFlopE169);
        simulacionJ6.setSupra(supra);

        simulacionJ6.simulacionGeneral();
        simulacionJ6.prepararResultado();

        return simulacionJ6;
    }

    public ArrayList<PreFlopEData> simulacionJ2All01General(){
        SupraSegmentacion supra=new SupraSegmentacion();
        supra.generarSupra();

        PreFlopE169 preFlopE169=new PreFlopE169();

        PartidaE partida = new PartidaE();

        SimulacionJAll simulacionJ2=new SimulacionJAll();

        simulacionJ2.setPartida(partida);
        simulacionJ2.setPreFlop(preFlopE169);
        simulacionJ2.setSupra(supra);

        simulacionJ2.simulacionGeneral();
        simulacionJ2.prepararResultado();

        ArrayList<PreFlopEData> data=new ArrayList<>();
        ArrayList<PreflopE> preflopES=simulacionJ2.getPreFlop().getPreflopE169();

        for(PreflopE preflopE: preflopES){
            PreFlopEData preFlopEData=new PreFlopEData();
            preFlopEData.setPareja(preflopE.getPareja());
            preFlopEData.setPorcentaje(preflopE.getEstadistica().getGano());
            preFlopEData.setSaldo(((EstadisticaConDinero) preflopE.getEstadistica()).getSaldos().get(0));
            data.add(preFlopEData);
        }
        return data;
    }

    public ArrayList<PreFlopEData> simulacionJ2All6General(){
        SupraSegmentacion supra=new SupraSegmentacion();
        supra.generarSupra();

        PreFlopE169 preFlopE169=new PreFlopE169();

        PartidaE partida = new PartidaE();

        SimulacionJAll6 simulacionJ2=new SimulacionJAll6();

        simulacionJ2.setPartida(partida);
        simulacionJ2.setPreFlop(preFlopE169);
        simulacionJ2.setSupra(supra);

        simulacionJ2.simulacionGeneral();
        simulacionJ2.prepararResultado();

        ArrayList<PreFlopEData> data=new ArrayList<>();
        ArrayList<PreflopE> preflopES=simulacionJ2.getPreFlop().getPreflopE169();

        for(PreflopE preflopE: preflopES){
            PreFlopEData preFlopEData=new PreFlopEData();
            preFlopEData.setPareja(preflopE.getPareja());
            preFlopEData.setPorcentaje(preflopE.getEstadistica().getGano());
            preFlopEData.setSaldo(((EstadisticaConDinero) preflopE.getEstadistica()).getSaldos().get(0));
            data.add(preFlopEData);
        }
        return data;
    }




    public EstadisticaA simulacionS2General(ArrayList<SegmentacionFormal> formal){


        EuristicaPreflopLineal eu1=new EuristicaPreflopLineal();
        eu1.retructurarDatos(formal);
        eu1.setProfundidad(190);

        EuristicaPreflopLineal eu2=new EuristicaPreflopLineal();
        eu2.retructurarDatos(formal);
        eu2.setProfundidad(1);

        EuristicaPreflopLinealExpand eu1E = new EuristicaPreflopLinealExpand();
        eu1E.expandir(eu1);

        EuristicaPreflopLinealExpand eu2E = new EuristicaPreflopLinealExpand();
        eu2E.expandir(eu2);

        ArrayList<EuristicaPreflopLinealExpand> euristicas=new ArrayList<>();
        euristicas.add(eu1E);
        euristicas.add(eu2E);

        SimulacionS simulacionS2=new SimulacionS();
        simulacionS2.setEuristicas(euristicas);
        simulacionS2.prepararPartida();
        simulacionS2.simularPartida();

        EstadisticaA estadistica=(EstadisticaA) ((RondaEConDinero) simulacionS2.getPartida().getRonda()).getEstadistica();
        estadistica.generarPorcentaje();

        return estadistica;
    }

    public EstadisticaA simulacionS2TGeneral(ArrayList<SegmentacionFormal> formal){


        EuristicaPreflopLineal eu1=new EuristicaPreflopLineal();
        eu1.retructurarDatos(formal);
        eu1.setProfundidad(1);

        EuristicaPreflopLineal eu2=new EuristicaPreflopLineal();
        eu2.retructurarDatos(formal);
        eu2.setProfundidad(190);

        EuristicaPreflopLinealExpand eu1E = new EuristicaPreflopLinealExpand();
        eu1E.expandir(eu1);

        EuristicaPreflopLinealExpand eu2E = new EuristicaPreflopLinealExpand();
        eu2E.expandir(eu2);

        ArrayList<EuristicaPreflopLinealExpand> euristicas=new ArrayList<>();
        euristicas.add(eu1E);
        euristicas.add(eu2E);

        SimulacionST simulacionS2T=new SimulacionST();
        simulacionS2T.setEuristicas(euristicas);
        simulacionS2T.prepararPartida();
        simulacionS2T.simularPartida();

        EstadisticaA estadistica=(EstadisticaA) ((RondaEConDinero) simulacionS2T.getPartida().getRonda()).getEstadistica();
        estadistica.generarPorcentaje();

        return estadistica;
    }

    public EstadisticaA simulacionS2TCGeneral(ArrayList<SegmentacionFormal> formal){


        EuristicaPreflopLineal eu1=new EuristicaPreflopLineal();
        eu1.retructurarDatos(formal);
        eu1.setProfundidad(30);

        EuristicaPreflopLineal eu2=new EuristicaPreflopLineal();
        eu2.retructurarDatos(formal);
        eu2.setProfundidad(15);

        EuristicaPreflopLinealExpand eu1E = new EuristicaPreflopLinealExpand();
        eu1E.expandir(eu1);

        EuristicaPreflopLinealExpand eu2E = new EuristicaPreflopLinealExpand();
        eu2E.expandir(eu2);

        ArrayList<EuristicaPreflopLinealExpand> euristicas=new ArrayList<>();
        euristicas.add(eu1E);
        euristicas.add(eu2E);

        SimulacionSTC simulacionS2TC=new SimulacionSTC();
        simulacionS2TC.setEuristicas(euristicas);
        simulacionS2TC.prepararPartida();
        simulacionS2TC.simularPartida();

        EstadisticaA estadistica=(EstadisticaA) ((RondaEConDinero) simulacionS2TC.getPartida().getRonda()).getEstadistica();
        estadistica.generarPorcentaje();

        return estadistica;
    }

    public EstadisticaA simulacionS6General(ArrayList<SegmentacionFormal> formal){


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


        SimulacionS6 simulacionS2=new SimulacionS6();
        simulacionS2.setEuristicas(euristicas);
        simulacionS2.prepararPartida();
        simulacionS2.simularPartida();

        EstadisticaA estadistica=(EstadisticaA) ((RondaEConDinero) simulacionS2.getPartida().getRonda()).getEstadistica();
        estadistica.generarPorcentaje();

        return estadistica;
    }
    public EstadisticaA simulacionST6General(ArrayList<SegmentacionFormal> formal){


        EuristicaPreflopLineal eu1=new EuristicaPreflopLineal();
        eu1.retructurarDatos(formal);
        eu1.setProfundidad(20);

        EuristicaPreflopLineal eu2=new EuristicaPreflopLineal();
        eu2.retructurarDatos(formal);
        eu2.setProfundidad(30);

        EuristicaPreflopLineal eu3=new EuristicaPreflopLineal();
        eu3.retructurarDatos(formal);
        eu3.setProfundidad(50);


        EuristicaPreflopLineal eu4=new EuristicaPreflopLineal();
        eu4.retructurarDatos(formal);
        eu4.setProfundidad(900);

        EuristicaPreflopLineal eu5=new EuristicaPreflopLineal();
        eu5.retructurarDatos(formal);
        eu5.setProfundidad(130);

        EuristicaPreflopLineal eu6=new EuristicaPreflopLineal();
        eu6.retructurarDatos(formal);
        eu6.setProfundidad(190);

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


        SimulacionST6 simulacionS2=new SimulacionST6();
        simulacionS2.setEuristicas(euristicas);
        simulacionS2.prepararPartida();
        simulacionS2.simularPartida();

        EstadisticaA estadistica=(EstadisticaA) ((RondaEConDinero) simulacionS2.getPartida().getRonda()).getEstadistica();
        estadistica.generarPorcentaje();

        return estadistica;
    }

    public EstadisticaA simulacionSTC6General(ArrayList<SegmentacionFormal> formal){


        EuristicaPreflopLineal eu1=new EuristicaPreflopLineal();
        eu1.retructurarDatos(formal);
        eu1.setProfundidad(20);

        EuristicaPreflopLineal eu2=new EuristicaPreflopLineal();
        eu2.retructurarDatos(formal);
        eu2.setProfundidad(30);

        EuristicaPreflopLineal eu3=new EuristicaPreflopLineal();
        eu3.retructurarDatos(formal);
        eu3.setProfundidad(50);


        EuristicaPreflopLineal eu4=new EuristicaPreflopLineal();
        eu4.retructurarDatos(formal);
        eu4.setProfundidad(60);

        EuristicaPreflopLineal eu5=new EuristicaPreflopLineal();
        eu5.retructurarDatos(formal);
        eu5.setProfundidad(60);

        EuristicaPreflopLineal eu6=new EuristicaPreflopLineal();
        eu6.retructurarDatos(formal);
        eu6.setProfundidad(60);

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


        SimulacionSTC6 simulacionS2=new SimulacionSTC6();
        simulacionS2.setEuristicas(euristicas);
        simulacionS2.prepararPartida();
        simulacionS2.simularPartida();

        EstadisticaA estadistica=(EstadisticaA) ((RondaEConDinero) simulacionS2.getPartida().getRonda()).getEstadistica();
        estadistica.generarPorcentaje();

        return estadistica;
    }

    public EstadisticaA simulacionSTC2FGeneral(ArrayList<SegmentacionFormal> formal){


        EuristicaPreflopLineal eu1=new EuristicaPreflopLineal();
        eu1.retructurarDatos(formal);
        eu1.setProfundidad(10);

        EuristicaPreflopLineal eu2=new EuristicaPreflopLineal();
        eu2.retructurarDatos(formal);
        eu2.setProfundidad(30);

        EuristicaPreflopLinealExpand eu1E = new EuristicaPreflopLinealExpand();
        eu1E.expandir(eu1);

        EuristicaPreflopLinealExpand eu2E = new EuristicaPreflopLinealExpand();
        eu2E.expandir(eu2);

        ArrayList<EuristicaPreflopLinealExpand> euristicas=new ArrayList<>();
        euristicas.add(eu1E);
        euristicas.add(eu2E);

        SimulacionSTC2F simulacionS2TC=new SimulacionSTC2F();
        simulacionS2TC.setEuristicas(euristicas);
        simulacionS2TC.prepararPartida();
        simulacionS2TC.simularPartida();

        EstadisticaA estadistica=(EstadisticaA) ((RondaEConDinero) simulacionS2TC.getPartida().getRonda()).getEstadistica();
        estadistica.generarPorcentaje();

        return estadistica;
    }*/
}

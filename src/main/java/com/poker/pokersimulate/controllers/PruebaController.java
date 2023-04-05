package com.poker.pokersimulate.controllers;

import com.poker.pokersimulate.models.data.PreFlopEData;
import com.poker.pokersimulate.models.service.basico.ServicioFuncionalidadBasico;
import com.poker.pokersimulate.models.service.informe.ServicioFuncionalidadInforme;
import com.poker.pokersimulate.modles.domains.basico.Asiento;
import com.poker.pokersimulate.modles.domains.basico.Ronda;
import com.poker.pokersimulate.modles.domains.basico.Simulacion;
import com.poker.pokersimulate.modles.domains.dinero.preflop.jerarquiaDinero.EstadisticaA;
import com.poker.pokersimulate.modles.domains.estadistica.RondaE;
import com.poker.pokersimulate.modles.domains.estadistica.SimulacionE;
import com.poker.pokersimulate.modles.domains.estadistica.SimulacionE6;
import com.poker.pokersimulate.modles.domains.jerarquia.PreflopE;
import com.poker.pokersimulate.modles.domains.jerarquia.SimulacionJ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class PruebaController {


    @Autowired
    private ServicioFuncionalidadBasico servicioFuncionalidadBasico;

    @Autowired
    private ServicioFuncionalidadInforme servicioFuncionalidadInforme;

    @GetMapping(value="/prueba01")
    public String prueba01(ModelMap model){

        model.addAttribute("titulo", "Prueba 01 - Prueba Baraja Sin Barajar");
        model.addAttribute("cartas", servicioFuncionalidadBasico.barajaSinBarajar().getCartas());
        return "pruebas/basicas/prueba01";
    }

    @GetMapping(value="/prueba02")
    public String prueba02(ModelMap model){

        model.addAttribute("titulo", "Prueba 02 - Prueba Baraja Barajada");
        model.addAttribute("cartas", servicioFuncionalidadBasico.barajaBarajada().getCartas());
        return "pruebas/basicas/prueba02";
    }


    @GetMapping(value="/prueba03")
    public String prueba03(ModelMap model){

        Ronda ronda= servicioFuncionalidadInforme.rondaTerminada01();

        Asiento asiento=ronda.getMesa().getAsientos().get(0);

        asiento.setComunitarias(ronda.getComunitarias());
        asiento.generarRango();

        model.addAttribute("titulo", "Prueba 3 - Ronda Terminada Reparto Cartas - Evaluacion de  Asiento");
        model.addAttribute("asientos", ronda.getMesa().getAsientos());
        model.addAttribute("comunitarias", ronda.getComunitarias());

        model.addAttribute("cartas", ronda.getBaraja().getCartas());

        model.addAttribute("asiento",asiento);
        return "pruebas/basicas/prueba03";
    }

    @GetMapping(value="/prueba04")
    public String prueba04(ModelMap model){

        Ronda ronda= servicioFuncionalidadInforme.rondaTerminada02();
        model.addAttribute("titulo", "Prueba 5 - Ronda Terminada - Evaluacion Ganador");
        model.addAttribute("asientos", ronda.getMesa().getAsientos());
        model.addAttribute("comunitarias", ronda.getComunitarias());

        model.addAttribute("cartas", ronda.getBaraja().getCartas());

        model.addAttribute("ganadores",ronda.getRankings().get(0).getPosRankings().get(0).getGanadores());
        return "pruebas/basicas/prueba04";
    }



    @GetMapping(value="/prueba05")
    public String prueba05(ModelMap model){

        Ronda ronda= servicioFuncionalidadInforme.rondaTerminada03();
        model.addAttribute("titulo", "Prueba 5 - Ronda Terminada - Evaluacion Ganador - Mesa 2");
        model.addAttribute("asientos", ronda.getMesa().getAsientos());
        model.addAttribute("comunitarias", ronda.getComunitarias());

        model.addAttribute("cartas", ronda.getBaraja().getCartas());

        model.addAttribute("ganadores",ronda.getRankings().get(0).getPosRankings().get(0).getGanadores());
        return "pruebas/basicas/prueba05";
    }



    @GetMapping(value="/prueba06")
    public String prueba06(ModelMap model){

        Ronda ronda= servicioFuncionalidadInforme.rondaTerminada04();
        model.addAttribute("titulo", "Prueba 6 - Ronda Terminada - Evaluacion Ganador - Mesa 6");
        model.addAttribute("asientos", ronda.getMesa().getAsientos());
        model.addAttribute("comunitarias", ronda.getComunitarias());

        model.addAttribute("cartas", ronda.getBaraja().getCartas());

        model.addAttribute("ganadores",ronda.getRankings().get(0).getPosRankings().get(0).getGanadores());
        return "pruebas/basicas/prueba06";
    }

    @GetMapping(value="/prueba07")
    public String prueba07(ModelMap model){

        Simulacion simulacion = servicioFuncionalidadInforme.generarSimulacion();
        model.addAttribute("titulo", "Prueba 7 - Simulacion - Mesa 2 - informe");
        model.addAttribute("informe", simulacion.getPartida().getInforme());
        return "pruebas/basicas/prueba07";
    }

    @GetMapping(value="/prueba08")
    public String prueba08(ModelMap model){

        SimulacionE simulacion = servicioFuncionalidadInforme.generarSimulacionE();
        model.addAttribute("titulo", "Prueba 8 - SimulacionE - Mesa 2 - informe");
        model.addAttribute("informe", simulacion.getPartida().getInforme());
        return "pruebas/estadistica/prueba08";
    }


    @GetMapping(value="/prueba09")
    public String prueba09(ModelMap model){

        SimulacionE6 simulacion = servicioFuncionalidadInforme.generarSimulacionE6();

        model.addAttribute("titulo", "Prueba 9 - SimulacionE6 - Mesa 6 - informe");
        model.addAttribute("informe", simulacion.getPartida().getInforme());
        return "pruebas/estadistica/prueba09";
    }

    @GetMapping(value="/prueba10")
    public String prueba10(ModelMap model){

        SimulacionE6 simulacion = servicioFuncionalidadInforme.generarSimulacionE6Alt2();
        ((RondaE)simulacion.getPartida().getRonda()).getEstadistica().generarPorcentaje();
        model.addAttribute("titulo", "Prueba 10 - SimulacionE6 - Mesa 6 - Estadistica");
        model.addAttribute("estadistica", ((RondaE)simulacion.getPartida().getRonda()).getEstadistica());
        return "pruebas/estadistica/prueba10";
    }

    @GetMapping(value="/prueba11")
    public String prueba11(ModelMap model){

        SimulacionJ simulacion = servicioFuncionalidadInforme.simulacionJ();

        model.addAttribute("titulo", "Prueba 11 - SimulacionJ - Mesa 2 - informe");
        model.addAttribute("informe", simulacion.getPartida().getInforme());
        return "pruebas/jerarquia/prueba11";
    }


    @GetMapping(value="/prueba12")
    public String prueba12(ModelMap model){


        model.addAttribute("titulo", "Prueba 12 - SimulacionJ2General - Mesa 2 - Estadistica");
        model.addAttribute("preflop", servicioFuncionalidadInforme.simulacionJ2General().getPreFlop());
        return "pruebas/jerarquia/prueba12";
    }

    @GetMapping(value="/prueba13")
    public String prueba13(ModelMap model){


        model.addAttribute("titulo", "Prueba 13 - SimulacionJ6General - Mesa 6 - Estadistica");
        model.addAttribute("preflop", servicioFuncionalidadInforme.simulacionJ6General().getPreFlop());
        return "pruebas/jerarquia/prueba13";
    }


    @GetMapping(value="/prueba14")
    public String prueba14(ModelMap model){


        model.addAttribute("titulo", "Prueba 14 - SimulacionJAll2 - Mesa 2 - Informe");
        model.addAttribute("informe", servicioFuncionalidadInforme.simulacionJ2All().getPartida().getInforme());
        return "pruebas/dinero/prueba14";
    }

    @GetMapping(value="/prueba15")
    public String prueba15(ModelMap model){


        model.addAttribute("titulo", "Prueba 15 - SimulacionJAll6 - Mesa 2 - Informe");
        model.addAttribute("informe", servicioFuncionalidadInforme.simulacionJAll6().getPartida().getInforme());
        return "pruebas/dinero/prueba15";
    }

    @GetMapping(value="/prueba16")
    public String prueba16(ModelMap model){

        ArrayList<PreflopE> preflopES= servicioFuncionalidadInforme.simulacionJ2AllGeneral().getPreFlop().getPreflopE169();
        ArrayList<PreFlopEData> data=new ArrayList<>();
        for(PreflopE preflopE:preflopES){
            PreFlopEData d=new PreFlopEData();
            d.setPareja(preflopE.getPareja());
            d.setPorcentaje(preflopE.getEstadistica().getPorcentaje().toString());
            d.setSaldo(((EstadisticaA)preflopE.getEstadistica()).getSaldos().get(0));
            data.add(d);
        }
        model.addAttribute("titulo", "Prueba 16 - SimulacionJAll2General - Mesa 2 - Estadistica");
        model.addAttribute("data", data);
        return "pruebas/dinero/prueba16";
    }


    @GetMapping(value="/prueba17")
    public String prueba17(ModelMap model){

        ArrayList<PreflopE> preflopES= servicioFuncionalidadInforme.simulacionJAll6General().getPreFlop().getPreflopE169();
        ArrayList<PreFlopEData> data=new ArrayList<>();
        for(PreflopE preflopE:preflopES){
            PreFlopEData d=new PreFlopEData();
            d.setPareja(preflopE.getPareja());
            d.setPorcentaje(preflopE.getEstadistica().getPorcentaje().toString());
            d.setSaldo(((EstadisticaA)preflopE.getEstadistica()).getSaldos().get(0));
            data.add(d);
        }
        model.addAttribute("titulo", "Prueba 17 - SimulacionJAll6General - Mesa 6 - Estadistica");
        model.addAttribute("data", data);
        return "pruebas/dinero/prueba17";
    }
}

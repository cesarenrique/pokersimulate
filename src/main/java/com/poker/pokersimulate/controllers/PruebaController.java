package com.poker.pokersimulate.controllers;

import com.poker.pokersimulate.models.data.PreFlopEData;
import com.poker.pokersimulate.models.entity.SegmentacionFormal;
import com.poker.pokersimulate.models.service.basedatos.ServicioSegmentacionFormal;
import com.poker.pokersimulate.models.service.basico.ServicioFuncionalidadBasico;
import com.poker.pokersimulate.models.service.informe.ServicioFuncionalidadInforme;
import com.poker.pokersimulate.modles.domains.basico.Asiento;
import com.poker.pokersimulate.modles.domains.basico.Ronda;
import com.poker.pokersimulate.modles.domains.basico.Simulacion;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.SimulacionS;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.SimulacionS6;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.EstadisticaA;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.basico.SimulacionST;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.basico.SimulacionST6;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.ciegas.SimulacionSTC;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.ciegas.SimulacionSTC6;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.comeCiegas.SimulacionSTCC;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.comeCiegas.SimulacionSTCC6;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.comeCiegasSupra.SimulacionSTCCS;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.comeCiegasSupra.SimulacionSTCCS6;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.escalonado.Uniforme.nivel.golpe.SimulacionSTCCSENG;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.escalonado.Uniforme.nivel.golpe.SimulacionSTCCSENG6;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.escalonado.Uniforme.nivel.menor.SimulacionSTCCSENM;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.escalonado.Uniforme.nivel.menor.SimulacionSTCCSENM6;
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
    private ServicioSegmentacionFormal servicioSegmentacionFormal;

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


        model.addAttribute("titulo", "Prueba 15 - SimulacionJAll6 - Mesa 6 - Informe");
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

    @GetMapping(value="/prueba18")
    public String prueba18(ModelMap model){

        model.addAttribute("titulo", "Prueba 18 - SimulacionJAll6 - Mesa 2 - Informe - check");
        model.addAttribute("informe", servicioFuncionalidadInforme.simulacionJAllcheck().getPartida().getInforme());
        return "pruebas/dinero/prueba18";
    }


    @GetMapping(value="/prueba19")
    public String prueba19(ModelMap model){


        model.addAttribute("titulo", "Prueba 19 - SimulacionJAll6 - Mesa 6 - Informe -check");
        model.addAttribute("informe", servicioFuncionalidadInforme.simulacionJAll6check().getPartida().getInforme());
        return "pruebas/dinero/prueba19";
    }

    @GetMapping(value="/prueba20")
    public String prueba20(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionS simulacionS= servicioFuncionalidadInforme.simulacionSInforme(formal);

        model.addAttribute("titulo", "Prueba 20 - SimulacionS - Mesa 2 - Informe ");
        model.addAttribute("informe", simulacionS.getPartida().getInforme() );
        return "pruebas/postflop/prueba20";
    }

    @GetMapping(value="/prueba21")
    public String prueba21(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionS simulacion= servicioFuncionalidadInforme.simulacionS(formal);

        model.addAttribute("titulo", "Prueba 21 - SimulacionS - Mesa 2 ");
        model.addAttribute("estadistica", ((EstadisticaA)((RondaE)simulacion.getPartida().getRonda()).getEstadistica()));
        return "pruebas/postflop/prueba21";
    }


    @GetMapping(value="/prueba22")
    public String prueba22(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionS6 simulacion= servicioFuncionalidadInforme.simulacionS6Informe(formal);

        model.addAttribute("titulo", "Prueba 22 - SimulacionS - Mesa 6 - Informe ");
        model.addAttribute("informe", simulacion.getPartida().getInforme() );
        return "pruebas/postflop/prueba22";
    }

    @GetMapping(value="/prueba23")
    public String prueba23(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionS6 simulacion= servicioFuncionalidadInforme.simulacionS6(formal);

        model.addAttribute("titulo", "Prueba 23 - SimulacionS - Mesa 6 ");
        model.addAttribute("estadistica", ((EstadisticaA)((RondaE)simulacion.getPartida().getRonda()).getEstadistica()));
        return "pruebas/postflop/prueba23";
    }

    @GetMapping(value="/prueba24")
    public String prueba24(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionST simulacion= servicioFuncionalidadInforme.simulacionSTInforme(formal);

        model.addAttribute("titulo", "Prueba 24 - SimulacionST - Mesa 2 - Informe ");
        model.addAttribute("informe", simulacion.getPartida().getInforme() );
        return "pruebas/postflop/turno/prueba24";
    }

    @GetMapping(value="/prueba25")
    public String prueba25(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionST simulacion= servicioFuncionalidadInforme.simulacionST(formal);

        model.addAttribute("titulo", "Prueba 25 - SimulacionST - Mesa 2 ");
        model.addAttribute("estadistica", ((EstadisticaA)((RondaE)simulacion.getPartida().getRonda()).getEstadistica()));
        return "pruebas/postflop/turno/prueba25";
    }

    @GetMapping(value="/prueba26")
    public String prueba26(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionST6 simulacion= servicioFuncionalidadInforme.simulacionST6Informe(formal);

        model.addAttribute("titulo", "Prueba 26 - SimulacionST6 - Mesa 6 - Informe ");
        model.addAttribute("informe", simulacion.getPartida().getInforme() );
        return "pruebas/postflop/turno/prueba26";
    }

    @GetMapping(value="/prueba27")
    public String prueba27(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionST6 simulacion= servicioFuncionalidadInforme.simulacionST6(formal);

        model.addAttribute("titulo", "Prueba 27 - SimulacionST6 - Mesa 6 ");
        model.addAttribute("estadistica", ((EstadisticaA)((RondaE)simulacion.getPartida().getRonda()).getEstadistica()));
        return "pruebas/postflop/turno/prueba27";
    }

    @GetMapping(value="/prueba28")
    public String prueba28(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionSTC simulacion= servicioFuncionalidadInforme.simulacionSTCInforme(formal);

        model.addAttribute("titulo", "Prueba 28 - SimulacionSTC - Mesa 2 - Informe ");
        model.addAttribute("informe", simulacion.getPartida().getInforme() );
        return "pruebas/postflop/ciegas/prueba28";
    }

    @GetMapping(value="/prueba29")
    public String prueba29(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionSTC simulacion= servicioFuncionalidadInforme.simulacionSTC(formal);

        model.addAttribute("titulo", "Prueba 29 - SimulacionSTC - Mesa 2 ");
        model.addAttribute("estadistica", ((EstadisticaA)((RondaE)simulacion.getPartida().getRonda()).getEstadistica()));
        return "pruebas/postflop/ciegas/prueba29";
    }

    @GetMapping(value="/prueba30")
    public String prueba30(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionSTC6 simulacion= servicioFuncionalidadInforme.simulacionSTC6Informe(formal);

        model.addAttribute("titulo", "Prueba 30 - SimulacionSTC - Mesa 6 - Informe ");
        model.addAttribute("informe", simulacion.getPartida().getInforme() );
        return "pruebas/postflop/ciegas/prueba30";
    }

    @GetMapping(value="/prueba31")
    public String prueba31(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionSTC6 simulacion= servicioFuncionalidadInforme.simulacionSTC6(formal);

        model.addAttribute("titulo", "Prueba 31 - SimulacionSTC - Mesa 6 ");
        model.addAttribute("estadistica", ((EstadisticaA)((RondaE)simulacion.getPartida().getRonda()).getEstadistica()));
        return "pruebas/postflop/ciegas/prueba31";
    }

    @GetMapping(value="/prueba32")
    public String prueba32(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionSTCC simulacion= servicioFuncionalidadInforme.simulacionSTCCInforme(formal);

        model.addAttribute("titulo", "Prueba 32 - SimulacionSTCC - Mesa 2 - Informe ");
        model.addAttribute("informe", simulacion.getPartida().getInforme() );
        return "pruebas/postflop/comeciegas/prueba32";
    }

    @GetMapping(value="/prueba33")
    public String prueba33(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionSTCC simulacion= servicioFuncionalidadInforme.simulacionSTCC(formal);

        model.addAttribute("titulo", "Prueba 33 - SimulacionSTCC - Mesa 2 ");
        model.addAttribute("estadistica", ((EstadisticaA)((RondaE)simulacion.getPartida().getRonda()).getEstadistica()));
        return "pruebas/postflop/comeciegas/prueba33";
    }

    @GetMapping(value="/prueba34")
    public String prueba34(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionSTCC6 simulacion= servicioFuncionalidadInforme.simulacionSTCC6Informe(formal);

        model.addAttribute("titulo", "Prueba 34 - SimulacionSTCC6 - Mesa 6 - Informe ");
        model.addAttribute("informe", simulacion.getPartida().getInforme() );
        return "pruebas/postflop/comeciegas/prueba34";
    }

    @GetMapping(value="/prueba35")
    public String prueba35(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionSTCC6 simulacion= servicioFuncionalidadInforme.simulacionSTCC6(formal);

        model.addAttribute("titulo", "Prueba 35 - SimulacionSTCC - Mesa 6 ");
        model.addAttribute("estadistica", ((EstadisticaA)((RondaE)simulacion.getPartida().getRonda()).getEstadistica()));
        return "pruebas/postflop/comeciegas/prueba35";
    }

    @GetMapping(value="/prueba36")
    public String prueba36(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionSTCCS simulacion= servicioFuncionalidadInforme.simulacionSTCCSInforme(formal);

        model.addAttribute("titulo", "Prueba 36 - SimulacionSTCCS - Mesa 2 - Informe ");
        model.addAttribute("informe", simulacion.getPartida().getInforme() );
        return "pruebas/postflop/comeciegassupra/prueba36";
    }

    @GetMapping(value="/prueba37")
    public String prueba37(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionSTCCS simulacion= servicioFuncionalidadInforme.simulacionSTCCS(formal);

        model.addAttribute("titulo", "Prueba 37 - SimulacionSTCCS - Mesa 2 ");
        model.addAttribute("estadistica", ((EstadisticaA)((RondaE)simulacion.getPartida().getRonda()).getEstadistica()));
        return "pruebas/postflop/comeciegassupra/prueba37";
    }

    @GetMapping(value="/prueba38")
    public String prueba38(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionSTCCS6 simulacion= servicioFuncionalidadInforme.simulacionSTCCS6Informe(formal);

        model.addAttribute("titulo", "Prueba 38 - SimulacionSTCCS6 - Mesa 6 - Informe ");
        model.addAttribute("informe", simulacion.getPartida().getInforme() );
        return "pruebas/postflop/comeciegassupra/prueba38";
    }

    @GetMapping(value="/prueba39")
    public String prueba39(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionSTCCS6 simulacion= servicioFuncionalidadInforme.simulacionSTCCS6(formal);

        model.addAttribute("titulo", "Prueba 39 - SimulacionSTCCS6 - Mesa 6 ");
        model.addAttribute("estadistica", ((EstadisticaA)((RondaE)simulacion.getPartida().getRonda()).getEstadistica()));
        return "pruebas/postflop/comeciegassupra/prueba39";
    }

    @GetMapping(value="/prueba40")
    public String prueba40(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionSTCCSENG simulacion= servicioFuncionalidadInforme.simulacionSTCCSEN2GInforme(formal);

        model.addAttribute("titulo", "Prueba 40 - SimulacionSTCCSEN2 - Mesa 2 - Informe ");
        model.addAttribute("informe", simulacion.getPartida().getInforme() );
        return "pruebas/postflop/escalonado/prueba40";
    }

    @GetMapping(value="/prueba41")
    public String prueba41(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionSTCCSENG simulacion= servicioFuncionalidadInforme.simulacionSTCCSEN2G(formal);

        model.addAttribute("titulo", "Prueba 41 - SimulacionSTCCSEN2 - Mesa 2 ");
        model.addAttribute("estadistica", ((EstadisticaA)((RondaE)simulacion.getPartida().getRonda()).getEstadistica()));
        return "pruebas/postflop/escalonado/prueba41";
    }

    @GetMapping(value="/prueba42")
    public String prueba42(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionSTCCSENG6 simulacion= servicioFuncionalidadInforme.simulacionSTCCSEN2G6Informe(formal);

        model.addAttribute("titulo", "Prueba 42 - SimulacionSTCCSEN26 - Mesa 6 - Informe ");
        model.addAttribute("informe", simulacion.getPartida().getInforme() );
        return "pruebas/postflop/escalonado/prueba42";
    }

    @GetMapping(value="/prueba43")
    public String prueba43(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionSTCCSENG6 simulacion= servicioFuncionalidadInforme.simulacionSTCCSEN2G6(formal);

        model.addAttribute("titulo", "Prueba 43 - SimulacionSTCCSEN26 - Mesa 6 ");
        model.addAttribute("estadistica", ((EstadisticaA)((RondaE)simulacion.getPartida().getRonda()).getEstadistica()));
        return "pruebas/postflop/escalonado/prueba43";
    }

    @GetMapping(value="/prueba44")
    public String prueba44(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionSTCCSENM simulacion= servicioFuncionalidadInforme.simulacionSTCCSEN2MInforme(formal);

        model.addAttribute("titulo", "Prueba 44 - SimulacionSTCCSEN2M - Mesa 2 - Informe ");
        model.addAttribute("informe", simulacion.getPartida().getInforme() );
        return "pruebas/postflop/escalonado/prueba44";
    }

    @GetMapping(value="/prueba45")
    public String prueba45(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionSTCCSENM simulacion= servicioFuncionalidadInforme.simulacionSTCCSEN2M(formal);

        model.addAttribute("titulo", "Prueba 41 - SimulacionSTCCSEN2M - Mesa 2 ");
        model.addAttribute("estadistica", ((EstadisticaA)((RondaE)simulacion.getPartida().getRonda()).getEstadistica()));
        return "pruebas/postflop/escalonado/prueba45";
    }

    @GetMapping(value="/prueba46")
    public String prueba46(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionSTCCSENM6 simulacion= servicioFuncionalidadInforme.simulacionSTCCSEN2M6Informe(formal);

        model.addAttribute("titulo", "Prueba 46 - SimulacionSTCCSEN2M - Mesa 6 - Informe ");
        model.addAttribute("informe", simulacion.getPartida().getInforme() );
        return "pruebas/postflop/escalonado/prueba46";
    }

    @GetMapping(value="/prueba47")
    public String prueba47(ModelMap model){
        ArrayList<SegmentacionFormal> formal=servicioSegmentacionFormal.listaSegmentada();
        SimulacionSTCCSENM6 simulacion= servicioFuncionalidadInforme.simulacionSTCCSEN2M6(formal);

        model.addAttribute("titulo", "Prueba 47 - SimulacionSTCCSEN2M - Mesa 6 ");
        model.addAttribute("estadistica", ((EstadisticaA)((RondaE)simulacion.getPartida().getRonda()).getEstadistica()));
        return "pruebas/postflop/escalonado/prueba47";
    }
}

package com.poker.pokersimulate.controllers;

import com.poker.pokersimulate.models.data.PreFlopEData;
import com.poker.pokersimulate.models.entity.SegmentacionFormal;
import com.poker.pokersimulate.models.service.basedatos.ServicioSegmentacionFormal;
import com.poker.pokersimulate.models.service.informe.ServicioFuncionalidadInforme;
import com.poker.pokersimulate.modles.domains.basico.Carta;
import com.poker.pokersimulate.modles.domains.basico.Pareja;
import com.poker.pokersimulate.modles.domains.jerarquia.PreflopE;
import com.poker.pokersimulate.modles.domains.jerarquia.SimulacionJ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SegmentacionController {

    @Autowired
    private ServicioSegmentacionFormal servicioSegmentacionFormal;

    @Autowired
    private ServicioFuncionalidadInforme servicioFuncionalidadInforme;

    @GetMapping(value="listar01")
    public String listar01(Model model){
        model.addAttribute("titulo", "Cartas");
        model.addAttribute("segmentacion",servicioSegmentacionFormal.presentarLista());
        return "pruebas/basedatos/listar01";
    }


    @GetMapping(value="generardatos01")
    public String generarDatos(){
        SimulacionJ simulacionJ2=servicioFuncionalidadInforme.simulacionJ2General();
        servicioSegmentacionFormal.guardadatos(simulacionJ2.getPreFlop().getPreflopE169());
        return "redirect:listar01";
    }


    /*
    @GetMapping(value="segmentacion/listar")
    public String listar(Model model){
        model.addAttribute("titulo", "Cartas");
        model.addAttribute("segmentacion",segmentacion.findAll());
        return "segmentacionlistar";
    }

    @GetMapping(value="generardatos")
    public String generarDatos(){
        SimulacionJ simulacionJ2=servicioFuncionalidad.simulacionJ2General();

        ArrayList<PreflopE> preflopEs=simulacionJ2.getPreFlop().getPreflopE169();

        segmentacion.deleteAll();
        for(PreflopE preflopE:preflopEs){
            Segmentacion seg=new Segmentacion();
            seg.setCarta1(preflopE.getPareja().getCartas().get(0).mostrar());
            seg.setCarta2(preflopE.getPareja().getCartas().get(1).mostrar());
            seg.setPorcentaje(preflopE.getEstadistica().getGano());
            segmentacion.save(seg);
        }
        return "redirect:segmentacion/listar";
    }

    @GetMapping(value="generardatos02")
    public String generarDatosFormal(ModelMap model){
        SimulacionJ simulacionJ2=servicioFuncionalidad.simulacionJ2General();

        ArrayList<PreflopE> preflopEs=simulacionJ2.getPreFlop().getPreflopE169();

        segmentacionFormal.deleteAll();
        for(PreflopE preflopE:preflopEs){
            SegmentacionFormal seg=new SegmentacionFormal();
            seg.setNumero1(preflopE.getPareja().getCartas().get(0).getNumero());
            seg.setNumero2(preflopE.getPareja().getCartas().get(1).getNumero());
            seg.setPalo1((preflopE.getPareja().getCartas().get(0).getPalo()));
            seg.setPalo2((preflopE.getPareja().getCartas().get(1).getPalo()));
            seg.setPorcentaje(preflopE.getEstadistica().getGano());
            segmentacionFormal.save(seg);
        }
        model.addAttribute("titulo", "Cartas");
        return "index01";
    }

    @GetMapping(value="estadistica")
    public String generaEstadisticaSupra(ModelMap model){

        EstadisticaA estadistica2=servicioFuncionalidad.simulacionS2General((ArrayList<SegmentacionFormal>) segmentacionFormal.findAll());
        model.addAttribute("titulo", "Cartas");
        model.addAttribute("estadistica", estadistica2);
        return "estadistica";
    }

    @GetMapping(value="estadistica02")
    public String generaEstadisticaSupra2(ModelMap model){

        EstadisticaA estadistica2=servicioFuncionalidad.simulacionS2TGeneral((ArrayList<SegmentacionFormal>) segmentacionFormal.findAll());
        model.addAttribute("titulo", "Cartas");
        model.addAttribute("estadistica", estadistica2);
        return "estadistica";
    }

    @GetMapping(value="estadistica03")
    public String generaEstadisticaSupra3(ModelMap model){

        EstadisticaA estadistica2=servicioFuncionalidad.simulacionS2TCGeneral((ArrayList<SegmentacionFormal>) segmentacionFormal.findAll());
        model.addAttribute("titulo", "Cartas");
        model.addAttribute("estadistica", estadistica2);
        return "estadistica";
    }

    @GetMapping(value="estadistica04")
    public String generaEstadisticaSupra4(ModelMap model){

        EstadisticaA estadistica2=servicioFuncionalidad.simulacionS6General((ArrayList<SegmentacionFormal>) segmentacionFormal.findAll());
        model.addAttribute("titulo", "Cartas");
        model.addAttribute("estadistica", estadistica2);
        return "estadistica02";
    }

    @GetMapping(value="estadistica05")
    public String generaEstadisticaSupra5(ModelMap model){

        EstadisticaA estadistica2=servicioFuncionalidad.simulacionST6General((ArrayList<SegmentacionFormal>) segmentacionFormal.findAll());
        model.addAttribute("titulo", "Cartas");
        model.addAttribute("estadistica", estadistica2);
        return "estadistica02";
    }
    @GetMapping(value="estadistica06")
    public String generaEstadisticaSupra6(ModelMap model){

        EstadisticaA estadistica2=servicioFuncionalidad.simulacionSTC6General((ArrayList<SegmentacionFormal>) segmentacionFormal.findAll());
        model.addAttribute("titulo", "Cartas");
        model.addAttribute("estadistica", estadistica2);
        return "estadistica02";
    }

    @GetMapping(value="estadistica07")
    public String generaEstadisticaSupra7(ModelMap model){

        EstadisticaA estadistica2=servicioFuncionalidad.simulacionSTC2FGeneral((ArrayList<SegmentacionFormal>) segmentacionFormal.findAll());
        model.addAttribute("titulo", "Cartas");
        model.addAttribute("estadistica", estadistica2);
        return "estadistica02";
    }*/
}

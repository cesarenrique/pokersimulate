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

}

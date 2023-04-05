package com.poker.pokersimulate.models.service.basico;

import com.poker.pokersimulate.modles.domains.basico.*;
import org.springframework.stereotype.Component;

@Component
public class ServicioFuncionalidadBasico {

    public Baraja barajaSinBarajar(){
        Baraja baraja=new Baraja();
        baraja.generarBaraja();
        return baraja;
    }

    public Baraja barajaBarajada(){
        Baraja baraja=new Baraja();
        baraja.generarBaraja();
        baraja.barajar();
        return baraja;
    }


}

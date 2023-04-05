package com.poker.pokersimulate.modles.domains.jerarquia;

import com.poker.pokersimulate.modles.domains.basico.Baraja;
import com.poker.pokersimulate.modles.domains.basico.Carta;
import com.poker.pokersimulate.modles.domains.basico.Pareja;

import java.util.ArrayList;

public class Trucada2 extends Baraja {

    private Pareja pareja;

    public Trucada2() {
        super();
        setTipo(20);
    }

    @Override
    public void barajar(){
        super.barajar();
        trucar();
    }

    public Pareja getPareja() {
        return pareja;
    }

    public void setPareja(Pareja pareja) {
        this.pareja = pareja;
    }


    public void trucar(){
        ArrayList<Carta> cartas=getCartas();

        for(int j=0;j<pareja.getCartas().size();j++) {
            boolean encontrado=false;
            for (int i = 0; i < cartas.size() && !encontrado; i++) {
                if (pareja.getAt(j).getNumero().equals(cartas.get(i).getNumero())
                        && pareja.getAt(j).getPalo().equals(cartas.get(i).getPalo())) {
                    cartas.remove(cartas.get(i));
                    encontrado=true;
                }
            }
        }

        cartas.add(0,pareja.getAt(1));
        cartas.add(0,pareja.getAt(0));
        setCartas(cartas);
    }

}

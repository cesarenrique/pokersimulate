package com.poker.pokersimulate.modles.domains.jerarquia;

import com.poker.pokersimulate.modles.domains.basico.Carta;
import com.poker.pokersimulate.modles.domains.basico.Pareja;

import java.util.ArrayList;

public class SupraSegmentacion {

    private ArrayList<Pareja> supra;

    public SupraSegmentacion() {
        supra=new ArrayList<>();
    }

    public void generarSupra(){
        for(int i=2;i<=14;i++){
            for(int j=i;j<=14;j++){

                if(i!=j){
                    Carta c1 = new Carta(i, 1);
                    Carta c2 = new Carta(j, 1);

                    Pareja p1=new Pareja();
                    p1.anyadirCartas(c1);
                    p1.anyadirCartas(c2);
                    supra.add(p1);
                }
                Carta c3 = new Carta(i, 1);
                Carta c4 = new Carta(j, 2);

                Pareja p2=new Pareja();
                p2.anyadirCartas(c3);
                p2.anyadirCartas(c4);
                supra.add(p2);


            }
        }
    }


    public ArrayList<Pareja> getSupra() {
        return supra;
    }

    public void setSupra(ArrayList<Pareja> supra) {
        this.supra = supra;
    }
}

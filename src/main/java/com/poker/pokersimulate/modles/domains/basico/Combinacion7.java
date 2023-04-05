package com.poker.pokersimulate.modles.domains.basico;

import java.util.ArrayList;

public class Combinacion7 extends ListaCartas {
    public Combinacion7() {
        super();
        setTamanyo(7);
    }



    public ArrayList<Jerarquia5> combinacionMasAlta(){
        ArrayList<Carta> cartas=getCartas();
        ArrayList<ArrayList<Carta>> combinaciones= new ArrayList<>();
        for(int a=0;a<7;a++){
            for(int b=a+1;b<7;b++){
                for(int c=b+1;c<7;c++) {
                    for (int d = c + 1; d < 7; d++) {
                        for (int e= d + 1; e < 7; e++) {
                            ArrayList<Carta> nueva=new ArrayList<>();
                            nueva.add(cartas.get(a));
                            nueva.add(cartas.get(b));
                            nueva.add(cartas.get(c));
                            nueva.add(cartas.get(d));
                            nueva.add(cartas.get(e));
                            combinaciones.add(nueva);
                        }
                    }
                }
            }
        }

        ArrayList<Jerarquia5> jerarquias5=new ArrayList<>();

        for(ArrayList<Carta> aux: combinaciones){
            Jerarquia5 jerarquia5=new Jerarquia5();
            jerarquia5.setCartas(aux);
            jerarquia5.clasificarJerarquia();
            jerarquias5.add(jerarquia5);

        }


        int tam=jerarquias5.size();
        Jerarquia5 mejor=jerarquias5.get(0);
        for(int i=1;i<tam;i++){
            if(jerarquias5.get(i).masAltaQue(mejor)){
                mejor=jerarquias5.get(i);
            }
        }

        ArrayList<Integer> mejoresPosiciones=new ArrayList<>();

        for(int i=0;i<tam;i++){
            if(mejor.equals(jerarquias5.get(i))){
                mejoresPosiciones.add(i);
            }
        }

        ArrayList<Jerarquia5> mejores=new ArrayList<>();
        for(Integer mejorPosicion :mejoresPosiciones){
            mejores.add(jerarquias5.get(mejorPosicion));
        }

        return mejores;
    }


}

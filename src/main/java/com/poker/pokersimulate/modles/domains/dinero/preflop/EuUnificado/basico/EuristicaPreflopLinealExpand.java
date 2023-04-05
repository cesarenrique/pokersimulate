package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico;

import com.poker.pokersimulate.modles.domains.basico.Carta;
import com.poker.pokersimulate.modles.domains.basico.Pareja;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.EuristicaPreflopLineal;

import java.util.ArrayList;

public class EuristicaPreflopLinealExpand {
    private ArrayList<Pareja> expandido;
    private Integer profundidad;
    public EuristicaPreflopLinealExpand() {
        expandido=new ArrayList<>();
    }


    public ArrayList<Pareja> getExpandido() {
        return expandido;
    }

    public void setExpandido(ArrayList<Pareja> expandido) {
        this.expandido = expandido;
    }

    public Integer getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(Integer profundidad) {
        this.profundidad = profundidad;
    }

    public void expandir(EuristicaPreflopLineal lineal){

        ArrayList<Pareja> parejas=lineal.getParejas();
        Integer tope=lineal.getProfundidad();
        profundidad=0;
        int tam=parejas.size();
        for(int a=0;a<tam && a<tope;a++){
            Pareja pareja=parejas.get(a);
            if(pareja.getCartas().get(0).getNumero().equals(pareja.getCartas().get(1).getNumero())){
                for(int i=1;i<=4;i++){
                    for(int j=1;j<=4;j++){
                        if(i!=j){
                            Carta c1=new Carta(pareja.getCartas().get(0).getNumero(),i);
                            Carta c2=new Carta(pareja.getCartas().get(1).getNumero(),j);
                            Pareja p1=new Pareja();
                            p1.anyadirCartas(c1);
                            p1.anyadirCartas(c2);
                            expandido.add(p1);
                            profundidad++;
                        }
                    }
                }
            }else if(pareja.getCartas().get(0).getPalo().equals(pareja.getCartas().get(1).getPalo())){
                for(int j=1;j<=4;j++) {

                    Carta c1 = new Carta(pareja.getCartas().get(0).getNumero(), j);
                    Carta c2 = new Carta(pareja.getCartas().get(1).getNumero(), j);
                    Pareja p1 = new Pareja();
                    p1.anyadirCartas(c1);
                    p1.anyadirCartas(c2);
                    expandido.add(p1);
                    profundidad++;
                }
                for(int j=1;j<=4;j++) {

                    Carta c1 = new Carta(pareja.getCartas().get(1).getNumero(), j);
                    Carta c2 = new Carta(pareja.getCartas().get(0).getNumero(), j);
                    Pareja p1 = new Pareja();
                    p1.anyadirCartas(c1);
                    p1.anyadirCartas(c2);
                    expandido.add(p1);
                    profundidad++;
                }
            }else{
                for(int i=1;i<=4;i++){
                    for(int j=1;j<=4;j++){
                        if(i!=j){
                            Carta c1=new Carta(pareja.getCartas().get(0).getNumero(),i);
                            Carta c2=new Carta(pareja.getCartas().get(1).getNumero(),j);
                            Pareja p1=new Pareja();
                            p1.anyadirCartas(c1);
                            p1.anyadirCartas(c2);
                            expandido.add(p1);
                            profundidad++;
                        }
                    }
                }
                for(int i=1;i<=4;i++){
                    for(int j=1;j<=4;j++){
                        if(i!=j){
                            Carta c1=new Carta(pareja.getCartas().get(1).getNumero(),i);
                            Carta c2=new Carta(pareja.getCartas().get(0).getNumero(),j);
                            Pareja p1=new Pareja();
                            p1.anyadirCartas(c1);
                            p1.anyadirCartas(c2);
                            expandido.add(p1);
                            profundidad++;
                        }
                    }
                }
            }
        }
    }

    public boolean dentroEuristica(Pareja actual){
        int tam=expandido.size();
        boolean encontrado=false;
        int i=0;
        while(i<tam && !encontrado){
            if(actual.equals(expandido.get(i))){
                encontrado=true;
            }
            i++;
        }

        return encontrado;
    }
}

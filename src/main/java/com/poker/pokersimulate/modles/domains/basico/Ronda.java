package com.poker.pokersimulate.modles.domains.basico;

import com.poker.pokersimulate.modles.domains.jerarquia.PosJerarquia5;

import java.util.ArrayList;

public class Ronda {

    private Mesa mesa;
    private Baraja baraja;
    private Comunitarias comunitarias;
    private ArrayList<Ranking> rankings;
    private Integer tipo;
    private ArrayList<ArrayList<Integer>> igualadas;

    public Ronda() {
        this.mesa = null;
        comunitarias=new Comunitarias();
        rankings=new ArrayList<>();
        tipo=10;
        igualadas=new ArrayList<>();
    }



    public Baraja getBaraja() {
        return baraja;
    }

    public void setBaraja(Baraja baraja) {
        this.baraja = baraja;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Comunitarias getComunitarias() {
        return comunitarias;
    }

    public void setComunitarias(Comunitarias comunitarias) {
        this.comunitarias = comunitarias;
    }

    public ArrayList<Ranking> getRankings() {
        return rankings;
    }

    public void setRankings(ArrayList<Ranking> rankings) {
        this.rankings = rankings;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public ArrayList<ArrayList<Integer>> getIgualadas() {
        return igualadas;
    }

    public void setIgualadas(ArrayList<ArrayList<Integer>> igualadas) {
        this.igualadas = igualadas;
    }

    public void barajar()  {
        baraja.barajar();
    }

    public void repartirCartasJugadores(){
        comunitarias.borrarCartas();
        ArrayList<Asiento> asientos=mesa.getAsientos();
        barajar();
        Integer posicion=0;
        for ( Asiento asiento : asientos) {
            Pareja p=asiento.getPareja();
            p.borrarCartas();
            p.anyadirCartas(baraja.repartir());
            p.anyadirCartas(baraja.repartir());
            asiento.setPareja(p);
            posicion++;
            asiento.getJugador().setPosicion(posicion);
        }
    }

    public void repartirComunitarias(){
        comunitarias.borrarCartas();
        for(int i=0;i<5;i++){
            comunitarias.anyadirCartas(baraja.repartir());
        }
    }

    public void evaluarJugadores(){
        for (Asiento asiento : mesa.getAsientos()) {
            asiento.setComunitarias(comunitarias);
            asiento.generarRango();
        }
    }

    public void compararJerarquiasCrearUnficacion(ArrayList<Integer> igualo) {
        ArrayList<PosJerarquia5> unificar = new ArrayList<>();

        Integer pos = 0;
        for (Asiento asiento : mesa.getAsientos()) {
            if(igualo.contains(asiento.getPosicion())) {
                PosJerarquia5 posJerarquia5 = new PosJerarquia5();
                posJerarquia5.setJerarquia5(asiento.getRango().get(0));
                posJerarquia5.setPosicion(pos);
                unificar.add(posJerarquia5);

            }
            pos++;
        }
        compararJerarquias(unificar);
    }

    public void compararJerarquias(ArrayList<PosJerarquia5> unificar){
        int tam=unificar.size();

        for(int i=0;i<tam;i++){
            for(int j=i+1;j<tam;j++) {
                if (!unificar.get(i).getJerarquia5().masAltaQue(unificar.get(j).getJerarquia5())) {
                     PosJerarquia5 aux= unificar.get(i);
                     PosJerarquia5 aux2=unificar.get(j);
                     unificar.set(i,aux2);
                     unificar.set(j,aux);
                }
            }
        }

        ArrayList<ArrayList<Integer> > mejoresPosiciones=new ArrayList<>();

        ArrayList<Integer> recolectar=new ArrayList<>();
        if(tam==1){
            for (PosJerarquia5 aux: unificar) {
                recolectar.add(aux.getPosicion());
            }
            mejoresPosiciones.add(recolectar);
        }else if(tam==2){
            recolectar.add(unificar.get(0).getPosicion());
            if (unificar.get(0).getJerarquia5().equals(unificar.get(1).getJerarquia5())) {
                recolectar.add(unificar.get(1).getPosicion());
                mejoresPosiciones.add(recolectar);
            }else{
                mejoresPosiciones.add(recolectar);
                recolectar=new ArrayList<>();
                recolectar.add(unificar.get(1).getPosicion());
                mejoresPosiciones.add(recolectar);
            }
        }else {
            for (int i = 0; i < tam ; i++) {
                if (i == 0) {
                    recolectar.add(unificar.get(0).getPosicion());
                } else {
                    if (unificar.get(i-1).getJerarquia5().equals(unificar.get(i).getJerarquia5())) {
                        recolectar.add(unificar.get(i).getPosicion());
                        if (i == tam - 1) mejoresPosiciones.add(recolectar);
                    } else {
                        mejoresPosiciones.add(recolectar);
                        recolectar = new ArrayList<>();
                    }
                }
            }
        }
        crearRanking( mejoresPosiciones);
    }

    public void crearRanking(ArrayList<ArrayList<Integer> > rank){
        Ranking ranking=new Ranking();
        for(ArrayList<Integer> posiciones:rank) {
            PosRanking posRanking=new PosRanking();
            for (Asiento asiento : mesa.getAsientos()) {
                if (posiciones.contains(asiento.getPosicion())) {
                    Ganador ganador = new Ganador();
                    ganador.setPosicion(asiento.getPosicion());
                    ganador.setJerarquia5(asiento.getRango().get(0));
                    ganador.setJugador(asiento.getJugador());
                    posRanking.getGanadores().add(ganador);

                }
            }
            ranking.getPosRankings().add(posRanking);
        }
        rankings.add(ranking);
    }

    public void generarGanadores(){
        rankings.clear();
        for(ArrayList<Integer> igualo:igualadas){
            compararJerarquiasCrearUnficacion(igualo);
        }
    }



    public void clear(){
        comunitarias.borrarCartas();
        for (Asiento asiento : mesa.getAsientos()) {
            if(asiento.getPareja()!=null) asiento.clear();
        }
    }
}

package com.poker.pokersimulate.modles.domains.dinero.basico;

import com.poker.pokersimulate.modles.domains.basico.Asiento;
import com.poker.pokersimulate.modles.domains.basico.Ganador;
import com.poker.pokersimulate.modles.domains.basico.Ranking;
import com.poker.pokersimulate.modles.domains.estadistica.RondaE;

import java.util.ArrayList;

public class RondaEConDinero extends RondaE {

    private ArrayList<Integer> botePrincipal;
    private ArrayList<Integer> apuestas;
    private ArrayList<Integer> sigue;

    public RondaEConDinero() {
        super();
        botePrincipal=new ArrayList<>();
        apuestas=new ArrayList<>();
        sigue=new ArrayList<>();
        setTipo(30);
    }


    public ArrayList<Integer> getBotePrincipal() {
        return botePrincipal;
    }

    public void setBotePrincipal(ArrayList<Integer> botePrincipal) {
        this.botePrincipal = botePrincipal;
    }

    public ArrayList<Integer> getApuestas() {
        return apuestas;
    }

    public void setApuestas(ArrayList<Integer> apuestas) {
        this.apuestas = apuestas;
    }

    public ArrayList<Integer> getSigue() {
        return sigue;
    }

    public void setSigue(ArrayList<Integer> sigue) {
        this.sigue = sigue;
    }



    public void apuestaPreFlop(Integer posicion, Integer apuesta){

        Integer previo=apuestas.get(posicion);
        apuestas.set(posicion,apuesta+previo);
        ((AsientoConFichas)getMesa().getAsientos().get(posicion)).setFichas(0);

    }

    public void limpiarMesa(){
        limpiarApuestas();
        limpiarBote();
    }

    public void limpiarSigue(){
        sigue.clear();
        int tam = getMesa().getTamanyo();
        for (int i = 0; i < tam; i++) {
            sigue.add(0);
        }
    }


    public void limpiarApuestas() {
        apuestas.clear();
        int tam = getMesa().getTamanyo();
        for (int i = 0; i < tam; i++) {
            apuestas.add(0);
        }
    }
    public void limpiarBote(){
        botePrincipal.clear();
    }

    public void compraFichas(Integer posicion,Integer fichas,Integer dinero){

        ((AsientoConFichas)getMesa().getAsientos().get(posicion)).setFichas(fichas);
        Integer saldoActual= ((JugadorNormal)getMesa().getAsientos().get(posicion).getJugador()).getSaldo();
        saldoActual-=dinero;
        ((JugadorNormal)getMesa().getAsientos().get(posicion).getJugador()).setSaldo(saldoActual);

    }

    public void repartirRecompensa(){
        boolean fallo=false;
        int aux=botePrincipal.size()-1;
        int anterior=-1;
        ArrayList<Ranking> rank=(ArrayList<Ranking>) getRankings().clone();
        while(!botePrincipal.isEmpty() && !fallo){
            rank=repartirRecompensaBote(rank);
            if(aux==anterior){
                fallo=true;
            }
            anterior=aux;
            aux=botePrincipal.size()-1;
        }

    }

    public ArrayList<Ranking> repartirRecompensaBote(ArrayList<Ranking> rank){

        if(rank.size()>0 && rank.get(0).getPosRankings().size()>0) {

            if (rank.get(0).getPosRankings().get(0).getGanadores().size() > 1) {
                int recompensa = botePrincipal.get(0) / rank.get(0).getPosRankings().get(0).getGanadores().size();
                ArrayList<Asiento> asientos = getMesa().getAsientos();
                for (Asiento asiento : asientos) {
                    for(Ganador ganador:rank.get(0).getPosRankings().get(0).getGanadores()) {
                        if (ganador.getPosicion().equals(asiento.getPosicion())) {
                            Integer fichasActual = ((AsientoConFichas) asiento).getFichas();
                            fichasActual += recompensa;
                            ((AsientoConFichas) asiento).setFichas(fichasActual);
                        }
                    }
                }
                botePrincipal.remove(botePrincipal.get(0));
                rank.remove(rank.get(0));
            } else if (rank.get(0).getPosRankings().get(0).getGanadores().size() == 1) {
                int fichasActual = ((AsientoConFichas) getMesa().getAsientos().get(rank.get(0).getPosRankings().get(0).getGanadores().get(0).getPosicion())).getFichas();
                fichasActual += botePrincipal.get(0);
                ((AsientoConFichas) getMesa().getAsientos().get(rank.get(0).getPosRankings().get(0).getGanadores().get(0).getPosicion())).setFichas(fichasActual);
                botePrincipal.remove(botePrincipal.get(0));
                rank.remove(rank.get(0));
            }

        }
        return rank;
    }

    public void simplificarBote() {
        ArrayList<Integer> seguir=simplificarBotePre();
        simplificarBoteEjecucion(seguir);
    }

    public ArrayList<Integer> simplificarBotePre(){
        ArrayList<Integer> seguir=(ArrayList<Integer>) sigue.clone();
        getIgualadas().clear();
        return seguir;
    }

    public void simplificarBoteCasoNumJug1(ArrayList<Integer> seguir){
        ArrayList<Integer> igualar=new ArrayList<>();
        Integer bote = 0;
        for (int j = 0; j < apuestas.size(); j++) {
            bote += apuestas.get(j);
            if(seguir.get(j)==1){
                igualar.add(j);
            }
        }
        botePrincipal.add(bote);
        getIgualadas().add(igualar);
    }

    public void simplificarBoteCasoNumJug2(ArrayList<Integer> seguir){
        ArrayList<Integer> igualar=new ArrayList<>();
        Integer menor = 1000000000;

        for (int j = 0; j < apuestas.size(); j++) {
            if (menor > apuestas.get(j) && seguir.get(j) == 1) {
                menor = apuestas.get(j);
            }
        }

        int diferencia=0;
        int bote = 0;
        int pos=-1;

        for (int j = 0; j < apuestas.size(); j++) {
            if(seguir.get(j)==1){
                igualar.add(j);
            }
            if(seguir.get(j)==1 && apuestas.get(j)>menor){
                bote += menor;
                pos=j;
                diferencia= apuestas.get(j)-menor;
                apuestas.set(j,apuestas.get(j)-menor);
            }else if(seguir.get(j)==1 && apuestas.get(j).equals(menor)){
                bote+= menor;
                apuestas.set(j,0);

            }

        }
        botePrincipal.add(bote);
        if(pos!=-1) devolver(pos, diferencia);
        getIgualadas().add(igualar);
    }


    public void simplificarBoteCasoNumJugMuchos(ArrayList<Integer> seguir){
        int cont2=0;
        for(Integer num:seguir){
            if(num==1) cont2++;
        }
        while(cont2!=0) {
            ArrayList<Integer> igualar = new ArrayList<>();
            Integer menor = 1000000000;

            for (int j = 0; j < apuestas.size(); j++) {
                if (menor > apuestas.get(j) && seguir.get(j) == 1) {
                    menor = apuestas.get(j);
                }
            }
            if (menor != 1000000000 && cont2>1) {
                int bote = 0;

                for (int j = 0; j < apuestas.size(); j++) {
                    if (seguir.get(j) == 1) {
                        igualar.add(j);
                    }
                    if (seguir.get(j) == 1 && apuestas.get(j) > menor) {
                        bote += menor;
                        apuestas.set(j, apuestas.get(j) - menor);
                    } else if (seguir.get(j) == 1 && apuestas.get(j).equals(menor)) {
                        bote += menor;
                        apuestas.set(j, 0);
                        seguir.set(j, 0);
                    } else {
                        bote += apuestas.get(j);
                        apuestas.set(j, 0);
                    }
                }
                cont2 = 0;
                int pos = 0;
                int i = 0;
                for (Integer num : seguir) {
                    if (num == 1) {
                        cont2++;
                        pos = i;
                    }
                    i++;
                }
                botePrincipal.add(bote);
                getIgualadas().add(igualar);
                if (cont2 == 1) {
                    devolver(pos, apuestas.get(pos));
                }

            }else{
                cont2=0;
            }

        }

    }

    public void simplificarBoteEjecucion(ArrayList<Integer> seguir) {

        int cont = 0;
        for (Integer num : seguir) {
            if (num == 1) cont++;
        }
        if (cont == 1) {
            simplificarBoteCasoNumJug1(seguir);
        } else if (cont == 2) {
            simplificarBoteCasoNumJug2(seguir);
        } else if (cont > 2) {
            simplificarBoteCasoNumJugMuchos(seguir);
        }
        limpiarApuestas();
    }

    public void devolver(Integer posicion, Integer diferencia){

        Integer tope=((AsientoConFichas)getMesa().getAsientos().get(posicion)).getFichas();
        tope+=diferencia;
        ((AsientoConFichas)getMesa().getAsientos().get(posicion)).setFichas(tope);

    }

    public Integer intencionSeguir(){
        Integer seguir=0;
        for(Integer ap:sigue){
            if(ap>0) {
                seguir++;
            }
        }
        return seguir;
    }

    public Integer intencionSeguirQuien() {
        int quien = -1;
        int tam = sigue.size();
        for (int i = 0; i < tam; i++) {
            if (sigue.get(i) > 0) quien = i;
        }
        return quien;
    }

    @Override
    public void clear() {
        super.clear();
        limpiarMesa();
        limpiarSigue();
    }
}

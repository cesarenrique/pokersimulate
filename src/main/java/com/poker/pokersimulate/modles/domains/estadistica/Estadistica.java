package com.poker.pokersimulate.modles.domains.estadistica;

import java.util.ArrayList;

public class Estadistica {
    private ArrayList<Integer> ganados;
    private Integer total;
    private Float porcentaje;
    private String gano;
    public Estadistica() {
        ganados=new ArrayList<>();
        total=0;
    }

    public String getGano() {
        return gano;
    }

    public void setGano(String gano) {
        this.gano = gano;
    }


    public ArrayList<Integer> getGanados() {
        return ganados;
    }

    public void setGanados(ArrayList<Integer> ganados) {
        this.ganados = ganados;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void ganoMasUno(Integer pos){
        Integer aux=ganados.get(pos);
        aux++;
        ganados.set(pos,aux);
    }

    public void totalMasUno(){
        total++;
    }


    public void generarPorcentaje(){
        float aux=ganados.get(0);
        float totalF=total;
        porcentaje=aux/totalF;
        gano=porcentaje.toString();

    }

    public Float getPorcentaje() {

        return porcentaje;
    }

    public void setPorcentaje(Float porcentaje) {
        this.porcentaje = porcentaje;
    }


}

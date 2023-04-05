package com.poker.pokersimulate.modles.domains.basico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Jerarquia5 {
    private ArrayList<Carta> cartas;
    private ArrayList<Integer> jerarquia5;
    private final Integer[] numeros =new Integer[15];

    public Jerarquia5() {
        jerarquia5=new ArrayList<>();
    }

    public Jerarquia5(Jerarquia5 otro) {
        this.jerarquia5=new ArrayList<>();
        this.jerarquia5.addAll(otro.jerarquia5);

        cartas=new ArrayList<>();
        for(Carta carta:otro.cartas){
            Carta nueva=new Carta(carta);
            cartas.add(nueva);
        }
        System.arraycopy(otro.numeros, 0, this.numeros, 0, 15);
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public ArrayList<Integer> getJerarquia5() {
        return jerarquia5;
    }

    public void setJerarquia5(ArrayList<Integer> jerarquia5) {
        this.jerarquia5 = jerarquia5;
    }

    public void limpiarNumeros(){
        for(int i=0;i<15;i++){
            numeros[i]=0;
        }
    }

    public void meterNumeros(){
        for(Carta carta:cartas){
            numeros[carta.getNumero()]++;
        }
    }

    public Boolean escalera(){
        int contador=0;
        boolean esEscalera=Boolean.FALSE;
        for(int i=0;i<15 && esEscalera==Boolean.FALSE ;i++){
            if(numeros[i]==1){
                contador++;
            }else{
                contador=0;
            }
            if(contador==5) esEscalera=Boolean.TRUE;
        }

        return esEscalera;
    }

    public Boolean color(){
        return (cartas.get(0).getPalo().equals(cartas.get(1).getPalo()) &&
                cartas.get(1).getPalo().equals(cartas.get(2).getPalo()) &&
                cartas.get(2).getPalo().equals(cartas.get(3).getPalo()) &&
                cartas.get(3).getPalo().equals(cartas.get(4).getPalo()) );
    }

    public Integer numeroMasAlto(){
        boolean encontrado=false;
        int masAlto=0;
        for(int i=14;i>=0 && !encontrado;i--){
            if(numeros[i]!=0) {
                masAlto=i;
                encontrado=true;
            }
        }
        return masAlto;
    }


    public Integer repeticiones(Integer tipo){
        boolean encontrado=false;
        int buscado=0;
        for(int i=14;i>=0 && !encontrado;i--){
            if(numeros[i].equals(tipo)) {
                buscado=i;
                encontrado=true;
            }
        }
        return buscado;
    }

    public Integer repeticionesAlt(Integer tipo,int posicion){
        boolean encontrado=false;
        int buscado=0;
        int contador=1;
        for(int i=14;i>=0 && !encontrado;i--){
            if(numeros[i].equals(tipo)) {

                if(posicion==contador ) {
                    encontrado = true;
                    buscado=i;
                }

                contador++;

            }
        }
        return buscado;
    }

    public void clasificarJerarquia() {
        jerarquia5.clear();
        limpiarNumeros();
        meterNumeros();
        Boolean bescalera = escalera();
        Boolean bColor = color();
        Integer masAlto = numeroMasAlto();
        Integer repeticion4 = repeticiones(4);
        Integer repeticion3 = repeticiones(3);
        Integer repeticion2 = repeticiones(2);
        Integer repeticion2Alt = repeticionesAlt(2, 2);
        Integer repeticion1 = repeticiones(1);
        Integer repeticion1Alt2 = repeticionesAlt(1, 2);
        Integer repeticion1Alt3 = repeticionesAlt(1, 3);
        Integer repeticion1Alt4 = repeticionesAlt(1, 4);
        Integer repeticion1Alt5 = repeticionesAlt(1, 5);
        if (bescalera && bColor) {
            //Escalera de  color
            jerarquia5.add(9);
            jerarquia5.add(masAlto);
            for (int i = 0; i < 4; i++) {
                jerarquia5.add(0);
            }
        } else if (repeticion4 != 0) {
            // poker
            jerarquia5.add(8);
            jerarquia5.add(repeticion4);
            jerarquia5.add(repeticion1);
            for (int i = 0; i < 3; i++) {
                jerarquia5.add(0);
            }
        } else if (repeticion3 != 0 && repeticion2 != 0) {
            //full house
            jerarquia5.add(7);
            jerarquia5.add(repeticion3);
            jerarquia5.add(repeticion2);
            for (int i = 0; i < 3; i++) {
                jerarquia5.add(0);
            }
        } else if (bColor) {
            jerarquia5.add(6);
            jerarquia5.add(repeticion1);
            jerarquia5.add(repeticion1Alt2);
            jerarquia5.add(repeticion1Alt3);
            jerarquia5.add(repeticion1Alt4);
            jerarquia5.add(repeticion1Alt5);
        } else if (bescalera) {
            jerarquia5.add(5);
            jerarquia5.add(masAlto);
            for (int i = 0; i < 4; i++) {
                jerarquia5.add(0);
            }
        } else if (repeticion3 != 0) {
            //trio
            jerarquia5.add(4);
            jerarquia5.add(repeticion3);
            jerarquia5.add(repeticion1);
            jerarquia5.add(repeticion1Alt2);
            jerarquia5.add(0);
            jerarquia5.add(0);

        } else if (repeticion2Alt != 0) {
            //doble pareja
            jerarquia5.add(3);
            jerarquia5.add(repeticion2);
            jerarquia5.add(repeticion2Alt);
            jerarquia5.add(repeticion1);
            jerarquia5.add(0);
            jerarquia5.add(0);
        }else if(repeticion2!=0){
            //pareja
            jerarquia5.add(2);
            jerarquia5.add(repeticion2);
            jerarquia5.add(repeticion1);
            jerarquia5.add(repeticion1Alt2);
            jerarquia5.add(repeticion1Alt3);
            jerarquia5.add(0);

        }else{
            // no se ligo
            jerarquia5.add(1);
            jerarquia5.add(repeticion1);
            jerarquia5.add(repeticion1Alt2);
            jerarquia5.add(repeticion1Alt3);
            jerarquia5.add(repeticion1Alt4);
            jerarquia5.add(repeticion1Alt5);
        }
    }
    public String nivelNumeros(){
        StringBuilder sb=new StringBuilder();

        for(Integer num: jerarquia5){
            sb.append(num);
            sb.append(" ");
        }
        return sb.toString();
    }

    public String mostrarFrase(){
        StringBuilder sb=new StringBuilder();
        ArrayList<Carta> jerarquia5Alt=new ArrayList<>();
        for(Integer num: jerarquia5){
            Carta c=new Carta(num,1);
            jerarquia5Alt.add(c);
        }
        if(jerarquia5.get(0)==9){
            sb.append("Escalera de color al ");
            sb.append(jerarquia5Alt.get(1).getNumeroLetra());
        }else if(jerarquia5.get(0)==8){
            sb.append("Poker al ");
            sb.append(jerarquia5Alt.get(1).getNumeroLetra());
            sb.append(" acompañado de ");
            sb.append(jerarquia5Alt.get(2).getNumeroLetra());
        }else if(jerarquia5.get(0)==7){
            sb.append("Full al ");
            sb.append(jerarquia5Alt.get(1).getNumeroLetra());
            sb.append(" acompañado de ");
            sb.append(jerarquia5Alt.get(2).getNumeroLetra());
        }else if(jerarquia5.get(0)==6){
            sb.append("Color con siguiente combinacion ");
            sb.append(jerarquia5Alt.get(1).getNumeroLetra());
            sb.append(" ");
            sb.append(jerarquia5Alt.get(2).getNumeroLetra());
            sb.append(" ");
            sb.append(jerarquia5Alt.get(3).getNumeroLetra());
            sb.append(" ");
            sb.append(jerarquia5Alt.get(4).getNumeroLetra());
            sb.append(" ");
            sb.append(jerarquia5Alt.get(5).getNumeroLetra());
        }else if(jerarquia5.get(0)==5) {
            sb.append("Escalera al ");
            sb.append(jerarquia5Alt.get(1).getNumeroLetra());
        }else if(jerarquia5.get(0)==4){
            sb.append("Trio al ");
            sb.append(jerarquia5Alt.get(1).getNumeroLetra());
            sb.append(" acompañado de ");
            sb.append(jerarquia5Alt.get(2).getNumeroLetra());
            sb.append(" ");
            sb.append(jerarquia5Alt.get(3).getNumeroLetra());
        }else if(jerarquia5.get(0)==3) {
            sb.append("Doble Pareja al ");
            sb.append(jerarquia5Alt.get(1).getNumeroLetra());
            sb.append(" y segunda pareja al ");
            sb.append(jerarquia5Alt.get(2).getNumeroLetra());
            sb.append(" acompañado con la combinación ");
            sb.append(jerarquia5Alt.get(3).getNumeroLetra());
        }else if(jerarquia5.get(0)==2) {
            sb.append("Pareja al ");
            sb.append(jerarquia5Alt.get(1).getNumeroLetra());
            sb.append(" acompañado con la combinación ");
            sb.append(jerarquia5Alt.get(2).getNumeroLetra());
            sb.append(" ");
            sb.append(jerarquia5Alt.get(3).getNumeroLetra());
            sb.append(" ");
            sb.append(jerarquia5Alt.get(4).getNumeroLetra());
        }else{
            sb.append("Carta mas alta con la siguiente combinacion ");
            sb.append(jerarquia5Alt.get(1).getNumeroLetra());
            sb.append(" ");
            sb.append(jerarquia5Alt.get(2).getNumeroLetra());
            sb.append(" ");
            sb.append(jerarquia5Alt.get(3).getNumeroLetra());
            sb.append(" ");
            sb.append(jerarquia5Alt.get(4).getNumeroLetra());
            sb.append(" ");
            sb.append(jerarquia5Alt.get(5).getNumeroLetra());
        }


        return sb.toString();
    }

    public boolean masAltaQue(Jerarquia5 jerarquia5Alt){

        boolean noEsIgual=false;
        int pos=-1;
        for(int i=0;i<6 && !noEsIgual;i++){
            if(!jerarquia5.get(i).equals(jerarquia5Alt.getJerarquia5().get(i))){
                noEsIgual=true;
                pos=i;
            }
        }
        boolean esMasAlta=true;
        if(noEsIgual){
            if(jerarquia5.get(pos)<jerarquia5Alt.getJerarquia5().get(pos)){
                esMasAlta=false;
            }
        }

        return esMasAlta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jerarquia5 that = (Jerarquia5) o;

        if(jerarquia5.size()!=that.jerarquia5.size() && jerarquia5.size()!=6) return false;
        boolean igual=true;
        int i=0;
        while(i<6 && igual){
            if(!jerarquia5.get(i).equals(that.jerarquia5.get(i))){
                igual=false;
            }
            i++;
        }
        return igual;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(cartas, jerarquia5);
        result = 31 * result + Arrays.hashCode(numeros);
        return result;
    }


    public String mostrar(){
        StringBuilder sb=new StringBuilder();
        for(Integer num:jerarquia5){
            sb.append((new Carta(num,1)).getNumeroLetra());
            sb.append(" ");
        }
        return sb.toString();
    }
}

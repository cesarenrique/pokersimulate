package com.poker.pokersimulate.modles.domains.basico;

import java.util.ArrayList;
import java.util.Objects;

public class ListaCartas {

	private ArrayList<Carta> cartas;
    private Integer tamanyo;
	private Integer tipo;
	public ListaCartas() {
		
		// TODO Auto-generated constructor stub
		
		cartas=new ArrayList<>();
		tamanyo=2;
		tipo=0;
	}



	public void anyadirCartas(Carta c) {
		if(cartas.size()<tamanyo) {
			cartas.add(c);
		}
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public void borrarCartas() {
		cartas.clear();
	}

	public Integer getTamanyo() {
		return tamanyo;
	}

	public void setTamanyo(Integer tamanyo) {
		this.tamanyo = tamanyo;
	}

	public ArrayList<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}

	public Carta getAt(Integer pos){
		return cartas.get(pos);
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ListaCartas that = (ListaCartas) o;
		if(cartas.size()!=that.cartas.size()) return false;
		boolean igual=true;
		int tam=cartas.size();
		int i=0;
		while(i<tam && igual){
			if(!cartas.get(i).equals(that.cartas.get(i))){
				igual=false;
			}
			i++;
		}
		return igual;
	}


	public String mostrar(){
		StringBuilder sb=new StringBuilder();
		for(Carta carta:cartas){
			sb.append(carta.mostrar());
			sb.append(" ");
		}
		return sb.toString();
	}
}

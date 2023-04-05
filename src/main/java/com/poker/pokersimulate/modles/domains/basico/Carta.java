package com.poker.pokersimulate.modles.domains.basico;

import java.util.Objects;

public class Carta {

	private Integer numero;
	private Integer palo;
	public Carta() {
		
	}

	public Carta(Carta otro) {
		this.numero = otro.numero;
		this.palo = otro.palo;
	}
	
	public Carta(Integer numero, Integer palo) {
		this.numero = numero;
		this.palo = palo;
	}

	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Integer getPalo() {
		return palo;
	}
	public void setPalo(Integer palo) {
		this.palo = palo;
	}
	public String getNumeroLetra(){
		char c='0';
		if(numero<10){
			c=(char)('0'+numero);
		}else if(numero==10){
			c='T';
		}else if(numero==11){
			c='J';
		}else if(numero==12){
			c='Q';
		}else if(numero==13){
			c='K';
		}else if(numero==14){
			c='A';
		}
		String s="";
		s+=c;
		return s;
	}

	public String getPaloLetra(){
		char c='0';
		if(palo==1){
			c='C';
		}else if(palo==2){
			c='T';
		}else if(palo==3){
			c='P';
		}else if(palo==4){
			c='D';
		}
		String s="";
		s+=c;
		return s;
	}

	public String mostrar(){
		return getNumeroLetra()+getPaloLetra();
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Carta carta = (Carta) o;
		return (numero.equals(carta.numero) && palo.equals(carta.palo));
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero, palo);
	}
}

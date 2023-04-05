package com.poker.pokersimulate.modles.domains.basico;

import java.util.ArrayList;

public class Baraja extends ListaCartas {

	private Integer posicion;

	public Baraja() {
		super();
		// TODO Auto-generated constructor stub
		setTamanyo(52);
		posicion=0;
		setTipo(10);
	}



	public void generarBaraja() {
		borrarCartas();
		for(int i=2;i<=14;i++) {
			for(int j=1;j<=4;j++) {
				Carta c=new Carta(i,j);
				anyadirCartas(c);
			}
		}
		posicion=0;
	}

	public void barajar(){
		ArrayList<Carta> nuevo= getCartas();
		ArrayList<Carta> futuro=new ArrayList<>();

		while(!nuevo.isEmpty()){
			int cambio=(int)Math.floor(Math.random()* nuevo.size());

			futuro.add(nuevo.get(cambio));
			nuevo.remove(nuevo.get(cambio));

		}
		setCartas(futuro);
		posicion=0;
	}

	public Integer getPosicion() {
		return posicion;
	}

	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}

	public Carta repartir(){
		Carta c=getAt(posicion);
		posicion++;
		return c;
	}

}

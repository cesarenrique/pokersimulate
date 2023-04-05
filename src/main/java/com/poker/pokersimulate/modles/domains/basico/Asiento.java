package com.poker.pokersimulate.modles.domains.basico;

import java.util.ArrayList;

public class Asiento {

	private Jugador jugador;
	private Pareja pareja;
	private Integer posicion;
	private Comunitarias comunitarias;
	private Combinacion7 combinacion7;
	private ArrayList<Jerarquia5> rango;
	public Asiento() {
		comunitarias=new Comunitarias();
		combinacion7=new Combinacion7();
		rango=new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Pareja getPareja() {
		return pareja;
	}

	public void setPareja(Pareja pareja) {
		this.pareja = pareja;
	}

	public Comunitarias getComunitarias() {
		return comunitarias;
	}

	public void setComunitarias(Comunitarias comunitarias) {
		this.comunitarias = comunitarias;
	}

	public Combinacion7 getCombinacion7() {
		return combinacion7;
	}

	public void setCombinacion7(Combinacion7 combinacion7) {
		this.combinacion7 = combinacion7;
	}

	public ArrayList<Jerarquia5> getRango() {
		return rango;
	}

	public void setRango(ArrayList<Jerarquia5> rango) {
		this.rango = rango;
	}

	public Integer getPosicion() {
		return posicion;
	}

	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}

	public ArrayList<Jerarquia5> clasificacion() {
		ArrayList<Carta> mano=new ArrayList<>();
		mano.addAll(pareja.getCartas());
		mano.addAll(comunitarias.getCartas());
		combinacion7.setCartas(mano);
		return combinacion7.combinacionMasAlta();
	}

	public void generarRango(){
		rango=clasificacion();
	}



	public void clear(){
		pareja.borrarCartas();
		comunitarias.borrarCartas();
		combinacion7.borrarCartas();
		rango.clear();
	}
}

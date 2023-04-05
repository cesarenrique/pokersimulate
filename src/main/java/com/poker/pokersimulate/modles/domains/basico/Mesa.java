package com.poker.pokersimulate.modles.domains.basico;

import java.util.ArrayList;

public class Mesa {
	
	private ArrayList<Asiento> asientos;
	private Integer tamanyo;
	
	
	public Mesa() {
		
		this.asientos = new ArrayList<>();
		this.tamanyo = 6;
	}


	public Integer getTamanyo() {
		return tamanyo;
	}

	public void setTamanyo(Integer tamanyo) {
		this.tamanyo = tamanyo;
	}
	
	public void generarAsientos() {
		asientos.clear();
		for(int i=0;i<tamanyo;i++) {
			asientos.add(new Asiento());
		}
	}

	public ArrayList<Asiento> getAsientos() {
		return asientos;
	}

	public void setAsientos(ArrayList<Asiento> asientos) {
		this.asientos = asientos;
	}


}

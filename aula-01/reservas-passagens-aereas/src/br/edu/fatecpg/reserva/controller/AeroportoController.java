package br.edu.fatecpg.reserva.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.fatecpg.reserva.model.Voo;

public class AeroportoController {

	
	private List<Voo> listaVoo = new ArrayList<>();
	
	public void setVoo(Voo v) {
		
		listaVoo.add(v);
	}
	
	public String getPedido (int index) {
		return listaVoo.get(index).toString();
	}
	
	public String getLista () {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < listaVoo.size(); i++) {
			sb.append(listaVoo.get(i).toString());
			
		}
		return sb.toString();
	}
	
}

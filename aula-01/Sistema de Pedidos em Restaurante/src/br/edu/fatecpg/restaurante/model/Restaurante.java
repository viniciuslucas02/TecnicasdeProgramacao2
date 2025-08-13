package br.edu.fatecpg.restaurante.model;
import br.edu.fatecpg.restaurante.model.*;
import java.util.ArrayList;
import java.util.List;

public class Restaurante {
	private List<itemPedido> pedidos = new ArrayList<>();
	
	 public void adicionarItem(itemPedido item) {
			pedidos.add(item);
	        }
	 
	 public void removerItem(itemPedido item) {
		 pedidos.remove(item);
	 }
	
	public String buscarPedido(int index) {
		return pedidos.get(index).toString();
	}
	
	public String mostrar() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < pedidos.size(); i++) {
			sb.append(pedidos.get(i).toString());
			sb.append("\n");
		}
		return sb.toString();
	}
}

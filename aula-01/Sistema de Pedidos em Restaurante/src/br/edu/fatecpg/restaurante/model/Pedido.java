package br.edu.fatecpg.restaurante.model;
import br.edu.fatecpg.restaurante.model.*;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private int nmrPedido;
	private int nmrMesa;
	public Pedido(int nmrPedido) {
	super();
	this.nmrPedido = nmrPedido;
	this.listaPedidos = new ArrayList<>();
	}
	
	private List<itemPedido> listaPedidos = new ArrayList<>();

	public void adicionarItem(itemPedido item) {
	listaPedidos.add(item);
	}

	public void removerItem(itemPedido item) {
	listaPedidos.remove(item);
	}
	public double calcularPreco() {
	double valorTotal = 0;
	for (itemPedido item : listaPedidos) {
	valorTotal += item.getPrecoUni() * item.getQtd();
	}
	return valorTotal;
	}
	public void reservarMesa(int nmrMesa) {
	this.nmrMesa = nmrMesa;
	System.out.println("Mesa reservada!");
	
	}
	}
	
	
	
	


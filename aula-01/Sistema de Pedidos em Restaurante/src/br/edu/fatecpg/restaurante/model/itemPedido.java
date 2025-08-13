package br.edu.fatecpg.restaurante.model;

public class itemPedido {
	private String nmPrato;
	private int qtd;
	private double precoUni;
	
	
	public itemPedido(String nmPrato, int qtd, double precoUni) {
		super();
		this.nmPrato = nmPrato;
		this.qtd = qtd;
		this.precoUni = precoUni;
	}
	public String getNmPrato() {
		return nmPrato;
	}
	public void setNmPrato(String nmPrato) {
		this.nmPrato = nmPrato;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public double getPrecoUni() {
		return precoUni;
	}
	public void setPrecoUni(double precoUni) {
		this.precoUni = precoUni;
	}
	@Override
	public String toString() {
		return "itemPedido [nome Prato=" + nmPrato + ", Quantidade =" + qtd + ", Preço Unitário=" + precoUni + "]";
	}
}

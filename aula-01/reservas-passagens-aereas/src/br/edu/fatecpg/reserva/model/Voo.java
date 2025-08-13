package br.edu.fatecpg.reserva.model;

public class Voo {

	private String numeroVoo;
	private String origem;
	private String destino;
	private int assentosDisponiveis;
	
	
	
	public Voo(String numeroVoo, String origem, String destino, int assentosDisponiveis) {
		this.numeroVoo = numeroVoo;
		this.origem = origem;
		this.destino = destino;
		this.assentosDisponiveis = assentosDisponiveis;
	}
	
	public String getNumeroVoo() {
		return numeroVoo;
	}
	public void setNumeroVoo(String numeroVoo) {
		this.numeroVoo = numeroVoo;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public int getAssentosDisponiveis() {
		return assentosDisponiveis;
	}
	public void setAssentosDisponiveis(int assentosDisponiveis) {
		this.assentosDisponiveis = assentosDisponiveis;
	}
	
	
	public void realizarReserva (int qtdAssentos) {
		
		this.assentosDisponiveis -= qtdAssentos;
	}
	
	
	public boolean verificarDisponibilidade (int qtdAssentos) {
		return qtdAssentos <= this.assentosDisponiveis;
	}
	
	
    public double realizarPagamento(String tipoViagem, boolean pontosTuristicos) {
	double  precoNormal = tipoViagem.equalsIgnoreCase("ida") ? 500 : 900 ;
    	
    	if(pontosTuristicos) {
    		precoNormal += 200;
    	}
    	System.out.println("pagamento feito, total de: " + precoNormal);
    	return precoNormal;
    }
    

    public void imprimirPassagem () {
	System.out.println("foi");
    }

	@Override
	public String toString() {
		return "Voo [numeroVoo=" + numeroVoo + ", origem=" + origem + ", destino=" + destino + ", assentosDisponiveis="
				+ assentosDisponiveis + "]";
	}
    
	
	
	
	
	
}

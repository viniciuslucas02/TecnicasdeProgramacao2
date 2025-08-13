package br.edu.fatecpg.reserva.view;
import br.edu.fatecpg.reserva.model.*;

public class Main {

	public static void main(String[] args) {
	
		Voo vo1 = new Voo("AA123", "miami", "guaruja", 50);
		Voo vo2 = new Voo("BB123", "brasil", "osasco", 60);
		
		Aeroporto aeroporto = new Aeroporto();
		
		aeroporto.setVoo(vo1);
		aeroporto.setVoo(vo2);
		
		
		
		vo1.realizarReserva(10);
		vo1.realizarPagamento("ida", true);
		System.out.println(vo1.verificarDisponibilidade(3));
		
		
		System.out.println(aeroporto.getVoo(1));
		System.out.println(aeroporto.getLista());
	}

}

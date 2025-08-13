package br.edu.fatecpg.restaurante.view;
import br.edu.fatecpg.restaurante.model.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Restaurante r = new Restaurante();
        Pedido p = new Pedido(1);
        itemPedido item1 = new itemPedido("Lasanha Bolonhesa", 2, 29.90);
        itemPedido item2 = new itemPedido("Parmegiana de Frango", 2, 19.90);
        r.adicionarItem(item1);
        r.removerItem(item2);
        System.out.println(r.mostrar());
        System.out.println("a");
	}

}

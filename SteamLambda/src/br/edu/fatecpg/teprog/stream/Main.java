package br.edu.fatecpg.teprog.stream;

import br.edu.fatecpg.teprog.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       List<Produto> produtos = new ArrayList<>();
       produtos.add(new Produto("Frigobar", 900.00, "Eletronicos"));
        produtos.add(new Produto("Celular", 4000.00, "Eletronicos"));
        produtos.add(new Produto("Calça", 300.00, "Roupas"));
        produtos.add(new Produto("Boné", 200.00, "Roupas"));

        System.out.println("Mostrando produtos filtrados por categoria: ");
        produtos.stream().filter(p -> p.getCategoria().equals("Eletronicos"))
                .forEach(System.out::println);

        var desconto = produtos.stream().map(d -> d.getPreco() - (d.getPreco() * 0.10)).sorted();
        System.out.println("Itens com desconto de 10%");
        desconto.forEach(System.out::println);


        var total_gastos = produtos.stream()
                .filter(d ->  d.getCategoria().equals("Roupas"))
                .map(m -> m.getPreco())
                .reduce(0.0, Double::sum);
        System.out.println("Total gastos: " + total_gastos);

        var agruparE = produtos.stream()
                .filter( a -> a.getCategoria().equals("Eletronicos")).mapToDouble(p -> p.getPreco())
                .average()
                .getAsDouble();
        System.out.println("Media dos eletronicos: " + agruparE);

        var agruparR = produtos.stream()
                .filter( a -> a.getCategoria().equals("Roupas")).mapToDouble(p -> p.getPreco())
                .average()
                .getAsDouble();
        System.out.println("Media das Roupas: " + agruparR);

    }



    }


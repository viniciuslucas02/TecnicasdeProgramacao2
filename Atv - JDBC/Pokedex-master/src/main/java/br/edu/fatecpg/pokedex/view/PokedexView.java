package br.edu.fatecpg.pokedex.view;

import br.edu.fatecpg.pokedex.model.Pokemon;

public class PokedexView {

    public void exibirMenuInicial() {
        System.out.println("======================================");
        System.out.println("        Bem-vindo à Pokédex!");
        System.out.println("======================================");
    }

    public void solicitarNomePokemon() {
        System.out.print("Digite o nome de um Pokémon para busca (ou 'sair' para fechar):\n> ");
    }

    public void exibirDadosPokemon(Pokemon pokemon) {
        System.out.println("\n--- Dados do Pokémon ---");
        System.out.println("Nome: " + pokemon.name());
        System.out.println("Altura: " + pokemon.height());
        System.out.println("Peso: " + pokemon.weight());
        System.out.println("------------------------\n");
    }

    public void exibirMensagemDeSaida() {
        System.out.println("Programa finalizado.");
    }

    public void exibirErro(String mensagem) {
        System.err.println("ERRO: " + mensagem);
        System.out.println("Por favor, tente novamente.\n");
    }
}
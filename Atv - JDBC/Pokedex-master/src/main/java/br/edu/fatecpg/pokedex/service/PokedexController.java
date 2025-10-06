package br.edu.fatecpg.pokedex.controller;

import br.edu.fatecpg.pokedex.model.Pokemon;
import br.edu.fatecpg.pokedex.service.PokedexService;
import br.edu.fatecpg.pokedex.view.PokedexView;

import java.util.Scanner;

public class PokedexController {
    private final PokedexService service;
    private final PokedexView view;
    private final Scanner scanner;

    public PokedexController() {
        this.service = new PokedexService();
        this.view = new PokedexView();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        view.exibirMenuInicial();
        while (true) {
            view.solicitarNomePokemon();
            String nome = scanner.nextLine();

            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                Pokemon pokemon = service.buscarPokemon(nome);
                view.exibirDadosPokemon(pokemon);
            } catch (Exception e) {
                view.exibirErro(e.getMessage());
            }
        }
        view.exibirMensagemDeSaida();
        scanner.close();
    }
}
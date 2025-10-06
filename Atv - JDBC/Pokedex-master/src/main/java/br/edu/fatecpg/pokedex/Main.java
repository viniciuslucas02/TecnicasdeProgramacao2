package br.edu.fatecpg.pokedex;

import br.edu.fatecpg.pokedex.controller.PokedexController;

public class PokedexApplication {
    public static void main(String[] args) {
        PokedexController controller = new PokedexController();
        controller.start();
    }
}
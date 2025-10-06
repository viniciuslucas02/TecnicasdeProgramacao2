package br.edu.fatecpg.pokedex.service;

import br.edu.fatecpg.pokedex.model.Pokemon;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PokedexService {
    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();
    private static final String API_BASE_URL = "https://pokeapi.co/api/v2/pokemon/";

    public Pokemon buscarPokemon(String nome) throws IOException, InterruptedException {
        String url = API_BASE_URL + nome.toLowerCase();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Pokémon não encontrado! Status code: " + response.statusCode());
        }

        String json = response.body();
        return mapper.readValue(json, Pokemon.class);
    }
}

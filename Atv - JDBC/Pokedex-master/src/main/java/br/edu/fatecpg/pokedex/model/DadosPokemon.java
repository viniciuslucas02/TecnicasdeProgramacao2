package br.edu.fatecpg.pokedex.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Pokemon(String name, Integer height, Integer weight) {
}

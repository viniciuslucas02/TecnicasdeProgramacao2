package br.edu.fatecpg.noticias.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Resposta {
    @SerializedName("status")
    private String status;

    @SerializedName("totalResults")
    private int totalResults;

    @SerializedName("articles")
    private List<Noticia> artigos;

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public List<Noticia> getArtigos() {
        return artigos;
    }
}

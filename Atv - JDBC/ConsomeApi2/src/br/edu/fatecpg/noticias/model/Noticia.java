package br.edu.fatecpg.noticias.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Noticia {
    @SerializedName("title")
    private String titulo;
    @SerializedName("author")
    private String autor;
    @SerializedName("description")
    private String descricao;

    public Noticia(String titulo, String autor, String descricao) {
        this.titulo = titulo;
        this.autor = autor;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

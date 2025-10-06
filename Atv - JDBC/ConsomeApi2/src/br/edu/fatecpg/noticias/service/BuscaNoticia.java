package br.edu.fatecpg.noticias.service;
import br.edu.fatecpg.noticias.model.Noticia;
import br.edu.fatecpg.noticias.model.Resposta;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.time.Duration;
import java.util.List;

public class BuscaNoticia {
    public List<Noticia> obterNoticia(String x, int y) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://newsapi.org/v2/everything?q="+x.trim()+"&from=2025-08-10&sortBy=publishedAt&pageSize"+y+"&page=1&apiKey=22d3d331300a4457b208e5d515d4a5f3"))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        Resposta resposta = gson.fromJson(response.body(), Resposta.class);
        List<Noticia> artigos = resposta.getArtigos();

        if (artigos != null && artigos.size() > y) {
            return artigos.subList(0, y);
        }

        return artigos;
    }
}


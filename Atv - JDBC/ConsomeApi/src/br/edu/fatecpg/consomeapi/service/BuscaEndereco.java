package br.edu.fatecpg.consomeapi.service;

import br.edu.fatecpg.consomeapi.model.Banco;
import br.edu.fatecpg.consomeapi.model.Endereco;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BuscaEndereco {
    public String obterEndereco(String x) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/" + x + "/json/"))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String inserirEnd(Endereco end) {
        String query = "INSERT INTO endereco (cep,logradouro,bairro,localidade,estado) VALUES(?,?,?,?,?)";
        try (var conexao = Banco.conectar()) {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, end.getCep());
            stmt.setString(2, end.getRua());
            stmt.setString(3, end.getBairro());
            stmt.setString(4, end.getLocalidade());
            stmt.setString(5, end.getEstado());
            stmt.execute();
            return "Gravado com sucesso";

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String mostrarEndereco() {
        String query = "SELECT * FROM endereco";
        List<Endereco> ts = new ArrayList<>();
        try (var conexao = Banco.conectar()) {
            PreparedStatement stmt = conexao.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ts.add(new Endereco(rs.getString("cep"),
                        rs.getString("logradouro"),
                        rs.getString("bairro"),
                        rs.getString("localidade"),
                        rs.getString("estado")));

            }
            return ts.toString();
        } catch (Exception e) {
            return e.getMessage();
        }

    }
}

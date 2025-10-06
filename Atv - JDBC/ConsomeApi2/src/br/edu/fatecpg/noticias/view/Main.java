package br.edu.fatecpg.noticias.view;

import br.edu.fatecpg.noticias.model.Noticia;
import br.edu.fatecpg.noticias.service.BuscaNoticia;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BuscaNoticia busca = new BuscaNoticia();
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual tema você deseja buscar sobre? ");
        String i = sc.nextLine();
        System.out.println("Quantas noticias deseja ver? ");
        int e = sc.nextInt();

        List<Noticia> noticias = busca.obterNoticia(i, e);

        if (noticias != null) {
            for (Noticia noticia : noticias) {
                System.out.println(noticia);
            }
        } else {
            System.out.println("Nenhuma notícia encontrada ou erro na requisição.");
        }

    }
}




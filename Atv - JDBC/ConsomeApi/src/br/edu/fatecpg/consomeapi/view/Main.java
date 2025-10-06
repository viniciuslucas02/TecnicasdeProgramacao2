package br.edu.fatecpg.consomeapi.view;
import java.util.Scanner;
import br.edu.fatecpg.consomeapi.model.Endereco;
import br.edu.fatecpg.consomeapi.service.BuscaEndereco;
import com.google.gson.Gson;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BuscaEndereco bE = new BuscaEndereco();
        Gson gson = new Gson();

        //System.out.println(end);
        //System.out.println(novoEnd);
        Scanner sc = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("------ Menu ------");
            System.out.println("1 - Buscar Endereço");
            System.out.println("2 - Mostrar todos os endereços salvos");
            System.out.println("------------------");
            System.out.println("Escolha uma opção ou digite 0 para sair");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao){
                case 1:
                    System.out.println("Digite o CEP do endereço desejado: ");
                    String cep = sc.nextLine().trim();
                    String end = bE.obterEndereco(cep);
                    Endereco novoEnd = gson.fromJson(end, Endereco.class);
                    if (Boolean.TRUE.equals(novoEnd.getErro())) {
                        System.out.println("CEP inválido, não é possível salvar.");
                    } else {
                        System.out.println(novoEnd);
                        System.out.println("Deseja salvar o endereço s/n?");
                        String salvar = sc.nextLine().toLowerCase().trim();

                        if (salvar.equals("s")) {
                            String add = bE.inserirEnd(novoEnd);
                            System.out.println(add);
                        } else if (salvar.equals("n")) {
                            System.out.println("Endereço não foi salvo.");
                        } else {
                            System.out.println("ERRO: opção inválida.");
                        }
                    }

                    break;
                case 2:
                    String mostrar = bE.mostrarEndereco();
                    System.out.println(mostrar);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção invalida!");
            }
        }while(opcao != 0);

    }
}

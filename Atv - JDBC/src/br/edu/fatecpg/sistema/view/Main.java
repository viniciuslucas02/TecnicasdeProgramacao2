package br.edu.fatecpg.sistema.view;

import br.edu.fatecpg.sistema.model.Banco;

import java.sql.SQLOutput;
import java.util.Scanner;
import br.edu.fatecpg.sistema.controller.TarefaController;

import javax.security.auth.DestroyFailedException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TarefaController tb = new TarefaController();
        int opcao;
        do {
            System.out.println("-----------------------");
            System.out.println("Escolha uma opção ");
            System.out.println("1 - Criar uma Tarefa");
            System.out.println("2 - Editar uma Tarefa");
            System.out.println("3 - Excluir uma Tafefa");
            System.out.println("4 - Listar as Tarefas");
            System.out.println("5 - Atualizar Status");
            System.out.println("0 - Sair");
            System.out.println("-----------------------");
            System.out.println("Digite um numero: ");
            opcao = sc.nextInt();

        switch(opcao)
        {
            case 1:
                System.out.println("--- Cadastro de Tarefa ---");
                System.out.println("Digite seu ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("Digite o nome da Tarefa: ");
                String nome = sc.next();
                System.out.println("Digite o Status: ");
                boolean status = sc.nextBoolean();
                System.out.println("Digite a categoria: ");
                String categoria = sc.next().trim().toLowerCase();
                String criar = tb.inserirTarefa(id, nome, false, categoria);
                System.out.println(criar);
                break;

            case 2:
                System.out.println("Editar uma tarefa");
                System.out.println("Digite seu ID");
                int idE = sc.nextInt();
                sc.nextLine();
                System.out.println("Digite o novo nome");
                String nomeE = sc.next();
                System.out.println("Digite a nova Categoria: ");
                String categoriaE = sc.next().toLowerCase().trim();
                String editar = tb.editarTarefa(idE, nomeE, false, categoriaE);
                System.out.println(editar);
                break;

            case 3:
                System.out.println("Excluir Tarefa");
                System.out.println("Digite seu ID");
                int idDel = sc.nextInt();
                String excluir = tb.deletarTarefa(idDel);
                System.out.println(excluir);
                break;
            case 4:
                int filtro;
                do {
                    System.out.println("- MOSTRAR TAREFAS -");
                    System.out.println("1 - Mostrar todas as tarefas");
                    System.out.println("2 - Filtrar por categoria");
                    System.out.println("3 - Filtrar por status");
                    System.out.println("Escolha um opção ou aperte 0 para sair");
                    filtro = sc.nextInt();
                    sc.nextLine();
                    switch (filtro){
                        case 1:
                            String msgM = tb.selecionarTarefa();
                            System.out.println(msgM);
                            break;
                        case 2:
                            System.out.println("Qual categoria você deseja filtrar? ");
                            String cg = sc.nextLine().trim().toLowerCase();
                            String msgCG = tb.listarCategoria(cg);
                            System.out.println(msgCG);
                            break;
                        case 3:
                            System.out.println("concluida ou pendente?");
                            String resp = sc.nextLine().trim().toLowerCase();
                            boolean status1;
                            if(resp.equalsIgnoreCase("concluida")){
                                status1 = true;
                                String msgCO = tb.ListarStatus(status1);
                                System.out.println(msgCO);
                            } else if (resp.equalsIgnoreCase("pendente")) {
                                status1 = false;
                                String msgPE = tb.ListarStatus(status1);
                                System.out.println(msgPE);
                            }
                            else {
                                System.out.println("opção invalida");
                            }
                            break;
                        case 0:
                            System.out.printf("Voltando para o menu inicial... \n");
                            break;
                        default:
                            System.out.printf("Erro, digite uma opção valida");
                    }
                }while (filtro != 0);
            case 5:
                System.out.println("Atualizar Status: ");
                System.out.println("Digite seu ID");
                int idA = sc.nextInt();
                String atualizar = tb.atualizarStatus(idA, true);
                System.out.println(atualizar);
                break;


            default:
                System.out.println("Saiu");
                break;
        }


        }while(opcao != 0);
        sc.close();
    }
}

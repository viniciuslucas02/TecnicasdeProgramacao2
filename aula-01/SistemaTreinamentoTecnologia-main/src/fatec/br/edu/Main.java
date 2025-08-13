package fatec.br.edu;

import fatec.br.edu.controller.TreinamentoController;
import fatec.br.edu.model.*;
import fatec.br.edu.view.TreinamentoView;

public class Main {
    public static void main(String[] args) {
        TreinamentoView view = new TreinamentoView();
        TreinamentoController controller = new TreinamentoController(view);

        view.exibirMensagem("### Sistema de Treinamento Tecnologia\n");

        Aluno alunaAna = new Aluno("Ana Souza");
        Aluno alunoBruno = new Aluno("Bruno Costa");

        TreinamentoPresencial treinamentoJava = new TreinamentoPresencial(
                101, "Dr. Ricardo Alves", "Java Avançado", "Auditório Principal"
        );
        treinamentoJava.definirCargaHoraria(60);

        TreinamentoOnline treinamentoPython = new TreinamentoOnline(
                202, "Dra. Flávia Borges", "Python para Data Science", "http://meet.empresa.com/python-ds"
        );
        treinamentoPython.definirCargaHoraria(30);

        // 3. Usar o Controller para orquestrar as ações
        controller.exibirDetalhes(treinamentoJava);
        controller.inscreverAluno(treinamentoJava, alunaAna);   // Deve ter sucesso (0 + 60h)
        controller.inscreverAluno(treinamentoJava, alunoBruno); // Deve ter sucesso (0 + 60h)

        System.out.println();

        controller.exibirDetalhes(treinamentoPython);
        controller.inscreverAluno(treinamentoPython, alunaAna); // Deve falhar (60h + 30h > 80h)

        // Adicionar notas para os testes
        alunaAna.setNotaFinal(9.0);
        alunoBruno.setNotaFinal(8.0);

        System.out.println();


        controller.calcularEMostrarMedia(treinamentoJava);

        System.out.println();

        controller.verificarDisponibilidade(treinamentoPython);

        view.exibirMensagem("\nSistema Finalizado.");
    }
}
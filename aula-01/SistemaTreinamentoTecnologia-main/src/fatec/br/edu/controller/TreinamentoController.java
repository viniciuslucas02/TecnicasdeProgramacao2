package fatec.br.edu.controller;

import fatec.br.edu.model.Aluno;
import fatec.br.edu.model.Treinamento;
import fatec.br.edu.view.TreinamentoView;

public class TreinamentoController {
    private TreinamentoView view;

    public TreinamentoController(TreinamentoView view) {
        this.view = view;
    }

    public void inscreverAluno(Treinamento treinamento, Aluno aluno) {
        boolean sucesso = treinamento.adicionarAluno(aluno);
        if (sucesso) {
            view.exibirMensagem("-> Inscrição de " + aluno.getNome() + " realizada com sucesso!");
        } else {
            view.exibirMensagem("-> FALHA: " + aluno.getNome() + " não pôde ser inscrito(a) por exceder o limite de horas.");
        }
    }

    public void verificarDisponibilidade(Treinamento treinamento) {
        view.exibirDisponibilidade(treinamento.getNomeInstrutor(), treinamento.getLinguagemEnsinada(), true);
    }

    public void exibirDetalhes(Treinamento treinamento) {
        view.exibirDetalhesTreinamento(treinamento.toString());
    }

    public void calcularEMostrarMedia(Treinamento treinamento) {
        double media = treinamento.calcularMediaAlunos();
        view.exibirMediaDaTurma(treinamento.getLinguagemEnsinada(), media);
    }
}
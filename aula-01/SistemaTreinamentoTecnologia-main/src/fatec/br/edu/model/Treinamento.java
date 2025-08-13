package fatec.br.edu.model;

import java.util.ArrayList;

public abstract class Treinamento {
    protected int id;
    protected String nomeInstrutor;
    protected String linguagemEnsinada;
    protected ArrayList<Aluno> alunos;
    protected int cargaHoraria;

    public Treinamento(int id, String nomeInstrutor, String linguagemEnsinada) {
        this.id = id;
        this.nomeInstrutor = nomeInstrutor;
        this.linguagemEnsinada = linguagemEnsinada;
        this.alunos = new ArrayList<>();
        this.cargaHoraria = 0;
    }

    public String getNomeInstrutor() {
        return nomeInstrutor;
    }

    public String getLinguagemEnsinada() {
        return linguagemEnsinada;
    }

    public void definirCargaHoraria(int horas) {
        if (horas > 0) {
            this.cargaHoraria = horas;
        }
    }

    public boolean verificarUltimoTreinamento(Aluno aluno) {
        final int LIMITE_HORAS = 80;
        return (aluno.getCargaHorariaAcumulada() + this.cargaHoraria) <= LIMITE_HORAS;
    }

    public boolean adicionarAluno(Aluno aluno) {
        if (verificarUltimoTreinamento(aluno)) {
            this.alunos.add(aluno);
            aluno.adicionarCargaHoraria(this.cargaHoraria);
            return true; // Sucesso
        }
        return false; // Falha
    }

    public double calcularMediaAlunos() {
        if (alunos.isEmpty()) {
            return 0.0;
        }
        double somaDasNotas = 0.0;
        for (Aluno aluno : alunos) {
            somaDasNotas += aluno.getNotaFinal();
        }
        return somaDasNotas / alunos.size();
    }

    public abstract String getDetalhesEspecificos();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append("\n");
        sb.append("Linguagem: ").append(linguagemEnsinada).append("\n");
        sb.append("Instrutor: ").append(nomeInstrutor).append("\n");
        sb.append("Carga Horária: ").append(cargaHoraria).append(" horas\n");
        sb.append("Nº de Alunos Inscritos: ").append(alunos.size()).append("\n");
        sb.append(getDetalhesEspecificos()); // Adiciona detalhes da subclasse
        return sb.toString();
    }
}
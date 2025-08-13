package fatec.br.edu.model;

public class Aluno {
    private String nome;
    private double notaFinal;
    private int cargaHorariaAcumulada;

    public Aluno(String nome) {
        this.nome = nome;
        this.notaFinal = 0.0;
        this.cargaHorariaAcumulada = 0;
    }

    public String getNome() {
        return nome;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public int getCargaHorariaAcumulada() {
        return cargaHorariaAcumulada;
    }

    public void adicionarCargaHoraria(int horas) {
        this.cargaHorariaAcumulada += horas;
    }
}
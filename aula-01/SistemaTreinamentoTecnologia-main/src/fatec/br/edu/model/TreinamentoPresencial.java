package fatec.br.edu.model;

public class TreinamentoPresencial extends Treinamento {
    private String local;

    public TreinamentoPresencial(int id, String nomeInstrutor, String linguagemEnsinada, String local) {
        super(id, nomeInstrutor, linguagemEnsinada);
        this.local = local;
    }

    @Override
    public String getDetalhesEspecificos() {
        return "Tipo: Presencial\nLocal: " + this.local;
    }
}
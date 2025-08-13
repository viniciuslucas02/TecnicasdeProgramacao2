package fatec.br.edu.model;

public class TreinamentoOnline extends Treinamento {
    private String linkAcesso;

    public TreinamentoOnline(int id, String nomeInstrutor, String linguagemEnsinada, String linkAcesso) {
        super(id, nomeInstrutor, linguagemEnsinada);
        this.linkAcesso = linkAcesso;
    }

    @Override
    public String getDetalhesEspecificos() {
        return "Tipo: Online\nLink de Acesso: " + this.linkAcesso;
    }
}
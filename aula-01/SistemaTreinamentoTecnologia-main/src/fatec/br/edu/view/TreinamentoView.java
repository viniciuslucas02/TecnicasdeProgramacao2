package fatec.br.edu.view;

public class TreinamentoView {

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void exibirDetalhesTreinamento(String detalhes) {
        System.out.println("Detalhes do Treinamento");
        System.out.println(detalhes);
    }

    public void exibirDisponibilidade(String nomeInstrutor, String linguagem, boolean disponivel) {
        System.out.println("Verificando disponibilidade para " + linguagem + " com " + nomeInstrutor + "...");
        if (disponivel) {
            System.out.println("-> Instrutor disponível.");
        } else {
            System.out.println("-> Instrutor indisponível.");
        }
    }

    public void exibirMediaDaTurma(String linguagem, double media) {
        System.out.println("Média da Turma:");
        System.out.println("Curso: " + linguagem);
        System.out.printf("Média final: %.2f\n", media);
    }
}
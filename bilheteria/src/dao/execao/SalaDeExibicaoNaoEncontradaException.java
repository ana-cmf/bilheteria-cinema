package dao.execucao;

public class SalaDeExibicaoNaoEncontradaException extends Exception {

    public SalaDeExibicaoNaoEncontradaException(int idSala) {
        super("Sala com ID " + idSala + " não foi encontrada.");
    } 
}

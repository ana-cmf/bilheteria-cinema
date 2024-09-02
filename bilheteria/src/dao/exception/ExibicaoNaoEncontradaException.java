package dao.exception;

public class ExibicaoNaoEncontradaException extends Exception {

    public ExibicaoNaoEncontradaException(Long idExibicao) {
        super("Exibicao com ID " + idExibicao + " nao foi encontrada.");
    }
}

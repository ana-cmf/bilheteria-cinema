package dao.execucao;

public class FilmeNaoEncontradoException extends Exception {

    public FilmeNaoEncontradoException(Long idFilme) {
        super("Filme com ID " + idFilme + " não foi encontrado.");
    }
}

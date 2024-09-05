package dao.exception;

public class FilmeNaoEncontradoPeloIDException extends Exception {

    public FilmeNaoEncontradoPeloIDException(Long idFilme) {
        super("Filme com ID " + idFilme + " não foi encontrado.");
    }
}

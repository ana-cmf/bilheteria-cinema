package dao.exception;

public class FilmeNaoEncontradoPeloNomeException extends Exception {

    public FilmeNaoEncontradoPeloNomeException(String titulo) {
        super("O Filme " + titulo + " não foi encontrado.");
    }
}

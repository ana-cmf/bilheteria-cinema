package dao.exception;

public class FuncionarioNaoEncontradoPeloEmailException extends Exception {

    public FuncionarioNaoEncontradoPeloEmailException(String email) {
        super("O email " + email + " nao foi encontrado.");
    }
}

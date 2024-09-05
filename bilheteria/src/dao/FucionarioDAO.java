package dao;

import java.sql.SQLException;
import java.util.List;
import dao.exception.FuncionarioNaoEncontradoPeloEmailException;
import dto.FuncionarioDTO;

public interface FucionarioDAO {

    public void cadastrarFuncionario(FuncionarioDTO funcionario);
    public void excluirFuncionario(FuncionarioDTO funcinario);
    public void editarInformacoesFuncionario(FuncionarioDTO funcionario);
    public FuncionarioDTO buscarFuncionarioPeloEmail(FuncionarioDTO funcionario) throws FuncionarioNaoEncontradoPeloEmailException;
    public List<FuncionarioDTO> listarTodosFuncionarios() throws SQLException;
}

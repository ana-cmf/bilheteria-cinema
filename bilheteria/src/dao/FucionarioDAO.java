package dao;

import java.sql.SQLException;
import java.util.List;
import dto.FuncionarioDTO;

public interface FucionarioDAO {

    public void cadastrarFuncionario(FuncionarioDTO funcionario);
    public void excluirFuncionario(FuncionarioDTO funcinario);
    public void editarInformacoesFuncionario(FuncionarioDTO funcionario);
    public List<FuncionarioDTO> listarTodosFuncionarios() throws SQLException;
}

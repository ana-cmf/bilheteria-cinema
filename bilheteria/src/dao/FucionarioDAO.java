package dao;

import dto.FuncionarioDTO;

public interface FucionarioDAO {

    public void cadastrarFuncionario(FuncionarioDTO funcionario);
    public void editarInformacoesFuncionario(FuncionarioDTO funcionario);
}

package dao;

import dto.SalaDeExibicaoDTO;
import dto.FilmeDTO;
import dto.FuncionarioDTO;

public interface AdministradorDAO {

    public void cadastrarFuncionario(FuncionarioDTO funcionario);
    public void editarInformacoesFuncionario(FuncionarioDTO funcionario);
    public void cadastrarFilme(FilmeDTO filme);
    public void excluirFilme(int id);
    public void cadastrarSalaExibicao(SalaDeExibicaoDTO sala);
}

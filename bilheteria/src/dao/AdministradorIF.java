package dao;

import dto.FilmeDTO;
import dto.FuncionarioDTO;

public interface AdministradorIF {

    public void cadastrarFuncionario(String nomeCompleto, int cpf, int senha);
    public void editarInformacoesFuncionario(FuncionarioDTO editarInformacao);
    public void cadastrarFilme(int id, String titulo, String sinopse, String genero, 
    int duracao, int classificacaoIndicativa);
    public void excluirFilme(int id);
    public void cadastrarSalaExibicao(int id, String endereco, FilmeDTO[] filmes);
}

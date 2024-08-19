package dao;

import dto.FilmeDTO;

public interface FilmeDAO {

    public void cadastrarFilme(FilmeDTO filme);
    public void excluirFilme(int id);
}

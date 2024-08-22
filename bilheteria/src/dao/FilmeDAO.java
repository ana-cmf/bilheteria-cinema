package dao;

import dto.FilmeDTO;

public interface FilmeDAO {

    public void cadastrarFilme(FilmeDTO filme);
    public FilmeDTO buscarFilme(FilmeDTO filme);
    public void excluirFilme(FilmeDTO filme);
}

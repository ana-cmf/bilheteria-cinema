package dao;

import dao.execucao.FilmeNaoEncontradoException;
import dto.FilmeDTO;

public interface FilmeDAO {

    public void cadastrarFilme(FilmeDTO filme);
    public FilmeDTO buscarFilme(FilmeDTO filme) throws FilmeNaoEncontradoException;
    public void excluirFilme(FilmeDTO filme);
}

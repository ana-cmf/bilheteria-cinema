package dao;

import java.sql.SQLException;
import java.util.List;

import dao.exception.FilmeNaoEncontradoPeloIDException;
import dao.exception.FilmeNaoEncontradoPeloNomeException;
import dto.FilmeDTO;

public interface FilmeDAO {

    public void cadastrarFilme(FilmeDTO filme);
    public FilmeDTO buscarFilmeID(FilmeDTO filme) throws FilmeNaoEncontradoPeloIDException;
    public FilmeDTO buscarFilmeNome(FilmeDTO filme) throws FilmeNaoEncontradoPeloNomeException;
    public void excluirFilme(FilmeDTO filme);
    public List<FilmeDTO> listarTodosFilmes() throws SQLException;
}

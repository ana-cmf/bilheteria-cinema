package dao;

import java.sql.SQLException;
import java.util.List;

import dao.exception.ExibicaoNaoEncontradaException;
import dto.ExibicaoDTO;

public interface ExibicaoDAO {

    public void adicionarExibicao(ExibicaoDTO exibicao);
    public void excluirExibicao(ExibicaoDTO exibicao);
    public ExibicaoDTO buscarExibicao(ExibicaoDTO exibicao) throws ExibicaoNaoEncontradaException;
    public List<ExibicaoDTO> listarTodasExibicoes() throws SQLException;
}

package dao;

import java.sql.SQLException;
import java.util.List;

import dto.ExibicaoDTO;

public interface ExibicaoDAO {

    public void adicionarExibicao(ExibicaoDTO exibicao);
    public void excluirExibicao(ExibicaoDTO exibicao);
    public List<ExibicaoDTO> listarTodasExibicoes() throws SQLException;
}

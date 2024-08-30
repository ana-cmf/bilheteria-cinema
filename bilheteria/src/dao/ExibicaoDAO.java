package dao;

import dto.ExibicaoDTO;

public interface ExibicaoDAO {

    public void adicionarExibicao(ExibicaoDTO exibicao);
    public void excluirExibicao(ExibicaoDTO exibicao);
}

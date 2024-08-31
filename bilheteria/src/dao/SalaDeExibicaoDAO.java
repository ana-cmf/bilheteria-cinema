package dao;

import dao.execao.SalaDeExibicaoNaoEncontradaException;
import dto.SalaDeExibicaoDTO;

public interface SalaDeExibicaoDAO {

    public void cadastrarSalaExibicao(SalaDeExibicaoDTO sala);
    public SalaDeExibicaoDTO buscarSalaExibicao(SalaDeExibicaoDTO sala) throws SalaDeExibicaoNaoEncontradaException;
    public void excluirSalaExibicao(SalaDeExibicaoDTO sala);
} 

package dao;

import dto.SalaDeExibicaoDTO;

public interface SalaDeExibicaoDAO {

    public void cadastrarSalaExibicao(SalaDeExibicaoDTO sala);
    public SalaDeExibicaoDTO buscarSalaExibicao(SalaDeExibicaoDTO sala);
    public void excluirSalaExibicao(SalaDeExibicaoDTO sala);
} 

package dao;

import java.sql.SQLException;
import java.util.List;
import dao.execao.SalaDeExibicaoNaoEncontradaException;
import dto.SalaDeExibicaoDTO;

public interface SalaDeExibicaoDAO {

    public void cadastrarSalaExibicao(SalaDeExibicaoDTO sala);
    public SalaDeExibicaoDTO buscarSalaExibicao(SalaDeExibicaoDTO sala) throws SalaDeExibicaoNaoEncontradaException;
    public void excluirSalaExibicao(SalaDeExibicaoDTO sala);
    public List<SalaDeExibicaoDTO> listarTodasSalasDeExibicao() throws SQLException;
} 

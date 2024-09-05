package controller;

import dao.ExibicaoDAO;
import dao.ExibicaoDAOImpl;
import dto.ExibicaoDTO;
import model.Exibicao;
import model.Filme;
import model.SalaDeExibicao;

public class ExibicaoController {
    private Exibicao exibicao;
    private ExibicaoDAO exibicaodao;

    public ExibicaoController(){
        this.exibicaodao = new ExibicaoDAOImpl();
    }
    public void cadastrarExibicao(ExibicaoDTO dto){
        exibicao.setId(dto.getId());
        exibicao.setHorario(dto.getHorario());
        exibicao.setLegendado(dto.isLegendado());
        Filme filme = Filme.fromDTO(dto.getFilme());
        exibicao.setFilme(filme);
        SalaDeExibicao sala = SalaDeExibicao.fromDTO(dto.getSalaDeExibicao());
        exibicao.setSalaDeExibicao(sala);
        exibicaodao.adicionarExibicao(dto);
    }
    public void excluirExibicaoController(ExibicaoDTO dto){
        exibicao.setId(dto.getId());
        exibicaodao.excluirExibicao(dto);
    }
}

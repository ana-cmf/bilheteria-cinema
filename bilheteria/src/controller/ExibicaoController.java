package controller;

import java.util.Arrays;
import dao.ExibicaoDAO;
import dao.ExibicaoDAOImpl;
import dto.AssentoDTO;
import dto.ExibicaoDTO;
import dto.FilmeDTO;
import dto.ModeloDeExibicaoDTO;
import dto.SalaDeExibicaoDTO;
import model.Assento;
import model.Exibicao;
import model.Filme;
import model.ModeloDeExibicao;
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
        Filme filme = conversorFilmeparaDTO(dto.getFilme());
        exibicao.setFilme(filme);
        SalaDeExibicao sala = conversorSalaDeExibicaoFromDTO(dto.getSalaDeExibicao());
        exibicao.setSalaDeExibicao(sala);
        exibicaodao.adicionarExibicao(dto);
    }
    public void excluirExibicaoController(ExibicaoDTO dto){
        exibicao.setId(dto.getId());
        exibicaodao.excluirExibicao(dto);
    }
    public Filme conversorFilmeparaDTO(FilmeDTO filmedto){
        Filme filme = new Filme();
        filme.setId(filmedto.getId()); 
        filme.setTitulo(filmedto.getTitulo());
        filme.setClassificacaoIndicativa(filmedto.getClassificacaoIndicativa());
        filme.setDuracaoDoFilme(filmedto.getDuracaoDoFilme());
        filme.setGenero(filmedto.getGenero());
        return filme;
    }
    public SalaDeExibicao conversorSalaDeExibicaoFromDTO(SalaDeExibicaoDTO saladto){
        SalaDeExibicao sala = new SalaDeExibicao();
        sala.setNumeroDaSala(saladto.getNumeroDaSala());
        sala.setQuantidadeDeAssentos(saladto.getQuantidadeDeAssentos());

        ModeloDeExibicao modelo = conversorModeloDeExibicaoFromDTO(saladto.getModeloDeExibicao());
        sala.setModeloDeExibicao(modelo);

        Assento[] assentos = Arrays.stream(saladto.getAssentos())
                                   .map(this::conversorAssentoFromDTO)
                                   .toArray(Assento[]::new);
        sala.setAssentos(assentos);
        return sala;
    }
    public ModeloDeExibicao conversorModeloDeExibicaoFromDTO(ModeloDeExibicaoDTO dto) {
        if (null == dto) {
            throw new IllegalArgumentException("Modelo de Exibição desconhecido: " + dto);
        } else switch (dto) {
            case _2D -> {
                return ModeloDeExibicao._2D;
            }
            case _3D -> {
                return ModeloDeExibicao._3D;
            }
            default -> throw new IllegalArgumentException("Modelo de Exibição desconhecido: " + dto);
        }
    }
    public Assento conversorAssentoFromDTO(AssentoDTO dto){
        Assento assento = new Assento();
        assento.setPosicao(dto.getPosicao());
        assento.setReservado(dto.isReservado());
        return assento;
        
    }
}

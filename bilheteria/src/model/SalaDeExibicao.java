package model;

import dto.ModeloDeExibicaoDTO;
import dto.SalaDeExibicaoDTO;

public class SalaDeExibicao {
    private int numeroDaSala;
    private ModeloDeExibicao modeloDeExibicao;
    private int quantidadeDeAssentos;
    private Assento[] assentos = new Assento[40];
    

    public SalaDeExibicao( ){
        criarAssento();

    }

    private void  criarAssento(){
        this.assentos = new Assento[40];
        this.quantidadeDeAssentos=assentos.length;
        for (int i=1; i<assentos.length; i++) {
            assentos[i]=new Assento();
            assentos[i].setPosicao(i);
        }
    }

    public int getNumeroDaSala() {
        return numeroDaSala;
    }
    public void setNumeroDaSala(int numeroDaSala) {
        this.numeroDaSala = numeroDaSala;
    }
    public ModeloDeExibicao getModeloDeExibicao() {
        return modeloDeExibicao;
    }
    public void setModeloDeExibicao(ModeloDeExibicao modeloDeExibicao) {
        this.modeloDeExibicao = modeloDeExibicao;
    }
    public int getQuantidadeDeAssentos() {
        return quantidadeDeAssentos;
    }
    public void setQuantidadeDeAssentos(int quantidadeDeAssentos) {
        this.quantidadeDeAssentos = quantidadeDeAssentos;
    }
    public Assento[] getAssentos() {
        return assentos;
    }
    public void setAssentos(Assento[] assentos) {
        this.assentos = assentos;
    }
    @Override
    public String toString() {
        return String.format(
            "SalaDeExibicao{Número da Sala=%d, Modelo de Exibição='%s', Quantidade de Assentos=%d, Assentos=%s}",
            numeroDaSala, modeloDeExibicao, quantidadeDeAssentos, java.util.Arrays.toString(assentos)
        );
}
    public static SalaDeExibicao fromDTO(SalaDeExibicaoDTO dto) {
        SalaDeExibicao sala = new SalaDeExibicao();
        sala.setNumeroDaSala(dto.getNumeroDaSala());
        sala.setQuantidadeDeAssentos(dto.getQuantidadeDeAssentos());
        sala.criarAssento();
        ModeloDeExibicao modelo = ModeloDeExibicao.valueOf(dto.getModeloDeExibicao().getModelo());
        sala.setModeloDeExibicao(modelo);

        return sala;
    }

    public SalaDeExibicaoDTO toDTO() {
        SalaDeExibicaoDTO dto = new SalaDeExibicaoDTO();
        dto.setNumeroDaSala(this.numeroDaSala);
        dto.setQuantidadeDeAssentos(this.quantidadeDeAssentos);

        ModeloDeExibicaoDTO modeloDTO = new ModeloDeExibicaoDTO();
        modeloDTO.setModelo(this.modeloDeExibicao.toDTOString());
        dto.setModeloDeExibicao(modeloDTO);
        return dto;
    }
}
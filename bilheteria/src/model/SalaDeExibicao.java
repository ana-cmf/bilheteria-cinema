package model;

import dto.ModeloDeExibicaoDTO;
import dto.SalaDeExibicaoDTO;

public class SalaDeExibicao {
    private int numeroDaSala;
    private ModeloDeExibicao modeloDeExibicao;
    private int quantidadeDeAssentos;
    private Assento[] assentos = new Assento[40];
    

    public SalaDeExibicao(int quantidadeDeAssentos, int numeroDaSala, ModeloDeExibicao modeloDeExibicao) {
        this.quantidadeDeAssentos = quantidadeDeAssentos;
        this.numeroDaSala = numeroDaSala;
        this.modeloDeExibicao = modeloDeExibicao;
        this.assentos = new Assento[quantidadeDeAssentos];
        criarAssento(quantidadeDeAssentos);
    }

    private SalaDeExibicao() {
    }

    private Assento[] criarAssento(int quantidadeDeAssentos) {
        Assento[] assentos = new Assento[quantidadeDeAssentos];

        for (int i = 1; i < quantidadeDeAssentos; i++) {
            assentos[i] = new Assento();
        }
        return assentos;
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
    public boolean isExibicao3D(ModeloDeExibicaoDTO dto){
        if (dto != null && modeloDeExibicao.equals(ModeloDeExibicao.valueOf(dto.getModelo()))) {
            return dto.getModelo().equals(ModeloDeExibicao._3D.toString());
        }
        return false;
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
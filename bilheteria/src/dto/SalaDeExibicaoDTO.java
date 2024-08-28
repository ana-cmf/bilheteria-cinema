package dto;

public class SalaDeExibicaoDTO{
    private int idSala;
    private ModeloDeExibicaoDTO modeloDeExibicao;
    private int quantidadeDeAssentos;
    private AssentoDTO[][] assentos = new AssentoDTO[4][10];

     public SalaDeExibicaoDTO(AssentoDTO[][] assentos){
        this.assentos = assentos;
    }

    public int getNumeroDaSala() {
        return idSala;
    }
    public void setNumeroDaSala(int idSala) {
        this.idSala = idSala;
    }
    public ModeloDeExibicaoDTO getModeloDeExibicao() {
        return modeloDeExibicao;
    }
    public void setModeloDeExibicao(ModeloDeExibicaoDTO modeloDeExibicao) {
        this.modeloDeExibicao = modeloDeExibicao;
    }
    public int getQuantidadeDeAssentos() {
        return quantidadeDeAssentos;
    }
    public void setQuantidadeDeAssentos(int quantidadeDeAssentos) {
        this.quantidadeDeAssentos = quantidadeDeAssentos;
    }
    public AssentoDTO[][] getAssentos() {
        return assentos;
    }
    public void setAssentos(AssentoDTO[][] assentos) {
        this.assentos = assentos;
    }   
}
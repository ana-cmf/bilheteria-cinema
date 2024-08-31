package dto;

public class SalaDeExibicaoDTO {
    private int numeroDaSala;
    private ModeloDeExibicaoDTO modeloDeExibicao;
    private int quantidadeDeAssentos;
    private AssentoDTO[] assentos = new AssentoDTO[40];

    public SalaDeExibicaoDTO( ){
        this.assentos = new AssentoDTO[40];
        this.quantidadeDeAssentos=assentos.length;
        criarAssento();

    }

    public void  criarAssento(){
        for (int i=0; i<assentos.length; i++) {
            assentos[i]=new AssentoDTO();
            assentos[i].setPosicao(i+1);
        }
    }

    public int getNumeroDaSala() {
        return numeroDaSala;
    }
    public void setNumeroDaSala(int numeroDaSala) {
        this.numeroDaSala = numeroDaSala;
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
    public AssentoDTO[] getAssentos() {
        return assentos;
    }
    public void setAssentos(AssentoDTO[] assentos) {
        this.assentos = assentos;
    }
}
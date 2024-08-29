package model;

public class SalaDeExibicao {
    private int numeroDaSala;
    private ModeloDeExibicao modeloDeExibicao;
    private int quantidadeDeAssentos;
    private Assento[] assentos = new Assento[40];

    public SalaDeExibicao( ){
        this.assentos = new Assento[40];
        this.quantidadeDeAssentos=assentos.length;
        criarAssento();

    }

    public void  criarAssento(){
        for (int i=0; i<assentos.length; i++) {
            assentos[i]=new Assento();
            assentos[i].setPosicao(i+1);
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
}
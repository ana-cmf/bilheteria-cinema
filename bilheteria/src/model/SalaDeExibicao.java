public class SalaDeExibicao {
    
    private int numeroDaSala;
    private ModeloDeExibicao modeloDeExibicao;
    private int quantidadeDeAssentos;
    private Assento[][] assentos = new Assento[4][10];

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
    public Assento[][] getAssentos() {
        return assentos;
    }
    public void setAssentos(Assento[][] assentos) {
        this.assentos = assentos;
    }
}
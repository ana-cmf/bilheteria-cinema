package model;

public class Ingresso{

    private Exibicao exibicao;
    private Assento assento;
    private Cliente cliente;
    private float preco;
    private FormaDePagamento formaDePagamento;
    private TipoDeEntrada tipoDeEntrada;
    private boolean pagamentoRealizado;
    
    public Exibicao getExibicao() {
        return exibicao;
    }
    public void setExibicao(Exibicao exibicao) {
        this.exibicao = exibicao;
    }
    public Assento getAssento() {
        return assento;
    }
    public void setAssento(Assento assento) {
        this.assento = assento;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    public FormaDePagamento getFormaDePagamento() {
        return formaDePagamento;
    }
    public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }
    public TipoDeEntrada getTipoDeEntrada() {
        return tipoDeEntrada;
    }
    public void setTipoDeEntrada(TipoDeEntrada tipoDeEntrada) {
        this.tipoDeEntrada = tipoDeEntrada;
    }
    public boolean isPagamentoRealizado() {
        return pagamentoRealizado;
    }
    public void setPagamentoRealizado(boolean pagamentoRealizado) {
        this.pagamentoRealizado = pagamentoRealizado;
    }
}

    
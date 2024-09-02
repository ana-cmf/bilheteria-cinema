package model;

import model.execption.SecaoExibidaException;

public class Ingresso{
    private Long id;
    private Exibicao exibicao;
    private Assento assento;
    private Cliente cliente;
    private float preco;
    private TipoDeEntrada tipoDeEntrada;
    private boolean pagamentoRealizado;

    public Ingresso(Long id) {
	    this.id = System.currentTimeMillis();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
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
    public boolean podeComprarIngresso(Ingresso ingresso) throws SecaoExibidaException {
        if(ingresso.getExibicao().isSecaoJaExibida()){
            throw new SecaoExibidaException();
        }
        return true;
     }
}

    
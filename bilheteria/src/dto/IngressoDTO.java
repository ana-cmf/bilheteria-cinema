package dto;

public class IngressoDTO {
    private Long id;
    private ExibicaoDTO exibicao;
    private AssentoDTO assento;
    private ClienteDTO cliente;
    private float preco;
    private TipoDeEntradaDTO tipoDeEntrada;
    private FormaDePagamentoDTO formaDePagamento;
    private boolean pagamentoRealizado;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public IngressoDTO(TipoDeEntradaDTO tipoDeEntrada) {
        this.tipoDeEntrada = tipoDeEntrada;
    }
    public ExibicaoDTO getExibicao() {
        return exibicao;
    }
    public void setExibicao(ExibicaoDTO exibicao) {
        this.exibicao = exibicao;
    }
    public AssentoDTO getAssento() {
        return assento;
    }
    public void setAssento(AssentoDTO assento) {
        this.assento = assento;
    }
    public ClienteDTO getCliente() {
        return cliente;
    }
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    public FormaDePagamentoDTO getFormaDePagamento() {
        return formaDePagamento;
    }
    public void setFormaDePagamento(FormaDePagamentoDTO formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }
    public TipoDeEntradaDTO getTipoDeEntrada() {
        return tipoDeEntrada;
    }
    public void setTipoDeEntrada(TipoDeEntradaDTO tipoDeEntrada) {
        this.tipoDeEntrada = tipoDeEntrada;
    }
    public boolean isPagamentoRealizado() {
        return pagamentoRealizado;
    }
    public void setPagamentoRealizado(boolean pagamentoRealizado) {
        this.pagamentoRealizado = pagamentoRealizado;
    }
}
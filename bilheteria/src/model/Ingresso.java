package model;

import dto.IngressoDTO;
import dto.ModeloDeExibicaoDTO;
import dto.TipoDeEntradaDTO;
import model.execption.CpfInvalidoException;
import model.execption.EmailInvalidoException;
import model.execption.SecaoExibidaException;

public class Ingresso{
    private Long id;
    private Exibicao exibicao;
    private Assento assento;
    private Cliente cliente;
    private float preco;
    private TipoDeEntrada tipoDeEntrada;
    private boolean pagamentoRealizado;

    public Ingresso() {
        this.exibicao = new Exibicao();
	    this.id = System.currentTimeMillis();
        this.preco = 30f;
        
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
        if (isMeiaEntrada(TipoDeEntrada._MEIA.toDTO())) {
            preco = preco / 2;
            }
        if (exibicao != null && exibicao.getSalaDeExibicao() != null &&
            exibicao.getSalaDeExibicao().getModeloDeExibicao() != null &&
            exibicao.getSalaDeExibicao().getModeloDeExibicao() == ModeloDeExibicao._3D) {
            preco += 10.0f; // Adiciona valor extra para exibições em 3D
            }
        if(ingressoPodeSerIsento(exibicao.getFilme())){
            ingressoIsentado(exibicao.getFilme());
            preco +=0;

        }
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
     public boolean ingressoPodeSerIsento(Filme dto) {
    	 return dto.getClassificacaoIndicativa() == 0;
     }
     public void ingressoIsentado(Filme dto) {
    	 if(ingressoPodeSerIsento(dto)) {
         this.preco=0f;
        }
    }

    @Override
    public String toString() {
        return String.format(
        "Ingresso{ID=%d, Exibicao=[Filme='%s', Sala=%d, Horário='%s', Legendado=%b], Assento=Posição %d, Cliente='%s', Preço=%.2f, Tipo de Entrada='%s', Pagamento Realizado=%b}",
        id,
        exibicao.getFilme().getTitulo(),            
        exibicao.getSalaDeExibicao().getNumeroDaSala(),
        exibicao.getHorario().toString(),
        exibicao.isLegendado(),
        assento.getPosicao(),
        cliente.getNomeCompleto(),
        preco,
        tipoDeEntrada.toString(),
        pagamentoRealizado
        );
}
    public boolean isMeiaEntrada(TipoDeEntradaDTO dto){
        if (dto != null && TipoDeEntrada._MEIA.equals(TipoDeEntrada.valueOf(dto.getTipo().toUpperCase()))){
        }
        return true;
    }
    public boolean isExibicao3D(ModeloDeExibicaoDTO dto) {
        if (dto != null && this.getExibicao() != null && this.getExibicao().getSalaDeExibicao() != null) {
            ModeloDeExibicao modeloExibicao = this.getExibicao().getSalaDeExibicao().getModeloDeExibicao();
            return modeloExibicao != null && modeloExibicao.toString().equals(dto.getModelo());
        }
        return false;
    }
    
    public static Ingresso fromDTO(IngressoDTO dto) throws EmailInvalidoException, CpfInvalidoException {
        Ingresso ingresso = new Ingresso();
        ingresso.setId(dto.getId());
        ingresso.setPreco(dto.getPreco());
        ingresso.setCliente(Cliente.fromDTO(dto.getCliente()));
        ingresso.setExibicao(Exibicao.fromDTO(dto.getExibicao()));
        ingresso.setAssento(Assento.fromDTO(dto.getAssento()));

        ingresso.setTipoDeEntrada(TipoDeEntrada.fromDTO(dto.getTipoDeEntrada()));

        ingresso.setPagamentoRealizado(dto.isPagamentoRealizado());
        return ingresso;
    }
    public IngressoDTO toDTO() {
        IngressoDTO dto = new IngressoDTO();
        dto.setId(this.id);
        dto.setAssento(this.assento.toDTO());
        dto.setCliente(this.cliente.toDTO());
        dto.setExibicao(this.exibicao.toDTO());
        dto.setPreco(this.preco);
        dto.setTipoDeEntrada(this.tipoDeEntrada != null ? this.tipoDeEntrada.toDTO() : null); 
        dto.setPagamentoRealizado(this.pagamentoRealizado);
        return dto;
    }
}
package model;

import dto.CompraDTO;
import dto.IngressoDTO;

public class CartaoDeCredito implements FormaDePagamento{

    private int numParcelas;
    private float taxa;
    private SalaDeExibicao exibicao;
    private Ingresso ingressoCliente;
 
    public CartaoDeCredito(Ingresso ingresso) {
        this.ingressoCliente = ingresso;
    }    

    public CartaoDeCredito() {
    }
    

    public void setNumParcelas(int numParcelas){
        this.numParcelas = numParcelas;

    }
    public void setTaxa(float taxa){
       this.taxa=taxa;

    }
    @Override
    public int  getNumeroDeParcelas() {
        return numParcelas;
    }
    @Override
    public float  getTaxa() {
        return taxa;
    }
	public float calcularValorSemParcelar(CompraDTO compra) {
        if (compra.getIngressos() == null || compra.getIngressos().isEmpty()) {
            throw new IllegalArgumentException("A lista de ingressos não pode ser nula ou vazia.");
        }
        
        float precoFinal = 0;
        
        for (IngressoDTO ingresso : compra.getIngressos()) {
            float preco = ingresso.getPreco();
        
            // Adiciona o preço adicional para exibições em 3D
            if (exibicao.isExibicao3D(ingresso.getExibicao().getSalaDeExibicao().getModeloDeExibicao())) {
                preco += 10.0f;
            }
        
            // Se o cliente tem isenção, o preço é zerado
            if (ingressoCliente.ingressoPodeSerIsento(ingresso)) {
                preco = 0;
            } else if (ingressoCliente.isMeiaEntrada(ingresso.getTipoDeEntrada())) {
                // Caso seja meia entrada, aplica o desconto de 50%
                preco = preco / 2;
            }
        
            precoFinal += preco;
        }
        
        return precoFinal;
        
}
		
    public boolean podeParcelar(CompraDTO parcelado){
        if(calcularValorSemParcelar(parcelado) >= 60){
        }
        return true;
    }

    @Override
    public CompraDTO calcularValor(CompraDTO ingresso) {
        if(podeParcelar(ingresso) == true){
            float valorParcela= calcularValorSemParcelar(ingresso)/numParcelas;
            float precoComTaxaParcela= valorParcela+getTaxa();
            float precoFinal = precoComTaxaParcela*getNumeroDeParcelas();
            ingresso.setTotal(precoFinal);
            return ingresso;
        }else{
            ingresso.setTotal(calcularValorSemParcelar(ingresso));
            return ingresso;

        }

    }
    public SalaDeExibicao getExibicao() {
        return exibicao;
    }
    public void setExibicao(SalaDeExibicao exibicao) {
        this.exibicao = exibicao;
    }
    public Ingresso getIngressoCliente() {
        return ingressoCliente;
    }
    public void setIngressoCliente(Ingresso ingressoCliente) {
        this.ingressoCliente = ingressoCliente;
    }
}
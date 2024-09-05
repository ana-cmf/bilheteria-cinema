package model;

import dto.CompraDTO;
import dto.IngressoDTO;

public class CartaoDeCredito implements FormaDePagamento{

    private int numParcelas;
    private float taxa;
    private SalaDeExibicao exibicao;
    private Ingresso ingressoCliente;
 
    public CartaoDeCredito(Ingresso ingresso, SalaDeExibicao exibicao) {
        this.ingressoCliente = ingresso;
        this.exibicao = exibicao;
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
            throw new IllegalArgumentException();
        }
        float precoFinal = 0;
        for (IngressoDTO ingresso : compra.getIngressos()) {
            float preco = ingresso.getPreco();
            ingresso.setPreco(preco);
            precoFinal += preco;
        }
        return precoFinal;
    }
		
public boolean podeParcelar(CompraDTO parcelado){
    return calcularValorSemParcelar(parcelado) >= 60;
}
    @Override
    public CompraDTO calcularValor(CompraDTO ingresso) {
        float precoFinal;
        if (podeParcelar(ingresso)) {
            float valorParcela = calcularValorSemParcelar(ingresso) / numParcelas;
            precoFinal = (valorParcela + getTaxa()) * getNumeroDeParcelas();
        } else {
            precoFinal = calcularValorSemParcelar(ingresso);
        }
        ingresso.setTotal(precoFinal);
        return ingresso;
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
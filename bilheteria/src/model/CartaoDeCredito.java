package model;

import dto.CompraDTO;
import dto.IngressoDTO;

public class CartaoDeCredito implements FormaDePagamento{

	private int numParcelas;
    private float taxa;

    public CartaoDeCredito() {
        this.taxa = 0.02f;
        this.numParcelas = 1;
    }

    public void setNumParcelas(int numParcelas) {
        this.numParcelas = numParcelas; 
    }

    public void setTaxa(float taxa) {
        this.taxa = taxa;

    }

    @Override
    public int getNumeroDeParcelas() {
        return numParcelas;
    }

    @Override
    public float getTaxa() {
        return taxa;
    }

    public float calcularValorSemParcelar(CompraDTO compra) {
        if ((compra.getIngressos() == null) || compra.getIngressos().isEmpty()) {
        }

        float precoFinal = 0;

        for (IngressoDTO ingresso : compra.getIngressos()) {
            float preco = ingresso.getPreco();
            precoFinal += preco;
        }

        return precoFinal;

    }

    public boolean podeParcelar(CompraDTO parcelado) {
        return calcularValorSemParcelar(parcelado) >= 60;
    }

    @Override
    public CompraDTO calcularValor(CompraDTO compra) {
        if (podeParcelar(compra) && numParcelas>1) {
            float valorParcela = calcularValorSemParcelar(compra) / numParcelas;
            float precoComTaxaParcela = valorParcela + getTaxa();
            float precoFinal = precoComTaxaParcela * getNumeroDeParcelas();
            compra.setTotal(precoFinal);
            return compra;
        } else {
            compra.setTotal(calcularValorSemParcelar(compra));
            return compra;

        }
    }
}
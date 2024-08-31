package model;

import dto.CompraDTO;
import dto.IngressoDTO;

public class CartaoDeCredito implements FormaDePagamento{

    private int numParcelas;
    private float taxa;

    public void setNumParcelas(int numParcelas){
        this.numParcelas = numParcelas;

    }
    public void setTaxa(float taxa){
        this.taxa = taxa;

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
        float precoFinal= 0;

        for(IngressoDTO ingresso: compra.getIngressos()){
            if(ingresso.getCliente().getIdade() <= 6){
                 float preco = 0;
                 precoFinal+=preco;

            }else{
            float preco=ingresso.getPreco();
            precoFinal+=preco;
            }
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
}
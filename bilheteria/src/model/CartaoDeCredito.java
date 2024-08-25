package model;

import dto.IngressoDTO;

public class CartaoDeCredito implements FormaDePagamento{

    private int numParcelas;
    private float taxa;

    @Override
    public int  getNumeroDeParcelas() {
        return numParcelas;
    }
    @Override
    public float  getTaxa() {
        return taxa;
    }
	@Override
	public void calcularValor(IngressoDTO ingresso) {
		 float valorParcela=ingresso.getPreco() / getNumeroDeParcelas();
		 float preco= valorParcela+getTaxa();
	     float precoFinal = preco*getNumeroDeParcelas();
	     ingresso.setPreco(precoFinal);		
	}
}
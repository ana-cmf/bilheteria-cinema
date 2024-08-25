package model;

import dto.IngressoDTO;

public class Dinheiro implements FormaDePagamento{
    private int numParcelas;
    private float taxa;

    public Dinheiro(){
        this.numParcelas=1;
        this.taxa=0;
    }
    public int  getNumeroDeParcelas() {
        return numParcelas;
    }
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
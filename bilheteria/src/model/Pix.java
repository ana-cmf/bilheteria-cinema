package model;

import dto.CompraDTO;
import dto.IngressoDTO;

public class Pix implements FormaDePagamento{

    private int numParcelas;
    private float taxa;

    public Pix(){
        this.numParcelas=1;
        this.taxa=0;
    }
    @Override
    public int  getNumeroDeParcelas() {
        return numParcelas;
    }
    @Override
    public float  getTaxa() {
        return taxa;
    }
    public void setNumParcelas(int numParcelas) {
        this.numParcelas = numParcelas;
    }
    public void setTaxa(float taxa) {
        this.taxa = taxa;
    }
    @Override
	public CompraDTO calcularValor(CompraDTO compra) {
		float precoFinal= 0;
        for(IngressoDTO ingresso: compra.getIngressos()){
		    float preco=ingresso.getPreco();
	        precoFinal+=preco;
        }
        compra.setTotal(precoFinal);
        return compra;
        }
    }
    
   

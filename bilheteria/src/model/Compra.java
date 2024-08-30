package model;

import dto.CompraDTO;
import dto.IngressoDTO;

public class Compra {
    private IngressoDTO[] ingresso;
    private float Total;
    private FormaDePagamento formaDePagamento;

    

    public IngressoDTO[] getIngresso() {
        return ingresso;
    }

    public void setIngresso(IngressoDTO[] ingresso) {
        this.ingresso = ingresso;
    }

    public float getPrecoFinal() {
        return Total;
    }

    public void setPrecoFinal(float Total) {
        this.Total = Total;
    }

    public void adicionarIngresso(){
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float total) {
        Total = total;
    }

    public FormaDePagamento getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }
    public void calcularValorCompra( ){
        CompraDTO dto = new CompraDTO();
        dto.setIngressos(ingresso);
        setTotal(formaDePagamento.calcularValor(dto).getTotal());
    }
}

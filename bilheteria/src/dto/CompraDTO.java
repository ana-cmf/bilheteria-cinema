package dto;


public class CompraDTO {
    private IngressoDTO[] ingressos;
    private float total;
    private FormaDePagamentoDTO formaDePagamento;
    

    public IngressoDTO[] getIngressos() {
        return ingressos;
    }

    public void setIngressos(IngressoDTO[] ingressos) {
        this.ingressos = ingressos;
    }

    public float getTotal() {
        return total;
    }

    public void  setTotal(float total) {
        this.total = total;
    }

    public FormaDePagamentoDTO getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(FormaDePagamentoDTO formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

}

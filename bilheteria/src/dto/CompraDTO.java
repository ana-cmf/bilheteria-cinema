package dto;

import java.util.List;


public class CompraDTO {
    private List <IngressoDTO> ingressos;
    private float total;
    private FormaDePagamentoDTO formaDePagamento;
    private Long id;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List <IngressoDTO> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<IngressoDTO> ingressos) {
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

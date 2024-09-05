package model;

import dto.CompraDTO;
import dto.IngressoDTO;
import java.util.ArrayList;
import java.util.List;
import model.execption.CpfInvalidoException;
import model.execption.EmailInvalidoException;


public class Compra {
    private List<Ingresso> ingressos;
    private float total;
    private FormaDePagamento formaDePagamento;
    private Long id;

    
    public Compra() {
        this.id = System.currentTimeMillis();
        this.ingressos = new ArrayList<>();
    }
    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }


    public void adicionarIngresso(IngressoDTO dto) throws EmailInvalidoException, CpfInvalidoException {
        if (dto != null) {
            Ingresso ingresso = Ingresso.fromDTO(dto);
            ingressos.add(ingresso);
        }
    }
    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public FormaDePagamento getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return String.format(
            "Compra{ID=%d, Total=%.2f, Forma de Pagamento=%s, Ingressos=%s}",
            id,
            total,
            formaDePagamento != null ? formaDePagamento.getClass().getSimpleName() : "Nenhuma",
            ingressos.stream()
                     .map(Ingresso::toString)
                     .reduce((s1, s2) -> s1 + "\n" + s2)
                     .orElse("Nenhum ingresso"));
    }
    public void calcularValorCompra() {
        CompraDTO dto = new CompraDTO();
        List<IngressoDTO> ingressoDTOs = new ArrayList<>();

        for (Ingresso ingresso : ingressos) {
            dto.getIngressos().add(ingresso.toDTO());

        }
        dto.setIngressos(ingressoDTOs);
        CompraDTO resultadoDTO = formaDePagamento.calcularValor(dto);
        setTotal(resultadoDTO.getTotal());
    }
}

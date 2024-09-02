package model;

import java.time.LocalDateTime;
public class Exibicao {
    private Long id;
    private Filme filme;
    private SalaDeExibicao salaDeExibicao;
    private boolean legendado;
    private LocalDateTime horario;
    
    
    public Exibicao(Long id){
        this.id = System.currentTimeMillis();
    }
    public Filme getFilme() {
        return filme;
    }
    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    public SalaDeExibicao getSalaDeExibicao() {
        return salaDeExibicao;
    }
    public void setSalaDeExibicao(SalaDeExibicao salaDeExibicao) {
        this.salaDeExibicao = salaDeExibicao;
    }
    public boolean isLegendado() {
        return legendado;
    }
    public void setLegendado(boolean legendado) {
        this.legendado = legendado;
    }
    public LocalDateTime getHorario() {
        return horario;
    }
    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public boolean verificaConflitoDeHorario(Exibicao novaExibicao, Exibicao[] exibicoesExistentes) {
        for (Exibicao exibicaoExistente : exibicoesExistentes) {
            if (exibicaoExistente != null && exibicaoExistente.getSalaDeExibicao().equals(novaExibicao.getSalaDeExibicao()) &&
                exibicaoExistente.getHorario().equals(novaExibicao.getHorario())) {
                return true;
            }
        }
        return false;
    }
    public boolean verificarAssentoIsDisponivel(int numeroAssento) {
        if (numeroAssento <1 || numeroAssento < salaDeExibicao.getAssentos().length) {
            return false;
        }
        Assento assento = salaDeExibicao.getAssentos()[numeroAssento - 1];
        return !assento.isReservado();
    }
    public boolean isSecaoJaExibida() {
        return horario.isBefore(LocalDateTime.now());
    }
}
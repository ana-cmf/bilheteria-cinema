package dto;

import java.time.LocalDateTime;


public class ExibicaoDTO {
    private FilmeDTO filme;
    private SalaDeExibicaoDTO salaDeExibicao;
    private boolean legendado;
    private LocalDateTime horario;    
    
    public FilmeDTO getFilme() {
        return filme;
    }
    public void setFilme(FilmeDTO filme) {
        this.filme = filme;
    }
    public SalaDeExibicaoDTO getSalaDeExibicao() {
        return salaDeExibicao;
    }
    public void setSalaDeExibicao(SalaDeExibicaoDTO salaDeExibicao) {
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
} 

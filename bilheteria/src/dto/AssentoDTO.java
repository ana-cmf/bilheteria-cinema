package dto;
public class AssentoDTO {
    private SalaDeExibicaoDTO salaDeExibicao;
    private int posicao;
    private boolean reservado;

    public SalaDeExibicaoDTO getSalaDeExibicao() {
        return salaDeExibicao;
    }

    public void setSalaDeExibicao(SalaDeExibicaoDTO salaDeExibicao) {
        this.salaDeExibicao = salaDeExibicao;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }
}

package model;

public class Assento {
    private Long id;
    private int posicao;
    private boolean reservado;

    public Assento(Long id) {
	    this.id = System.currentTimeMillis();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
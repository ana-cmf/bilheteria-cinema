package model;

import model.execption.AssentoJaReservadoException;

public class Assento {
    private int posicao;
    private boolean reservado;
    
    public Assento(int posicao){
        this.posicao = posicao;
        this.reservado = false;
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
    public void reservar() throws AssentoJaReservadoException {
        if (reservado) {
            throw new AssentoJaReservadoException();
        }
        reservado = true;
    }
}
package model;

import execption.AssentoJaReservadoException;

public class Assento {
    private int posicao;
    private boolean reservado;
    
    public Assento(){
        this.posicao = posicao;
        this.reservado = false;
    }
   
    public int getPosicao() {
        return posicao;
    }
    public void  setPosicao(int posicao) {
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
    public void reservarAssento(Assento numeroAssento) throws AssentoJaReservadoException {
        if(numeroAssento.isReservado() == true){
            throw new AssentoJaReservadoException();
        }else{
            numeroAssento.reservar();
        }
    }
}
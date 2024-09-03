package model;

import model.execption.AssentoJaReservadoException;

public class Assento {
    private Long id;
    private int posicao;
    private boolean reservado;
    
    public Assento(){
        this.posicao = posicao;
        this.reservado = false;
    }
   
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
package model;

import dto.AssentoDTO;
import model.execption.AssentoJaReservadoException;

public class Assento {
    private Long id;
    private int posicao;
    private boolean reservado;
    
    public Assento(int posicao){
        this.posicao = posicao;
        this.reservado = false;

    }
    public Assento() {
        this.id = System.currentTimeMillis();
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
    public void reservarAssento() throws AssentoJaReservadoException {
        if (reservado == true) {
            throw new AssentoJaReservadoException();
        }
        reservado = true;
    }
    @Override
    public String toString() {
        return String.format(
            "Assento{ID=%d, Posição=%d, Reservado=%s}",
            id, posicao, reservado ? "Sim" : "Não"
        );
}
	public static Assento fromDTO(AssentoDTO dto) {
	        Assento assento = new Assento();
	        assento.setId(dto.getId());
	        assento.setPosicao(dto.getPosicao());
	        assento.setReservado(dto.isReservado());
	        return assento;
	    }
	
	    public AssentoDTO toDTO() {
	        AssentoDTO dto = new AssentoDTO();
	        dto.setId(this.id);
	        dto.setPosicao(this.posicao);
	        dto.setReservado(this.reservado);
	        return dto;
	    }
}
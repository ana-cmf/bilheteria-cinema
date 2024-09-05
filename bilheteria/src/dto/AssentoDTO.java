package dto;
public class AssentoDTO {
    private Long id; 
    private SalaDeExibicaoDTO salaDeExibicao;
    private int posicao;
    private boolean reservado;
    
    public AssentoDTO(Long id, SalaDeExibicaoDTO salaDeExibicao, int posicao, boolean reservado) {
		super();
		this.id = id;
		this.salaDeExibicao = salaDeExibicao;
		this.posicao = posicao;
		this.reservado = reservado;
	}
    public AssentoDTO() {
    	
    }
	public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
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
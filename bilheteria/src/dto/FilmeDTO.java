package dto;

public class FilmeDTO {
    private Long id;
    private String titulo;
	private String sinopse;
    private String genero;
    private int duracaoDoFilme;
    private int classificacaoIndicativa;

    public FilmeDTO(Long id, String titulo, String sinopse, String genero, int duracaoDoFilme, int classificacaoIndicativa) {
    	this.id = id;
    	this.titulo = titulo;
    	this.sinopse = sinopse;
    	this.genero = genero;
    	this.duracaoDoFilme = duracaoDoFilme;
    	this.classificacaoIndicativa = classificacaoIndicativa;
    }
    public FilmeDTO(Long id) {
	    this.id = id;
    }
    public FilmeDTO() {
    	
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getSinopse() {
        return sinopse;
    }
    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getDuracaoDoFilme() {
        return duracaoDoFilme;
    }
    public void setDuracaoDoFilme(int duracaoDoFilme) {
        this.duracaoDoFilme = duracaoDoFilme;
    }
    public int getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }
    public void setClassificacaoIndicativa(int classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }  
}
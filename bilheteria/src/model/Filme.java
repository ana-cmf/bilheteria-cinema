package model;

import dto.FilmeDTO;

public class Filme {
    private Long id;
    private String titulo;
    private String genero;
    private int duracaoDoFilme;
    private int classificacaoIndicativa;

    public Filme() {
	    this.id = System.currentTimeMillis();
    }
    public Filme(Long id) {
        this.id = id;
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
    @Override
    public String toString() {
        return String.format("Filme{ID=%d, Titulo='%s', Genero='%s', Duracao=%d minutos, Classificacao Indicativa=%d}",
                             id, titulo, genero, duracaoDoFilme, classificacaoIndicativa);
    }
    public static Filme fromDTO(FilmeDTO dto) {
        Filme filme = new Filme();
        filme.setId(dto.getId());
        filme.setTitulo(dto.getTitulo());
        filme.setClassificacaoIndicativa(dto.getClassificacaoIndicativa());
        filme.setDuracaoDoFilme(dto.getDuracaoDoFilme());
        filme.setGenero(dto.getGenero());
        return filme;
    }

    public FilmeDTO toDTO() {
        FilmeDTO dto = new FilmeDTO();
        dto.setId(this.id);
        dto.setTitulo(this.titulo);
        dto.setClassificacaoIndicativa(this.classificacaoIndicativa);
        dto.setDuracaoDoFilme(this.duracaoDoFilme);
        dto.setGenero(this.genero);
        return dto;
    }
}

package model;

import dto.FilmeDTO;
import dto.IngressoDTO;
import model.execption.ClassificacaoNaoIndicadaException;


public class Filme {
    private Long id;
    private String titulo;
    private String genero;
    private int duracaoDoFilme;
    private int classificacaoIndicativa;

<<<<<<< HEAD

    
    public Filme() {
=======
    public Filme(Long id) {
>>>>>>> Yasmin
	    this.id = System.currentTimeMillis();
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
    public void classificacaoIndicadaPelaIdade(IngressoDTO ingresso)throws ClassificacaoNaoIndicadaException{
        int indicado =ingresso.getCliente().getIdade();

        if(classificacaoIndicativa > 6){
            if (indicado < 10) {
                throw new ClassificacaoNaoIndicadaException();
            }
            if (indicado < 12) {
                throw new ClassificacaoNaoIndicadaException();
            }
            if (indicado < 14) {
                throw new ClassificacaoNaoIndicadaException();
            }
            if (indicado < 16) {
                throw new ClassificacaoNaoIndicadaException();
            }
            if (indicado < 18) {
                throw new ClassificacaoNaoIndicadaException();
            }
        else if (classificacaoIndicativa<6) {
            System.out.println("Classificação Indicativa Livre");
            }
        }
    }
}

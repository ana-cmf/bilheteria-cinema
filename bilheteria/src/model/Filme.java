package model;

import dto.CompraDTO;
import dto.IngressoDTO;
import model.execption.ClassificacaoNaoIndicadaException;


public class Filme {
    private Long id;
    private String titulo;
    private String genero;
    private int duracaoDoFilme;
    private int classificacaoIndicativa;


    
    public Filme(Long id) {
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

        switch(classificacaoIndicativa){
            case 0:
                break;
        case 10:
            if (indicado < 10) {
                throw new ClassificacaoNaoIndicadaException();
            }
            break;
        case 12:
            if (indicado < 12) {
                throw new ClassificacaoNaoIndicadaException();
            }
            break;
        case 14:
            if (indicado < 14) {
                throw new ClassificacaoNaoIndicadaException();
            }
            break;
        case 16:
            if (indicado < 16) {
                throw new ClassificacaoNaoIndicadaException();
            }
            break;
        case 18:
            if (indicado < 18) {
                throw new ClassificacaoNaoIndicadaException();
            }
            break;
        default:
            throw new IllegalArgumentException("Classificação indicativa desconhecida.");
        }
    }
}

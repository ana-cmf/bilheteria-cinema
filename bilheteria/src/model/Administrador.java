package model;

import dto.AssentoDTO;
import dto.ExibicaoDTO;
import dto.FilmeDTO;
import dto.FuncionarioDTO;
import dto.ModeloDeExibicaoDTO;
import dto.SalaDeExibicaoDTO;
import java.time.LocalDateTime;

public class Administrador {
    private static Administrador instancia;
    private String nomeUsuario;
    private String senha;


    public static Administrador getInstancia(){
      if(instancia ==null){
        instancia = new Administrador();
        }
        return instancia;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public FuncionarioDTO CadastrarFuncionario(String nome,int CPF, String senha, String email){
        FuncionarioDTO funcionario = new FuncionarioDTO();
        funcionario.setNomeCompleto(nome);
        funcionario.setCPF(CPF);
        funcionario.setSenha(senha);
        funcionario.setEmail(email);
        return funcionario;

    }

    
    public FilmeDTO CadastrarFilme( Long id, String titulo, String genero,int  duracaoDoFilme,int classificacaoIndicativa){
        FilmeDTO filme = new FilmeDTO(id);
        filme.setTitulo(titulo);
        filme.setGenero(genero);
        filme.setDuracaoDoFilme(duracaoDoFilme);
        filme.setClassificacaoIndicativa(classificacaoIndicativa);
        return filme;


    }
    public SalaDeExibicaoDTO CadastrarNovaSalaDeExibicao(int numeroDaSala, ModeloDeExibicaoDTO modeloDeExibicao, AssentoDTO [] [] assentos){
        SalaDeExibicaoDTO sala= new SalaDeExibicaoDTO(assentos);
        sala.setNumeroDaSala(numeroDaSala);
        sala.setModeloDeExibicao(modeloDeExibicao);
        sala.setQuantidadeDeAssentos(assentos.length);
        return sala;
    }
    public ExibicaoDTO CriarNovaExibicaoFilme(FilmeDTO filme, SalaDeExibicaoDTO sala, boolean legendado, LocalDateTime horario){
        ExibicaoDTO exibicao = new ExibicaoDTO();
        exibicao.setFilme(filme);
        exibicao.setSalaDeExibicao(sala);
        exibicao.setLegendado(legendado);
        exibicao.setHorario(horario);
        return exibicao;


    }
    public void AutenticarAdministrador(){ 

    }
    public void EditarFuncionario(String nome, String senha,String email){

    }
    public void ExcluirFilme(){
        
    }
    }

package model;

import model.execption.SenhaInvalidaException;

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

    public void setSenha(String senha) throws SenhaInvalidaException{
        if(senha.length()<6){
            throw new SenhaInvalidaException();
        }
        this.senha = senha;
        }
}

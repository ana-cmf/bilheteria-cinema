package model;

import model.execption.EmailInvalidoExecption;
import model.execption.SenhaInvalidaException;

public class Funcionario {
    private String nomeCompleto;
    private int CPF;
    private String senha;
    private String email;
    
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    public int getCPF() {
        return CPF;
    }
    public void setCPF(int cPF) {
        CPF = cPF;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) throws EmailInvalidoExecption{
        if(!(email.contains("@")) || !(email.contains("."))){
            throw new EmailInvalidoExecption();
        }
        this.email = email;
    }
}

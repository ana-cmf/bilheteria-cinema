package model;

import model.execption.CpfInvalidoException;
import model.execption.CpfInvalidoExexption;
import model.execption.EmailInvalidoException;
import model.execption.EmailInvalidoExecption;
import model.execption.SenhaInvalidaException;

public class Funcionario {
    private String nomeCompleto;
    private String CPF;
    private String senha;
    private String email;
    
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String cpf) throws CpfInvalidoException {
       ValidacaoCPF num= new ValidacaoCPF();
       if (num.CPFIsValido(cpf)){
            this.CPF = cpf;
       }else{
         throw  new CpfInvalidoException();

       }
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
    public void setEmail(String email) throws EmailInvalidoException{
        if(!(email.contains("@")) || !(email.contains("."))){
            throw new EmailInvalidoException();
        }
        this.email = email;
    }
}

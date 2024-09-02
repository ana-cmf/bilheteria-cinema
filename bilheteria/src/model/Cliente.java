package model;

import execption.CpfInvalidoException;
import execption.EmailInvalidoException;
public class Cliente{
    private String nomeCompleto;
    private String CPF;
    private String email;
    private int idade;


    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cpf) throws CpfInvalidoException{
        ValidacaoCPF num= new ValidacaoCPF();
       if (num.CPFIsValido(cpf)){
            this.CPF = cpf;
       }else{
            throw  new CpfInvalidoException();
        
       }
    }

    public String getEmail()  {
        return email;
    }

    public void setEmail(String email) throws EmailInvalidoException{
        if(!(email.contains("@")) || !(email.contains("."))){
            throw new EmailInvalidoException();
        }
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}

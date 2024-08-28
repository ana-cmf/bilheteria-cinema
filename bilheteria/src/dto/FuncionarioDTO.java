package dto;

public class FuncionarioDTO {
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
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

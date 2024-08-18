package dto;

public class FuncionarioDTO {
    private String nomeCompleto;
    private int CPF;
    private int senha;
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
    public int getSenha() {
        return senha;
    }
    public void setSenha(int i) {
        this.senha = i;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

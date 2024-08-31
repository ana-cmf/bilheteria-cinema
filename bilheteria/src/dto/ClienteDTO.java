package dto;

public class ClienteDTO {

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
    public void setCPF(String cpf) {
        CPF = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
}

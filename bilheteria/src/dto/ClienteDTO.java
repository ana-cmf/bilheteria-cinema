package dto;

public class ClienteDTO {

    private String nomeCompleto;
    private String CPF;
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
    public void setCPF(String cpf) {
        CPF = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

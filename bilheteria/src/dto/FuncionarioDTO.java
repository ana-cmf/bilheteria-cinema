package dto;

public class FuncionarioDTO {
    private String nomeCompleto;
    private String CPF;
    private String senha;
    private String email;
    
    public FuncionarioDTO(String nomeCompleto, String cpf, String senha, String email) {
		this.nomeCompleto = nomeCompleto;
		this.CPF = cpf;
		this.senha = senha;
		this.email = email;
	}
    public FuncionarioDTO() {
    	
    }
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

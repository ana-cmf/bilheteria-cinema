package dto;

import java.util.List;
import model.Ingresso;

public class ClienteDTO {

    private String nomeCompleto;
    private String CPF;
    private String email;
    private List<Ingresso> ingressos;


    public ClienteDTO(String nomeCompleto, String cPF, String email, int idade) {
		this.nomeCompleto = nomeCompleto;
		CPF = cPF;
		this.email = email;
    	}
    public ClienteDTO() {
    	
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }
}

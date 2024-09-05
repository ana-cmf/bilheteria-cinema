package model;

import dto.ClienteDTO;
import java.util.List;
import model.execption.CpfInvalidoException;
import model.execption.EmailInvalidoException;
public class Cliente{
    private String nomeCompleto;
    private String CPF;
    private String email;
    private List<Ingresso> ingressos;
    

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
    @Override
    public String toString() {
        return String.format("Cliente{Nome Completo='%s', CPF='%s', Email='%s'}",
                nomeCompleto, CPF, email);
    }
    public static Cliente fromDTO(ClienteDTO dto) throws EmailInvalidoException, CpfInvalidoException {
        Cliente cliente = new Cliente();
        cliente.setNomeCompleto(dto.getNomeCompleto());
        cliente.setEmail(dto.getEmail());
        cliente.setCPF(dto.getCPF());
        return cliente;
    }

    public ClienteDTO toDTO() {
        ClienteDTO dto = new ClienteDTO();
        dto.setNomeCompleto(this.nomeCompleto);
        dto.setEmail(this.email);
        dto.setCPF(this.CPF);
        return dto;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }
}

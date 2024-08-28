package model;

import dto.ClienteDTO;

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
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public ClienteDTO Cadastrarcliente (String nomeCompleto, int CPF, String email) {
        ClienteDTO cliente = new ClienteDTO();
        cliente.setNomeCompleto(nomeCompleto);
        cliente.setCPF(CPF);
        cliente.setEmail(email);
        return cliente;
    }
    public void VerPerfil(String nomeCompleto, int CPF, String email) {

}
    public void AutenticarFuncionario(String email, String senha){

    }
    public void AlterarInformacoesCliente(){

    }
    public void FinalizarCompra(){

    }
    public void CancelarCompra(){
        
    }
}

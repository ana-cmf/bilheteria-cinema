package controller;

import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import dto.ClienteDTO;
import model.Cliente;
import model.execption.CpfInvalidoException;
import model.execption.EmailInvalidoException;

public class ClienteController{
    private Cliente cliente;
    private ClienteDAO clientedao;

    public ClienteController(){
        this.clientedao = new ClienteDAOImpl();
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public ClienteDAO getClientedao() {
        return clientedao;
    }
    public void setClientedao(ClienteDAO clientedao) {
        this.clientedao = clientedao;
    }
    public void cadastrarClienteController(ClienteDTO dto){
        cliente.setNomeCompleto(dto.getNomeCompleto());
        try {
            cliente.setCPF(dto.getCPF());
        } catch (CpfInvalidoException ex) {
        }
        try {
            cliente.setEmail(dto.getEmail());
        } catch (EmailInvalidoException ex) {
        }
        clientedao.cadastrarCliente(dto);
    }
    public void excluirClienteController(ClienteDTO dto){
        dto.setCPF(cliente.getCPF());
        clientedao.excluirCliente(dto);
    }
    
}
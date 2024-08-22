package dao;

import dto.ClienteDTO;

public interface ClienteDAO {

    public void cadastrarCliente(ClienteDTO cliente);
    public void excluirCliente(ClienteDTO cliente);
}

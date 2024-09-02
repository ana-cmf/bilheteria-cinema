package dao;

import java.sql.SQLException;
import java.util.List;
import dto.ClienteDTO;

public interface ClienteDAO {

    public void cadastrarCliente(ClienteDTO cliente);
    public void excluirCliente(ClienteDTO cliente);
    public List<ClienteDTO> listarTodosClientes() throws SQLException;
}

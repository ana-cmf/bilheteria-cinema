package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ClienteDTO;

public class ClienteDAOImpl implements ClienteDAO {

    public void cadastrarCliente(ClienteDTO cliente) {
       String sql = "INSERT INTO bilheteria.cliente (nome_completo_cliente, cpf_cliente, email_cliente) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getNomeCompleto());
            pstmt.setString(2, cliente.getCPF());
            pstmt.setString(4, cliente.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    public void excluirCliente(ClienteDTO cliente) {
        
        String sql = "DELETE FROM bilheteria.cliente WHERE cpf_cliente = ?";
    
        try (Connection conn = ConexaoBancoDeDados.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setString(1, cliente.getCPF());
    
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<ClienteDTO> listarTodosClientes() throws SQLException {
        String sql = "SELECT * FROM bilheteria.cliente";
        List<ClienteDTO> clientes = new ArrayList<>();

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                ClienteDTO cliente = new ClienteDTO();
                cliente.setCPF(rs.getString("cpf_cliente"));
                cliente.setNomeCompleto(rs.getString("nome_completo_cliente"));
                // Povoar os outros campos, como email, etc.
                clientes.add(cliente);
            }
        }
        return clientes;
    }
}
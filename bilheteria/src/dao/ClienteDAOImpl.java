package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.ClienteDTO;

public class ClienteDAOImpl implements ClienteDAO {

    public void cadastrarCliente(ClienteDTO cliente) {
       String sql = "INSERT INTO bilheteria.cliente (nome_completo, cpf, email) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getNomeCompleto());
            pstmt.setInt(2, cliente.getCPF());
            pstmt.setString(4, cliente.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public void excluirCliente(ClienteDTO cliente) {
        
        String sql = "DELETE FROM bilheteria.cliente WHERE cpf = ?";
    
        try (Connection conn = ConexaoBancoDeDados.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setInt(1, cliente.getCPF());
    
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }       
}
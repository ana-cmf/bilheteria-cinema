package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dto.AdministradorDTO;

public class AdministradorDAOImpl implements AdministradorDAO {

    @Override
    public void cadastrarAdministrador(AdministradorDTO administrador) {
        String sql = "INSERT INTO bilheteria.administrador (nome_usuario_admin, senha_admin) VALUES (?, ?)";

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, administrador.getNomeUsuario());
            pstmt.setString(2, administrador.getSenha());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    
    @Override
    public void excluirAdministrador(AdministradorDTO administrador) {
        String sql = "DELETE FROM bilheteria.administrador WHERE nome_usuario_admin = ? AND senha_admin = ?";
    
        try (Connection conn = ConexaoBancoDeDados.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, administrador.getNomeUsuario());
            pstmt.setString(2, administrador.getSenha());
    
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean autenticarAdministrador(AdministradorDTO administrador) {
        String sql = "SELECT COUNT(*) FROM bilheteria.administrador WHERE nome_usuario_admin = ? AND senha_admin = ?";

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            pstmt.setString(1, administrador.getNomeUsuario());
            pstmt.setString(2, administrador.getSenha());

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean buscarAdminstrador() {
        String verificarSql = "SELECT COUNT(*) FROM bilheteria.administrador";
        String inserirSql = "INSERT INTO bilheteria.administrador (nome_usuario_admin, senha_admin) VALUES (?, ?)";
    
        try (Connection conn = ConexaoBancoDeDados.conectar();
             PreparedStatement verificarPstmt = conn.prepareStatement(verificarSql);
             PreparedStatement inserirPstmt = conn.prepareStatement(inserirSql)) {
    
            ResultSet rs = verificarPstmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
    
            if (count > 0) {
                System.out.println("Já existe um administrador cadastrado");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }   
}
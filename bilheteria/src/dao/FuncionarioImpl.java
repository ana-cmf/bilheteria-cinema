package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dto.FuncionarioDTO;

public class FuncionarioImpl implements FucionarioDAO {

    public void cadastrarFuncionario(FuncionarioDTO funcionario) {
        String sql = "INSERT INTO bilheteria.funcionario (nome_completo_funcionario, cpf_funcionario, senha_funcionario, email_funcionario) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, funcionario.getNomeCompleto());
            pstmt.setInt(2, funcionario.getCPF());
            pstmt.setString(3, funcionario.getSenha());
            pstmt.setString(4, funcionario.getEmail());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editarInformacoesFuncionario(FuncionarioDTO funcionario) {
        String sql = "UPDATE bilheteria.funcionario SET nome_completo_funcionario = ?, senha_funcionario = ?,  email_funcionario = ?, cpf_funcionario = ?";

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, funcionario.getNomeCompleto());
            pstmt.setString(2, funcionario.getSenha());
            pstmt.setString(3, funcionario.getEmail());
            pstmt.setInt(4, funcionario.getCPF());
            

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirFuncionario(FuncionarioDTO funcionario) {
        
        String sql = "DELETE FROM bilheteria.funcionario WHERE cpf_funcionario = ?";
    
        try (Connection conn = ConexaoBancoDeDados.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setInt(1, funcionario.getCPF());
    
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
}

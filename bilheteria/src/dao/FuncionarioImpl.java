package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dto.FuncionarioDTO;

public class FuncionarioImpl implements FucionarioDAO {

    public void cadastrarFuncionario(FuncionarioDTO funcionario) {
        String sql = "INSERT INTO bilheteria.funcionarios (nome_completo, cpf, senha) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, funcionario.getNomeCompleto());
            pstmt.setInt(2, funcionario.getCPF());
            pstmt.setInt(3, funcionario.getSenha());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editarInformacoesFuncionario(FuncionarioDTO funcionario) {
        String sql = "UPDATE bilheteria.funcionarios SET nome_completo = ?, senha = ? WHERE cpf = ?";

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, funcionario.getNomeCompleto());
            pstmt.setInt(2, funcionario.getSenha());
            pstmt.setInt(3, funcionario.getCPF());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

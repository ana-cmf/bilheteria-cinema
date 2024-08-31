package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.ExibicaoDTO;

public class ExibicaoDAOImpl implements ExibicaoDAO {

    @Override
    public void adicionarExibicao(ExibicaoDTO exibicao) {
        
    }

    @Override
    public void excluirExibicao(ExibicaoDTO exibicao) {
         String sql = "DELETE FROM bilheteria.exibicao WHERE id_exibicao = ?";

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
    //      pstmt.setLong(1, exibicao.getId()));

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }   
}

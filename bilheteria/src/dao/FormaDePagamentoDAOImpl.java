package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dto.FormaDePagamentoDTO;

public class FormaDePagamentoDAOImpl implements FormaDePagamentoDAO {

    @Override
    public void adicionarPagamento(FormaDePagamentoDTO pagamento) {
     
    }

    @Override
    public void excluirPagamento(FormaDePagamentoDTO pagamento) {
        String sql = "DELETE FROM bilheteria.pagamento WHERE id_forma_pagamento = ?";

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

           
      //    pstmt.setInt(1, pagamento.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

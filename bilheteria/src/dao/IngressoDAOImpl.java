package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dto.IngressoDTO;

public class IngressoDAOImpl implements IngressoDAO {

    @Override
    public void adicionarIngresso(IngressoDTO ingresso) {
        String sql = "INSERT INTO bilheteria.filme (id_ingresso, preco_ingresso, pagamento_realizado_ingresso, id_tipo_entrada, id_exibicao, id_assento) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, ingresso.getId());
            pstmt.setFloat(2, ingresso.getPreco());
            pstmt.setBoolean(3, ingresso.isPagamentoRealizado());
            // id_tipo_entrada
            pstmt.setLong(4, ingresso.getExibicao().getId());
            pstmt.setLong(5, ingresso.getAssento().getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluirIngresso(IngressoDTO ingresso) {
        String sql = "DELETE FROM bilheteria.ingresso WHERE id_assento = ? AND id_exibicao = ?";
    
        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
       
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
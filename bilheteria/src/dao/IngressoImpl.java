package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.IngressoDTO;

public class IngressoImpl implements IngressoDAO {

    @Override
    public void adicionarIngresso(IngressoDTO ingresso) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionarIngresso'");
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

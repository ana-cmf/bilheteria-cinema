package dao;

import dto.AssentoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssentoDAOImpl implements AssentoDAO {

    @Override
    public void adicionarAssento(AssentoDTO assento) {
        String sql = "INSERT INTO bilheteria.assento (numero_sala, posicao_assento, reservado) VALUES (?, ?, ?)";
    
        try (Connection conn = ConexaoBancoDeDados.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, assento.getSalaDeExibicao().getNumeroDaSala());
            pstmt.setInt(2, assento.getPosicao());
            pstmt.setBoolean(3, assento.isReservado());
    
            pstmt.executeUpdate();
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<AssentoDTO> buscarAssento(AssentoDTO assento) {
        String sql = "SELECT posicao_assento, reservado FROM bilheteria.assento WHERE numero_sala = ?";
        List<AssentoDTO> assentos = new ArrayList<>();

        try (Connection conn = ConexaoBancoDeDados.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, assento.getPosicao());
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    AssentoDTO lugares = new AssentoDTO();
                    lugares.setPosicao(rs.getInt("posicao_assento"));
                    lugares.setReservado(rs.getBoolean("reservado"));
                    assentos.add(lugares);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return assentos;
    }  
}

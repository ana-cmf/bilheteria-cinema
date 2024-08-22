package dao;

import dto.AssentoDTO;
import dto.SalaDeExibicaoDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssentoDAOImpl implements AssentoDAO {

    public List<AssentoDTO> buscarAssento(SalaDeExibicaoDTO sala) {
        String sql = "SELECT posicao, reservado FROM bilheteria.assento WHERE numero_sala = ?";
        List<AssentoDTO> assentos = new ArrayList<>();

        try (Connection conn = ConexaoBancoDeDados.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, sala.getNumeroDaSala());
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    AssentoDTO assento = new AssentoDTO();
                    assento.setPosicao(rs.getInt("posicao"));
                    assento.setReservado(rs.getBoolean("reservado"));
                    assentos.add(assento);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return assentos;
    }
}

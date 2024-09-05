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

    @Override
    public List<AssentoDTO> buscarAssento(SalaDeExibicaoDTO sala) {
        String sql = "SELECT id_assento, posicao_assento, reservado FROM bilheteria.assento WHERE numero_sala = ?";
        List<AssentoDTO> assentos = new ArrayList<>();

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, sala.getNumeroDaSala());
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    AssentoDTO assentoDTO = new AssentoDTO();
                    assentoDTO.setId(rs.getLong("id_assento"));
                    assentoDTO.setPosicao(rs.getInt("posicao_assento"));
                    assentoDTO.setReservado(rs.getBoolean("reservado"));
                    assentoDTO.setSalaDeExibicao(sala);
                    assentos.add(assentoDTO);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return assentos;
    }
}
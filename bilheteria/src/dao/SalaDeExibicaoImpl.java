package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dto.ModeloDeExibicaoDTO;
import dto.SalaDeExibicaoDTO;

public class SalaDeExibicaoImpl implements SalaDeExibicaoDAO {

    public void cadastrarSalaExibicao(SalaDeExibicaoDTO sala) {
        String sql = "INSERT INTO bilheteria.sala_exibicao (numero_sala, modelo_exibicao, quantidade_assentos) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBancoDeDados.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, sala.getNumeroDaSala());
            pstmt.setString(2, sala.getModeloDeExibicao().name());
            pstmt.setInt(3, sala.getQuantidadeDeAssentos());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SalaDeExibicaoDTO buscarSalaExibicao(SalaDeExibicaoDTO numeroDaSala) {
        String sql = "SELECT * FROM bilheteria.sala_exibicao WHERE numero_sala = ?";
        SalaDeExibicaoDTO sala = null;

        try (Connection conn = ConexaoBancoDeDados.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, numeroDaSala.getNumeroDaSala());
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                sala = new SalaDeExibicaoDTO();
                sala.setNumeroDaSala(rs.getInt("numero_sala"));
                String modeloExibicaoStr = rs.getString("modelo_exibicao");
                sala.setModeloDeExibicao(ModeloDeExibicaoDTO.valueOf(modeloExibicaoStr));
                sala.setQuantidadeDeAssentos(rs.getInt("quantidade_assentos"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sala;
    }

    
    public void excluirSalaExibicao(SalaDeExibicaoDTO sala) {
        
        String sql = "DELETE FROM bilheteria.sala_exibicao WHERE numero_sala = ?";
        
        try (Connection conn = ConexaoBancoDeDados.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setInt(1, sala.getNumeroDaSala());
    
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }  
}
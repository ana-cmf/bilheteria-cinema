package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.execao.SalaDeExibicaoNaoEncontradaException;
import dto.SalaDeExibicaoDTO;

public class SalaDeExibicaoDAOImpl implements SalaDeExibicaoDAO {

    public void cadastrarSalaExibicao(SalaDeExibicaoDTO sala) {
        String sql = "INSERT INTO bilheteria.sala_exibicao (numero_sala, quantidade_assentos) VALUES (?, ?)";

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, sala.getNumeroDaSala());
            pstmt.setInt(2, sala.getQuantidadeDeAssentos());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SalaDeExibicaoDTO buscarSalaExibicao(SalaDeExibicaoDTO numeroDaSala) throws SalaDeExibicaoNaoEncontradaException {
        String sql = "SELECT * FROM bilheteria.sala_exibicao WHERE numero_sala = ?";
        SalaDeExibicaoDTO sala = null;

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, numeroDaSala.getNumeroDaSala());
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                sala = new SalaDeExibicaoDTO();
                sala.setNumeroDaSala(rs.getInt("numero_sala"));
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

    @Override
    public List<SalaDeExibicaoDTO> listarTodasSalasDeExibicao() throws SQLException {
        String sql = "SELECT * FROM bilheteria.sala_exibicao";
        List<SalaDeExibicaoDTO> salas = new ArrayList<>();

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                SalaDeExibicaoDTO sala = new SalaDeExibicaoDTO();
                sala.setNumeroDaSala(rs.getInt("numero_sala"));
                salas.add(sala);
            }
        }
        return salas;
    }
}
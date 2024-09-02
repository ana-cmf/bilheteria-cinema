package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.exception.ExibicaoNaoEncontradaException;
import dto.ExibicaoDTO;
import dto.FilmeDTO;
import dto.SalaDeExibicaoDTO;

public class ExibicaoDAOImpl implements ExibicaoDAO {

    public void adicionarExibicao(ExibicaoDTO exibicao) {
        String sql = "INSERT INTO bilheteria.exibicao (id_exibicao, id_filme, numero_sala, legenda_exibicao, horario_exibicao) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setLong(1, exibicao.getId());
            pstmt.setLong(2, exibicao.getFilme().getId());
            pstmt.setInt(3, exibicao.getSalaDeExibicao().getNumeroDaSala());
            pstmt.setBoolean(4, exibicao.isLegendado());
            pstmt.setTimestamp(5, Timestamp.valueOf(exibicao.getHorario()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluirExibicao(ExibicaoDTO exibicao) {
        String sql = "DELETE FROM bilheteria.exibicao WHERE id_exibicao = ?";

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, exibicao.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ExibicaoDTO> listarTodasExibicoes() throws SQLException {
        String sql = "SELECT * FROM bilheteria.exibicao";
        List<ExibicaoDTO> exibicoes = new ArrayList<>();

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                ExibicaoDTO exibicao = new ExibicaoDTO();
                exibicao.setId(rs.getLong("id_exibicao"));
                exibicoes.add(exibicao);
            }
        }
        return exibicoes;
    }

    @Override
    public ExibicaoDTO buscarExibicao(ExibicaoDTO exibicao) throws ExibicaoNaoEncontradaException {
        String sql = "SELECT * FROM bilheteria.exibicao WHERE id_exibicao = ?";
        ExibicaoDTO exibicaoDTO = null;
    
        try (Connection conn = ConexaoBancoDeDados.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setLong(1, exibicao.getId());
            ResultSet rs = pstmt.executeQuery();
    
            if (rs.next()) {
                exibicaoDTO = new ExibicaoDTO();
                exibicaoDTO.setId(rs.getLong("id_exibicao"));
    
                FilmeDTO filme = new FilmeDTO(null);
                filme.setId(rs.getLong("id_filme"));
                exibicaoDTO.setFilme(filme);
    
                SalaDeExibicaoDTO sala = new SalaDeExibicaoDTO();
                sala.setNumeroDaSala(rs.getInt("numero_sala"));
                exibicaoDTO.setSalaDeExibicao(sala);
    
                exibicaoDTO.setLegendado(rs.getBoolean("legenda_exibicao"));
                exibicaoDTO.setHorario(rs.getObject("horario_exibicao", LocalDateTime.class));
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return exibicaoDTO;
    }   
}

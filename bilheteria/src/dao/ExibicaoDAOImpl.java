package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dto.ExibicaoDTO;

public class ExibicaoDAOImpl implements ExibicaoDAO {

    public void adicionarExibicao(ExibicaoDTO exibicao) {
        String sql = "INSERT INTO bilheteria.exibicao (id_filme, id_sala_exibicao, legendado, horario) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setLong(1, exibicao.getFilme().getId());
            pstmt.setInt(2, exibicao.getSalaDeExibicao().getNumeroDaSala());
            pstmt.setBoolean(3, exibicao.isLegendado());
            pstmt.setTimestamp(4, Timestamp.valueOf(exibicao.getHorario()));
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
}

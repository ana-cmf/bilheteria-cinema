package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.execucao.FilmeNaoEncontradoException;

import java.sql.ResultSet;
import dto.FilmeDTO;

public class FilmeDAOImpl implements FilmeDAO {

    public void cadastrarFilme(FilmeDTO filme) {
        String sql = "INSERT INTO bilheteria.filme (id_filme, titulo_filme, sinopse_filme, genero_filme, duracao_filme, classificacao_indicativa_filme) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, filme.getId());
            pstmt.setString(2, filme.getTitulo());
            pstmt.setString(4, filme.getGenero());
            pstmt.setInt(5, filme.getDuracaoDoFilme());
            pstmt.setInt(6, filme.getClassificacaoIndicativa());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public FilmeDTO buscarFilme(FilmeDTO buscarFilme) throws FilmeNaoEncontradoException {
        String sql = "SELECT * FROM bilheteria.filme WHERE id_filme = ?";
        FilmeDTO filme = null;

        try (Connection conn = ConexaoBancoDeDados.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, filme.getId());
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                filme = new FilmeDTO(null);
                filme.setId(rs.getLong("id"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setGenero(rs.getString("genero"));
                filme.setDuracaoDoFilme(rs.getInt("duracao_filme"));
                filme.setClassificacaoIndicativa(rs.getInt("classificacao_indicativa"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return filme;
    }

    public void excluirFilme(FilmeDTO filme) {
        String sql = "DELETE FROM bilheteria.filme WHERE id_filme = ?";

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, filme.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
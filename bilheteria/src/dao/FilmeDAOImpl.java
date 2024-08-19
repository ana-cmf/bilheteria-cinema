package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dto.FilmeDTO;

public class FilmeDAOImpl implements FilmeDAO {

    public void cadastrarFilme(FilmeDTO filme) {
        String sql = "INSERT INTO bilheteria.filmes (id, titulo, sinopse, genero, duracao, classificacao) VALUES (?, ?, ?, ?, ?, ?)";

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

    public void excluirFilme(FilmeDTO filme) {
        String sql = "DELETE FROM bilheteria.filmes WHERE id = ?";

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, filme.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

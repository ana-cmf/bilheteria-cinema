package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.exception.FilmeNaoEncontradoPeloIDException;
import dao.exception.FilmeNaoEncontradoPeloNomeException;

import java.sql.ResultSet;
import dto.FilmeDTO;

public class FilmeDAOImpl implements FilmeDAO {

    public void cadastrarFilme(FilmeDTO filme) {
        String sql = "INSERT INTO bilheteria.filme (id_filme, titulo_filme, sinopse_filme, genero_filme, duracao_filme, classificacao_indicativa_filme) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, filme.getId());
            pstmt.setString(2, filme.getTitulo());
            pstmt.setString(3, filme.getSinopse());
            pstmt.setString(4, filme.getGenero());
            pstmt.setInt(5, filme.getDuracaoDoFilme());
            pstmt.setInt(6, filme.getClassificacaoIndicativa());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public FilmeDTO buscarFilmeID(FilmeDTO buscarFilme) throws FilmeNaoEncontradoPeloIDException {
        String sql = "SELECT * FROM bilheteria.filme WHERE id_filme = ?";
        FilmeDTO filme = null;

        try (Connection conn = ConexaoBancoDeDados.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, filme.getId());
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                filme = new FilmeDTO(null);
                filme.setId(rs.getLong("id_filme"));
                filme.setTitulo(rs.getString("titulo_filme"));
                filme.setSinopse(rs.getString("sinopse_filme"));
                filme.setGenero(rs.getString("genero_filme"));
                filme.setDuracaoDoFilme(rs.getInt("duracao_filme"));
                filme.setClassificacaoIndicativa(rs.getInt("classificacao_indicativa_filme"));
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

    @Override
    public List<FilmeDTO> listarTodosFilmes() throws SQLException {
        String sql = "SELECT * FROM bilheteria.filme";
        List<FilmeDTO> filmes = new ArrayList<>();

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                FilmeDTO filme = new FilmeDTO(null);
                filme.setId(rs.getLong("id_filme"));
                filme.setTitulo(rs.getString("titulo_filme"));
                filmes.add(filme);
            }
        }
        return filmes;
    }

    @Override
    public FilmeDTO buscarFilmeNome(FilmeDTO buscarFilmeNome) throws FilmeNaoEncontradoPeloNomeException {
        String sql = "SELECT * FROM bilheteria.filme WHERE titulo_filme = ?";
        FilmeDTO filme = null;

        try (Connection conn = ConexaoBancoDeDados.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, filme.getTitulo());
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                filme = new FilmeDTO(null);
                filme.setTitulo(rs.getString("titulo_filme"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return filme;
    }
}
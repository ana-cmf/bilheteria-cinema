package dao;

import dto.FilmeDTO;
import dto.FuncionarioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoAdministradorDAOImpl implements AdministradorDAO {

    @Override
    public void cadastrarFilme(int id, String titulo, String sinopse, String genero, int duracao,
                               int classificacaoIndicativa) {
        String sql = "INSERT INTO bilheteria.filmes (id, titulo, sinopse, genero, duracao, classificacao) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoAdministradorDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, titulo);
            pstmt.setString(3, sinopse);
            pstmt.setString(4, genero);
            pstmt.setInt(5, duracao);
            pstmt.setInt(6, classificacaoIndicativa);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cadastrarFuncionario(String nomeCompleto, int cpf, int senha) {
        String sql = "INSERT INTO bilheteria.funcionarios (nome_completo, cpf, senha) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoAdministradorDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nomeCompleto);
            pstmt.setInt(2, cpf);
            pstmt.setInt(3, senha);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cadastrarSalaExibicao(int id, String endereco, FilmeDTO[] filmes) {
        String sql = "INSERT INTO bilheteria.salas_exibicao (id, endereco) VALUES (?, ?)";

        try (Connection conn = ConexaoAdministradorDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, endereco);

            pstmt.executeUpdate();

            // Adicione lógica para associar filmes à sala, se necessário
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editarInformacoesFuncionario(FuncionarioDTO editarInformacao) {
        String sql = "UPDATE bilheteria.funcionarios SET nome_completo = ?, senha = ? WHERE cpf = ?";

        try (Connection conn = ConexaoAdministradorDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, editarInformacao.getNomeCompleto());
            pstmt.setInt(2, editarInformacao.getSenha());
            pstmt.setInt(3, editarInformacao.getCPF());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluirFilme(int id) {
        String sql = "DELETE FROM bilheteria.filmes WHERE id = ?";

        try (Connection conn = ConexaoAdministradorDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

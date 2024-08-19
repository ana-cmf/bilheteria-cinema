package dao;

import dto.AssentoDTO;
import dto.FilmeDTO;
import dto.FuncionarioDTO;
import dto.SalaDeExibicaoDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoAdministradorDAOImpl implements AdministradorDAO {

    public void cadastrarFuncionario(FuncionarioDTO funcionario) {
        String sql = "INSERT INTO bilheteria.funcionarios (nome_completo, cpf, senha) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoAdministradorDAO.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, funcionario.getNomeCompleto());
            pstmt.setInt(2, funcionario.getCPF());
            pstmt.setInt(3, funcionario.getSenha());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editarInformacoesFuncionario(FuncionarioDTO funcionario) {
        String sql = "UPDATE bilheteria.funcionarios SET nome_completo = ?, senha = ? WHERE cpf = ?";

        try (Connection conn = ConexaoAdministradorDAO.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, funcionario.getNomeCompleto());
            pstmt.setInt(2, funcionario.getSenha());
            pstmt.setInt(3, funcionario.getCPF());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarFilme(FilmeDTO filme) {
        String sql = "INSERT INTO bilheteria.filmes (id, titulo, sinopse, genero, duracao, classificacao) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoAdministradorDAO.conectar();
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

    public void cadastrarSalaExibicao(SalaDeExibicaoDTO sala) {
        String sql = "INSERT INTO bilheteria.salas_exibicao (numero_sala, modelo_exibicao, quantidade_assentos) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoAdministradorDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, sala.getNumeroDaSala());
        //  pstmt.setString(2, sala.getModeloDeExibicao().getNome());
            pstmt.setInt(3, sala.getQuantidadeDeAssentos());

            pstmt.executeUpdate();

            AssentoDTO[][] assentos = sala.getAssentos();
            for (int i = 0; i < assentos.length; i++) {
                for (int j = 0; j < assentos[i].length; j++) {
                    AssentoDTO assento = assentos[i][j];
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

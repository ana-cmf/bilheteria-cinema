package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dto.AssentoDTO;
import dto.SalaDeExibicaoDTO;

public class SalaDeExibicaoImpl implements SalaDeExibicaoDAO {

    public void cadastrarSalaExibicao(SalaDeExibicaoDTO sala) {
        String sql = "INSERT INTO bilheteria.salas_exibicao (numero_sala, modelo_exibicao, quantidade_assentos) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBancoDeDados.conectar();
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

    
    public void excluirSalaExibicao(SalaDeExibicaoDTO sala) {
        
    /*   String sql = "DELETE FROM bilheteria.sala_exibicao WHERE identificador = ?";
    
        try (Connection conn = ConexaoBancoDeDados.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setInt(1, sala.getNumeroDaSala());
        //  pstmt.setString(2, sala.getModeloDeExibicao().getNome());
            pstmt.setInt(3, sala.getQuantidadeDeAssentos());
    
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    */

    } 
}
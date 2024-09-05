package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.exception.SalaDeExibicaoNaoEncontradaException;
import dto.SalaDeExibicaoDTO;

public class SalaDeExibicaoDAOImpl implements SalaDeExibicaoDAO {

    @Override
    public void cadastrarSalaExibicao(SalaDeExibicaoDTO sala) {
        String sqlSala = "INSERT INTO bilheteria.sala_exibicao (numero_sala, quantidade_assentos) VALUES (?, ?)";
        String sqlAssento = "INSERT INTO bilheteria.assento (id_assento, posicao_assento, reservado, numero_sala) VALUES (?, ?, ?, ?)";
    
        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmtSala = conn.prepareStatement(sqlSala);
            PreparedStatement pstmtAssento = conn.prepareStatement(sqlAssento)) {

            pstmtSala.setInt(1, sala.getNumeroDaSala());
            pstmtSala.setInt(2, sala.getQuantidadeDeAssentos());
            pstmtSala.executeUpdate();
    
            for (int i = 1; i <= sala.getQuantidadeDeAssentos(); i++) {
                pstmtAssento.setInt(1, i);
                pstmtAssento.setInt(2, i);
                pstmtAssento.setBoolean(3, false); 
                pstmtAssento.setInt(4, sala.getNumeroDaSala()); 
                
                pstmtAssento.addBatch(); 
            }
    
            pstmtAssento.executeBatch();
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluirSalaExibicao(SalaDeExibicaoDTO sala) {
        String sqlExcluirAssentos = "DELETE FROM bilheteria.assento WHERE numero_sala = ?";
        String sqlExcluirSala = "DELETE FROM bilheteria.sala_exibicao WHERE numero_sala = ?";
    
        try (Connection conn = ConexaoBancoDeDados.conectar();
             PreparedStatement pstmtExcluirAssentos = conn.prepareStatement(sqlExcluirAssentos);
             PreparedStatement pstmtExcluirSala = conn.prepareStatement(sqlExcluirSala)) {
    
            pstmtExcluirAssentos.setInt(1, sala.getNumeroDaSala());
            pstmtExcluirAssentos.executeUpdate();
    
            pstmtExcluirSala.setInt(1, sala.getNumeroDaSala());
            pstmtExcluirSala.executeUpdate();
            
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

    @Override
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
}
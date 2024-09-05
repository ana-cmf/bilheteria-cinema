package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dto.CompraDTO;

public class CompraDAOImpl implements CompraDAO {

    @Override
    public void adicionarCompra(CompraDTO compra) {
        String sql = "INSERT INTO bilheteria.compra (total_compra, quantidade_parcelas, taxa, id_forma_pagamento) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoBancoDeDados.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setFloat(1, compra.getTotal());   
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluirCompra(CompraDTO compra) {
        String sql = "DELETE FROM bilheteria.compra WHERE id_compra = ?";

        try (Connection conn = ConexaoBancoDeDados.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, compra.getId()); 
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CompraDTO> listarTodasCompras() throws SQLException {
        String sql = "SELECT * FROM bilheteria.compra";
        List<CompraDTO> compras = new ArrayList<>();

        try (Connection conn = ConexaoBancoDeDados.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                CompraDTO compra = new CompraDTO();
                compra.setId(rs.getLong("id_compra")); 
                compra.setTotal(rs.getFloat("total_compra"));  
 
                compras.add(compra);
            }
        }
        return compras;
    }
}

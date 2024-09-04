package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import dto.CompraDTO;
import dto.IngressoDTO;

public class CompraDAOImpl implements CompraDAO {

    @Override
    public void adicionarCompra(CompraDTO compra) {
        String sql = "INSERT INTO compras (id_compra, total_compra, forma_de_pagamento_compra) VALUES (?, ?)";

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setFloat(1, compra.getTotal());
    //      pstmt.setString(2, compra.getFormaDePagamento().name()); 
            
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void excluirCompra(CompraDTO compra) {
        String sql = "DELETE FROM compras WHERE id_compra = ?";

        try (Connection conn = ConexaoBancoDeDados.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

//          pstmt.setLong(1, compra.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

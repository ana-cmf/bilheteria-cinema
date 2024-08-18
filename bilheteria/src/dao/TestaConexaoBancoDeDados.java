package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexaoBancoDeDados {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = ConexaoAdministradorDAO.conectar();
            if (conn != null) {
                System.out.println("Conexao bem-sucedida!");
            } else {
                System.out.println("Falha na conexao.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar a conexao: " + e.getMessage());
                }
            }
        }
    }
}


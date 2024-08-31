package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDeDados {

	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres"; // Ajuste para seu usuário PostgreSQL
    private static final String PASSWORD = "15344155"; // Ajuste para sua senha PostgreSQL

    private static ConexaoBancoDeDados instancia;

    private ConexaoBancoDeDados() {}

    public static ConexaoBancoDeDados getInstancia() {
        if (instancia == null) {
            instancia = new ConexaoBancoDeDados();
        }
        return instancia;
    }

    public static Connection conectar() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver PostgreSQL não encontrado.", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void fecharConexao(Connection con) throws SQLException {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar conexão com o banco: " + e.getMessage(), e);
        }
    }    
}
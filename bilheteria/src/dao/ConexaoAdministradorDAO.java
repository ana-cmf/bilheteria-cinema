package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoAdministradorDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres"; // Ajuste para seu usuário PostgreSQL
    private static final String PASSWORD = "15344155"; // Ajuste para sua senha PostgreSQL

    public static Connection conectar() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver PostgreSQL nao encontrado.", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

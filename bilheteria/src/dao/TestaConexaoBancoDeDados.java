package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexaoBancoDeDados {

    public static void main(String[] args) {
        Connection conexao = null;

        try {
            conexao = ConexaoBancoDeDados.conectar();
            System.out.println("Conexão estabelecida com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        } /* finally {
            try {
                ConexaoBancoDeDados.fecharConexao(conexao);
                System.out.println("Conexão fechada com sucesso!");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }  */  
    }
}
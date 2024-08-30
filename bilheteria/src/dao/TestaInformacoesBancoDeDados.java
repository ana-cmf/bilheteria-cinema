package dao;

import dto.AdministradorDTO;
import java.util.Scanner;

public class TestaInformacoesBancoDeDados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome de usuário: ");
        String nomeUsuario = scanner.nextLine();

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        AdministradorDTO administrador = new AdministradorDTO();
        administrador.setNomeUsuario(nomeUsuario);
        administrador.setSenha(senha);

        AdministradorDAOImpl dao = new AdministradorDAOImpl();
        dao.cadastrarAdministrador(administrador);
        dao.buscarAdminstrador();
        
        scanner.close();
    }
}
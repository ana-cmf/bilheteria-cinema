package dao;

import dto.AdministradorDTO;

public class TestaInformacoesBancoDeDados {
    public static void main(String[] args) {

        AdministradorDTO ad = new AdministradorDTO();
        ad.setNomeUsuario("user");
        ad.setSenha("123");
        
        AdministradorDAOImpl dao = new AdministradorDAOImpl();
        dao.excluirAdministrador(ad);
    }
}
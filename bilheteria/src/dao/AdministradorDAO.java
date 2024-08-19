package dao;

import dto.AdministradorDTO;

public interface AdministradorDAO {

    public void cadastrarAdministrador(AdministradorDTO administrador);
    public void excluirAdministrador(AdministradorDTO administrador);
}

package controller;

import copiamodel.AdministradoCopia;
import dao.AdministradorDAO;
import dao.AdministradorDAOImpl;
import dao.FucionarioDAO;
import dao.FuncionarioImpl;
import dto.AdministradorDTO;
import dto.FuncionarioDTO;
import model.Funcionario;
import view.TelaLogin;

public class LoginController {

    private AdministradorDAO adminDAO;
    private FucionarioDAO funcionarioDAO;
    private TelaLogin telaLogin;
    private AdministradoCopia admin;
    private Funcionario funcionario;

    public LoginController(){
        this.admin = AdministradoCopia.getInstancia();
        this.adminDAO = new AdministradorDAOImpl();
        this.funcionarioDAO = new FuncionarioImpl();
        this.funcionario = new Funcionario();
    }

    public void logarUsuario(AdministradorDTO adminDTO, FuncionarioDTO funcionarioDTO){
        
    }

}

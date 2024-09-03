package controller;

import model.Administrador;
import dao.AdministradorDAO;
import dao.AdministradorDAOImpl;
import dao.FucionarioDAO;
import dao.FuncionarioDAOImpl;
import dto.AdministradorDTO;
import dto.FuncionarioDTO;
import model.Funcionario;
import view.TelaInicialAdministrador;
import view.TelaInicialFuncionario;
import view.TelaLogin;

public class LoginController {

    private AdministradorDAO adminDAO;
    private FucionarioDAO funcionarioDAO;
    private TelaLogin telaLogin;
    private Administrador admin;
    private Funcionario funcionario;

    public LoginController(){
        this.admin = Administrador.getInstancia();
        this.adminDAO = new AdministradorDAOImpl();
        this.funcionarioDAO = new FuncionarioDAOImpl();
        this.funcionario = new Funcionario();
    }

    public void logarUsuario(AdministradorDTO adminDTO, FuncionarioDTO funcionarioDTO){
        if(adminDAO.autenticarAdministrador(adminDTO)){
            new TelaInicialAdministrador();
        }else{
            new TelaInicialFuncionario();
        }
    }
}

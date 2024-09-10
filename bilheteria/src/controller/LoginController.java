package controller;

import model.Administrador;
import dao.AdministradorDAO;
import dao.AdministradorDAOImpl;
import dao.FucionarioDAO;
import dao.FuncionarioDAOImpl;
import dao.exception.FuncionarioNaoEncontradoPeloEmailException;
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

    public LoginController(TelaLogin tela){
        this.admin = Administrador.getInstancia();
        this.adminDAO = new AdministradorDAOImpl();
        this.funcionarioDAO = new FuncionarioDAOImpl();
        this.funcionario = new Funcionario();
        this.telaLogin = tela;
    }


    public LoginController() {
    }

    public void logarUsuario(AdministradorDTO adminDTO){
        if(adminDAO.autenticarAdministrador(adminDTO)){
            new TelaInicialAdministrador();
        }else{
            try {
                FuncionarioDTO dto = funcionarioDAO.buscarFuncionarioPeloEmail(telaLogin.salvarDadosParaFuncionario());
                TelaInicialFuncionario telaFuncionario = new TelaInicialFuncionario();
                telaFuncionario.setFuncionario(dto);
            } catch (FuncionarioNaoEncontradoPeloEmailException e) {
                telaLogin.mostrarMensagensDeErroDoNome();
            }
        }
    }
}

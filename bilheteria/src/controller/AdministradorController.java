package controller;

import dao.AdministradorDAO;
import dao.AdministradorDAOImpl;
import dto.AdministradorDTO;
import model.execption.SenhaInvalidaException;
import model.Administrador;
import view.TelaCadastroAdministrador;
import view.TelaLogin;


public class AdministradorController {
    private AdministradorDAO adminDAO;
    private Administrador admin;
    private TelaCadastroAdministrador telaCadastro;

    public AdministradorController(){
        this.admin = Administrador.getInstancia();
        this.adminDAO = new AdministradorDAOImpl(); 
        iniciarPrograma();
    }

    public void iniciarPrograma(){
        if(adminDAO.buscarAdminstrador()){
            new TelaLogin();
        }else{
            this.telaCadastro = new TelaCadastroAdministrador(this);
        }
    }

    public void cadastrarAdministrador(AdministradorDTO dto){
        admin.setNomeUsuario(dto.getNomeUsuario());
        try {
            admin.setSenha(dto.getSenha());
            adminDAO.cadastrarAdministrador(dto);
            telaCadastro.mudarParaTelaDeLogin();
        } catch (SenhaInvalidaException e) {
            telaCadastro.mostrarMensagensDeErroDaSenha();
        }
    }

    public void autenticarAdministrador(AdministradorDTO dto){
        if(adminDAO.autenticarAdministrador(dto)){
            
        }
    }
}

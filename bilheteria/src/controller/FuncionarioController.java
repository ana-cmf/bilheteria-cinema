package controller;

import dao.FucionarioDAO;
import dao.FuncionarioImpl;
import dto.FuncionarioDTO;
import model.Funcionario;
import model.execption.CpfInvalidoException;
import model.execption.EmailInvalidoException;
import model.execption.SenhaInvalidaException;

public class FuncionarioController {
    private Funcionario funcionario;
    private FucionarioDAO funcionariodao;

    public FuncionarioController() {
        this.funcionariodao = new FuncionarioImpl();
    }

    
    public void cadastrarClienteController(FuncionarioDTO funcionariodto){
        funcionario.setNomeCompleto(funcionariodto.getNomeCompleto());
        try {
            funcionario.setCPF(funcionariodto.getCPF());
        } catch (CpfInvalidoException ex) {

        }
        try {
            funcionario.setEmail(funcionariodto.getEmail());
        } catch (EmailInvalidoException ex) {
        }
        try {
            funcionario.setSenha(funcionariodto.getSenha());
        } catch (SenhaInvalidaException ex) {
        }
        funcionariodao.cadastrarFuncionario(funcionariodto);
    }
    public void excluirFuncionarioController(FuncionarioDTO dto){
        dto.setCPF(funcionario.getCPF());
        funcionariodao.excluirFuncionario(dto);
    }
    public void editarInformacoesFuncionarioController(FuncionarioDTO dto){
        String informacao = null;
        if("nome".equalsIgnoreCase(informacao)){
            funcionario.setNomeCompleto(dto.getNomeCompleto());
            funcionariodao.editarInformacoesFuncionario(dto); 
        }
        if("email".equalsIgnoreCase(informacao)){
            try {
                funcionario.setEmail(dto.getEmail());
                funcionariodao.editarInformacoesFuncionario(dto);
            } catch (EmailInvalidoException ex) {

            }
        if("senha".equalsIgnoreCase(informacao)){
                try {
                    funcionario.setSenha(dto.getSenha());
                    funcionariodao.editarInformacoesFuncionario(dto);
                } catch (SenhaInvalidaException ex) {
            }

        }
    }
    }

}

package controller;

import dao.AssentoDAO;
import dao.AssentoDAOImpl;
import dto.SalaDeExibicaoDTO;
import model.Assento;

public class AssentoController{
    private Assento assento;
    private AssentoDAO assentodao;
    
    public AssentoController(){
        this.assentodao= new AssentoDAOImpl();
    }
    public void ProcurarAssentoControlller(SalaDeExibicaoDTO sala){
        sala.getAssentos();
        assentodao.buscarAssento(sala);
    }
    
}
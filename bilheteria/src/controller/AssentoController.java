package controller;

import dao.AssentoDAO;
import dao.AssentoDAOImpl;
import model.Assento;

public class AssentoController{
    private Assento assento;
    private AssentoDAO assentodao;
    
    public AssentoController(){
        this.assentodao= new AssentoDAOImpl();
    }
    public void ProcurarAssentoControlller(Assento sala){

        assentodao.buscarAssento(sala);
    }     
}
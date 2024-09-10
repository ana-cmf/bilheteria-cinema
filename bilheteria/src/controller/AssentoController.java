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
    
}
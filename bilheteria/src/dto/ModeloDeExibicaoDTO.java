package dto;

import model.ModeloDeExibicao;

public class ModeloDeExibicaoDTO {
    private ModeloDeExibicaoDTO modelodto;
    private ModeloDeExibicao modelo;

    public ModeloDeExibicaoDTO(){
        this.modelodto=ModeloDeExibicao._2D;

    }
    public ModeloDeExibicaoDTO getModelo2D() {
        return modelo2D;
    }
    public void setModelo2D(ModeloDeExibicaoDTO modelo2d) {
        modelo2D = modelo2d;
    }
    public ModeloDeExibicaoDTO getModelo3D() {
        return modelo3D;
    }
    public void setModelo3D(ModeloDeExibicaoDTO modelo3d) {
        modelo3D = modelo3d;
    }
     

   

}

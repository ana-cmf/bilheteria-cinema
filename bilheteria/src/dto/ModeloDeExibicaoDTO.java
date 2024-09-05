package dto;

public class ModeloDeExibicaoDTO {
    private String  modelo;

    public ModeloDeExibicaoDTO(){
        this.modelo="2D";

    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
    	this.modelo = modelo;
    }
    public ModeloDeExibicaoDTO getModelo3D() {
        return modelo3D;
    }
    public void setModelo3D(ModeloDeExibicaoDTO modelo3d) {
        modelo3D = modelo3d;
    }
}

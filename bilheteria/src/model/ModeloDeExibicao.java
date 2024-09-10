package model;

public enum ModeloDeExibicao {
    _2D, 
    _3D;

    public String toDTOString() {
        return this.name();
    }
}


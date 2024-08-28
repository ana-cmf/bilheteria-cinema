package model;

import dto.IngressoDTO;

public interface FormaDePagamento{
    
    void calcularValor(IngressoDTO ingresso);
    
    float getTaxa();
    
    int getNumeroDeParcelas();
}
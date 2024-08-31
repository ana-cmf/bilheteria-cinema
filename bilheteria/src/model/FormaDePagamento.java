package model;

import dto.CompraDTO;

public interface FormaDePagamento{
    
    CompraDTO calcularValor(CompraDTO ingresso);
    
    float getTaxa();
    
    int getNumeroDeParcelas();
}
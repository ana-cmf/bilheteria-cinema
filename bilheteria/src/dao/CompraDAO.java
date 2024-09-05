package dao;

import dto.CompraDTO;

public interface CompraDAO {

    public void adicionarCompra(CompraDTO compra);
    public void excluirCompra(CompraDTO compra);
}
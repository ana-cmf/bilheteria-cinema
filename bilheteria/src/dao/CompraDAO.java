package dao;

import java.sql.SQLException;
import java.util.List;
import dto.CompraDTO;

public interface CompraDAO {

    public void adicionarCompra(CompraDTO compra);
    public void excluirCompra(CompraDTO compra);
    public List<CompraDTO> listarTodasCompras() throws SQLException;
}

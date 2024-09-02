package dao;

import java.util.List;
import dto.AssentoDTO;

public interface AssentoDAO {

    public void adicionarAssento(AssentoDTO assento);
    public List<AssentoDTO> buscarAssento(AssentoDTO assento);
}

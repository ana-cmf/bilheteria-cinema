package dao;

import java.util.List;
import dto.AssentoDTO;
import dto.SalaDeExibicaoDTO;

public interface AssentoDAO {

    public List<AssentoDTO> buscarAssento(SalaDeExibicaoDTO sala);
}

package dao;

import dto.IngressoDTO;

public interface IngressoDAO {

    public void adicionarIngresso(IngressoDTO ingresso);
    public void excluirIngresso(IngressoDTO ingresso);
}

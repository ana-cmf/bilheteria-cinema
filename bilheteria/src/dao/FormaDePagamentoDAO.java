package dao;

import dto.FormaDePagamentoDTO;

public interface FormaDePagamentoDAO {
	
	public void adicionarPagamento(FormaDePagamentoDTO pagamento);
	public void excluirPagamento(FormaDePagamentoDTO pagamento);
}
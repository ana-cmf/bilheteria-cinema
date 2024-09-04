package dao;

import dto.SalaDeExibicaoDTO;

public class TestaInformacoesBancoDeDados {
    public static void main(String[] args) {
        SalaDeExibicaoDTO sala = new SalaDeExibicaoDTO();
        sala.setNumeroDaSala(1); // Exemplo de número da sala
        sala.setQuantidadeDeAssentos(50); // Exemplo de quantidade de assentos

        SalaDeExibicaoDAO salaDAO = new SalaDeExibicaoDAOImpl();
        salaDAO.cadastrarSalaExibicao(sala);
        
        System.out.println("Sala de exibição e assentos cadastrados com sucesso.");
    }
}
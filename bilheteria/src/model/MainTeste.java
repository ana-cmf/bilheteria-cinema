package model;

import java.time.LocalDateTime;
import model.execption.CpfInvalidoException;
import model.execption.EmailInvalidoException;

public class MainTeste {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNomeCompleto("Luciana Farias");
        try {
            cliente.setEmail("luciana@gmail.com");
        } catch (EmailInvalidoException ex) {
            System.out.println("E-mail inválido");
        }
        try {
            cliente.setCPF("48948031864");
        } catch (CpfInvalidoException ex) {
            System.out.println("CPF inválido");
        }

        Filme filme1 = new Filme();
        filme1.setTitulo("A Cabana");
        filme1.setClassificacaoIndicativa(12);
        filme1.setDuracaoDoFilme(120);
        filme1.setGenero("Drama");

        SalaDeExibicao sala = new SalaDeExibicao();
        sala.setNumeroDaSala(1);
        sala.setModeloDeExibicao(ModeloDeExibicao._3D);

        Exibicao exibicao = new Exibicao();
        exibicao.setFilme(filme1);
        exibicao.setHorario(LocalDateTime.of(2024, 9, 4, 19, 30));
        exibicao.setLegendado(true);
        exibicao.setSalaDeExibicao(sala);

        Assento assento = new Assento();
        assento.setPosicao(40);

        Ingresso ingresso = new Ingresso();
        ingresso.setExibicao(exibicao);
        ingresso.setCliente(cliente);
        ingresso.setAssento(assento);
        ingresso.setTipoDeEntrada(TipoDeEntrada._MEIA);
        ingresso.ingressoPodeSerIsento(ingresso.toDTO());
        ingresso.setPagamentoRealizado(true);

        CartaoDeCredito cartao = new CartaoDeCredito();
        cartao.setNumParcelas(1);
        cartao.setTaxa(cartao.getTaxa());
        Compra compra = new Compra();
        compra.setFormaDePagamento(cartao);
        compra.calcularValorCompra();

        
        System.out.println(ingresso);
        System.out.println(compra);
    }
}
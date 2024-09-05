package view;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import dto.ExibicaoDTO;
import dto.FilmeDTO;
import dto.FuncionarioDTO;
import dto.SalaDeExibicaoDTO;

public class TelaInicialFuncionario extends JFrame{

    private FuncionarioDTO funcionario;
    private JButton botaoLogin;
    private JMenuItem menuSalas;
    private JMenuItem menuExibicoes;
    private JTextField caixaDePesquisa;

    private SalaDeExibicaoDTO salaDTO;
    private FilmeDTO filmeDTO;
    private ExibicaoDTO exibicaoDTO;

    private List<SalaDeExibicaoDTO> salas;
    private List<ExibicaoDTO> exibicoes;

    private JPanel listaDasSalas;
    private JPanel listaDasExibicoes;

    public void adicionarCaixaDePesquisa(){
        this.caixaDePesquisa = new JTextField();
        int largura = 300;
        int margemEsquerda = (int) (tamanhoDaTela().getWidth()-largura-40);
        caixaDePesquisa.setBounds(margemEsquerda, botaoLogin.getY()+10, largura, 20);
        caixaDePesquisa.setVisible(true);

        JLabel pesquisarFilme = new JLabel("Pesquisar filme:");
        largura = 110;
        pesquisarFilme.setBounds(margemEsquerda-largura, caixaDePesquisa.getY(), largura, 20);
        pesquisarFilme.setLabelFor(caixaDePesquisa);
        pesquisarFilme.setVisible(true);
        add(pesquisarFilme);
        add(caixaDePesquisa);
    }

    public void adicionarListaDeSalas(){
        
        this.salas = new ArrayList<SalaDeExibicaoDTO>();
        for (int i = 1; i < 11; i++) {
            SalaDeExibicaoDTO dto = new SalaDeExibicaoDTO();
            dto.setNumeroDaSala(i);
            salas.add(dto);
        }
        
        JPanel conteinerBotoes = new JPanel();
        int quantidadeDeBotoes = salas.size();
        if(quantidadeDeBotoes<10){
            quantidadeDeBotoes = 10;
        }
        conteinerBotoes.setLayout(new GridLayout(quantidadeDeBotoes,1,5,5));
        for(SalaDeExibicaoDTO sala: salas){
            JButton botaoDaSala = new JButton("Sala "+sala.getNumeroDaSala());
            botaoDaSala.setMaximumSize(new Dimension(250, 20));
            botaoDaSala.setBackground(adicionarCor(191, 4, 3));
            botaoDaSala.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            conteinerBotoes.add(botaoDaSala);
        }
        
        JScrollPane painelBarraDeRolagem = new JScrollPane();
        painelBarraDeRolagem.setViewportView(conteinerBotoes);
        painelBarraDeRolagem.setAlignmentX(CENTER_ALIGNMENT);
        int larguraListaBotoes = 400;
        int alturaListaBotoes = 500;
        int margemEsquerdaBotoes = (int) (tamanhoDaTela().getWidth()/2-larguraListaBotoes/2);
        painelBarraDeRolagem.setBounds(margemEsquerdaBotoes,100,larguraListaBotoes,alturaListaBotoes);
        painelBarraDeRolagem.setPreferredSize(new Dimension(larguraListaBotoes, alturaListaBotoes));
        painelBarraDeRolagem.setBorder(null);
        conteinerBotoes.setVisible(true);
        painelBarraDeRolagem.setVisible(true);
        
        JLabel tituloSalas = new JLabel("Salas de exibição");
        tituloSalas.setBounds(0,20,larguraListaBotoes,30);
        tituloSalas.setFont(new Font("Futura", Font.BOLD, 16));
        tituloSalas.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        tituloSalas.setHorizontalAlignment(SwingConstants.CENTER);
        tituloSalas.setVisible(true);
        
        this.listaDasSalas = new JPanel();
        listaDasSalas.setBounds(margemEsquerdaBotoes,200,larguraListaBotoes,alturaListaBotoes+100);
        listaDasSalas.setVisible(true);
        listaDasSalas.add(tituloSalas);
        listaDasSalas.add(painelBarraDeRolagem);
        add(listaDasSalas);
    }
    
    public void adicionarListaDeExibicoes(){
        
        this.exibicoes = new ArrayList<ExibicaoDTO>();
        for (int i = 1; i < 11; i++) {
            //FilmeDTO dto = new FilmeDTO();
            //filmes.add(dto);
        }
        
        JPanel conteinerBotoes = new JPanel();
        int quantidadeDeBotoes = exibicoes.size();
        if(quantidadeDeBotoes<10){
            quantidadeDeBotoes = 10;
        }
        conteinerBotoes.setLayout(new GridLayout(quantidadeDeBotoes,1,5,5));
        for(ExibicaoDTO dto: exibicoes){
            JButton botaoExibicao = new JButton(dto.toString());
            botaoExibicao.setMaximumSize(new Dimension(250, 20));
            botaoExibicao.setBackground(adicionarCor(191, 4, 3));
            botaoExibicao.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            conteinerBotoes.add(botaoExibicao);
        }
        
        JScrollPane painelBarraDeRolagem = new JScrollPane();
        painelBarraDeRolagem.setViewportView(conteinerBotoes);
        painelBarraDeRolagem.setAlignmentX(CENTER_ALIGNMENT);
        int larguraListaBotoes = 400;
        int alturaListaBotoes = 500;
        int margemEsquerdaBotoes = (int) (tamanhoDaTela().getWidth()/2-larguraListaBotoes/2);
        painelBarraDeRolagem.setBounds(margemEsquerdaBotoes,100,larguraListaBotoes,alturaListaBotoes);
        painelBarraDeRolagem.setPreferredSize(new Dimension(larguraListaBotoes, alturaListaBotoes));
        painelBarraDeRolagem.setBorder(null);
        conteinerBotoes.setVisible(true);
        painelBarraDeRolagem.setVisible(true);
        
        JLabel tituloFilmes = new JLabel("Filmes");
        tituloFilmes.setBounds(0,20,larguraListaBotoes,30);
        tituloFilmes.setFont(new Font("Futura", Font.BOLD, 16));
        tituloFilmes.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        tituloFilmes.setHorizontalAlignment(SwingConstants.CENTER);
        tituloFilmes.setVisible(true);
        
        this.listaDasSalas = new JPanel();
        listaDasSalas.setBounds(margemEsquerdaBotoes,200,larguraListaBotoes,alturaListaBotoes+100);
        listaDasSalas.setVisible(true);
        listaDasSalas.add(tituloFilmes);
        listaDasSalas.add(painelBarraDeRolagem);
        add(listaDasSalas);
    }

    public Color adicionarCor(int num1, int num2, int num3) {
        float[] cor = new float[3];
		cor = Color.RGBtoHSB(num1, num2, num3, cor);
		return Color.getHSBColor(cor[0], cor[1], cor[2]);
	}

    public static void main(String[] args) {
        new TelaInicialFuncionario();
    }
    
    public Dimension tamanhoDaTela() {
        Toolkit t = Toolkit.getDefaultToolkit();
        return t.getScreenSize();
	}

    public FuncionarioDTO getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioDTO funcionario) {
        this.funcionario = funcionario;
    }

}

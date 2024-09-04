package view;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import dto.ExibicaoDTO;
import dto.FilmeDTO;
import dto.FuncionarioDTO;
import dto.SalaDeExibicaoDTO;
import model.Funcionario;

public class TelaInicialAdministrador extends JFrame{

    private JButton botaoLogin;
    private JMenuItem menuSalas;
    private JMenuItem menuExibicoes;
    private JMenuItem menuFilmes;
    private JMenuItem menuFuncionarios;
    private JMenuItem menuClientes;
    private JTextField caixaDePesquisa;

    private SalaDeExibicaoDTO salaDTO;
    private FilmeDTO filmeDTO;
    private FuncionarioDTO funcionarioDTO;
    private ExibicaoDTO exibicaoDTO;

    private List<SalaDeExibicaoDTO> salas;
    private List<FilmeDTO> filmes;

    private JPanel listaDasSalas;
    private JPanel listaDasExibicoes;
    private JPanel listaDosFilmes;
    private JPanel listaDosFuncionarios;
    private JPanel listaDosClientes;

    private JPanel detalhesSala;
    
    public TelaInicialAdministrador(){
        adicionarMenu();
        adicionarBotaoLogin();
        adicionarCaixaDePesquisa();
        adicionarListaDeFilmes();
        criarTela();
        repaint();
    }

    public void criarTela(){
        setIconImage(Imagens.ICONE_TOPO_DA_JANELA);
        setTitle("Absolute Cinema");
        setLayout(null);
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
        setSize(900, 800);
        setVisible(true);
    }

    public void adicionarMenu(){
        JMenuBar barraDeMenu =  new JMenuBar();
        this.menuSalas = new JMenuItem("Salas");
        this.menuExibicoes = new JMenuItem("Exibições");
        this.menuFilmes = new JMenuItem("Filmes");
        this.menuFuncionarios = new JMenuItem("Funcionarios");
        this.menuClientes = new JMenuItem("Clientes");
        barraDeMenu.add(menuSalas);
        barraDeMenu.add(menuExibicoes);
        barraDeMenu.add(menuFilmes);
        barraDeMenu.add(menuFuncionarios);
        barraDeMenu.add(menuClientes);

        barraDeMenu.setBounds(60, 100, 450, 25);
        barraDeMenu.setOpaque(false);
        barraDeMenu.setBorder(null);
        barraDeMenu.setVisible(true);
        add(barraDeMenu);
    }

    public void adicionarBotaoLogin(){
        this.botaoLogin = new JButton("Login");
        botaoLogin.setBounds(200, 25, 100, 30);
        botaoLogin.setBackground(adicionarCor(191, 3, 4));
        botaoLogin.setForeground(Color.WHITE);
        botaoLogin.setBorder(null);
        botaoLogin.setVisible(true);
        add(botaoLogin);
    }

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

    
    public void moverPainelParaEsquerda(JPanel painel){
        painel.setVisible(false);
        painel.setBounds(20, painel.getY(), painel.getWidth(), painel.getHeight());
        painel.setVisible(true);
    }

    public void removerListaDasSalas(){
        listaDasSalas.setVisible(false);
    }
    
    public void adicionarListaDeSalas(){
        
        this.salas = new ArrayList<SalaDeExibicaoDTO>();
        for (int i = 1; i < 11; i++) {
            SalaDeExibicaoDTO dto = new SalaDeExibicaoDTO();
            dto.setNumeroDaSala(i);
            salas.add(dto);
        }
        
        JPanel areaBotoesSalas = new JPanel();
        int quantidadeDeBotoes = salas.size();
        if(quantidadeDeBotoes<10){
            quantidadeDeBotoes = 10;
        }
        areaBotoesSalas.setLayout(new GridLayout(quantidadeDeBotoes,1,5,5));
        for(SalaDeExibicaoDTO sala: salas){
            JButton botaoDaSala = new JButton("Sala "+sala.getNumeroDaSala());
            botaoDaSala.setMaximumSize(new Dimension(250, 20));
            botaoDaSala.setBackground(adicionarCor(191, 4, 3));
            botaoDaSala.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            areaBotoesSalas.add(botaoDaSala);
        }
        
        JScrollPane painelBarraDeRolagem = new JScrollPane();
        painelBarraDeRolagem.setViewportView(areaBotoesSalas);
        painelBarraDeRolagem.setAlignmentX(CENTER_ALIGNMENT);
        int larguraListaBotoes = 400;
        int alturaListaBotoes = 500;
        int margemEsquerdaBotoes = (int) (tamanhoDaTela().getWidth()/2-larguraListaBotoes/2);
        painelBarraDeRolagem.setBounds(margemEsquerdaBotoes,100,larguraListaBotoes,alturaListaBotoes);
        painelBarraDeRolagem.setPreferredSize(new Dimension(larguraListaBotoes, alturaListaBotoes));
        painelBarraDeRolagem.setBorder(null);
        areaBotoesSalas.setVisible(true);
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
    
    public void adicionarListaDeFilmes(){
        
        this.filmes = new ArrayList<FilmeDTO>();
        for (int i = 1; i < 11; i++) {
            //FilmeDTO dto = new FilmeDTO();
            //filmes.add(dto);
        }
        
        JPanel areaBotoesFilmes = new JPanel();
        int quantidadeDeBotoes = filmes.size();
        if(quantidadeDeBotoes<10){
            quantidadeDeBotoes = 10;
        }
        areaBotoesFilmes.setLayout(new GridLayout(quantidadeDeBotoes,1,5,5));
        for(FilmeDTO filme: filmes){
            JButton botaoDoFilme = new JButton(filme.getTitulo());
            botaoDoFilme.setMaximumSize(new Dimension(250, 20));
            botaoDoFilme.setBackground(adicionarCor(191, 4, 3));
            botaoDoFilme.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            areaBotoesFilmes.add(botaoDoFilme);
        }
        
        JScrollPane painelBarraDeRolagem = new JScrollPane();
        painelBarraDeRolagem.setViewportView(areaBotoesFilmes);
        painelBarraDeRolagem.setAlignmentX(CENTER_ALIGNMENT);
        int larguraListaBotoes = 400;
        int alturaListaBotoes = 500;
        int margemEsquerdaBotoes = (int) (tamanhoDaTela().getWidth()/2-larguraListaBotoes/2);
        painelBarraDeRolagem.setBounds(margemEsquerdaBotoes,100,larguraListaBotoes,alturaListaBotoes);
        painelBarraDeRolagem.setPreferredSize(new Dimension(larguraListaBotoes, alturaListaBotoes));
        painelBarraDeRolagem.setBorder(null);
        areaBotoesFilmes.setVisible(true);
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
    public void adicionarListaDeExibicoes(){
        
        this.filmes = new ArrayList<FilmeDTO>();
        for (int i = 1; i < 11; i++) {
            //FilmeDTO dto = new FilmeDTO();
            //filmes.add(dto);
        }
        
        JPanel areaBotoesFilmes = new JPanel();
        int quantidadeDeBotoes = filmes.size();
        if(quantidadeDeBotoes<10){
            quantidadeDeBotoes = 10;
        }
        areaBotoesFilmes.setLayout(new GridLayout(quantidadeDeBotoes,1,5,5));
        for(FilmeDTO filme: filmes){
            JButton botaoDoFilme = new JButton(filme.getTitulo());
            botaoDoFilme.setMaximumSize(new Dimension(250, 20));
            botaoDoFilme.setBackground(adicionarCor(191, 4, 3));
            botaoDoFilme.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            areaBotoesFilmes.add(botaoDoFilme);
        }
        
        JScrollPane painelBarraDeRolagem = new JScrollPane();
        painelBarraDeRolagem.setViewportView(areaBotoesFilmes);
        painelBarraDeRolagem.setAlignmentX(CENTER_ALIGNMENT);
        int larguraListaBotoes = 400;
        int alturaListaBotoes = 500;
        int margemEsquerdaBotoes = (int) (tamanhoDaTela().getWidth()/2-larguraListaBotoes/2);
        painelBarraDeRolagem.setBounds(margemEsquerdaBotoes,100,larguraListaBotoes,alturaListaBotoes);
        painelBarraDeRolagem.setPreferredSize(new Dimension(larguraListaBotoes, alturaListaBotoes));
        painelBarraDeRolagem.setBorder(null);
        areaBotoesFilmes.setVisible(true);
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

    public void adicionarListaDeFuncionarios(){
        
        this.filmes = new ArrayList<FilmeDTO>();
        for (int i = 1; i < 11; i++) {
            //FilmeDTO dto = new FilmeDTO();
            //filmes.add(dto);
        }
        
        JPanel areaBotoesFilmes = new JPanel();
        int quantidadeDeBotoes = filmes.size();
        if(quantidadeDeBotoes<10){
            quantidadeDeBotoes = 10;
        }
        areaBotoesFilmes.setLayout(new GridLayout(quantidadeDeBotoes,1,5,5));
        for(FilmeDTO filme: filmes){
            JButton botaoDoFilme = new JButton(filme.getTitulo());
            botaoDoFilme.setMaximumSize(new Dimension(250, 20));
            botaoDoFilme.setBackground(adicionarCor(191, 4, 3));
            botaoDoFilme.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            areaBotoesFilmes.add(botaoDoFilme);
        }
        
        JScrollPane painelBarraDeRolagem = new JScrollPane();
        painelBarraDeRolagem.setViewportView(areaBotoesFilmes);
        painelBarraDeRolagem.setAlignmentX(CENTER_ALIGNMENT);
        int larguraListaBotoes = 400;
        int alturaListaBotoes = 500;
        int margemEsquerdaBotoes = (int) (tamanhoDaTela().getWidth()/2-larguraListaBotoes/2);
        painelBarraDeRolagem.setBounds(margemEsquerdaBotoes,100,larguraListaBotoes,alturaListaBotoes);
        painelBarraDeRolagem.setPreferredSize(new Dimension(larguraListaBotoes, alturaListaBotoes));
        painelBarraDeRolagem.setBorder(null);
        areaBotoesFilmes.setVisible(true);
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

    public void detalharSala(){
        this.salaDTO = new SalaDeExibicaoDTO();
        salaDTO.setNumeroDaSala(1);
        salaDTO.setQuantidadeDeAssentos(40);

        this.detalhesSala = new JPanel();
        
    }

    public Color adicionarCor(int num1, int num2, int num3) {
        float[] cor = new float[3];
		cor = Color.RGBtoHSB(num1, num2, num3, cor);
		return Color.getHSBColor(cor[0], cor[1], cor[2]);
	}
    
    public Dimension tamanhoDaTela() {
        Toolkit t = Toolkit.getDefaultToolkit();
        return t.getScreenSize();
	}
    
    public static void main(String[] args) {
        new TelaInicialAdministrador();
    }
    
        public JButton getBotaoLogin() {
            return botaoLogin;
        }
    
        public void setBotaoLogin(JButton botaoLogin) {
            this.botaoLogin = botaoLogin;
        }
    
        public JMenuItem getMenuSalas() {
            return menuSalas;
        }
    
        public void setMenuSalas(JMenuItem menuSalas) {
            this.menuSalas = menuSalas;
        }
    
        public JMenuItem getMenuExibicoes() {
            return menuExibicoes;
        }
    
        public void setMenuExibicoes(JMenuItem menuExibicoes) {
            this.menuExibicoes = menuExibicoes;
        }
    
        public JMenuItem getMenuFilmes() {
            return menuFilmes;
        }
    
        public void setMenuFilmes(JMenuItem menuFilmes) {
            this.menuFilmes = menuFilmes;
        }
    
        public JMenuItem getMenuFuncionarios() {
            return menuFuncionarios;
        }
    
        public void setMenuFuncionarios(JMenuItem menuFuncionarios) {
            this.menuFuncionarios = menuFuncionarios;
        }
    
        public JMenuItem getMenuClientes() {
            return menuClientes;
        }
    
        public void setMenuClientes(JMenuItem menuClientes) {
            this.menuClientes = menuClientes;
        }
    
        public JTextField getCaixaDePesquisa() {
            return caixaDePesquisa;
        }
    
        public void setCaixaDePesquisa(JTextField caixaDePesquisa) {
            this.caixaDePesquisa = caixaDePesquisa;
        }
    
        public SalaDeExibicaoDTO getSalaDTO() {
            return salaDTO;
        }
    
        public void setSalaDTO(SalaDeExibicaoDTO salaDTO) {
            this.salaDTO = salaDTO;
        }
    
        public FilmeDTO getFilmeDTO() {
            return filmeDTO;
        }
    
        public void setFilmeDTO(FilmeDTO filmeDTO) {
            this.filmeDTO = filmeDTO;
        }
    
        public FuncionarioDTO getFuncionarioDTO() {
            return funcionarioDTO;
        }
    
        public void setFuncionarioDTO(FuncionarioDTO funcionarioDTO) {
            this.funcionarioDTO = funcionarioDTO;
        }
    
        public ExibicaoDTO getExibicaoDTO() {
            return exibicaoDTO;
        }
    
        public void setExibicaoDTO(ExibicaoDTO exibicaoDTO) {
            this.exibicaoDTO = exibicaoDTO;
        }
    
        public List<SalaDeExibicaoDTO> getSalas() {
            return salas;
        }
    
        public void setSalas(List<SalaDeExibicaoDTO> salas) {
            this.salas = salas;
        }
    
        public List<FilmeDTO> getFilmes() {
            return filmes;
        }
    
        public void setFilmes(List<FilmeDTO> filmes) {
            this.filmes = filmes;
        }
    
        public JPanel getListaDasSalas() {
            return listaDasSalas;
        }
    
        public void setListaDasSalas(JPanel listaDasSalas) {
            this.listaDasSalas = listaDasSalas;
        }
    
        public JPanel getListaDasExibicoes() {
            return listaDasExibicoes;
        }
    
        public void setListaDasExibicoes(JPanel listaDasExibicoes) {
            this.listaDasExibicoes = listaDasExibicoes;
        }
    
        public JPanel getListaDosFilmes() {
            return listaDosFilmes;
        }
    
        public void setListaDosFilmes(JPanel listaDosFilmes) {
            this.listaDosFilmes = listaDosFilmes;
        }
    
        public JPanel getListaDosFuncionarios() {
            return listaDosFuncionarios;
        }
    
        public void setListaDosFuncionarios(JPanel listaDosFuncionarios) {
            this.listaDosFuncionarios = listaDosFuncionarios;
        }
    
        public JPanel getListaDosClientes() {
            return listaDosClientes;
        }
    
        public void setListaDosClientes(JPanel listaDosClientes) {
            this.listaDosClientes = listaDosClientes;
        }

    }

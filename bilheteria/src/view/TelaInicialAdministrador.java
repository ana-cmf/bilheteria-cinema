package view;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.ExibicaoDTO;
import dto.FilmeDTO;
import dto.FuncionarioDTO;
import dto.SalaDeExibicaoDTO;
import model.Funcionario;

public class TelaInicialAdministrador extends JFrame {

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

    private List<SalaDeExibicaoDTO> salas = new ArrayList<>();
    private List<FilmeDTO> filmes = new ArrayList<>();
    private List<FuncionarioDTO> funcionarios = new ArrayList<>();
    private List<ExibicaoDTO> exibicoes = new ArrayList<>();

    private JPanel listaDasSalas;
    private JPanel listaDasExibicoes;
    private JPanel listaDosFilmes;
    private JPanel listaDosFuncionarios;
    private JPanel listaDosClientes;

    private JPanel formularioEdicao;
    private JComboBox<Integer> campoNumeroSala;
    private JComboBox<Integer> campoQuantidadeAssentos;
    private JComboBox<String> campoModeloExibicao;
    private JButton botaoSalvarMudancas;

    private JButton botaoEditar;
    private JButton botaoExcluir;
    private JButton botaoCriar;

    public TelaInicialAdministrador() {
        adicionarMenu();
        adicionarBotaoLogin();
        adicionarCaixaDePesquisa();
        adicionarListaDeSalas();
        adicionarBotoesDeEdicao();
        criarTela();
        repaint();
    }

    public void criarTela() {
        setIconImage(Imagens.ICONE_TOPO_DA_JANELA);
        setTitle("Absolute Cinema");
        setLayout(null);
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
        setSize(tamanhoDaTela());

        JLabel nomeDoTopo = new JLabel("ABSOLUTE CINEMA");
        nomeDoTopo.setFont(new Font("Futura", Font.BOLD, 16));
        nomeDoTopo.setBounds(20, 25, 170, 30);
        add(nomeDoTopo);
        setVisible(true);
    }

    public void adicionarMenu() {
        JMenuBar barraDeMenu = new JMenuBar();
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

    public void adicionarBotaoLogin() {
        this.botaoLogin = criarBotaoVermelho();
        botaoLogin.setBounds(200,25,100,30);
        botaoLogin.setText("Login");
        botaoLogin.setVisible(true);
        add(botaoLogin);
    }
    
    public JButton criarBotaoVermelho(){
        JButton botaoVermelho = new JButton();
        botaoVermelho.setBackground(adicionarCor(191, 3, 4));
        botaoVermelho.setForeground(Color.WHITE);
        botaoVermelho.setBorder(null);
        return botaoVermelho;
    }

    public void adicionarCaixaDePesquisa() {
        this.caixaDePesquisa = new JTextField();
        int largura = 300;
        int margemEsquerda = (int) (tamanhoDaTela().getWidth() - largura - 40);
        caixaDePesquisa.setBounds(margemEsquerda, botaoLogin.getY() + 10, largura, 20);
        caixaDePesquisa.setVisible(true);

        JLabel pesquisarFilme = new JLabel("Pesquisar filme:");
        largura = 110;
        pesquisarFilme.setBounds(margemEsquerda - largura, caixaDePesquisa.getY(), largura, 20);
        pesquisarFilme.setLabelFor(caixaDePesquisa);
        pesquisarFilme.setVisible(true);
        add(pesquisarFilme);
        add(caixaDePesquisa);
    }

    public void moverPainelParaEsquerda(JPanel painel) {
        painel.setVisible(false);
        painel.setBounds(20, painel.getY(), painel.getWidth(), painel.getHeight());
        painel.setVisible(true);
    }

    public void removerListaDasSalas() {
        listaDasSalas.setVisible(false);
    }

    public void adicionarListaDeSalas() {

        List<SalaDeExibicaoDTO> salasCadastradas = new ArrayList<SalaDeExibicaoDTO>();
        for (int i = 1; i < 11; i++) {
            SalaDeExibicaoDTO dto = new SalaDeExibicaoDTO();
            dto.setNumeroDaSala(i);
            salasCadastradas.add(dto);
        }

        JPanel conteiner = new JPanel();
        int quantidadeDeItensDetalhados = salasCadastradas.size();
        if (quantidadeDeItensDetalhados < 10) {
            quantidadeDeItensDetalhados = 10;
        }
        conteiner.setLayout(new GridLayout(quantidadeDeItensDetalhados, 1, 5, 5));

        class OuvinteSelecao implements ActionListener {

            private SalaDeExibicaoDTO salaRelacionada;

            public OuvinteSelecao(SalaDeExibicaoDTO salaRelacionada) {
                this.salaRelacionada = salaRelacionada;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JCheckBox) {
                    JCheckBox selecao = (JCheckBox) e.getSource();
                    if (selecao.isSelected()) {
                        getSalas().add(salaRelacionada);
                    } else if (getSalas().contains(salaRelacionada)) {
                        getSalas().remove(salaRelacionada);
                    }

                    if(getSalas().size() == 1){
                        botaoEditar.setEnabled(true);
                    }else{
                        botaoEditar.setEnabled(false);
                    }
                    if(getSalas().size() >= 1){
                        botaoExcluir.setEnabled(true);
                    }else{
                        botaoExcluir.setEnabled(false);
                    }

                }

            }

        }

        for (SalaDeExibicaoDTO sala : salasCadastradas) {

            JPanel conteinerDetalhes = new JPanel();
            JCheckBox selecao = new JCheckBox();
            selecao.addActionListener(new OuvinteSelecao(sala));

            JTextArea informacoes = new JTextArea(sala.toString());
            informacoes.setEditable(false);
            informacoes.setCaretColor(conteiner.getBackground());
            informacoes.setDisabledTextColor(Color.black);
            informacoes.setOpaque(false);

            conteinerDetalhes.add(selecao);
            conteinerDetalhes.add(informacoes);
            conteiner.add(conteinerDetalhes);
        }

        JScrollPane painelBarraDeRolagem = new JScrollPane();
        painelBarraDeRolagem.setViewportView(conteiner);
        painelBarraDeRolagem.setAlignmentX(CENTER_ALIGNMENT);
        int larguraListaBotoes = 400;
        int alturaListaBotoes = 500;
        int margemEsquerdaBotoes = (int) (tamanhoDaTela().getWidth() / 2 - larguraListaBotoes / 2);
        painelBarraDeRolagem.setBounds(margemEsquerdaBotoes, 100, larguraListaBotoes, alturaListaBotoes);
        painelBarraDeRolagem.setPreferredSize(new Dimension(larguraListaBotoes, alturaListaBotoes));
        painelBarraDeRolagem.setBorder(null);
        conteiner.setVisible(true);
        painelBarraDeRolagem.setVisible(true);

        JLabel tituloSalas = new JLabel("Salas de exibição");
        tituloSalas.setBounds(0, 20, larguraListaBotoes, 30);
        tituloSalas.setFont(new Font("Futura", Font.BOLD, 16));
        tituloSalas.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        tituloSalas.setHorizontalAlignment(SwingConstants.CENTER);
        tituloSalas.setVisible(true);

        this.listaDasSalas = new JPanel();
        listaDasSalas.setBounds(margemEsquerdaBotoes, 200, larguraListaBotoes, alturaListaBotoes + 100);
        listaDasSalas.setVisible(true);
        listaDasSalas.add(tituloSalas);
        listaDasSalas.add(painelBarraDeRolagem);
        add(listaDasSalas);
    }

    public void adicionarListaDeFilmes() {

        this.filmes = new ArrayList<FilmeDTO>();
        for (int i = 1; i < 11; i++) {
            // FilmeDTO dto = new FilmeDTO();
            // filmes.add(dto);
        }

        JPanel conteiner = new JPanel();
        int quantidadeDeItensDetalhados = filmes.size();
        if (quantidadeDeItensDetalhados < 10) {
            quantidadeDeItensDetalhados = 10;
        }
        conteiner.setLayout(new GridLayout(quantidadeDeItensDetalhados, 1, 5, 5));

        class OuvinteSelecaoFilme implements ActionListener {

            private FilmeDTO filmeRelacionado;

            public OuvinteSelecaoFilme(FilmeDTO filmeRelacionado) {
                this.filmeRelacionado = filmeRelacionado;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JCheckBox) {
                    JCheckBox selecao = (JCheckBox) e.getSource();
                    if (selecao.isSelected()) {
                        getFilmes().add(filmeRelacionado);
                    } else if (getFilmes().contains(filmeRelacionado)) {
                        getFilmes().remove(filmeRelacionado);
                    }

                    if(getFilmes().size() == 1){
                        botaoEditar.setEnabled(true);
                    }else{
                        botaoEditar.setEnabled(false);
                    }
                    if(getFilmes().size() >= 1){
                        botaoExcluir.setEnabled(true);
                    }else{
                        botaoExcluir.setEnabled(false);
                    }

                }

            }

        }

        for (FilmeDTO filme : filmes) {

            JPanel conteinerDetalhes = new JPanel();
            JCheckBox selecao = new JCheckBox();
            selecao.addActionListener(new OuvinteSelecaoFilme(filme));

            JTextArea informacoes = new JTextArea(filme.toString());
            informacoes.setEditable(false);
            informacoes.setCaretColor(conteiner.getBackground());
            informacoes.setDisabledTextColor(Color.black);
            informacoes.setOpaque(false);

            conteinerDetalhes.add(selecao);
            conteinerDetalhes.add(informacoes);
            conteiner.add(conteinerDetalhes);
        }

        JScrollPane painelBarraDeRolagem = new JScrollPane();
        painelBarraDeRolagem.setViewportView(conteiner);
        painelBarraDeRolagem.setAlignmentX(CENTER_ALIGNMENT);
        int larguraListaBotoes = 400;
        int alturaListaBotoes = 500;
        int margemEsquerdaBotoes = (int) (tamanhoDaTela().getWidth() / 2 - larguraListaBotoes / 2);
        painelBarraDeRolagem.setBounds(margemEsquerdaBotoes, 100, larguraListaBotoes, alturaListaBotoes);
        painelBarraDeRolagem.setPreferredSize(new Dimension(larguraListaBotoes, alturaListaBotoes));
        painelBarraDeRolagem.setBorder(null);
        conteiner.setVisible(true);
        painelBarraDeRolagem.setVisible(true);

        JLabel tituloFilmes = new JLabel("Filmes");
        tituloFilmes.setBounds(0, 20, larguraListaBotoes, 30);
        tituloFilmes.setFont(new Font("Futura", Font.BOLD, 16));
        tituloFilmes.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        tituloFilmes.setHorizontalAlignment(SwingConstants.CENTER);
        tituloFilmes.setVisible(true);

        this.listaDosFilmes = new JPanel();
        listaDosFilmes.setBounds(margemEsquerdaBotoes, 200, larguraListaBotoes, alturaListaBotoes + 100);
        listaDosFilmes.setVisible(true);
        listaDosFilmes.add(tituloFilmes);
        listaDosFilmes.add(painelBarraDeRolagem);
        add(listaDosFilmes);
    }

    public void adicionarListaDeExibicoes() {

        this.exibicoes = new ArrayList<ExibicaoDTO>();
        for (int i = 1; i < 11; i++) {
            // FilmeDTO dto = new FilmeDTO();
            // filmes.add(dto);
        }

        JPanel conteiner = new JPanel();
        int quantidadeDeItensDetalhados = filmes.size();
        if (quantidadeDeItensDetalhados < 10) {
            quantidadeDeItensDetalhados = 10;
        }
        conteiner.setLayout(new GridLayout(quantidadeDeItensDetalhados, 1, 5, 5));
        for (ExibicaoDTO dto : exibicoes) {
            JButton botaoExibicao = new JButton(dto.toString());
            botaoExibicao.setMaximumSize(new Dimension(250, 20));
            botaoExibicao.setBackground(adicionarCor(191, 4, 3));
            botaoExibicao.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            conteiner.add(botaoExibicao);
        }

        JScrollPane painelBarraDeRolagem = new JScrollPane();
        painelBarraDeRolagem.setViewportView(conteiner);
        painelBarraDeRolagem.setAlignmentX(CENTER_ALIGNMENT);
        int larguraListaBotoes = 400;
        int alturaListaBotoes = 500;
        int margemEsquerdaBotoes = (int) (tamanhoDaTela().getWidth() / 2 - larguraListaBotoes / 2);
        painelBarraDeRolagem.setBounds(margemEsquerdaBotoes, 100, larguraListaBotoes, alturaListaBotoes);
        painelBarraDeRolagem.setPreferredSize(new Dimension(larguraListaBotoes, alturaListaBotoes));
        painelBarraDeRolagem.setBorder(null);
        conteiner.setVisible(true);
        painelBarraDeRolagem.setVisible(true);

        JLabel tituloFilmes = new JLabel("Filmes");
        tituloFilmes.setBounds(0, 20, larguraListaBotoes, 30);
        tituloFilmes.setFont(new Font("Futura", Font.BOLD, 16));
        tituloFilmes.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        tituloFilmes.setHorizontalAlignment(SwingConstants.CENTER);
        tituloFilmes.setVisible(true);

        this.listaDasSalas = new JPanel();
        listaDasSalas.setBounds(margemEsquerdaBotoes, 200, larguraListaBotoes, alturaListaBotoes + 100);
        listaDasSalas.setVisible(true);
        listaDasSalas.add(tituloFilmes);
        listaDasSalas.add(painelBarraDeRolagem);
        add(listaDasSalas);
    }

    public void adicionarListaDeFuncionarios() {

        this.funcionarios = new ArrayList<FuncionarioDTO>();
        for (int i = 1; i < 11; i++) {
            // FilmeDTO dto = new FilmeDTO();
            // filmes.add(dto);
        }

        JPanel conteiner = new JPanel();
        int quantidadeDeItensDetalhados = filmes.size();
        if (quantidadeDeItensDetalhados < 10) {
            quantidadeDeItensDetalhados = 10;
        }
        conteiner.setLayout(new GridLayout(quantidadeDeItensDetalhados, 1, 5, 5));
        for (FuncionarioDTO dto : funcionarios) {
            JButton botaoFuncionario = new JButton(dto.getNomeCompleto());
            botaoFuncionario.setMaximumSize(new Dimension(250, 20));
            botaoFuncionario.setBackground(adicionarCor(191, 4, 3));
            botaoFuncionario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            conteiner.add(botaoFuncionario);
        }

        JScrollPane painelBarraDeRolagem = new JScrollPane();
        painelBarraDeRolagem.setViewportView(conteiner);
        painelBarraDeRolagem.setAlignmentX(CENTER_ALIGNMENT);
        int larguraListaBotoes = 400;
        int alturaListaBotoes = 500;
        int margemEsquerdaBotoes = (int) (tamanhoDaTela().getWidth() / 2 - larguraListaBotoes / 2);
        painelBarraDeRolagem.setBounds(margemEsquerdaBotoes, 100, larguraListaBotoes, alturaListaBotoes);
        painelBarraDeRolagem.setPreferredSize(new Dimension(larguraListaBotoes, alturaListaBotoes));
        painelBarraDeRolagem.setBorder(null);
        conteiner.setVisible(true);
        painelBarraDeRolagem.setVisible(true);

        JLabel tituloFilmes = new JLabel("Filmes");
        tituloFilmes.setBounds(0, 20, larguraListaBotoes, 30);
        tituloFilmes.setFont(new Font("Futura", Font.BOLD, 16));
        tituloFilmes.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        tituloFilmes.setHorizontalAlignment(SwingConstants.CENTER);
        tituloFilmes.setVisible(true);

        this.listaDasSalas = new JPanel();
        listaDasSalas.setBounds(margemEsquerdaBotoes, 200, larguraListaBotoes, alturaListaBotoes + 100);
        listaDasSalas.setVisible(true);
        listaDasSalas.add(tituloFilmes);
        listaDasSalas.add(painelBarraDeRolagem);
        add(listaDasSalas);
    }

    public void adicionarBotoesDeEdicao(){
        JPanel botoesEdicao = new JPanel();
        botoesEdicao.setLayout(new GridLayout(1,0,5,5));
        int largura = 310;
        int x = (int) (tamanhoDaTela().getWidth() - largura - 40);
        botoesEdicao.setBounds(x, 120, largura, 30);

        this.botaoEditar = criarBotaoVermelho();
        botaoEditar.setText("Editar");
        botaoEditar.setEnabled(false);
        botaoEditar.setVisible(true);
        
        this.botaoCriar = criarBotaoVermelho();
        botaoCriar.setText("Criar");
        botaoCriar.setVisible(true);
        
        this.botaoExcluir = criarBotaoVermelho();
        botaoExcluir.setText("Excluir");
        botaoExcluir.setEnabled(false);
        botaoExcluir.setVisible(true);

        botoesEdicao.add(botaoEditar);
        botoesEdicao.add(botaoExcluir);
        botoesEdicao.add(botaoCriar);
        botoesEdicao.setVisible(true);
        add(botoesEdicao);
    }

    public void adicionarFormularioEdicao() {
        this.formularioEdicao = new JPanel();
        //formularioEdicao.setLayout(null);

        int margemEsquerda;
        int margemSuperior;
        int largura;
        int altura;
        margemEsquerda = (int) (tamanhoDaTela().getWidth() / 2);
        margemSuperior = (int) (tamanhoDaTela().getHeight() / 5);
        largura = (int) (margemEsquerda * 0.75);
        altura = (int) (tamanhoDaTela().getHeight() * 0.75);
        formularioEdicao.setBounds(margemEsquerda, margemSuperior, largura, altura);

        JLabel tituloEdicao = new JLabel("Editar Sala");
        tituloEdicao.setFont(new Font("Futura", Font.BOLD, 20));
        tituloEdicao.setBounds(0, 30, largura, 50);
        tituloEdicao.setHorizontalAlignment(SwingConstants.CENTER);

        int alturaComponentes = 20;
        int larguraComponentes = largura/2;
        int XComponentes = largura/4;
        int espaco = 20;

        Font fonteFormulario = new Font("Futura", Font.BOLD, 14);
        JLabel numeroSala = new JLabel("Número da sala:");
        numeroSala.setFont(fonteFormulario);
        numeroSala.setBounds(XComponentes, tituloEdicao.getY() + 50 + espaco, larguraComponentes,
                alturaComponentes);

        int numMaximoSala = 999;
        Integer[] numeros = new Integer[numMaximoSala];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i + 1;
        }

        this.campoNumeroSala = new JComboBox<>(numeros);
        campoNumeroSala.setBounds(XComponentes, numeroSala.getY() + alturaComponentes + espaco, larguraComponentes,
                alturaComponentes);
        campoNumeroSala.setName("Número da sala");
        campoNumeroSala.setVisible(true);

        JLabel quantidadeAssentos = new JLabel("Quantidade de assentos:");
        quantidadeAssentos.setFont(fonteFormulario);
        quantidadeAssentos.setBounds(XComponentes, campoNumeroSala.getY() + alturaComponentes + espaco, larguraComponentes, alturaComponentes);

        int maximoAssentos = 40;
        Integer[] quantidades = new Integer[maximoAssentos];
        for (int index = 0; index < quantidades.length; index++) {
            quantidades[index] = index + 1;

        }

        this.campoQuantidadeAssentos = new JComboBox<>(quantidades);
        campoQuantidadeAssentos.setBounds(XComponentes, quantidadeAssentos.getY() + alturaComponentes + espaco, larguraComponentes, alturaComponentes);
        campoQuantidadeAssentos.setName("Quantidade de assentos");
        campoQuantidadeAssentos.setVisible(true);

        JLabel modeloExibicao = new JLabel("Modelo de exibição:");
        modeloExibicao.setFont(fonteFormulario);
        modeloExibicao.setBounds(XComponentes, campoQuantidadeAssentos.getY() + alturaComponentes + espaco, larguraComponentes, alturaComponentes);

        this.campoModeloExibicao = new JComboBox<>(new String[] { "2D", "3D" });
        campoModeloExibicao.setBounds(XComponentes, modeloExibicao.getY() + alturaComponentes + espaco, larguraComponentes, alturaComponentes);
        campoModeloExibicao.setName("Modelo de exibição");
        campoModeloExibicao.setVisible(true);
        // campoNumeroSala.setSelectedItem(salaDTO.getNumeroDaSala());
        
        altura = altura - tituloEdicao.getY();// - botaoSalvarMudancas.getHeight() - espaco;
        this.botaoSalvarMudancas = criarBotaoVermelho();
        botaoSalvarMudancas.setText("Salvar");
        botaoSalvarMudancas.setBounds(espaco, altura-30-espaco, 100, 30);
        botaoSalvarMudancas.setVisible(true);

        JPanel conteiner = new JPanel();
        conteiner.setLayout(null);
        conteiner.add(tituloEdicao);
        conteiner.add(numeroSala);
        conteiner.add(campoNumeroSala);
        conteiner.add(quantidadeAssentos);
        conteiner.add(campoQuantidadeAssentos);
        conteiner.add(modeloExibicao);
        conteiner.add(campoModeloExibicao);
        conteiner.add(botaoSalvarMudancas);
        
        JScrollPane painelBarraDeRolagem = new JScrollPane();
        painelBarraDeRolagem.setViewportView(conteiner);
        painelBarraDeRolagem.setAlignmentX(CENTER_ALIGNMENT);
        
        painelBarraDeRolagem.setBounds(margemEsquerda, margemSuperior, largura, altura);
        painelBarraDeRolagem.setPreferredSize(new Dimension(largura, altura));
        painelBarraDeRolagem.setBorder(null);
        conteiner.setBounds(margemEsquerda, margemSuperior, largura, altura);
        conteiner.setVisible(true);
        painelBarraDeRolagem.setVisible(true);
        formularioEdicao.setVisible(true);
        formularioEdicao.add(painelBarraDeRolagem);
        add(formularioEdicao);
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

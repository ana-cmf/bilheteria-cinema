package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.AdministradorController;
import dto.AdministradorDTO;

public class TelaCadastroAdministrador extends JFrame implements ActionListener, KeyListener{

    private AdministradorDTO admin;
    private JLabel imagemLogo;
    private JLabel mensagemErroNome;
    private JLabel mensagemErroSenha;
    
    private JPanel quadradoVermelho;
    private JTextField campoNome;
    private JPasswordField campoSenha;
    private JButton botaoCadastrar;
    private AdministradorController controller;
    
    
    public TelaCadastroAdministrador(AdministradorController controller){
        this.controller = controller;
        criarTela();
    }
    
    public void criarTela(){
        setIconImage(Imagens.ICONE_TOPO_DA_JANELA);
        setTitle("Absolute Cinema");
        setLayout(null);
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
        setSize(900, 800);
        adicionarImagemLogo();
        adicionarFormulario();
        setVisible(true);
    }
    
    public void adicionarImagemLogo() {
        this.imagemLogo = new JLabel(Imagens.IMAGEM_GRANDE_LOGO);
    	imagemLogo.setBounds(10, 40, 750, 750);
    	imagemLogo.setVisible(true);
    	add(imagemLogo);
    }
    
    public void adicionarFormulario(){
        this.quadradoVermelho = new JPanel();
        quadradoVermelho.setBackground(adicionarCor(191, 3, 4));
        quadradoVermelho.setOpaque(true);
        quadradoVermelho.setLayout(null);
        
        int margemEsquerda;
        int margemSuperior;
        int largura;
        int altura;
        margemEsquerda = (int) (tamanhoDaTela().getWidth()/2); 
        margemSuperior = (int) (tamanhoDaTela().getHeight()/5);
        largura = (int) (margemEsquerda*0.75);
        altura = (int) (tamanhoDaTela().getHeight()*0.6);
        quadradoVermelho.setBounds(margemEsquerda, margemSuperior, largura, altura);
        
        JLabel tituloCadastro = new JLabel("Cadastro do administrador");
        tituloCadastro.setFont(new Font("Futura", Font.BOLD, 20));
        tituloCadastro.setForeground(Color.WHITE);
        tituloCadastro.setBounds(160, 30, largura, 50);
        quadradoVermelho.add(tituloCadastro);
        
        Font fonteFormulario = new Font("Futura", Font.BOLD, 14);
        JLabel nome = new JLabel("Nome de usuário:");
        nome.setFont(fonteFormulario);
        nome.setForeground(Color.WHITE);
        nome.setBounds(largura/4, altura/3, largura/2, 20);
        quadradoVermelho.add(nome);
        
        this.campoNome = new JTextField();
        campoNome.setBounds(largura/4, nome.getY()+40, largura/2, 20);
        campoNome.setBorder(null);
        campoNome.addKeyListener(this);
        quadradoVermelho.add(campoNome);
        
        Font fonteErro = new Font("Futura", Font.ITALIC, 12);
        this.mensagemErroNome = new JLabel("Nome inválido!");
        mensagemErroNome.setFont(fonteErro);
        mensagemErroNome.setForeground(Color.YELLOW);
        mensagemErroNome.setBounds(largura/4, campoNome.getY()+campoNome.getHeight(), campoNome.getWidth(), 12);
        mensagemErroNome.setVisible(false);
        quadradoVermelho.add(mensagemErroNome);
        
        JLabel senha = new JLabel("Senha:");
        senha.setFont(fonteFormulario);
        senha.setForeground(Color.WHITE);
        senha.setBounds(largura/4, altura/2, largura/2, 20);
        quadradoVermelho.add(senha);
        
        this.campoSenha = new JPasswordField();
        campoSenha.setBounds(largura/4, senha.getY()+40, largura/2, 20);
        campoSenha.setBorder(null);
        campoSenha.addKeyListener(this);
        quadradoVermelho.add(campoSenha);
        
        this.mensagemErroSenha = new JLabel("Senha inválida!");
        mensagemErroSenha.setFont(fonteErro);
        mensagemErroSenha.setForeground(Color.YELLOW);
        mensagemErroSenha.setBounds(largura/4, campoSenha.getY()+campoSenha.getHeight(), campoSenha.getWidth(), 12);
        mensagemErroSenha.setVisible(false);
        quadradoVermelho.add(mensagemErroSenha);

        this.botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBackground(Color.LIGHT_GRAY);
        botaoCadastrar.setBounds(largura/3, (int) (altura*0.75), largura/3, 60);
        botaoCadastrar.setEnabled(false);
        botaoCadastrar.addActionListener(this);
        quadradoVermelho.add(botaoCadastrar);
        
        quadradoVermelho.setVisible(true);
        add(quadradoVermelho);
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
    
    public AdministradorDTO salvarDadosParaAdministrador(){
        AdministradorDTO dto = new AdministradorDTO();
        dto.setNomeUsuario(campoNome.getText());
        dto.setSenha(new String(campoSenha.getPassword()));
        return dto;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botaoCadastrar){
            admin = new AdministradorDTO();
            admin.setNomeUsuario(campoNome.getText());
            admin.setSenha(new String(campoSenha.getPassword()));
            controller.cadastrarAdministrador(admin);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {

        if(e.getSource() == campoNome){
            mostrarMensagensDeErroDoNome();
        }
        habilitarBotao();
       
    }

    public void mostrarMensagensDeErroDoNome(){
        boolean nomeEstaInvalido = campoNome.getText().isBlank();
        mensagemErroNome.setVisible(nomeEstaInvalido);
    }
    
    public void mostrarMensagensDeErroDaSenha(){
        mensagemErroNome.setVisible(true);
    }
    
    public void habilitarBotao(){
        if(!campoNome.getText().isBlank() && campoSenha.getPassword().length >= 6){
            botaoCadastrar.setEnabled(true);
        }else{
            botaoCadastrar.setEnabled(false);
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        habilitarBotao();
    }
    
    public void mudarParaTelaDeLogin(){
        new TelaLogin();
        dispose();
    }
    
    public JLabel getMensagemErroNome() {
        return mensagemErroNome;
    }
    
    public void setMensagemErroNome(JLabel mensagemErroNome) {
        this.mensagemErroNome = mensagemErroNome;
    }
    
    public JLabel getMensagemErroSenha() {
        return mensagemErroSenha;
    }
    
    public void setMensagemErroSenha(JLabel mensagemErroSenha) {
        this.mensagemErroSenha = mensagemErroSenha;
    }
    public AdministradorDTO getAdmin() {
        return admin;
    }
    
    public void setAdmin(AdministradorDTO admin) {
        this.admin = admin;
    }
    
    public JLabel getImagemLogo() {
        return imagemLogo;
    }
    
    public void setImagemLogo(JLabel imagemLogo) {
        this.imagemLogo = imagemLogo;
    }
    
    public JPanel getQuadradoVermelho() {
        return quadradoVermelho;
    }
    
    public void setQuadradoVermelho(JPanel quadradoVermelho) {
        this.quadradoVermelho = quadradoVermelho;
    }
    
    public JTextField getCampoNome() {
        return campoNome;
    }
    
    public void setCampoNome(JTextField campoNome) {
        this.campoNome = campoNome;
    }
    
    public JPasswordField getCampoSenha() {
        return campoSenha;
    }
    
    public void setCampoSenha(JPasswordField campoSenha) {
        this.campoSenha = campoSenha;
    }
    
    public JButton getBotaoCadastrar() {
        return botaoCadastrar;
    }
    
    public void setBotaoCadastrar(JButton botaoCadastrar) {
        this.botaoCadastrar = botaoCadastrar;
    }
    
    public AdministradorController getController() {
        return controller;
    }
    
    public void setController(AdministradorController controller) {
        this.controller = controller;
    }
    
    public static void main(String[] args) {
        new AdministradorController();
    }
    

    
}

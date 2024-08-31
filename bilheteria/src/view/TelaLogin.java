package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dto.AdministradorDTO;
import dto.FuncionarioDTO;

public class TelaLogin extends JFrame{

    private JLabel imagemLogo;
    private JPanel quadradoVermelho;
    private JTextField campoNome;
    private JPasswordField campoSenha;
    private JButton botaoEntrar;

    public TelaLogin(){
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

        JLabel tituloLogin = new JLabel("Login");
        tituloLogin.setFont(new Font("Futura", Font.BOLD, 20));
        tituloLogin.setForeground(Color.WHITE);
        tituloLogin.setBounds(260, 30, largura, 50);
        quadradoVermelho.add(tituloLogin);
        
        JLabel nome = new JLabel("Nome de usuário ou email:");
        nome.setFont(new Font("Futura", Font.BOLD, 14));
        nome.setForeground(Color.WHITE);
        nome.setBounds(largura/4, altura/3, largura/2, 20);
        quadradoVermelho.add(nome);

        this.campoNome = new JTextField();
        campoNome.setBounds(largura/4, nome.getY()+40, largura/2, 20);
        quadradoVermelho.add(campoNome);
        
        JLabel senha = new JLabel("Senha:");
        senha.setFont(new Font("Futura", Font.BOLD, 14));
        senha.setForeground(Color.WHITE);
        senha.setBounds(largura/4, altura/2, largura/2, 20);
        quadradoVermelho.add(senha);
        
        this.campoSenha = new JPasswordField();
        campoSenha.setBounds(largura/4, senha.getY()+40, largura/2, 20);
        quadradoVermelho.add(campoSenha);

        this.botaoEntrar = new JButton("Entrar");
        botaoEntrar.setBackground(Color.LIGHT_GRAY);
        botaoEntrar.setBounds(largura/3, (int) (altura*0.75), largura/3, 60);
        quadradoVermelho.add(botaoEntrar);

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
    
    public FuncionarioDTO salvarDadosParaFuncionario(){
        FuncionarioDTO dto = new FuncionarioDTO();
        dto.setEmail(campoNome.getText());
        dto.setSenha(new String(campoSenha.getPassword()));
        return dto;
    }
    public static void main(String[] args) {
        new TelaLogin();
    }

}

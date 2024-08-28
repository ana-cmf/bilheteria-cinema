package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dto.AdministradorDTO;

public class TelaCadastroAdministrador extends JFrame{

    private AdministradorDTO admin;
    private JLabel imagemLogo;
    private JPanel quadradoVermelho;
    private JTextField campoNome;
    private JTextField campoSenha;
    
    public TelaCadastroAdministrador(){
        setIconImage(Imagens.ICONE_TOPO_DA_JANELA);
        setTitle("Absolute Cinema");
        setSize(900, 800);
        adicionarImagemLogo();
        setVisible(true);
    }
    
    public void adicionarImagemLogo() {
    	this.imagemLogo = new JLabel(Imagens.IMAGEM_GRANDE_LOGO);
    	imagemLogo.setBounds(20, 60, 700, 700);
    	imagemLogo.setVisible(true);
    	add(imagemLogo);
    }

    public static void main(String[] args) {
        new TelaCadastroAdministrador();
    }
}

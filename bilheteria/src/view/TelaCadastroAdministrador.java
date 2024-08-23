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
    }

    public static void main(String[] args) {
        new TelaCadastroAdministrador();
    }
}

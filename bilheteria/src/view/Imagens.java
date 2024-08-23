package view;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Imagens {

	public static final Image ICONE_TOPO_DA_JANELA = Toolkit.getDefaultToolkit().getImage(Imagens.class.getResource("/logo-grande.png"));

	public static final ImageIcon IMAGEM_GRANDE_LOGO = new ImageIcon(Imagens.class.getResource("/logo-icone-pequeno.png"));
}

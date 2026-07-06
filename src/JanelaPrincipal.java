import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;

//ferramentas para pegar o tamanho da tela
import java.awt.Dimension;
import java.awt.Toolkit;

public class JanelaPrincipal extends JFrame {

	private GerenciadorPersonagens gerenciador;
	private TelaDestaques telaDestaques;
	private TelaEdicao telaEdicao;

	public JanelaPrincipal() {
		this(new GerenciadorPersonagens());
	}

	public JanelaPrincipal(GerenciadorPersonagens gerenciador) {
		this.gerenciador = gerenciador;
		configurarJanela();
		montarTelas();
	}

	public GerenciadorPersonagens getGerenciador() {
		return gerenciador;
	}

	private void configurarJanela() {
		setTitle("Gerenciador de Personagens");

		Dimension tamanhoTela = Toolkit.getDefaultToolkit().getScreenSize(); // pega as dimençoes da tela

		int largura = (int) (tamanhoTela.width * 0.9);
		int altura = (int) (tamanhoTela.height * 0.9);

		setSize(largura, altura);
		setLocationRelativeTo(null); // centraliza janela
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
	}

	private void montarTelas() {
		telaDestaques = new TelaDestaques(gerenciador);
		telaEdicao  = new TelaEdicao(gerenciador);
		TelaCadastro telaCadastro = new TelaCadastro(gerenciador, this::atualizarTelas);

		JTabbedPane abas = new JTabbedPane();
		abas.addTab("Cadastro", telaCadastro);
		abas.addTab("Destaques", telaDestaques);
		abas.addTab("Personagens", telaEdicao);
		abas.addChangeListener(e -> atualizarTelas());

		add(abas, BorderLayout.CENTER);
		atualizarTelas();
	}

	public void atualizarTelas() {
		telaDestaques.atualizar();
		telaEdicao.montarTela();
	}

}

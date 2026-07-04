import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;

public class JanelaPrincipal extends JFrame {

	private GerenciadorPersonagens gerenciador;
	private TelaDestaques telaDestaques;

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
		setSize(820, 560);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
	}

	private void montarTelas() {
		telaDestaques = new TelaDestaques(gerenciador);

		TelaCadastro telaCadastro = new TelaCadastro(gerenciador, this::atualizarTelas);

		JTabbedPane abas = new JTabbedPane();
		abas.addTab("Cadastro", telaCadastro);
		abas.addTab("Destaques", telaDestaques);
		abas.addChangeListener(e -> atualizarTelas());

		add(abas, BorderLayout.CENTER);
		atualizarTelas();
	}

	public void atualizarTelas() {
		telaDestaques.atualizar();
	}

}

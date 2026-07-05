import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;

//ferramentas para pegar o tamanho da tela
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.LinkedHashMap;

public class JanelaPrincipal extends JFrame {

	private GerenciadorPersonagens gerenciador;
	private TelaDestaques telaDestaques;
	private LinkedHashMap<String, JPanel> telas;

	public JanelaPrincipal() {
		this(new GerenciadorPersonagens());
	}

	public JanelaPrincipal(GerenciadorPersonagens gerenciador) {
		this.gerenciador = gerenciador;
		this.telas = new LinkedHashMap<>();
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

		TelaCadastro telaCadastro = new TelaCadastro(gerenciador, this::atualizarTelas);

		adicionarTela("Cadastro", telaCadastro);
		adicionarTela("Destaques", telaDestaques);

		JTabbedPane abas = new JTabbedPane();

		for (String nome : telas.keySet()) {
			abas.addTab(nome, telas.get(nome));
		}

		abas.addChangeListener(e -> atualizarTelas());

		add(abas, BorderLayout.CENTER);
		atualizarTelas();
	}

	private void adicionarTela(String nome, JPanel tela) {
		telas.put(nome, tela);
	}

	public void atualizarTelas() {
		for (JPanel tela : telas.values()) {
			if (tela instanceof Atualizavel) {
				((Atualizavel) tela).atualizar();
			}
		}
	}

}
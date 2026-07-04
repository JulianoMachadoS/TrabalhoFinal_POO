import javax.swing.SwingUtilities;

public class App {

	private GerenciadorPersonagens gerenciadorPersonagens;

	public App() {
		this.gerenciadorPersonagens = new GerenciadorPersonagens();
	}

	public GerenciadorPersonagens getGerenciadorPersonagens() {
		return gerenciadorPersonagens;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			App app = new App();
			app.getGerenciadorPersonagens().carregarDadosIniciais();
			new JanelaPrincipal(app.getGerenciadorPersonagens()).setVisible(true);
		});
	}

}

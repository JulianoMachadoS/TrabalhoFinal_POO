import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class TelaCadastro extends JPanel {

	private GerenciadorPersonagens gerenciador;
	private Runnable aoCadastrar;
	private JComboBox<String> tipoCombo;
	private JTextField nomeCampo;
	private JSpinner nivelCampo;
	private JComboBox<Armas> armaCombo;
	private JComboBox<ElementoMagico> elementoCombo;
	private JSpinner forcaCampo;
	private JSpinner defesaCampo;
	private JSpinner manaCampo;
	private JSpinner poderMagicoCampo;

	public TelaCadastro(GerenciadorPersonagens gerenciador, Runnable aoCadastrar) {
		this.gerenciador = gerenciador;
		this.aoCadastrar = aoCadastrar;
		montarTela();
	}

	private void montarTela() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(8, 8, 8, 8);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		tipoCombo = new JComboBox<>(new String[] { "Guerreiro", "Mago" });
		nomeCampo = new JTextField(24);
		nivelCampo = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
		armaCombo = new JComboBox<>(Armas.values());
		elementoCombo = new JComboBox<>(ElementoMagico.values());
		forcaCampo = new JSpinner(new SpinnerNumberModel(1, 0, 999, 1));
		defesaCampo = new JSpinner(new SpinnerNumberModel(1, 0, 999, 1));
		manaCampo = new JSpinner(new SpinnerNumberModel(1, 0, 999, 1));
		poderMagicoCampo = new JSpinner(new SpinnerNumberModel(1, 0, 999, 1));

		adicionarCampo(gbc, 0, "Classe", tipoCombo);
		adicionarCampo(gbc, 1, "Nome", nomeCampo);
		adicionarCampo(gbc, 2, "Nivel", nivelCampo);
		adicionarCampo(gbc, 3, "Arma", armaCombo);
		adicionarCampo(gbc, 4, "Elemento", elementoCombo);
		adicionarCampo(gbc, 5, "Forca", forcaCampo);
		adicionarCampo(gbc, 6, "Defesa", defesaCampo);
		adicionarCampo(gbc, 7, "Mana", manaCampo);
		adicionarCampo(gbc, 8, "Poder magico", poderMagicoCampo);

		JButton cadastrarBotao = new JButton("CADASTRAR");
		cadastrarBotao.addActionListener(e -> cadastrar());
		gbc.gridx = 1;
		gbc.gridy = 9;
		add(cadastrarBotao, gbc);

		tipoCombo.addActionListener(e -> atualizarCamposPorTipo());
		atualizarCamposPorTipo();
	}

	private void adicionarCampo(GridBagConstraints gbc, int linha, String texto, java.awt.Component campo) {
		gbc.gridx = 0;
		gbc.gridy = linha;
		add(new JLabel(texto), gbc);
		gbc.gridx = 1;
		add(campo, gbc);
	}

	private void atualizarCamposPorTipo() {
		boolean guerreiro = "Guerreiro".equals(tipoCombo.getSelectedItem());
		armaCombo.setEnabled(guerreiro);
		forcaCampo.setEnabled(guerreiro);
		defesaCampo.setEnabled(guerreiro);
		elementoCombo.setEnabled(!guerreiro);
		manaCampo.setEnabled(!guerreiro);
		poderMagicoCampo.setEnabled(!guerreiro);
	}

	private void cadastrar() {
		String nome = nomeCampo.getText().trim();

		if (nome.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Informe o nome do personagem.");
			return;
		}

		if (gerenciador.nomeJaExiste(nome)) {
			JOptionPane.showMessageDialog(this, "Ja existe um personagem cadastrado com esse nome.");
			return;
		}

		int nivel = (int) nivelCampo.getValue();

		if ("Guerreiro".equals(tipoCombo.getSelectedItem())) {
			gerenciador.cadastrarGuerreiro(nome, nivel, (Armas) armaCombo.getSelectedItem(),
					(int) forcaCampo.getValue(), (int) defesaCampo.getValue());
		} else {
			gerenciador.cadastrarMago(nome, nivel, (ElementoMagico) elementoCombo.getSelectedItem(),
					(int) manaCampo.getValue(), (int) poderMagicoCampo.getValue());
		}

		nomeCampo.setText("");
		aoCadastrar.run();
		JOptionPane.showMessageDialog(this, "Personagem cadastrado com sucesso.");
	}

}

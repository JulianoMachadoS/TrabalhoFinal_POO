import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

public class TelaDestaques extends JPanel {

	private GerenciadorPersonagens gerenciador;

	private JLabel[] maiorNivelLabels;
	private JLabel[] maiorAtaqueLabels;
	private JLabel[] maiorDefesaLabels;
	private JLabel[] maiorPoderMagicoLabels;

	public TelaDestaques(GerenciadorPersonagens gerenciador) {
		this.gerenciador = gerenciador;
		montarTela();
	}

	private void montarTela() {
		setLayout(new GridLayout(2, 2, 12, 12));
    	setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

		maiorNivelLabels = adicionarDestaque("Personagem com maior nivel");
		maiorAtaqueLabels = adicionarDestaque("Personagem com maior ataque");
		maiorDefesaLabels = adicionarDestaque("Guerreiro com maior defesa");
		maiorPoderMagicoLabels = adicionarDestaque("Mago com maior poder magico");
	}

	

	private JLabel[] adicionarDestaque(String titulo) {
		JPanel painelPrincipal = new JPanel(new BorderLayout());
		painelPrincipal.setBorder(BorderFactory.createEtchedBorder());

		JLabel tituloLabel = new JLabel(titulo, SwingConstants.CENTER);
		tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));

		JPanel painelDados = new JPanel(new GridLayout(0, 1, 4, 4));

		JLabel[] labels = new JLabel[8];

		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel("", SwingConstants.CENTER);
			labels[i].setFont(new Font("Arial", Font.PLAIN, 14));
			painelDados.add(labels[i]);
		}

		painelPrincipal.add(tituloLabel, BorderLayout.NORTH);
		painelPrincipal.add(painelDados, BorderLayout.CENTER);

		add(painelPrincipal);

		return labels;
	}

	public void atualizar() {
		atualizarDestaque(maiorNivelLabels, gerenciador.personagemMaiorNivel());
		atualizarDestaque(maiorAtaqueLabels, gerenciador.personagemMaiorAtaque());
		atualizarDestaque(maiorDefesaLabels, gerenciador.guerreiroMaiorDefesa());
		atualizarDestaque(maiorPoderMagicoLabels, gerenciador.magoMaiorPoderMagico());
	}

	private void atualizarDestaque(JLabel[] labels, Personagem personagem) {
		limparLabels(labels);

		if (personagem == null) {
			labels[0].setText("Nenhum personagem cadastrado");
			return;
		}

		labels[0].setText("Nome: " + personagem.getNome());
		labels[1].setText("Classe: " + personagem.getTipo());
		labels[2].setText("Nivel: " + personagem.getNivel());
		labels[3].setText("Vida: " + personagem.getVida());
		labels[4].setText("Ataque: " + personagem.getAtaque());

		if (personagem instanceof Guerreiro) {
			Guerreiro guerreiro = (Guerreiro) personagem;

			labels[5].setText("Arma: " + guerreiro.getTipoArma());
			labels[6].setText("Forca: " + guerreiro.getForca());
			labels[7].setText("Defesa: " + guerreiro.getDefesa());
		}

		if (personagem instanceof Mago) {
			Mago mago = (Mago) personagem;

			labels[5].setText("Elemento: " + mago.getElemento());
			labels[6].setText("Mana: " + mago.getMana());
			labels[7].setText("Poder magico: " + mago.getPoderMagico());
		}
	}

	private void limparLabels(JLabel[] labels) {
		for (int i = 0; i < labels.length; i++) {
			labels[i].setText("");
		}
	}

}
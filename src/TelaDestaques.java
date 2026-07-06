import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class TelaDestaques extends JPanel {

	private GerenciadorPersonagens gerenciador;
	private JLabel maiorNivelLabel;
	private JLabel maiorAtaqueLabel;
	private JLabel maiorDefesaLabel;
	private JLabel maiorPoderMagicoLabel;

	public TelaDestaques(GerenciadorPersonagens gerenciador) {
		this.gerenciador = gerenciador;
		montarTela();
	}

	private void montarTela() {
		setLayout(new GridLayout(0, 1, 8, 8));
		maiorNivelLabel = adicionarLinha();
		maiorAtaqueLabel = adicionarLinha();
		maiorDefesaLabel = adicionarLinha();
		maiorPoderMagicoLabel = adicionarLinha();
	}

	private JLabel adicionarLinha() {
		JLabel label = new JLabel();
		add(label);
		return label;
	}

	public void atualizar() {
		maiorNivelLabel.setText(      "Personagem com maior nivel:  " + formatar(gerenciador.personagemMaiorNivel()));
		maiorAtaqueLabel.setText(     "Personagem com maior ataque: " + formatar(gerenciador.personagemMaiorAtaque()));
		maiorDefesaLabel.setText(     "Guerreiro com maior defesa:  " + formatar(gerenciador.guerreiroMaiorDefesa()));
		maiorPoderMagicoLabel.setText("Mago com maior poder magico: " + formatar(gerenciador.magoMaiorPoderMagico()));
	}

	private String formatar(Personagem personagem) {
		if (personagem == null) {
			return "Nenhum";
		}

		return personagem.toString() + personagem.getDadosEspecificos();
	}

}

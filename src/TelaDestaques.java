import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class TelaDestaques extends JPanel implements Atualizavel {

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

	@Override
	public void atualizar() {
		Personagem maiorNivel = gerenciador.personagemMaiorNivel();

		if (maiorNivel == null) {
			maiorNivelLabel.setText("Personagem com maior nivel: Nenhum");
		} else {
			maiorNivelLabel.setText("Personagem com maior nivel: " +
					maiorNivel.getNome() +
					" | Nivel: " + maiorNivel.getNivel());
		}

		Personagem maiorAtaque = gerenciador.personagemMaiorAtaque();

		if (maiorAtaque == null) {
			maiorAtaqueLabel.setText("Personagem com maior ataque: Nenhum");
		} else {
			maiorAtaqueLabel.setText("Personagem com maior ataque: " +
					maiorAtaque.getNome() +
					" | Ataque: " + maiorAtaque.getAtaque());
		}

		Guerreiro maiorDefesa = gerenciador.guerreiroMaiorDefesa();

		if (maiorDefesa == null) {
			maiorDefesaLabel.setText("Guerreiro com maior defesa: Nenhum");
		} else {
			maiorDefesaLabel.setText("Guerreiro com maior defesa: " +
					maiorDefesa.getNome() +
					" | Defesa: " + maiorDefesa.getDefesa());
		}

		Mago maiorPoderMagico = gerenciador.magoMaiorPoderMagico();

		if (maiorPoderMagico == null) {
			maiorPoderMagicoLabel.setText("Mago com maior poder magico: Nenhum");
		} else {
			maiorPoderMagicoLabel.setText("Mago com maior poder magico: " +
					maiorPoderMagico.getNome() +
					" | Poder magico: " + maiorPoderMagico.getPoderMagico());
		}
	}

	private String formatar(Personagem personagem) {
		if (personagem == null) {
			return "Nenhum";
		}

		return personagem.toString() + personagem.getDadosEspecificos() ;
	}

}

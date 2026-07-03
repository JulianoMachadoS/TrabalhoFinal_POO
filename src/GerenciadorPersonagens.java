import java.util.ArrayList;

public class GerenciadorPersonagens {

	private ArrayList<Personagem> personagens;

	public GerenciadorPersonagens() {

	}

	public void carregarDadosIniciais() {

	}

	public void cadastrarGuerreiro(String nome, int nivel, String tipoArma, int forca, int defesa) {

	}

	public void cadastrarMago(String nome, int nivel, ElementoMagico elemento, int mana, int poderMagico) {

	}

	public ArrayList<Personagem> listarTodos() {
		return null;
	}

	public ArrayList<Personagem> buscarPorNome(String nome) {
		return null;
	}

	public boolean removerPorNome(String nome) {
		return false;
	}

	public long totalPersonagens() {
		return 0;
	}

	public long totalGuerreiros() {
		return 0;
	}

	public long totalMagos() {
		return 0;
	}

	public int somaVidas() {
		return 0;
	}

	public double mediaNivel() {
		return 0;
	}

	public double mediaAtaque() {
		return 0;
	}

	public int totalManaMagos() {
		return 0;
	}

	public double mediaDefesaGuerreiros() {
		return 0;
	}

	public Personagem personagemMaiorNivel() {
		return null;
	}

	public Personagem personagemMaiorAtaque() {
		return null;
	}

	public Guerreiro guerreiroMaiorDefesa() {
		return null;
	}

	public Mago magoMaiorPoderMagico() {
		return null;
	}

}

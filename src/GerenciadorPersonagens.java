import java.util.ArrayList;

public class GerenciadorPersonagens {

	private ArrayList<Personagem> personagens;

	public GerenciadorPersonagens() {

	}

	public void carregarDadosIniciais() {
		// coloca os primeiros personagens

	}

	public void cadastrarGuerreiro(String nome, int nivel, Armas tipoArma, int forca, int defesa) {
		personagens.add(new Guerreiro(nome,nivel,tipoArma, forca, defesa));
	}

	public void cadastrarMago(String nome, int nivel, ElementoMagico elemento, int mana, int poderMagico) {
		personagens.add(new Mago(nome, nivel, elemento, mana, poderMagico ));
	}

	public ArrayList<Personagem> listarTodos() {
		return null;
	}

	public ArrayList<Personagem> buscarPorNome(String nome) {
		// pega todos os nomes que possuem determinado conjunto de caracteres e retorna uma lista com eles
		ArrayList<Personagem> resultado = new ArrayList<>();
		String filtro = nome.toLowerCase();

		 personagens.stream()
				.filter(p -> p.getNome().toLowerCase().contains(filtro))
				.forEach(p -> resultado.add(p));

		return resultado;
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

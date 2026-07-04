import java.util.ArrayList;
import java.util.Comparator;

public class GerenciadorPersonagens {

	private ArrayList<Personagem> personagens;

	public GerenciadorPersonagens() {
		this.personagens = new ArrayList<>();
	}

	public void carregarDadosIniciais() {
		if (!personagens.isEmpty()) {
			return;
		}

		cadastrarGuerreiro("Daniel Antonio Callegari", 8, Armas.ESPADA_LONGA, 17, 14);
	}

	public void cadastrarGuerreiro(String nome, int nivel, Armas tipoArma, int forca, int defesa) {
		personagens.add(new Guerreiro(nome, nivel, tipoArma, forca, defesa));
	}

	public void cadastrarGuerreiro(String nome, int nivel, String tipoArma, int forca, int defesa) {
		cadastrarGuerreiro(nome, nivel, Armas.valueOf(tipoArma.toUpperCase()), forca, defesa);
	}

	public void cadastrarMago(String nome, int nivel, ElementoMagico elemento, int mana, int poderMagico) {
		personagens.add(new Mago(nome, nivel, elemento, mana, poderMagico));
	}

	public ArrayList<Personagem> listarTodos() {
		return new ArrayList<>(personagens);
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
		return personagens.removeIf(p -> p.getNome().equalsIgnoreCase(nome));
	}

	public long totalPersonagens() {
		return personagens.size();
	}

	public long totalGuerreiros() {
		return personagens.stream()
				.filter(p -> p instanceof Guerreiro)
				.count();
	}

	public long totalMagos() {
		return personagens.stream()
				.filter(p -> p instanceof Mago)
				.count();
	}

	public int somaVidas() {
		return personagens.stream()
				.mapToInt(Personagem::getVida)
				.sum();
	}

	public double mediaNivel() {
		return personagens.stream()
				.mapToInt(Personagem::getNivel)
				.average()
				.orElse(0);
	}

	public double mediaAtaque() {
		return personagens.stream()
				.mapToInt(Personagem::getAtaque)
				.average()
				.orElse(0);
	}

	public int totalManaMagos() {
		return personagens.stream()
				.filter(p -> p instanceof Mago)
				.map(p -> (Mago) p)
				.mapToInt(Mago::getMana)
				.sum();
	}

	public double mediaDefesaGuerreiros() {
		return personagens.stream()
				.filter(p -> p instanceof Guerreiro)
				.map(p -> (Guerreiro) p)
				.mapToInt(Guerreiro::getDefesa)
				.average()
				.orElse(0);
	}

	public Personagem personagemMaiorNivel() {
		return personagens.stream()
				.max(Comparator.comparingInt(Personagem::getNivel))
				.orElse(null);
	}

	public Personagem personagemMaiorAtaque() {
		return personagens.stream()
				.max(Comparator.comparingInt(Personagem::getAtaque))
				.orElse(null);
	}

	public Guerreiro guerreiroMaiorDefesa() {
		return personagens.stream()
				.filter(p -> p instanceof Guerreiro)
				.map(p -> (Guerreiro) p)
				.max(Comparator.comparingInt(Guerreiro::getDefesa))
				.orElse(null);
	}

	public Mago magoMaiorPoderMagico() {
		return personagens.stream()
				.filter(p -> p instanceof Mago)
				.map(p -> (Mago) p)
				.max(Comparator.comparingInt(Mago::getPoderMagico))
				.orElse(null);
	}

}

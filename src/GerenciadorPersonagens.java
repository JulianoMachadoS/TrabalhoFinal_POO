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

		cadastrarGuerreiro("Hank", 8, Armas.ARCO, 14, 10);
		cadastrarGuerreiro("Eric", 6, Armas.ESCUDO, 10, 18);
		cadastrarGuerreiro("Diana", 7, Armas.LANCA, 13, 12);
		cadastrarGuerreiro("Sheila", 5, Armas.FACA, 9, 14);
		cadastrarGuerreiro("Bobby", 6, Armas.PORRETE, 18, 9);
		cadastrarMago("Presto", 5, ElementoMagico.AR, 45, 18);
		cadastrarMago("Mestre dos Magos", 10, ElementoMagico.TERRA, 90, 35);
		cadastrarMago("Vingador", 12, ElementoMagico.FOGO, 100, 42);
	}

	public void cadastrarGuerreiro(String nome, int nivel, Armas tipoArma, int forca, int defesa) {
		personagens.add(new Guerreiro(nome, nivel, tipoArma, forca, defesa));
	}

	public void cadastrarMago(String nome, int nivel, ElementoMagico elemento, int mana, int poderMagico) {
		personagens.add(new Mago(nome, nivel, elemento, mana, poderMagico));
	}

	public ArrayList<Personagem> listarTodos() {
		return new ArrayList<>(personagens);
	}

	public ArrayList<Personagem> buscarPorNome(String nome) {
		ArrayList<Personagem> resultado = new ArrayList<>();
		String filtro = nome.toLowerCase();

		for (Personagem personagem : personagens) {
			if (personagem.getNome().toLowerCase().contains(filtro)) {
				resultado.add(personagem);
			}
		}

		return resultado;
	}

	public ArrayList<Personagem> buscarPorTipo(String tipo) {
		ArrayList<Personagem> resultado = new ArrayList<>();
		String filtro = tipo.toLowerCase();

		for (Personagem personagem : personagens) {
			if (personagem.getTipo().toLowerCase().contains(filtro)) {
				resultado.add(personagem);
			}
		}

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
				.mapToInt(p -> p.getVida())
				.sum();
	}

	public double mediaNivel() {
		return personagens.stream()
				.mapToInt(p -> p.getNivel())
				.average()
				.orElse(0);
	}

	public double mediaAtaque() {
		return personagens.stream()
				.mapToInt(p -> p.getAtaque())
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
				.mapToInt(guerreiro -> guerreiro.getDefesa())
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
	public boolean nomeJaExiste(String nome) {
		String nomeDigitado = nome.trim();

		for (Personagem personagem : personagens) {
			if (personagem.getNome().equalsIgnoreCase(nomeDigitado)) {
				return true;
			}
		}

		return false;
	}

}

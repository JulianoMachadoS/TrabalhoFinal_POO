public abstract class Personagem {

	private String nome;

	private int nivel;

	private int vida;

	private int ataque;

	public Personagem(String nome, int nivel, int vida, int ataque) {
		this.nome = nome;
		this.nivel = nivel;
		this.vida = vida;
		this.ataque = ataque;
	}

	public String getNome() {
		return this.nome;
	}

	public int getNivel() {
		return this.nivel;
	}

	public int getVida() {
		return this.vida;
	}

	public int getAtaque() {
		return this.ataque;
	}

	public abstract String getDadosEspecificos();

	public abstract String getTipo();

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public void setAtaque(int novoAtaque) {
		this.ataque = ataque;
	}

	public String toString() {
		return "Nome: " + getNome() +
				", vida: " + getVida() +
				", Ataque: " + getAtaque() +
				", Nível: " + getNivel();
	}

}

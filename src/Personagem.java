public abstract class Personagem {

	private String nome;

	private int nivel;

	private int vida;

	private int ataque;

	public Personagem(String nome, int nivel) {
		this.nome = nome;
		this.nivel = nivel;
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

	// calcula atributos serve pra calcular os atributos particulares de cada classe com base no nivel.
	// Atributo = nivel + (Multiplicador x (Nivel - 1)^{Curva} )
	public abstract void calcularAtributos(int nivel);

	public abstract String getDadosEspecificos();

	public abstract String getTipo();

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
		calcularAtributos(nivel);
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public void setAtaque(int novoAtaque) {
		this.ataque = novoAtaque;
	}

	public String toString() {
		return "Nome: " + getNome() +
				", vida: " + getVida() +
				", Ataque: " + getAtaque() +
				", Nível: " + getNivel();
	}

}

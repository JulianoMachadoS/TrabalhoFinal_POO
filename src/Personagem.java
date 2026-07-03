public abstract class Personagem {

	private String nome;

	private int nivel;

	private int vida;

	private int ataque;

	public Personagem(String nome, int nivel, int vida, int ataque) {

	}

	public String getNome() {
		return null;
	}

	public int getNivel() {
		return 0;
	}

	public int getVida() {
		return 0;
	}

	public int getAtaque() {
		return 0;
	}

	public abstract String getDadosEspecificos();

	public abstract String getTipo();

	public void setNome(String nome) {

	}

	public void setNivel(int nivele) {

	}

	public void setVida(int vida) {

	}

	public void setAtaque(int novoAtaque) {

	}

	public String toString() {
		return null;
	}

}

public class Mago extends Personagem {

	private ElementoMagico elemento;

	private int mana;

	private int poderMagico;

	public Mago(String nome, int nivel, ElementoMagico elemento, int mana, int poderMagico) {
		super(nome, nivel, 10, 18);
	}

	public ElementoMagico getElemento() {
		return null;
	}

	public int getMana() {
		return 0;
	}

	public int getPoderMagico() {
		return 0;
	}

	public String getTipo() {
		return null;
	}

	public String getDadosEspecificos() {
		return null;
	}

	public void setElemento(ElementoMagico elemento) {

	}

	public void setMana(int mana) {

	}

	public void setPoderMagico(int poderMagico) {

	}

}

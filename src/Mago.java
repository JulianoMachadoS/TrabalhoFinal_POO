public class Mago extends Personagem {

	private ElementoMagico elemento;

	private int mana;

	private int poderMagico;

	public Mago(String nome, int nivel, ElementoMagico elemento, int mana, int poderMagico) {
		super(nome, nivel, 10, 18);
		// Mago tem atributo padrao na craiação. vida 10 ataque 18

	}

	public ElementoMagico getElemento() {
		return this.elemento;
	}

	public int getMana() {
		return this.mana;
	}

	public int getPoderMagico() {
		return this.poderMagico;
	}
	@Override
	public String getTipo() {
		return "Mago";
	}

	public String getDadosEspecificos() {
		return toString() +
				", Elemento magico: " + getElemento() +
				", Mana: " + getMana() +
				", Poder magico: " + getPoderMagico();
	}

	public void setElemento(ElementoMagico elemento) {
		this.elemento = elemento;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public void setPoderMagico(int poderMagico) {
		this.poderMagico = poderMagico;
	}

}

public class Mago extends Personagem {

	private ElementoMagico elemento;

	private int mana;

	private int poderMagico;

	public Mago(String nome, int nivel, ElementoMagico elemento, int mana, int poderMagico) {
		super(nome, nivel);
		this.elemento = elemento;
		this.mana = mana;
		this.poderMagico = poderMagico;
		// Mago tem atributo padrao na craiação. vida 10 ataque 18
		calcularAtributos(nivel);

	}
	@Override
	public void calcularAtributos(int nivel) {
		int vidaBase = 10;
		int ataqueBase = 18;

		// O calculo da progressão usando o nivel da propria classe
		int vidaCalculada = (int) (vidaBase + 12 * Math.pow(nivel - 1, 1.1));
		int ataqueCalculado = (int) (ataqueBase + 4 * Math.pow(nivel - 1, 1.3));

		this.setVida(vidaCalculada);
		this.setAtaque(ataqueCalculado);
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
		return ", Elemento magico: " + getElemento() +
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

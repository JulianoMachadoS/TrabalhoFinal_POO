public class Guerreiro extends Personagem {

	private Armas tipoArma;

	private int forca;

	private int defesa;

	public Guerreiro(String nome, int nivel, Armas tipoArma, int forca, int defesa) {
		super(nome, nivel, 25, 12);
		// Guerreiro tem atributo padrao na craiação. vida 25 ataque 12
    }

	public Armas getTipoArma() {
		return this.tipoArma;
	}

	public int getForca() {
		return this.forca;
	}

	public int getDefesa() {
		return this.defesa;
	}
	@Override
	public String getTipo() {
		return "Guerreiro";
	}
	@Override
	public String getDadosEspecificos() {
		return toString() + ", Tipo " + getTipo() +
				", Tipo de arma: " + getTipoArma() +
				", Força: " + getForca() +
				", Defesa: " + getDefesa();
	}

	public void setTipoArma(Armas tipoArma) {
		this.tipoArma = tipoArma;
	}

	public void setForca(int forca) {
		this.forca = forca;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}

}

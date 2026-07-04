public class Guerreiro extends Personagem {

	private Armas tipoArma;

	private int forca;

	private int defesa;

	public Guerreiro(String nome, int nivel, Armas tipoArma, int forca, int defesa) {
		super(nome, nivel);
		this.tipoArma = tipoArma;
		this.forca = forca;
		this.defesa = defesa;

		// Guerreiro tem atributos padrão na criação. vida 25 ataque 12 somente no nivel 1
		// formula de calculo:
		// Atributo = nivel + (Multiplicador x (Nivel - 1)^{Curva} )

		calcularAtributos(nivel);
    }


	@Override
	public void calcularAtributos(int nivel) {
		int vidaBase = 25;
		int ataqueBase = 12;

		// O calculo da progressão usando o nivel da propria classe
		int vidaCalculada = (int) (vidaBase + 12 * Math.pow(nivel - 1, 1.3));
		int ataqueCalculado = (int) (ataqueBase + 4 * Math.pow(nivel - 1, 1.1));

		// Injetando os valores gerados direto na classe mãe

		this.setVida(vidaCalculada);
		this.setAtaque(ataqueCalculado);
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
		return ", Tipo " + getTipo() +
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

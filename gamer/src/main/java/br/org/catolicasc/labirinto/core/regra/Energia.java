package br.org.catolicasc.labirinto.core.regra;
/**
 * Vida atual da cobaia
 * @author matheus.baade
 *
 */
public class Energia {

	/**
	 * Construtor da classe
	 * @param value
	 */
	public Energia(int value) {
		this.energia = value;
	}

	/**
	 * Coloca a energia como 0
	 */
	public Energia() {
		this.energia = 0;
	}

	private int energia;

	/**
	 * Retorna a energia atual
	 * @return
	 */
	public int getEnergia() {
		return energia;
	}

	/**
	 * Seta a energia
	 * @param energia
	 */
	public void setEnergia(int energia) {
		this.energia = energia;
	}

	/**
	 * Adiciona mais energiaPlus de energia
	 * @param energiaPlus
	 */
	public void add(int energiaPlus) {
		this.energia += energiaPlus;
	}

}

package br.org.catolicasc.labirinto.view.elemento;

/**
 * Classe substancia que é pai de veneno e remedio
 * @author matheus.baade
 *
 */
public class Substancia extends Cenario {

	/**
	 * Coloca a substancia em uma posicao
	 * @param posicao
	 */
	protected Substancia(Posicao posicao) {
		super(posicao);
	}

	/**
	 * Retorna o cheiro da substancia
	 * @return
	 */
	public boolean isCheiro() {
		return isCheiro;
	}

	/**
	 * Seta o cheiro da substancia
	 * @param isCheiro
	 */
	public void setCheiro(boolean isCheiro) {
		this.isCheiro = isCheiro;
	}

	private boolean isCheiro;
}

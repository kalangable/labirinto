package br.org.catolicasc.labirinto.view.elemento;
/**
 * Classe posição onde são armazenados os elementos
 * @author matheus.baade
 *
 */
public class Posicao {

	/**
	 * Construtor da classe
	 * @param posicaoX
	 * @param posicaoY
	 */
	public Posicao(int posicaoX, int posicaoY) {
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
	}

	/**
	 * Retorna a posição no eixo X
	 * @return
	 */
	public int getPosicaoX() {
		return posicaoX;
	}

	/**
	 * Seta a posição no eixo X
	 * @param posicaoX
	 */
	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}

	/**
	 * Retorna a posição no eixo Y
	 * @return
	 */
	public int getPosicaoY() {
		return posicaoY;
	}

	/**
	 * Seta a posição no eixo Y
	 * @param posicaoY
	 */
	public void setPosicaoY(int posicaoY) {
		this.posicaoY = posicaoY;
	}

	private int posicaoX;
	private int posicaoY;

}

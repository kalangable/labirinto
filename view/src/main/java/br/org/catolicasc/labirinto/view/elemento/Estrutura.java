package br.org.catolicasc.labirinto.view.elemento;

/**
 * Classe onde são criados as estruturas(parede e corredor) do cenario
 * @author matheus.baade
 *
 */
public class Estrutura extends Cenario {

	/**
	 * Construtor da classe
	 * @param posicao
	 */
	protected Estrutura(Posicao posicao) {
		super(posicao);
	}

	private boolean isObstaculo;

	/**
	 * Retorna se é um obstaculo
	 * @return
	 */
	public boolean isObstaculo() {
		return isObstaculo;
	}

	/**
	 * Seta se é um obstaculo
	 * @param isObstaculo
	 */
	protected void setObstaculo(boolean isObstaculo) {
		this.isObstaculo = isObstaculo;
	}

}

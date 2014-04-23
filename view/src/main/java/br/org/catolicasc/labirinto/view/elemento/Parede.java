package br.org.catolicasc.labirinto.view.elemento;

/**
 * Classe parede por onde o rato não pode passar
 * @author matheus.baade
 *
 */
public class Parede extends Estrutura {
	/**
	 * Construtor da classe
	 * @param posicao
	 */
	public Parede(Posicao posicao) {
		super(posicao);
		super.setElemento(EnumElementoCenario.PAREDE);
		super.setObstaculo(true);
	}

}

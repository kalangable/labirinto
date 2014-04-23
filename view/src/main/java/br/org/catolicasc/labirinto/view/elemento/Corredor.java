package br.org.catolicasc.labirinto.view.elemento;

/**
 * Classe corredor por onde o rato pode passar
 * @author matheus.baade
 *
 */
public class Corredor extends Estrutura {
	/**
	 * Construtor da classe
	 * @param posicao
	 */
	public Corredor(Posicao posicao) {
		super(posicao);
		super.setElemento(EnumElementoCenario.CORREDOR);
		super.setObstaculo(false);
	}
}

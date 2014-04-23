package br.org.catolicasc.labirinto.view.elemento;

/**
 * Classe remedio(queijo)
 * @author matheus.baade
 *
 */
public class Remedio extends Substancia {
	/**
	 * Construtor da classe remedio
	 * @param posicao
	 */
	public Remedio(Posicao posicao) {
		super(posicao);
		super.setElemento(EnumElementoCenario.REMEDIO);
		super.setCheiro(false);
	}
}

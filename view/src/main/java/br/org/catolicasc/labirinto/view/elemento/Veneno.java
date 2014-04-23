package br.org.catolicasc.labirinto.view.elemento;

/**
 * Classe responsavel por criar uma armadilha
 * @author matheus.baade
 *
 */
public class Veneno extends Substancia {
	/**
	 * Construtor da classe veneno
	 * @param posicao
	 */
	public Veneno(Posicao posicao) {
		super(posicao);
		super.setElemento(EnumElementoCenario.VENENO);
		super.setCheiro(false);
	}
}

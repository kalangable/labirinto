package br.org.catolicasc.labirinto.view.elemento;
/**
 * Enum para os elementos de cenario
 * @author matheus.baade
 *
 */
public enum EnumElementoCenario {

	PAREDE('#'), POSICAO_INICIAL('S'), SAIDA('E'), REMEDIO('C'), VENENO('T'), CORREDOR('.'), COBAIA('M'), MUTACAO('R');

	private char caracter;

	/**
	 * Adiciona um caracter no labirinto
	 * @param caracter
	 */
	private EnumElementoCenario(char caracter) {
		this.caracter = caracter;
	}

	/**
	 * Retorna o caracter da posição
	 * @return
	 */
	public char getCaracter() {
		return caracter;
	}
}

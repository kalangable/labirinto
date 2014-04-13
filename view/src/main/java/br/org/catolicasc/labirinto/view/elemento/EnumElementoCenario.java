package br.org.catolicasc.labirinto.view.elemento;

public enum EnumElementoCenario {

	PAREDE('#'), POSICAO_INICIAL('S'), SAIDA('E'), REMEDIO('C'), VENENO('T'), CORREDOR('.'), COBAIA('M'), MUTACAO('R');

	private char caracter;

	private EnumElementoCenario(char caracter) {
		this.caracter = caracter;
	}

	public char getCaracter() {
		return caracter;
	}
}

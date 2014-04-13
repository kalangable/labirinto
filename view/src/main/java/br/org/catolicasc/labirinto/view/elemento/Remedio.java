package br.org.catolicasc.labirinto.view.elemento;


public class Remedio extends Substancia {
	public Remedio(Posicao posicao) {
		super(posicao);
		super.setElemento(EnumElementoCenario.REMEDIO);
		super.setCheiro(false);
	}
}

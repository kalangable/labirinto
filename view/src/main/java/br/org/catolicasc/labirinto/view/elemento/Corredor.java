package br.org.catolicasc.labirinto.view.elemento;


public class Corredor extends Estrutura {
	public Corredor(Posicao posicao) {
		super(posicao);
		super.setElemento(EnumElementoCenario.CORREDOR);
		super.setObstaculo(false);
	}
}

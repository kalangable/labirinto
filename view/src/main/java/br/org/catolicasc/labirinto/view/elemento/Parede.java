package br.org.catolicasc.labirinto.view.elemento;


public class Parede extends Estrutura {
	public Parede(Posicao posicao) {
		super(posicao);
		super.setElemento(EnumElementoCenario.PAREDE);
		super.setObstaculo(true);
	}

}

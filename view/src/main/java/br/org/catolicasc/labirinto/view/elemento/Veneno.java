package br.org.catolicasc.labirinto.view.elemento;


public class Veneno extends Substancia {
	public Veneno(Posicao posicao) {
		super(posicao);
		super.setElemento(EnumElementoCenario.VENENO);
		super.setCheiro(false);
	}
}

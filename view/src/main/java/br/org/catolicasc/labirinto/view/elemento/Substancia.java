package br.org.catolicasc.labirinto.view.elemento;


public class Substancia extends Cenario {

	protected Substancia(Posicao posicao) {
		super(posicao);
	}

	public boolean isCheiro() {
		return isCheiro;
	}

	public void setCheiro(boolean isCheiro) {
		this.isCheiro = isCheiro;
	}

	private boolean isCheiro;
}

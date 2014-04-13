package br.org.catolicasc.labirinto.view.elemento;


public class Estrutura extends Cenario {

	protected Estrutura(Posicao posicao) {
		super(posicao);
	}

	private boolean isObstaculo;

	public boolean isObstaculo() {
		return isObstaculo;
	}

	protected void setObstaculo(boolean isObstaculo) {
		this.isObstaculo = isObstaculo;
	}

}

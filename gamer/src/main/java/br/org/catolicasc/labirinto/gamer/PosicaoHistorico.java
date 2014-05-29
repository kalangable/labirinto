package br.org.catolicasc.labirinto.gamer;

public class PosicaoHistorico {

	private boolean cima;
	private boolean baixo;
	private boolean esquerda;
	private boolean direita;
	private boolean invalido;

	public boolean isCima() {
		return cima;
	}

	public void setCima(boolean cima) {
		this.cima = cima;
	}

	public boolean isBaixo() {
		return baixo;
	}

	public void setBaixo(boolean baixo) {
		this.baixo = baixo;
	}

	public boolean isEsquerda() {
		return esquerda;
	}

	public void setEsquerda(boolean esquerda) {
		this.esquerda = esquerda;
	}

	public boolean isDireita() {
		return direita;
	}

	public void setDireita(boolean direita) {
		this.direita = direita;
	}

	public boolean isInvalido() {
		return (isBaixo() && isCima() && isEsquerda() && isDireita());
	}

}

package br.org.catolicasc.labirinto.view;

import br.org.catolicasc.labirinto.view.elemento.Cenario;
import br.org.catolicasc.labirinto.view.elemento.Posicao;

public class Labirinto {

	private Cenario[][] cenario;
	private Posicao exit;
	private Posicao begin;

	public Posicao getBegin() {
		return begin;
	}

	public void setBegin(Posicao begin) {
		this.begin = begin;
	}

	public Cenario[][] getCenario() {
		return cenario;
	}

	public void setCenario(Cenario[][] cenario) {
		this.cenario = cenario;
	}

	public Posicao getExit() {
		return exit;
	}

	public void setExit(Posicao exit) {
		this.exit = exit;
	}

}

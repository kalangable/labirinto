package br.org.catolicasc.labirinto.view;

import br.org.catolicasc.labirinto.view.elemento.Cenario;
import br.org.catolicasc.labirinto.view.elemento.Posicao;
/**
 * Armazena o labirinto
 * @author matheus.baade
 *
 */
public class Labirinto {

	private Cenario[][] cenario;
	private Posicao exit;
	private Posicao begin;

	/**
	 * Retorna a Posição inicial
	 * @return
	 */
	public Posicao getBegin() {
		return begin;
	}

	/**
	 * Seta a posição inicial
	 * @param begin
	 */
	public void setBegin(Posicao begin) {
		this.begin = begin;
	}

	/**
	 * Retorna o cenario
	 * @return
	 */
	public Cenario[][] getCenario() {
		return cenario;
	}

	/**
	 * Seta o cenario
	 * @param cenario
	 */
	public void setCenario(Cenario[][] cenario) {
		this.cenario = cenario;
	}

	/**
	 * Retorna a saida do labirinto
	 * @return
	 */
	public Posicao getExit() {
		return exit;
	}

	/**
	 * Seta a saida do labirinto
	 * @param exit
	 */
	public void setExit(Posicao exit) {
		this.exit = exit;
	}

}

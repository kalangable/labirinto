package br.org.catolicasc.labirinto.core.cobaia;

import br.org.catolicasc.labirinto.view.elemento.Posicao;

public interface ActionCobs<E> {

	public Posicao stroke();

	public E actionWinner();

	public E actionLoser();

}

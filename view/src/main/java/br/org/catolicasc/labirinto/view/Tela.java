package br.org.catolicasc.labirinto.view;

import br.org.catolicasc.labirinto.view.elemento.Cenario;

/**
 * Classe onde são executados as ações em tela
 * @author matheus.baade
 *
 */
public class Tela {

	/**
	 * Construtor da classe
	 */
	private Tela() {

	}

	private static Tela instance;

	/**
	 * Retorna a tela
	 * @return
	 */
	public static Tela getInstance() {
		return (instance == null ? new Tela() : instance);
	}

	/**
	 * atualiza o labirinto com os dados do cenario
	 * @param labirinto
	 */
	public void atualizar(Labirinto labirinto) {

		for (Cenario[] cenarioX : labirinto.getCenario()) {
			for (Cenario cenario : cenarioX) {
				System.out.print(cenario.getElemento().getCaracter());
			}
			System.out.println();
		}
	}

}

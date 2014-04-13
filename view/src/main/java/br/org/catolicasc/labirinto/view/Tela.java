package br.org.catolicasc.labirinto.view;

import br.org.catolicasc.labirinto.view.elemento.Cenario;


public class Tela {

	private Tela() {

	}

	private static Tela instance;

	public static Tela getInstance() {
		return (instance == null ? new Tela() : instance);
	}

	public void atualizar(Labirinto labirinto) {

		for (Cenario[] cenarioX : labirinto.getCenario()) {
			for (Cenario cenario : cenarioX) {
				System.out.print(cenario.getElemento().getCaracter());
			}
			System.out.println();
		}
	}

}

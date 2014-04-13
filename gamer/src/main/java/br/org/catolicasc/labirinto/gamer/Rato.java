package br.org.catolicasc.labirinto.gamer;

import br.org.catolicasc.labirinto.view.Labirinto;
import br.org.catolicasc.labirinto.view.elemento.Posicao;
import br.org.catolicasc.labirinto.view.elemento.Remedio;
import br.org.catolicasc.labirinto.view.elemento.Substancia;

public class Rato extends Roedor {

	public Rato(Posicao posicao) {
		super(posicao);
	}

	public void condolence() {
		System.out.println("Oh No!!!!!");

	}

	public void celebrate() {
		System.out.println("Chupa que é de Uva");

	}

	@Override
	public void eat(Substancia substancia) {
		if (substancia instanceof Remedio) {
			System.out.println("ARROTANDO!!!!!!!!!!!!!!!!!");
		}
	}

	@Override
	public Posicao game(Labirinto labirinto) {

		return new Posicao(posicao.getPosicaoX(), posicao.getPosicaoY() + 1);
	}

}

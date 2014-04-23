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
	public Posicao game(Labirinto labirinto, int isPossibleContinue) {
		
		switch(isPossibleContinue){
		case 0 :
			return new Posicao(posicao.getPosicaoX(), posicao.getPosicaoY() + 1);
		case 1:
			return new Posicao(posicao.getPosicaoX() +1, posicao.getPosicaoY());
		case 2:
			return new Posicao(posicao.getPosicaoX() -1, posicao.getPosicaoY() );
		case 3:
			return new Posicao(posicao.getPosicaoX(), posicao.getPosicaoY() -1);
		default:
			return new Posicao(posicao.getPosicaoX(), posicao.getPosicaoY());
		}
	}

}

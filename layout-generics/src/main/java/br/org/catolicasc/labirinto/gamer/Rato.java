package br.org.catolicasc.labirinto.gamer;

import br.org.catolicasc.labirinto.view.Labirinto;
import br.org.catolicasc.labirinto.view.elemento.Posicao;
import br.org.catolicasc.labirinto.view.elemento.Remedio;
import br.org.catolicasc.labirinto.view.elemento.Substancia;

public class Rato extends Roedor {
	
	static final int ESQUERDA = 0;
	static final int CIMA = 1;
	static final int DIREITA = 2;
	static final int BAIXO = 3;

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
			super.energia.add(10);
		}
		else{
			condolence();
			System.exit(0);
		}
	}
	

	@Override
	public Posicao game(Labirinto labirinto, int isPossibleContinue) {
		
		switch(isPossibleContinue){
		case ESQUERDA :
			return new Posicao(posicao.getPosicaoX(), posicao.getPosicaoY() + 1);
		case CIMA:
			return new Posicao(posicao.getPosicaoX() +1, posicao.getPosicaoY());
		case DIREITA:
			return new Posicao(posicao.getPosicaoX() -1, posicao.getPosicaoY() );
		case BAIXO:
			return new Posicao(posicao.getPosicaoX(), posicao.getPosicaoY() -1);
		default:
			return new Posicao(posicao.getPosicaoX(), posicao.getPosicaoY());
		}
	}

}

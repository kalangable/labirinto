package br.org.catolicasc.labirinto.gamer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import br.org.catolicasc.labirinto.view.Labirinto;
import br.org.catolicasc.labirinto.view.elemento.Cenario;
import br.org.catolicasc.labirinto.view.elemento.Posicao;
import br.org.catolicasc.labirinto.view.elemento.Remedio;
import br.org.catolicasc.labirinto.view.elemento.Substancia;
import br.org.catolicasc.labirinto.view.elemento.Veneno;

public class Rato extends Roedor {

	private static final Logger LOG = Logger.getLogger(Rato.class);
	static final int ESQUERDA = 0;
	static final int BAIXO = 1;
	static final int DIREITA = 2;
	static final int CIMA = 3;

	private Stack<Posicao> qPosicaos = new Stack<Posicao>();

	public Rato(Posicao posicao) {
		super(posicao);
	}

	public void condolence() {
		new Morte();
		JOptionPane.showMessageDialog(null, "Game Over", "Finalizando", JOptionPane.CLOSED_OPTION);

	}

	public void celebrate() {
		System.out.println("Chupa que é de Uva");

	}

	@Override
	public void eat(Substancia substancia) {
		if (substancia instanceof Remedio) {
			new Arroto();
			super.energia.add(10);
		} else {
			condolence();
			System.exit(0);
		}
	}

	@Override
	public Posicao game(Labirinto labirinto, int isPossibleContinue) {

		LOG.info(isPossibleContinue);

		int direcaoMovimentacao = isPossibleContinue;
		Posicao movimente = null;
		switch (direcaoMovimentacao) {
		case ESQUERDA:
			movimente = new Posicao(posicao.getPosicaoX(), posicao.getPosicaoY() + 1);
			break;
		case CIMA:
			movimente = new Posicao(posicao.getPosicaoX() + 1, posicao.getPosicaoY());
			break;
		case DIREITA:
			movimente = new Posicao(posicao.getPosicaoX() - 1, posicao.getPosicaoY());
			break;
		case BAIXO:
			movimente = new Posicao(posicao.getPosicaoX(), posicao.getPosicaoY() - 1);
			break;
		default:
			movimente = new Posicao(posicao.getPosicaoX(), posicao.getPosicaoY());
			break;
		}

		if (super.isExtremo(labirinto, movimente)) {
			return game(labirinto, ++direcaoMovimentacao);
		}
		Cenario elementoCenario = labirinto.getCenario()[movimente.getPosicaoX()][movimente.getPosicaoY()];
		if (isMove(elementoCenario)) {
			if (elementoCenario instanceof Substancia) {
				Substancia substanciaComestivel = (Substancia) elementoCenario;
				if (substanciaComestivel instanceof Veneno) {
					return game(labirinto, ++direcaoMovimentacao);
				}
			}
		}
		qPosicaos.push(movimente);
		LOG.info("Retornando " + movimente.toString());

		if (qPosicaos.size() > 16) {
			return qPosicaos.firstElement();
		}
		return movimente;

	}

}

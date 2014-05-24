package br.org.catolicasc.labirinto.gamer;

import java.util.ArrayList;
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
	ArrayList<int[]> memoryList = new ArrayList<int[]>();
	private Stack<Posicao> memoria = new Stack<Posicao>();

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
	public Posicao game(Labirinto labirinto, EnumAcaoCaminhar caminhar, int direcao) {

		LOG.info(direcao + " - " + caminhar);

		int direcaoMovimentacao = verificarDirecao(caminhar, direcao);

		if (direcaoMovimentacao > CIMA) {
			return game(labirinto, EnumAcaoCaminhar.TRAZ, direcaoMovimentacao);
		}

		if (direcaoMovimentacao < ESQUERDA) {
			memoria.pop();
			return game(labirinto, caminhar, CIMA);
		}

		Posicao movimente = getPosicaoDirecao(direcaoMovimentacao);

		if (super.isExtremo(labirinto, movimente)) {
			return game(labirinto, caminhar, direcaoMovimentacao);
		}
		Cenario elementoCenario = labirinto.getCenario()[movimente.getPosicaoX()][movimente.getPosicaoY()];
		if (isMove(elementoCenario)) {
			if (elementoCenario instanceof Substancia) {
				Substancia substanciaComestivel = (Substancia) elementoCenario;
				if (substanciaComestivel instanceof Veneno) {
					return game(labirinto, caminhar, direcaoMovimentacao);
				}
			}
		}

		if (memoria.contains(movimente)) {
			return game(labirinto, caminhar, direcaoMovimentacao);
		}

		memoria.push(movimente);
		return movimente;

	}

	private Posicao getPosicaoDirecao(int direcao) {
		Posicao movimente = null;
		switch (direcao) {
		case ESQUERDA:
			movimente = new Posicao(posicao.getPosicaoX(), posicao.getPosicaoY() - 1);
			break;
		case CIMA:
			movimente = new Posicao(posicao.getPosicaoX() + 1, posicao.getPosicaoY());
			break;
		case DIREITA:
			movimente = new Posicao(posicao.getPosicaoX(), posicao.getPosicaoY() + 1);
			break;
		case BAIXO:
			movimente = new Posicao(posicao.getPosicaoX() - 1, posicao.getPosicaoY());
			break;
		default:
			movimente = new Posicao(posicao.getPosicaoX(), posicao.getPosicaoY());
			break;
		}
		return movimente;
	}

	private int verificarDirecao(EnumAcaoCaminhar caminhar, int direcao) {
		if (caminhar.equals(EnumAcaoCaminhar.FRENTE)) {
			return direcao += 1;
		} else if (caminhar.equals(EnumAcaoCaminhar.TRAZ)) {
			return direcao -= 1;
		}
		return direcao;
	}

}

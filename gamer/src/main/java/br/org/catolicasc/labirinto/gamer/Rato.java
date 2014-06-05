package br.org.catolicasc.labirinto.gamer;

import java.util.HashMap;
import java.util.Map;
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

	private EnumDirecao ultimaAcao = null;

	Map<Posicao, PosicaoHistorico> posicaoHistorico = new HashMap<>();
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

	Posicao games(Labirinto labirinto, EnumDirecao direcao) {
		Posicao movimente = getPosicaoDirecao(direcao);

		if (!memoria.isEmpty() && posicaoHistorico.containsKey(movimente)) {
			if (posicaoHistorico.get(movimente).isInvalido()) {
				return memoria.pop();
			}
		}

		if (super.posicao.equals(movimente)) {
			return games(labirinto, novaDirecao(direcao));
		}

		if (super.isExtremo(labirinto, movimente)) {
			return games(labirinto, novaDirecao(direcao));
		}
		
		if(movimente.equals(labirinto.getExit())){
			celebrate();
		}
		else{

		Cenario elementoCenario = labirinto.getCenario()[movimente.getPosicaoX()][movimente.getPosicaoY()];

		if (isMove(elementoCenario)) {
			if (elementoCenario instanceof Substancia) {
				Substancia substanciaComestivel = (Substancia) elementoCenario;
				if (substanciaComestivel instanceof Veneno) {
					return games(labirinto, novaDirecao(direcao));
				}
			}
		} else {
			return games(labirinto, novaDirecao(direcao));
		}

		if (memoria.contains(movimente)) {
			return games(labirinto, novaDirecao(direcao));
		}
		}
		ultimaAcao = direcao;
		return memoria.push(movimente);
		
	}

	EnumDirecao novaDirecao(EnumDirecao direcao) {
		switch (direcao) {
		case ESQUERDA:
			return EnumDirecao.BAIXO;
		case BAIXO:
			return EnumDirecao.DIREITA;
		case DIREITA:
			return EnumDirecao.CIMA;
		default:
			return EnumDirecao.ESQUERDA;
		}
	}

	@Override
	public Posicao game(Labirinto labirinto, EnumAcaoCaminhar caminhar, int direcao) {

		if (ultimaAcao == null) {
			ultimaAcao = EnumDirecao.CIMA;
		}
		return games(labirinto, ultimaAcao);/*
											 * 
											 * LOG.info(direcao + " - " +
											 * caminhar);
											 * 
											 * int direcaoMovimentacao =
											 * verificarDirecao (caminhar,
											 * direcao);
											 * 
											 * if (direcaoMovimentacao > CIMA) {
											 * return game(labirinto,
											 * EnumAcaoCaminhar.TRAZ,
											 * direcaoMovimentacao); }
											 * 
											 * if (direcaoMovimentacao <
											 * ESQUERDA) { memoria.pop(); return
											 * game(labirinto, caminhar, CIMA);
											 * }
											 * 
											 * Posicao movimente =
											 * getPosicaoDirecao
											 * (direcaoMovimentacao);
											 * 
											 * if (super.isExtremo(labirinto ,
											 * movimente)) { return
											 * game(labirinto, caminhar,
											 * direcaoMovimentacao); } Cenario
											 * elementoCenario = labirinto
											 * .getCenario()[movimente
											 * .getPosicaoX ()][movimente.
											 * getPosicaoY()]; if
											 * (isMove(elementoCenario)) { if
											 * (elementoCenario instanceof
											 * Substancia) { Substancia
											 * substanciaComestivel =
											 * (Substancia) elementoCenario; if
											 * (substanciaComestivel instanceof
											 * Veneno) { return game(labirinto,
											 * caminhar, direcaoMovimentacao); }
											 * } } else { PosicaoHistorico
											 * posHis = posicaoHistorico.
											 * remove(super.posicao); switch
											 * (direcao) { case ESQUERDA:
											 * posHis.setEsquerda (false);
											 * break; case CIMA:
											 * posHis.setCima(false); break;
											 * case DIREITA:
											 * posHis.setDireita(false); break;
											 * default: posHis.setBaixo(false);
											 * break; } posicaoHistorico.
											 * put(super.posicao, posHis); }
											 * 
											 * if (memoria.contains(movimente ))
											 * { return game(labirinto,
											 * caminhar, direcaoMovimentacao); }
											 * 
											 * memoria.push(movimente);
											 * 
											 * return movimente;
											 */

	}

	private Posicao getPosicaoDirecao(EnumDirecao direcao) {

		Posicao movimente = null;

		PosicaoHistorico posicaoHis = null;
		if (!posicaoHistorico.containsKey(super.posicao)) {
			posicaoHistorico.put(new Posicao(posicao.getPosicaoX(), posicao.getPosicaoY()), new PosicaoHistorico());
		}
		posicaoHis = posicaoHistorico.get(super.posicao);

		switch (direcao) {
		case ESQUERDA:
			if (posicaoHis.isEsquerda()) {
				return getPosicaoDirecao(novaDirecao(direcao));
			}
			movimente = new Posicao(super.posicao.getPosicaoX(), super.posicao.getPosicaoY() - 1);
			posicaoHis.setEsquerda(true);
			break;
		case CIMA:
			if (posicaoHis.isCima()) {
				return getPosicaoDirecao(novaDirecao(direcao));
			}
			movimente = new Posicao(super.posicao.getPosicaoX() + 1, super.posicao.getPosicaoY());
			posicaoHis.setCima(true);
			break;
		case DIREITA:
			if (posicaoHis.isDireita()) {
				return getPosicaoDirecao(novaDirecao(direcao));
			}
			movimente = new Posicao(super.posicao.getPosicaoX(), super.posicao.getPosicaoY() + 1);
			posicaoHis.setDireita(true);
			break;
		case BAIXO:
			if (posicaoHis.isBaixo()) {
				return super.posicao;
			}
			movimente = new Posicao(super.posicao.getPosicaoX() - 1, super.posicao.getPosicaoY());
			posicaoHis.setBaixo(true);
			break;
		}
		// posicaoHistorico.put(super.posicao, posicaoHis);
		return movimente;
	}

}

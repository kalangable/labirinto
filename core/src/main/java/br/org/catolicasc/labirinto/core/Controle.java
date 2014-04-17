package br.org.catolicasc.labirinto.core;

import java.util.Scanner;

import org.joda.time.DateTime;
import org.joda.time.Minutes;

import br.org.catolicasc.labirinto.core.cobaia.Cobaia;
import br.org.catolicasc.labirinto.view.Labirinto;
import br.org.catolicasc.labirinto.view.Tela;
import br.org.catolicasc.labirinto.view.elemento.Cenario;
import br.org.catolicasc.labirinto.view.elemento.Corredor;
import br.org.catolicasc.labirinto.view.elemento.Estrutura;
import br.org.catolicasc.labirinto.view.elemento.Posicao;

public class Controle {

	private Cobaia cobaia;
	private Labirinto labirinto;
	private Tela tela;
	private DateTime tempoInicio;
	private DateTime tempoLimite;

	public Controle(Cobaia cobaia, Labirinto labirinto) {
		this.cobaia = cobaia;
		this.labirinto = labirinto;
		this.tela = Tela.getInstance();
		this.tempoInicio = DateTime.now();
		this.run();
	}

	private void run() {
		tela.atualizar(labirinto);
		boolean isRunning = true;
		int isPossibleContinue=0;
		Cenario[][] cenarioCompleto = this.labirinto.getCenario();
		Posicao posicaoAtual = cobaia.getPosicao();
		Posicao posicaoMovimentacao = null;
		this.tempoLimite = DateTime.now().plusMinutes(5);
		while (isRunning) {
			// posicaoMovimentacao = cobaia.getPosicao();
			cobaia.setPosicao(posicaoAtual);
			System.out.println(posicaoAtual.getPosicaoX() + "  " + posicaoAtual.getPosicaoY());
			System.out.println(isPossibleContinue);
			posicaoMovimentacao = cobaia.make(this.labirinto, isPossibleContinue);
			isPossibleContinue++;
			Cenario elementoCenarioPosicaoMovimentacao = getCenarioPosicao(cenarioCompleto, posicaoMovimentacao);
			if (isMove(elementoCenarioPosicaoMovimentacao)) {
				isPossibleContinue--;
				cenarioCompleto = executeMove(cenarioCompleto, posicaoAtual, posicaoMovimentacao);
				posicaoAtual = posicaoMovimentacao;
			}
			
			if(isPossibleContinue==4){
				System.out.println("problem");
				isPossibleContinue=0;
			}

			labirinto.setCenario(cenarioCompleto);
			tela.atualizar(labirinto);
			if (posicaoAtual.equals(labirinto.getExit())) {
				cobaia.celebrate();
				isRunning = false;
			}
			System.out.println(Minutes.minutesBetween(DateTime.now(), tempoLimite).getMinutes());
			if (Minutes.minutesBetween(DateTime.now(), tempoLimite).getMinutes() < 0) {
				cobaia.condolence();
				isRunning = false;
			}

			new Scanner(System.in).nextLine();
		}
	}

	private Cenario[][] executeMove(Cenario[][] cenario, Posicao posicaoAtual, Posicao proximaPosicao) {
		Cenario elementoCenarioPosicaoMovimentacao = getCenarioPosicao(cenario, proximaPosicao);
		elementoCenarioPosicaoMovimentacao.setElemento(cobaia.getElementoCenario());
		cenario = setElementoCenarioPosicao(cenario, proximaPosicao, elementoCenarioPosicaoMovimentacao);
		cenario = setElementoCenarioPosicao(cenario, posicaoAtual, new Corredor(posicaoAtual));
		return cenario;
	}

	private Cenario getCenarioPosicao(Cenario[][] cenario, Posicao posicao) {

		return cenario[posicao.getPosicaoX()][posicao.getPosicaoY()];
	}

	private Cenario[][] setElementoCenarioPosicao(Cenario[][] cenario, Posicao posicao, Cenario cenarioAlterado) {
		cenario[posicao.getPosicaoX()][posicao.getPosicaoY()] = cenarioAlterado;
		return cenario;
	}

	private boolean isMove(Cenario cenario) {
		boolean retorno = true;
		if (cenario instanceof Estrutura) {
			Estrutura estrutura = (Estrutura) cenario;
			if (estrutura.isObstaculo()) {
				retorno = false;
			}
		}
		return retorno;

	}

}

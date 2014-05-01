package br.org.catolicasc.labirinto.core;

import java.util.Scanner;
import java.util.ArrayList;

import org.joda.time.DateTime;
import org.joda.time.Minutes;

import br.org.catolicasc.labirinto.core.cobaia.Cobaia;
import br.org.catolicasc.labirinto.view.Labirinto;
import br.org.catolicasc.labirinto.view.Tela;
import br.org.catolicasc.labirinto.view.elemento.Cenario;
import br.org.catolicasc.labirinto.view.elemento.Corredor;
import br.org.catolicasc.labirinto.view.elemento.Estrutura;
import br.org.catolicasc.labirinto.view.elemento.Posicao;

/**
 * 
 * É a classe que gere tudo que acontece.
 * 
 */
public class Controle {

	private Cobaia cobaia;
	private Labirinto labirinto;
	private Tela tela;
	private DateTime tempoInicio;
	private DateTime tempoLimite;
	ArrayList<int[]> memoryList = new ArrayList<int[]>();
	static final int ESQUERDA = 0;
	static final int SEMCAMINHO = 0;
	static final int TEMPOLIMITE = 5;

	/**
	 * É criada a cobaia, labirinto e o contador, chamando a execução
	 * 
	 * @param cobaia
	 * @param labirinto
	 */
	public Controle(Cobaia cobaia, Labirinto labirinto) {
		this.cobaia = cobaia;
		this.labirinto = labirinto;
		this.tela = Tela.getInstance();
		this.tempoInicio = DateTime.now();
		this.run();
	}

	/**
	 * Gerencia toda a lógica tanto do rato como do labirinto
	 */
	private void run() {
		tela.atualizar(labirinto);
		boolean isRunning = true;
		int direcaoMovimentacao = ESQUERDA;
		Cenario[][] cenarioCompleto = this.labirinto.getCenario();
		Posicao posicaoAtual = cobaia.getPosicao();
		Posicao posicaoMovimentacao = null;
		this.tempoLimite = DateTime.now().plusMinutes(TEMPOLIMITE);//Removido número mágico
		while (isRunning) {
			// posicaoMovimentacao = cobaia.getPosicao();
			cobaia.setPosicao(posicaoAtual);
			System.out.println(posicaoAtual.getPosicaoX() + "  " + posicaoAtual.getPosicaoY());
			System.out.println(direcaoMovimentacao);
			posicaoMovimentacao = cobaia.make(this.labirinto, direcaoMovimentacao);
			direcaoMovimentacao++;
			Cenario elementoCenarioPosicaoMovimentacao = getCenarioPosicao(cenarioCompleto, posicaoMovimentacao);
			if (isMove(elementoCenarioPosicaoMovimentacao)
					&& !isInMemory(elementoCenarioPosicaoMovimentacao.getPosicao().getPosicaoX(), elementoCenarioPosicaoMovimentacao.getPosicao().getPosicaoY())) {
				// isPossibleContinue--;
				cenarioCompleto = executeMove(cenarioCompleto, posicaoAtual, posicaoMovimentacao);
				this.memoryList.add(new int[] { posicaoAtual.getPosicaoX(), posicaoAtual.getPosicaoY() });
				posicaoAtual = posicaoMovimentacao;
			}

			if (direcaoMovimentacao == SEMCAMINHO) { //Removido numero magicos
				direcaoMovimentacao = ESQUERDA; //Removido numero magicos
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

	/**
	 * Faz o rato andar
	 * @param cenario
	 * @param posicaoAtual
	 * @param proximaPosicao
	 * @return
	 */
	private Cenario[][] executeMove(Cenario[][] cenario, Posicao posicaoAtual, Posicao proximaPosicao) {
		Cenario elementoCenarioPosicaoMovimentacao = getCenarioPosicao(cenario, proximaPosicao);
		elementoCenarioPosicaoMovimentacao.setElemento(cobaia.getElementoCenario());
		cenario = setElementoCenarioPosicao(cenario, proximaPosicao, elementoCenarioPosicaoMovimentacao);
		cenario = setElementoCenarioPosicao(cenario, posicaoAtual, new Corredor(posicaoAtual));
		return cenario;
	}

	/**
	 * Retorna o que existe na posição
	 * @param cenario
	 * @param posicao
	 * @return
	 */
	private Cenario getCenarioPosicao(Cenario[][] cenario, Posicao posicao) {

		return cenario[posicao.getPosicaoX()][posicao.getPosicaoY()];
	}

	/**
	 * Seta o que existe na posição
	 * @param cenario
	 * @param posicao
	 * @param cenarioAlterado
	 * @return
	 */
	private Cenario[][] setElementoCenarioPosicao(Cenario[][] cenario, Posicao posicao, Cenario cenarioAlterado) {
		cenario[posicao.getPosicaoX()][posicao.getPosicaoY()] = cenarioAlterado;
		return cenario;
	}

	/**
	 * Verifica se é possivel mover para aquela direção
	 * @param cenario
	 * @return
	 */
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

	/**
	 * Verifica se ja passou por aquele local
	 * @param posX
	 * @param posY
	 * @return
	 */
	private boolean isInMemory(int posX, int posY) {

		for (int i = 0; i < this.memoryList.size(); i++) {
			if (this.memoryList.get(i)[0] == posX && this.memoryList.get(i)[1] == posY) {
				return true;
			}
		}

		return false;
	}

}

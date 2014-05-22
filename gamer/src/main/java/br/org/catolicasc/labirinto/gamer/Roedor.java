package br.org.catolicasc.labirinto.gamer;

import org.apache.log4j.Logger;

import br.org.catolicasc.labirinto.core.cobaia.Cobaia;
import br.org.catolicasc.labirinto.core.regra.Energia;
import br.org.catolicasc.labirinto.view.Labirinto;
import br.org.catolicasc.labirinto.view.elemento.Cenario;
import br.org.catolicasc.labirinto.view.elemento.EnumElementoCenario;
import br.org.catolicasc.labirinto.view.elemento.Estrutura;
import br.org.catolicasc.labirinto.view.elemento.Posicao;
import br.org.catolicasc.labirinto.view.elemento.Remedio;
import br.org.catolicasc.labirinto.view.elemento.Substancia;
import br.org.catolicasc.labirinto.view.elemento.Veneno;

/**
 * Classe abstrata de rato que vai implementar uma cobaia
 * 
 * @author matheus.baade
 * 
 */
public abstract class Roedor implements Cobaia {

	static final int ENERGIAMUTACAO = 30;
	private static final Logger LOG = Logger.getLogger(Roedor.class);

	/**
	 * Construtor da classe
	 * 
	 * @param posicao
	 */
	public Roedor(Posicao posicao) {
		this.posicao = posicao;
		this.energia = new Energia();
		this.elementoCenario = EnumElementoCenario.COBAIA;
	}

	/**
	 * Ação do rato
	 */
	public Posicao make(Labirinto labirinto, int isPossibleContinue) {
		int direcaoMovimentacao = isPossibleContinue;
		Posicao movimente = this.game(labirinto, direcaoMovimentacao);
		if (isExtremo(labirinto, movimente)) {
			return make(labirinto, ++direcaoMovimentacao);
		}
		Cenario elementoCenario = labirinto.getCenario()[movimente.getPosicaoX()][movimente.getPosicaoY()];
		if (isMove(elementoCenario)) {
			if (elementoCenario instanceof Substancia) {
				Substancia substanciaComestivel = (Substancia) elementoCenario;
				eat(substanciaComestivel);
				executeMutacao();
			}
		}
		return movimente;
	}

	/**
	 * Executa a mutação do rato
	 */
	protected void executeMutacao() {
		LOG.fatal(this.energia.getEnergia());
		if (energia.getEnergia() >= ENERGIAMUTACAO) { // Removido número mágico
			this.setElementoCenario(EnumElementoCenario.MUTACAO);
		}
	}

	protected Energia energia;
	protected Posicao posicao;

	/**
	 * Retorna a energia
	 * 
	 * @return
	 */
	public Energia getEnergia() {
		return energia;
	}

	/**
	 * Retorna a posição
	 */
	public Posicao getPosicao() {
		return this.posicao;
	}

	/**
	 * Seta a posição
	 */
	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;

	}

	protected EnumElementoCenario elementoCenario;

	/**
	 * Seta um elemento no cenario
	 */
	public void setElementoCenario(EnumElementoCenario elementoCenario) {
		this.elementoCenario = elementoCenario;

	}

	/**
	 * Retorna um elemento do cenario
	 */
	public EnumElementoCenario getElementoCenario() {
		// TODO Auto-generated method stub
		return this.elementoCenario;
	}

	/**
	 * Verifica se é um extremo do labirinto a posição atual
	 * 
	 * @param labirinto
	 * @param posicao
	 * @return
	 */
	protected boolean isExtremo(Labirinto labirinto, Posicao posicao) {
		boolean retorno = true;
		if (posicao.getPosicaoX() <= labirinto.getCenario().length) {
			if (posicao.getPosicaoY() <= labirinto.getCenario()[0].length) {
				retorno = false;
			}
		}

		return retorno;
	}

	/**
	 * Verifica se é possivel mover para aquela direção
	 * 
	 * @param cenario
	 * @return
	 */
	protected boolean isMove(Cenario cenario) {
		boolean retorno = true;
		if (cenario instanceof Estrutura) {
			Estrutura estrutura = (Estrutura) cenario;
			if (estrutura.isObstaculo()) {
				retorno = false;
			}
		}
		return retorno;

	}

	public abstract void eat(Substancia substancia);

	public abstract Posicao game(Labirinto labirinto, int isPossibleContinue);
}

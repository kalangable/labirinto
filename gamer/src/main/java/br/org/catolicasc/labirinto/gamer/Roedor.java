package br.org.catolicasc.labirinto.gamer;

import br.org.catolicasc.labirinto.core.cobaia.Cobaia;
import br.org.catolicasc.labirinto.core.regra.Energia;
import br.org.catolicasc.labirinto.view.Labirinto;
import br.org.catolicasc.labirinto.view.elemento.Cenario;
import br.org.catolicasc.labirinto.view.elemento.EnumElementoCenario;
import br.org.catolicasc.labirinto.view.elemento.Posicao;
import br.org.catolicasc.labirinto.view.elemento.Substancia;

public abstract class Roedor implements Cobaia {

	public Roedor(Posicao posicao) {
		this.posicao = posicao;
		this.energia = new Energia();
		this.elementoCenario = EnumElementoCenario.COBAIA;
	}

	public Posicao make(Labirinto labirinto) {
		Posicao movimente = this.game(labirinto);
		while (isExtremo(labirinto, movimente)) {
			System.out.println("Loop");
			movimente = this.game(labirinto);
		}
		Cenario elementoCenario = labirinto.getCenario()[movimente.getPosicaoX()][movimente.getPosicaoY()];
		if (elementoCenario instanceof Substancia) {
			Substancia substanciaComestivel = (Substancia) elementoCenario;
			eat(substanciaComestivel);
			executeMutacao();
		}
		return movimente;
	}

	private void executeMutacao() {
		if (this.energia.getEnergia() >= 10) {
			this.setElementoCenario(EnumElementoCenario.MUTACAO);
		}
	}

	protected Energia energia;
	protected Posicao posicao;

	public Energia getEnergia() {
		return energia;
	}

	public Posicao getPosicao() {
		return this.posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;

	}

	protected EnumElementoCenario elementoCenario;

	public void setElementoCenario(EnumElementoCenario elementoCenario) {
		this.elementoCenario = elementoCenario;

	}

	public EnumElementoCenario getElementoCenario() {
		// TODO Auto-generated method stub
		return this.elementoCenario;
	}

	private boolean isExtremo(Labirinto labirinto, Posicao posicao) {
		boolean retorno = true;
		if (posicao.getPosicaoX() <= labirinto.getCenario().length) {
			if (posicao.getPosicaoY() <= labirinto.getCenario()[0].length) {
				retorno = false;
			}
		}

		return retorno;
	}

	public abstract void eat(Substancia substancia);

	public abstract Posicao game(Labirinto labirinto);
}

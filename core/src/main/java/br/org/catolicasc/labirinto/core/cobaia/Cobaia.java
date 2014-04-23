package br.org.catolicasc.labirinto.core.cobaia;

import br.org.catolicasc.labirinto.view.Labirinto;
import br.org.catolicasc.labirinto.view.elemento.EnumElementoCenario;
import br.org.catolicasc.labirinto.view.elemento.Posicao;
/**
 * Interface para o animal que estara no labirinto
 * @author matheus.baade
 *
 */
public interface Cobaia {

	public void setElementoCenario(EnumElementoCenario elementoCenario);

	public EnumElementoCenario getElementoCenario();

	public Posicao getPosicao();

	public void setPosicao(Posicao posicao);

	public Posicao make(Labirinto labirinto, int isPossibleContinue);

	public void condolence();

	public void celebrate();

}

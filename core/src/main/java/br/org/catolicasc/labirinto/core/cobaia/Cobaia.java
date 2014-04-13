package br.org.catolicasc.labirinto.core.cobaia;

import br.org.catolicasc.labirinto.view.Labirinto;
import br.org.catolicasc.labirinto.view.elemento.EnumElementoCenario;
import br.org.catolicasc.labirinto.view.elemento.Posicao;

public interface Cobaia {

	public void setElementoCenario(EnumElementoCenario elementoCenario);

	public EnumElementoCenario getElementoCenario();

	public Posicao getPosicao();

	public void setPosicao(Posicao posicao);

	public Posicao make(Labirinto labirinto);

	public void condolence();

	public void celebrate();

}

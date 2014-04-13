package br.org.catolicasc.labirinto.view;

import static org.junit.Assert.*;

import org.junit.Test;

import br.org.catolicasc.labirinto.view.elemento.Cenario;
import br.org.catolicasc.labirinto.view.elemento.EnumElementoCenario;
import br.org.catolicasc.labirinto.view.elemento.Estrutura;
import br.org.catolicasc.labirinto.view.elemento.Parede;
import br.org.catolicasc.labirinto.view.elemento.Posicao;

public class ParedeTest {

	@Test
	public void testTipoEstruturaParede() {
		Cenario cenario = new Parede(new Posicao(1, 1));
		assertEquals(EnumElementoCenario.PAREDE, cenario.getElemento());
		assertTrue(((Estrutura) cenario).isObstaculo());
	}

}

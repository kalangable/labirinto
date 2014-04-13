package br.org.catolicasc.labirinto.view;

import static org.junit.Assert.*;

import org.junit.Test;

import br.org.catolicasc.labirinto.view.elemento.Cenario;
import br.org.catolicasc.labirinto.view.elemento.Corredor;
import br.org.catolicasc.labirinto.view.elemento.EnumElementoCenario;
import br.org.catolicasc.labirinto.view.elemento.Estrutura;
import br.org.catolicasc.labirinto.view.elemento.Posicao;

public class CorredorTest {

	@Test
	public void testTipoCorredor() {
		Cenario cenario = new Corredor(new Posicao(1, 1));
		assertEquals(EnumElementoCenario.CORREDOR, cenario.getElemento());
		assertFalse(((Estrutura) cenario).isObstaculo());
	}

}

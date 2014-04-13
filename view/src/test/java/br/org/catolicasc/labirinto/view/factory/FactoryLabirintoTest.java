package br.org.catolicasc.labirinto.view.factory;

import static org.junit.Assert.*;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import org.junit.Test;

import br.org.catolicasc.labirinto.view.Labirinto;
import br.org.catolicasc.labirinto.view.Tela;

public class FactoryLabirintoTest {

	@Test
	public void testCreateLabirinto() {
		Labirinto labirinto = FactoryLabirinto.createLabirinto(Thread.currentThread().getContextClassLoader().getResourceAsStream("lab001.txt"));
		Tela tela = Tela.getInstance();
		tela.atualizar(labirinto);
	}

}

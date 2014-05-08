package br.org.catolicasc.labirinto.view.factory;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.junit.Test;

import br.org.catolicasc.labirinto.view.Labirinto;
import br.org.catolicasc.labirinto.view.Tela;

public class FactoryLabirintoTest {

	@Test
	public void testCreateLabirinto() {
		Labirinto labirinto = null;
		try {
			labirinto = FactoryLabirinto.createLabirinto(Thread.currentThread().getContextClassLoader().getResourceAsStream("lab001.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Tela tela = Tela.getInstance();
		tela.atualizar(labirinto);
	}

}

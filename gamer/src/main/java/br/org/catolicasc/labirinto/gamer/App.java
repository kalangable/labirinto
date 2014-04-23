package br.org.catolicasc.labirinto.gamer;

import br.org.catolicasc.labirinto.core.Controle;
import br.org.catolicasc.labirinto.view.Labirinto;
import br.org.catolicasc.labirinto.view.factory.FactoryLabirinto;

/**
 * Inicia o programa
 * 
 */
public class App {
	public static void main(String[] args) {
		Labirinto labirinto = FactoryLabirinto.createLabirinto(Thread.currentThread().getContextClassLoader().getResourceAsStream("lab001.txt"));
		new Controle(new Rato(labirinto.getBegin()), labirinto);
	}
}

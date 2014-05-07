package br.org.catolicasc.labirinto.gamer;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import br.org.catolicasc.labirinto.core.Controle;
import br.org.catolicasc.labirinto.view.Labirinto;
import br.org.catolicasc.labirinto.view.factory.FactoryLabirinto;

/**
 * Inicia o programa
 * 
 */
public class App {
//	static {
//		PropertyConfigurator.configure(Thread.currentThread().getContextClassLoader().getResource("log4j.properties"));
//	}
	private static final Logger LOG = Logger.getLogger(App.class);
	public static void main(String[] args) {
		LOG.debug("Start da Aplicação");
		Labirinto labirinto = FactoryLabirinto.createLabirinto(Thread.currentThread().getContextClassLoader().getResourceAsStream("lab001.txt"));
		new Controle(new Rato(labirinto.getBegin()), labirinto);
	}
}

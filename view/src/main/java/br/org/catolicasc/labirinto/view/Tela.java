package br.org.catolicasc.labirinto.view;

import java.io.IOException;

import org.apache.log4j.Logger;

import br.org.catolicasc.labirinto.view.elemento.Cenario;

/**
 * Classe onde são executados as ações em tela
 * @author matheus.baade
 *
 */
public class Tela {

	private static final Logger LOG = Logger.getLogger(Tela.class);
	
	/**
	 * Construtor da classe
	 */
	private Tela() {

	}

	private static Tela instance;

	/**
	 * Retorna a tela
	 * @return
	 */
	public static Tela getInstance() {
		return (instance == null ? new Tela() : instance);
	}

	/**
	 * atualiza o labirinto com os dados do cenario
	 * @param labirinto
	 */
	public void atualizar(Labirinto labirinto) {


		MazeFrame mazeFrame = MazeFrame.instnceOf();
		try {
			mazeFrame.createFrame(labirinto.getCenario());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.fatal(e);
		}
	}

}

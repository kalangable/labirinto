package br.org.catolicasc.labirinto.gamer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
	static {
		PropertyConfigurator.configure(Thread.currentThread().getContextClassLoader().getResource("log4j.properties"));
	}
	private static final Logger LOG = Logger.getLogger(App.class);

	public static void main(String[] args) {
		LOG.debug("Start da Aplicação");
		Labirinto labirinto = null;
		File arquivoEntrada = null;

		/**
		 * Quando não localizar o arquivo no resources, solicito ao usuário que
		 * fornceça o arquivo
		 */
		try {
			arquivoEntrada = new File(Thread.currentThread().getContextClassLoader().getResource("lab001.txt").getFile());
		} catch (NullPointerException e) {
			arquivoEntrada = getFileInformationOfUser();
		}
		/**
		 * Se houver algum erro no processamento do arquivo vou encerrar a
		 * aplicação
		 */
		try {
			labirinto = FactoryLabirinto.createLabirinto(arquivoEntrada);
		} catch (IOException e) {
			LOG.warn("Não foi possível processar o arquivo");
			System.err.println("Erro no processamento do arquivo, verifique permissões no arquivo :" + arquivoEntrada.getAbsolutePath());
			System.exit(127);
		}

		// Vou iniciar o Game

		new Controle(new Rato(labirinto.getBegin()), labirinto);
	}

	/**
	 * Mantém o usuário em loop até que seja informado um arquivo válido
	 * 
	 * @return Arquivo informado pelo usuário
	 */
	private static File getFileInformationOfUser() {
		File arquivoEntrada = null;
		while (arquivoEntrada == null || !arquivoEntrada.exists()) {
			LOG.fatal("Não achei o arquivo");
			System.err.println("Arquivo não localizado, por favor forneçao o caminho do arquivo");
			Scanner leitura = new Scanner(System.in);
			String caminhoArquivo = leitura.nextLine();
			arquivoEntrada = new File(caminhoArquivo);
		}
		return arquivoEntrada;
	}
}

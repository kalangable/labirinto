package br.org.catolicasc.labirinto.gamer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import br.org.catolicasc.labirinto.Maze;
import br.org.catolicasc.labirinto.layout.generics.ComponentMaze;
import br.org.catolicasc.labirinto.layout.generics.console.Aid;
import br.org.catolicasc.labirinto.layout.generics.console.EnumMaze;
import br.org.catolicasc.labirinto.layout.generics.console.Exit;
import br.org.catolicasc.labirinto.layout.generics.console.Poison;
import br.org.catolicasc.labirinto.layout.generics.console.Start;
import br.org.catolicasc.labirinto.layout.generics.console.Track;
import br.org.catolicasc.labirinto.layout.generics.console.Wall;
import br.org.catolicasc.labirinto.layout.generics.factory.FactoryMaze;

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
		Maze labirinto = null;
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
			labirinto = FactoryMaze.createMaze(FactoryMaze.createMazeElements(arquivoEntrada));
		} catch (IOException e) {
			LOG.warn("Não foi possível processar o arquivo");
			System.err.println("Erro no processamento do arquivo, verifique permissões no arquivo :" + arquivoEntrada.getAbsolutePath());
			System.exit(127);
		}

		
		for (ComponentMaze<?> string : labirinto.getListcomComponentMazes()) {
			if(string instanceof Exit)
				System.out.println(string.isWall()+" "+((Exit)string).getType().getElement()+" "+((Exit)string).getPosition().getPositionX()+" "+((Exit)string).getPosition().getPositionY());
			if(string instanceof Start)
				System.out.println(string.isWall()+" "+((Start)string).getType().getElement());
			if(string instanceof Wall)
				System.out.println(string.isWall()+" "+((Wall)string).getType().getElement());
			if(string instanceof Track)
				System.out.println(string.isWall()+" "+((Track)string).getType().getElement());
			if(string instanceof Aid)
				System.out.println(string.isWall()+" "+((Aid)string).getType().getElement());
			if(string instanceof Poison)
				System.out.println(string.isWall()+" "+((Poison)string).getType().getElement());
		}
		
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

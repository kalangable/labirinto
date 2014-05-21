package br.org.catolicasc.labirinto.layout.generics.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import br.org.catolicasc.labirinto.Maze;
import br.org.catolicasc.labirinto.layout.generics.ComponentMaze;
import br.org.catolicasc.labirinto.layout.generics.Position;
import br.org.catolicasc.labirinto.layout.generics.console.EnumMaze;

public class FactoryMaze {

	private static final Logger LOG = Logger.getLogger(FactoryMaze.class);

	private static char[][] createMazeElements(List<String> fileList) {
		char elementsMaze[][] = new char[fileList.size()][fileList.get(0).length()];
		for (int i = 0; i < fileList.size(); i++) {
			for (int j = 0; j < fileList.get(i).length(); j++) {
				char caracter = fileList.get(i).charAt(j);
				elementsMaze[i][j] = caracter;
			}
		}
		return elementsMaze;
	}

	public static Maze createMaze(char[][] elements) {
		Maze maze = new Maze();
		maze.setHeight(elements.length);
		maze.setWidth(elements[0].length);

		Set<ComponentMaze<EnumMaze>> components = new HashSet<>();

		for (int i = 0; i < elements.length; i++) {
			for (int j = 0; j < elements[i].length; j++) {
				Position position = new Position(i, j);
				components.add((ComponentMaze<EnumMaze>) FactoryMazeElement.createMazeElement(elements[i][j], position));
			}
		}
		maze.setListcomComponentMazes(components);
		return maze;
	}

	/**
	 * Cria o labirinto
	 * 
	 * @return Labirinto com todos os valore setados, inicio, fim, cenario e
	 *         Cobaia
	 * @throws IOException
	 */

	public static char[][] createMazeElements(File file) throws IOException {
		return createMazeElements(readFile(file));
	}

	/**
	 * Cria o labirinto
	 * 
	 * @return Labirinto com todos os valore setados, inicio, fim, cenario e
	 *         Cobaia
	 * @throws IOException
	 */
	public static char[][] createMazeElements(String string) throws IOException {
		return createMazeElements(readFile(string));
	}

	/**
	 * Cria o labirinto
	 * 
	 * @return Labirinto com todos os valore setados, inicio, fim, cenario e
	 *         Cobaia
	 * @throws IOException
	 */
	public static char[][] createMazeElements(InputStream inputStream) throws IOException {
		return createMazeElements(readFile(inputStream));
	}

	/**
	 * Le o arquivo txt
	 * 
	 * @return Lista com todas as linhas do arquivo
	 * @throws IOException
	 */
	private static List<String> readFile(String string) throws IOException {
		return readFile(new File(string));
	}

	/**
	 * Le o arquivo txt
	 * 
	 * @return Lista com todas as linhas do arquivo
	 * @throws IOException
	 */
	private static List<String> readFile(File file) throws IOException {
		return readFile(new FileInputStream(file));
	}

	/**
	 * Le o arquivo txt
	 * 
	 * @return Lista com todas as linhas do arquivo
	 * @throws IOException
	 */
	private static List<String> readFile(InputStream inputStream) throws IOException {
		return IOUtils.readLines(inputStream);
	}

}

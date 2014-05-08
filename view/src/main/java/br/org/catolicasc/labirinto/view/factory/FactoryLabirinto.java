package br.org.catolicasc.labirinto.view.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import br.org.catolicasc.labirinto.view.Labirinto;
import br.org.catolicasc.labirinto.view.elemento.Cenario;
import br.org.catolicasc.labirinto.view.elemento.EnumElementoCenario;
import br.org.catolicasc.labirinto.view.elemento.Posicao;

/**
 * Fabrica que cria o labirinto
 * 
 * @author matheus.baade
 * 
 */
public class FactoryLabirinto {

	private static final Logger LOG = Logger.getLogger(FactoryLabirinto.class);

	private static Labirinto montandoLabirinto(List<String> arquivoListado) {
		Labirinto labirinto = new Labirinto();
		labirinto.setAltura(arquivoListado.size());
		labirinto.setLargura(arquivoListado.get(0).length());
		Cenario[][] cenarioCompleto = new Cenario[labirinto.getAltura()][labirinto.getLargura()];

		for (int i = 0; i < arquivoListado.size(); i++) {
			for (int j = 0; j < arquivoListado.get(i).length(); j++) {
				Posicao posicao = new Posicao(i, j);
				char caracter = arquivoListado.get(i).charAt(j);
				cenarioCompleto[i][j] = FactoryElementoCenario.createElemento(caracter, posicao);
				if (EnumElementoCenario.POSICAO_INICIAL.getCaracter() == caracter) {
					labirinto.setBegin(posicao);
				} else if (EnumElementoCenario.POSICAO_INICIAL.getCaracter() == caracter) {
					labirinto.setBegin(posicao);
				}
			}
		}
		labirinto.setCenario(cenarioCompleto);

		return labirinto;
	}

	/**
	 * Cria o labirinto
	 * 
	 * @return Labirinto com todos os valore setados, inicio, fim, cenario e
	 *         Cobaia
	 * @throws IOException
	 */

	public static Labirinto createLabirinto(File file) throws IOException {
		return montandoLabirinto(readFile(file));
	}

	/**
	 * Cria o labirinto
	 * 
	 * @return Labirinto com todos os valore setados, inicio, fim, cenario e
	 *         Cobaia
	 * @throws IOException
	 */
	public static Labirinto createLabirinto(String string) throws IOException {
		return montandoLabirinto(readFile(string));
	}

	/**
	 * Cria o labirinto
	 * 
	 * @return Labirinto com todos os valore setados, inicio, fim, cenario e
	 *         Cobaia
	 * @throws IOException
	 */
	public static Labirinto createLabirinto(InputStream inputStream) throws IOException {
		return montandoLabirinto(readFile(inputStream));
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

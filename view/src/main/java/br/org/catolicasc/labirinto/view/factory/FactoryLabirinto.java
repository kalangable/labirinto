package br.org.catolicasc.labirinto.view.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

import br.org.catolicasc.labirinto.view.Labirinto;
import br.org.catolicasc.labirinto.view.elemento.Cenario;
import br.org.catolicasc.labirinto.view.elemento.EnumElementoCenario;
import br.org.catolicasc.labirinto.view.elemento.Posicao;
/**
 * Fabrica que cria o labirinto
 * @author matheus.baade
 *
 */
public class FactoryLabirinto {

	public static Labirinto createLabirinto(File file) {
		try {
			return createLabirinto(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Labirinto createLabirinto(String file) {
		return createLabirinto(new File(file));
	}
	
	/**
	 * Cria o labirinto
	 * @param file
	 * @return
	 */
	public static Labirinto createLabirinto(InputStream file) {
		Labirinto labirinto = new Labirinto();

		List<String> arquivoListado = readFile(file);

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

	private static List<String> readFile(String file) {
		return readFile(new File(file));
	}

	private static List<String> readFile(File file) {
		try {
			return readFile(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Le o arquivo txt
	 * @param file
	 * @return
	 */
	private static List<String> readFile(InputStream file) {
		List<String> linhas = null;
		try {
			linhas = IOUtils.readLines(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return linhas;
	}

}

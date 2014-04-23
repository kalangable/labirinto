package br.org.catolicasc.labirinto.view.factory;

import br.org.catolicasc.labirinto.view.elemento.Cenario;
import br.org.catolicasc.labirinto.view.elemento.Corredor;
import br.org.catolicasc.labirinto.view.elemento.EnumElementoCenario;
import br.org.catolicasc.labirinto.view.elemento.Parede;
import br.org.catolicasc.labirinto.view.elemento.Posicao;
import br.org.catolicasc.labirinto.view.elemento.Remedio;
import br.org.catolicasc.labirinto.view.elemento.Veneno;
/**
 * Fabrica que cria elementos no cenario
 * @author matheus.baade
 *
 */
public class FactoryElementoCenario {
	/**
	 * Cria um elemento de cenario
	 * @param caracter
	 * @param posicao
	 * @return
	 */
	public static Cenario createElemento(char caracter, Posicao posicao) {
		EnumElementoCenario elementoCenario = null;
		Cenario cenario = null;
		for (EnumElementoCenario valores : EnumElementoCenario.values()) {
			if (valores.getCaracter() == caracter) {
				elementoCenario = valores;
				break;
			}
		}
		switch (elementoCenario) {
		case PAREDE:
			cenario = new Parede(posicao);
			break;
		case REMEDIO:
			cenario = new Remedio(posicao);
			break;
		case VENENO:
			cenario = new Veneno(posicao);
			break;
		default:
			cenario = new Corredor(posicao);
		}
		return cenario;
	}

}

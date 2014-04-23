package br.org.catolicasc.labirinto.view.elemento;

/**
 * Classe cenario onde são colocados todos os elementos
 * @author matheus.baade
 *
 */
public class Cenario {

	/**
	 * Construtor da classe
	 * @param posicao
	 */
	protected Cenario(Posicao posicao) {
		this.posicao = posicao;
	}

	private Posicao posicao;
	private EnumElementoCenario elemento;

	/**
	 * Retorna o elemento na posição do cenario
	 * @return
	 */
	public EnumElementoCenario getElemento() {
		return elemento;
	}

	/**
	 * Coloca um elemento em uma posição do cenario
	 * @param elemento
	 */
	public void setElemento(EnumElementoCenario elemento) {
		this.elemento = elemento;
	}

	/**
	 * Retorna a posição atual
	 * @return
	 */
	public Posicao getPosicao() {
		return posicao;
	}

	/**
	 * Seta a posição atual
	 * @param posicao
	 */
	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((elemento == null) ? 0 : elemento.hashCode());
		result = prime * result + ((posicao == null) ? 0 : posicao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cenario other = (Cenario) obj;
		if (elemento != other.elemento)
			return false;
		if (posicao == null) {
			if (other.posicao != null)
				return false;
		} else if (!posicao.equals(other.posicao))
			return false;
		return true;
	}

}

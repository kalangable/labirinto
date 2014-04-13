package br.org.catolicasc.labirinto.view.elemento;


public class Cenario {

	protected Cenario(Posicao posicao) {
		this.posicao = posicao;
	}

	private Posicao posicao;
	private EnumElementoCenario elemento;

	public EnumElementoCenario getElemento() {
		return elemento;
	}

	public void setElemento(EnumElementoCenario elemento) {
		this.elemento = elemento;
	}

	public Posicao getPosicao() {
		return posicao;
	}

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

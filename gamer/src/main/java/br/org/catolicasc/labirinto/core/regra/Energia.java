package br.org.catolicasc.labirinto.core.regra;

public class Energia {

	public Energia(int value) {
		this.energia = value;
	}

	public Energia() {
		this.energia = 0;
	}

	private int energia;

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public void add(Energia energiaPlus) {
		this.energia += energiaPlus.getEnergia();
	}

}

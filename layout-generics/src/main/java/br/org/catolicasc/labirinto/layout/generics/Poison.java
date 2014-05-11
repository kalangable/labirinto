package br.org.catolicasc.labirinto.layout.generics;

public class Poison implements ComponenteSubstance {

	private EnumSubtance element;

	public Poison(Position posicao) {
		this.set(EnumSubtance.POISON);
	}

	@Override
	public EnumSubtance get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set(EnumSubtance t) {
		this.element = t;

	}

	@Override
	public boolean isSmell() {
		// TODO Auto-generated method stub
		return true;
	}

}

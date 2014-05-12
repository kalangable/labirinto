package br.org.catolicasc.labirinto.layout.generics;

public class Poison implements ComponentSubstance {

	@Override
	public EnumSubtance getType() {
		return EnumSubtance.POISON;
	}

	@Override
	public boolean isWall() {
		return false;
	}

	@Override
	public boolean isSmell() {
		return true;
	}

}

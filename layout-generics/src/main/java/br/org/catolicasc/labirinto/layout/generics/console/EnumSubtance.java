package br.org.catolicasc.labirinto.layout.generics.console;

import br.org.catolicasc.labirinto.layout.generics.ElementMaze;

public enum EnumSubtance implements ElementMaze<Character> {

	POISON('T'), AID('C');

	private Character element;

	private EnumSubtance(Character character) {
		this.element = character;
	}

	@Override
	public Character getElement() {
		// TODO Auto-generated method stub
		return this.element;
	}

}

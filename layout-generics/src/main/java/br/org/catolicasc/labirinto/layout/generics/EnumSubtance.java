package br.org.catolicasc.labirinto.layout.generics;

public enum EnumSubtance implements ElementMaze<Character> {

	POISON('T'), AID('C');

	private Character character;

	private EnumSubtance(Character character) {
		this.character = character;
	}

	@Override
	public Character getElement() {
		// TODO Auto-generated method stub
		return this.character;
	}

}

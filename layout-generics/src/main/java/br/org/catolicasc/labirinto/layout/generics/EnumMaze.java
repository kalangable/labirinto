package br.org.catolicasc.labirinto.layout.generics;

public enum EnumMaze implements ElementMaze<Character> {

	START('S'), EXIT('E'), WALL('#'), TRACK('.');

	private EnumMaze(Character character) {
		this.character = character;

	}

	private Character character;

	@Override
	public Character getElement() {
		return this.character;
	}

}

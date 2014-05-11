package br.org.catolicasc.labirinto.layout.generics;

public enum EnumStructure implements ElementMaze<Character> {

	WALL('#'), TRACK('.');

	private Character character;

	private EnumStructure(Character character) {
		this.character = character;
	}

	@Override
	public Character get() {
		return this.character;
	}

}

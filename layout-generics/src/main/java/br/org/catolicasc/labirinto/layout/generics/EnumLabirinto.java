package br.org.catolicasc.labirinto.layout.generics;

public enum EnumLabirinto implements ElementMaze<Character> {
	START('S'), EXIT('E');

	private EnumLabirinto(Character character) {
		this.character = character;

	}

	private Character character;

	@Override
	public Character get() {
		return this.character;
	}

}

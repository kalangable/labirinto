package br.org.catolicasc.labirinto.layout.generics.console;

import br.org.catolicasc.labirinto.layout.generics.ElementMaze;

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

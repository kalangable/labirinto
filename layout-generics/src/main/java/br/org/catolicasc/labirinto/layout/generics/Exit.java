package br.org.catolicasc.labirinto.layout.generics;

public class Exit implements ComponentMaze<EnumMaze> {

	@Override
	public EnumMaze getType() {
		return EnumMaze.EXIT;
	}

	@Override
	public boolean isWall() {
		return false;
	}

}

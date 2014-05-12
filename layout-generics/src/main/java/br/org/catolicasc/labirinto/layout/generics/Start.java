package br.org.catolicasc.labirinto.layout.generics;

public class Start implements ComponentMaze<EnumMaze> {

	@Override
	public EnumMaze getType() {
		return EnumMaze.START;
	}

	@Override
	public boolean isWall() {
		return false;
	}

}

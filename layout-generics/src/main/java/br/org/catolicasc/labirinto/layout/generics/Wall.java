package br.org.catolicasc.labirinto.layout.generics;

public class Wall implements ComponentMaze<EnumMaze> {

	@Override
	public EnumMaze getType() {
		// TODO Auto-generated method stub
		return EnumMaze.WALL;
	}

	@Override
	public boolean isWall() {
		// TODO Auto-generated method stub
		return true;
	}

}

package br.org.catolicasc.labirinto.layout.generics;

public class Wall extends SettingMaze implements ComponentMaze<EnumMaze> {

	public Wall(Position position) {
		super(position);
	}

	public Wall(int positionX, int positionY) {
		super(positionX, positionY);
	}

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

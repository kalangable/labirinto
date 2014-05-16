package br.org.catolicasc.labirinto.layout.generics;

public class Track extends SettingMaze implements ComponentMaze<EnumMaze> {

	public Track(Position position) {
		super(position);
	}

	public Track(int positionX, int positionY) {
		super(positionX, positionY);
	}

	@Override
	public EnumMaze getType() {
		// TODO Auto-generated method stub
		return EnumMaze.TRACK;
	}

	@Override
	public boolean isWall() {
		// TODO Auto-generated method stub
		return false;
	}

}

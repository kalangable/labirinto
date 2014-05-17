package br.org.catolicasc.labirinto.layout.generics;


public abstract class SettingMaze {

	private Position position;

	public SettingMaze(Position position) {
		this.position = position;
	}

	public SettingMaze(int positionX, int positionY) {
		this.position = new Position(positionX, positionY);
	}

	public Position getPosition() {
		return position;
	}

}

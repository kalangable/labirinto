package br.org.catolicasc.labirinto.layout.generics;

public class Aid extends SettingMaze implements ComponentSubstance {

	public Aid(Position position) {
		super(position);
	}

	public Aid(int positionX, int positionY) {
		super(positionX, positionY);
	}

	@Override
	public EnumSubtance getType() {
		return EnumSubtance.AID;
	}

	@Override
	public boolean isWall() {
		return false;
	}

	@Override
	public boolean isSmell() {
		return false;
	}

}

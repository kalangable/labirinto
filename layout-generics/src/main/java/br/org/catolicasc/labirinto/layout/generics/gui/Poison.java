package br.org.catolicasc.labirinto.layout.generics.gui;

import br.org.catolicasc.labirinto.layout.generics.ComponentSubstance;
import br.org.catolicasc.labirinto.layout.generics.Position;
import br.org.catolicasc.labirinto.layout.generics.SettingMaze;

public class Poison extends SettingMaze implements ComponentSubstance {

	public Poison(Position position) {
		super(position);
		// TODO Auto-generated constructor stub
	}

	public Poison(int positionX, int positionY) {
		super(positionX, positionY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public EnumSubtance getType() {
		return EnumSubtance.POISON;
	}

	@Override
	public boolean isWall() {
		return false;
	}

	@Override
	public boolean isSmell() {
		return true;
	}

}

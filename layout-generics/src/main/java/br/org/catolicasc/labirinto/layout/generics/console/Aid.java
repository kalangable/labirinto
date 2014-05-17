package br.org.catolicasc.labirinto.layout.generics.console;

import br.org.catolicasc.labirinto.layout.generics.ComponentSubstance;
import br.org.catolicasc.labirinto.layout.generics.Position;
import br.org.catolicasc.labirinto.layout.generics.SettingMaze;

public class Aid<E> extends SettingMaze implements ComponentSubstance<> {

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

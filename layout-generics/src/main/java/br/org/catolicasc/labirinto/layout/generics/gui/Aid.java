package br.org.catolicasc.labirinto.layout.generics.gui;

import br.org.catolicasc.labirinto.layout.generics.ComponentSubstance;
import br.org.catolicasc.labirinto.layout.generics.Position;
import br.org.catolicasc.labirinto.layout.generics.SettingMaze;



public class Aid extends SettingMaze implements ComponentSubstance<EnumSubtance> {

	public Aid(Position position) {
		super(position);
	}

	public Aid(int positionX, int positionY) {
		super(positionX, positionY);
	}


	@Override
	public boolean isWall() {
		return false;
	}

	@Override
	public boolean isSmell() {
		return false;
	}

	@Override
	public br.org.catolicasc.labirinto.layout.generics.console.EnumSubtance getType() {
		// TODO Auto-generated method stub
		return null;
	}

}

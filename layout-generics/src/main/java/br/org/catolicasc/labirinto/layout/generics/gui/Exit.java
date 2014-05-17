package br.org.catolicasc.labirinto.layout.generics.gui;

import br.org.catolicasc.labirinto.layout.generics.ComponentMaze;
import br.org.catolicasc.labirinto.layout.generics.Position;
import br.org.catolicasc.labirinto.layout.generics.SettingMaze;

public class Exit extends SettingMaze implements ComponentMaze<EnumMaze> {

	public Exit(Position position) {
		super(position);
	}

	public Exit(int positionX, int positionY) {
		super(positionX, positionY);
	}
	
	@Override
	public EnumMaze getType() {
		return EnumMaze.EXIT;
	}

	@Override
	public boolean isWall() {
		return false;
	}

}

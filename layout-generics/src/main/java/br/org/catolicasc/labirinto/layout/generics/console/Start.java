package br.org.catolicasc.labirinto.layout.generics.console;

import br.org.catolicasc.labirinto.layout.generics.ComponentMaze;
import br.org.catolicasc.labirinto.layout.generics.Position;
import br.org.catolicasc.labirinto.layout.generics.SettingMaze;

public class Start extends SettingMaze implements ComponentMaze<EnumMaze> {

	public Start(Position position) {
		super(position);
	}

	public Start(int positionX, int positionY) {
		super(positionX, positionY);
	}

	@Override
	public EnumMaze getType() {
		return EnumMaze.START;
	}

	@Override
	public boolean isWall() {
		return false;
	}

}

package br.org.catolicasc.labirinto.layout.generics.factory;

import br.org.catolicasc.labirinto.layout.generics.ComponentMaze;
import br.org.catolicasc.labirinto.layout.generics.Position;
import br.org.catolicasc.labirinto.layout.generics.console.Aid;
import br.org.catolicasc.labirinto.layout.generics.console.Exit;
import br.org.catolicasc.labirinto.layout.generics.console.Poison;
import br.org.catolicasc.labirinto.layout.generics.console.Start;
import br.org.catolicasc.labirinto.layout.generics.console.Track;
import br.org.catolicasc.labirinto.layout.generics.console.Wall;

public class FactoryMazeElement {

	public static ComponentMaze<?> createMazeElement(char value, Position position) {

		ComponentMaze<?> componentMaze = null;
		switch (value) {
		case 'S':
			componentMaze = new Start(position);
			break;
		case 'E':
			componentMaze = new Exit(position);
			break;
		case '#':
			componentMaze = new Wall(position);
			break;
		case 'T':
			componentMaze = new Poison(position);
			break;
		case 'C':
			componentMaze = new Aid(position);
			break;
		default:
			componentMaze = new Track(position);
			break;
		}

		return componentMaze;
	}

}

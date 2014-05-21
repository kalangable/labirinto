package br.org.catolicasc.labirinto.core;

import br.org.catolicasc.labirinto.Maze;
import br.org.catolicasc.labirinto.layout.generics.ElementMaze;
import br.org.catolicasc.labirinto.layout.generics.Position;

public interface Experimental<E> extends ElementMaze<E> {

	public Position getPosition();

	public void setPosition(Position position);

	public void actionLoser();

	public void actionWinner();

	public Position move(Maze maze);
}

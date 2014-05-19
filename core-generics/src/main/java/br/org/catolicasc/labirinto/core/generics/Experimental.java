package br.org.catolicasc.labirinto.core.generics;

import br.org.catolicasc.labirinto.layout.generics.ElementMaze;
import br.org.catolicasc.labirinto.layout.generics.Position;

public interface Experimental<E> extends ElementMaze<E>{

	public Position getPosition();
	
	public void setPosition(Position position);
	
	public void loser();
	
	public void winner();
}

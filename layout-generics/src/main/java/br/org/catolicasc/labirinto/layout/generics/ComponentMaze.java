package br.org.catolicasc.labirinto.layout.generics;

public interface ComponentMaze<T extends Enum<?>> {

	public T getType();

	public boolean isWall();

}

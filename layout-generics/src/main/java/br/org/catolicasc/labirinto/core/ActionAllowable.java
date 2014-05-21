package br.org.catolicasc.labirinto.core;

import br.org.catolicasc.labirinto.layout.generics.Position;

public interface ActionAllowable {

	public Position moveRigth();

	public Position moveLeft();

	public Position moveUp();

	public Position moveDown();

}

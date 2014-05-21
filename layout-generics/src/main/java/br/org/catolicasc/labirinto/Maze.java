package br.org.catolicasc.labirinto;

import java.util.Set;

import br.org.catolicasc.labirinto.layout.generics.ComponentMaze;
import br.org.catolicasc.labirinto.layout.generics.Position;
import br.org.catolicasc.labirinto.layout.generics.console.EnumMaze;

public class Maze {

	private Set<ComponentMaze<EnumMaze>> listcomComponentMazes;

	private Position exit;
	private Position begin;

	private int width;
	private int height;

	public Set<ComponentMaze<EnumMaze>> getListcomComponentMazes() {
		return listcomComponentMazes;
	}

	public void setListcomComponentMazes(Set<ComponentMaze<EnumMaze>> listcomComponentMazes) {
		this.listcomComponentMazes = listcomComponentMazes;
	}

	public Position getExit() {
		return exit;
	}

	public void setExit(Position exit) {
		this.exit = exit;
	}

	public Position getBegin() {
		return begin;
	}

	public void setBegin(Position begin) {
		this.begin = begin;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}

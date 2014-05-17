package br.org.catolicasc.labirinto.layout.generics;

import br.org.catolicasc.labirinto.layout.generics.console.EnumMaze;
import br.org.catolicasc.labirinto.layout.generics.console.Wall;


public class App {
	public static void main(String[] args) {
		ElementMaze ele = EnumMaze.START;
		
		Wall a = new Wall(1,2);
		System.out.println(((ElementMaze) a.getType()).getElement());
		System.out.println(a.isWall());
		System.out.println(a.getPosition().getPositionX());
	}

}

package br.org.catolicasc.labirinto.layout.generics;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		ElementMaze ele = EnumMaze.START;
		
		Aid a = new Aid(1,2);
		System.out.println(a.getType().getElement());
		System.out.println(a.isWall());
		System.out.println(a.getPosition().getPositionX());
	}

}

package br.org.catolicasc.labirinto.layout.generics.gui;

import java.awt.image.BufferedImage;

import br.org.catolicasc.labirinto.layout.generics.ElementMaze;
import br.org.catolicasc.labirinto.layout.generics.commons.ReadUri;

public enum EnumMaze implements ElementMaze<BufferedImage> {

	START("stone.png"), EXIT("stone.png"), WALL("stone.png"), TRACK("empty.png");

	private EnumMaze(String uri) {
		this.element = ReadUri.getImage(uri);
	}

	private BufferedImage element;

	@Override
	public BufferedImage getElement() {
		return this.element;
	}

}

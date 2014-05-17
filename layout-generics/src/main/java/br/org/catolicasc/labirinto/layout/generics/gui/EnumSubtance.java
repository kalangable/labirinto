package br.org.catolicasc.labirinto.layout.generics.gui;

import java.awt.image.BufferedImage;

import br.org.catolicasc.labirinto.layout.generics.ElementMaze;
import br.org.catolicasc.labirinto.layout.generics.commons.ReadUri;

public enum EnumSubtance implements ElementMaze<BufferedImage> {

	POISON("trap.png"), AID("chesse.png");

	private BufferedImage element;

	private EnumSubtance(String uri) {
		this.element = ReadUri.getImage(uri);
	}

	@Override
	public BufferedImage getElement() {
		// TODO Auto-generated method stub
		return this.element;
	}

}

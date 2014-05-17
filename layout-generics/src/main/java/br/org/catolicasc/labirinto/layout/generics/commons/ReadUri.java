package br.org.catolicasc.labirinto.layout.generics.commons;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ReadUri {

	public static BufferedImage getImage(String uri) {
		try {
			return ImageIO.read(new File(Thread.currentThread()
					.getContextClassLoader().getResource(uri).getFile()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

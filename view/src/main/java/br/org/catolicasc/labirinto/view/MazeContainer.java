package br.org.catolicasc.labirinto.view;

import java.io.File;

public interface MazeContainer {

	public void init(File labirinto);

	public void update(Labirinto labirinto, int qtde);

	public void render(Labirinto labirinto);
}

package br.org.catolicasc.labirinto.layout.generics;

public interface ComponenteEstrutura extends ComponenteLabirinto<EnumStructure> {

	public boolean isWall();

	public void setWall(boolean isWall);
}

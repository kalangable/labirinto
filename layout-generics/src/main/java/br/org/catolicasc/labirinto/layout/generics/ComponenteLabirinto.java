package br.org.catolicasc.labirinto.layout.generics;

public interface ComponenteLabirinto<T extends Enum> {

	public T get();

	public void set(T t);

}

package br.org.catolicasc.labirinto.gamer;

public class Morte extends EfeitoSonoro {

	public Morte() {
		super(Thread.currentThread().getContextClassLoader().getResource("hmscream.wav"));
		super.execute();
	}
}

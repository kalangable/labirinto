package br.org.catolicasc.labirinto.gamer;

public class Arroto extends EfeitoSonoro {

	public Arroto() {
		super(Thread.currentThread().getContextClassLoader().getResource("arroto1.wav"));
		super.execute();
	}

}

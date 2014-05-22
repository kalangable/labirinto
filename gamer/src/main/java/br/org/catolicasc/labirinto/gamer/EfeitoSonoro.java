package br.org.catolicasc.labirinto.gamer;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public abstract class EfeitoSonoro {
	private AudioInputStream ais;
	private Clip clip;

	public EfeitoSonoro(URL url) {
		try {
			ais = AudioSystem.getAudioInputStream(url);
			clip = AudioSystem.getClip();
			clip.open(ais);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void execute() {
//		clip.start();
	}

}

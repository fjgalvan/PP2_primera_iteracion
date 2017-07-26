package sonido;

import java.applet.Applet;
import java.applet.AudioClip;


public class Sonido {
	public static final AudioClip TanqueDisparo = Applet
			.newAudioClip(Sonido.class.getResource
					("/Tanque Disparo.wav"));//("/sonido/Tanque Disparo.wav"));
	
	//TIRA ERROR 
	public static final AudioClip TanqueDisparoExplocion = Applet
			.newAudioClip(Sonido.class.getResource
					("/Tanque Disparo.wav"));//("/sonido/Tanque Disparo Explocion.wav"));
	
	public static final AudioClip PacmanChomp = Applet
			.newAudioClip(Sonido.class.getResource
					("/pacman_chomp.wav"));//("/sonido/Tanque Disparo Explocion.wav"));

	public static AudioClip getTanquedisparo() {
		return TanqueDisparo;
	}

	public static AudioClip getTanquedisparoexplocion() {
		return TanqueDisparoExplocion;
	}

	public static AudioClip getPacmanchomp() {
		return PacmanChomp;
	}
					
}

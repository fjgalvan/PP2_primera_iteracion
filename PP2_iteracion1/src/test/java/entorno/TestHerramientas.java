package entorno;

import javax.sound.sampled.Clip;

import org.junit.Test;

public class TestHerramientas {
	@Test
	public void testHerramientas() {
		//Herramientas h= new Herramientas();
		
		Herramientas.radianes(0);
		Herramientas.grados(0);
		//Herramientas.play("/sonido/Tanque Disparo.wav");
		Clip sonido = Herramientas.cargarSonido("src/main/java/Tanque Disparo.wav");
		sonido.loop(Clip.LOOP_CONTINUOUSLY);
		Herramientas.play("Tanque Disparo.wav");
		Herramientas.loop("src/main/java/Tanque Disparo.wav");
	}
	
}

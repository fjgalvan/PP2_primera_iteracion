package app.main;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestGamePacman {
	//ERROR DE TEST EN MAVEN
	@Test
	public void testIniciar() {
		GamePacman pacman = new GamePacman();
		pacman.iniciar();
		assertNotEquals(null, pacman.getTank());
	}
}

package app.main;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class TestGameBomberman {
	@Test
	public void testIniciar() {
		GameBomberman bomberman = new GameBomberman();
		bomberman.iniciar();
		assertNotEquals(null, bomberman.getTank());
	}
}

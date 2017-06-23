package app.mapa;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMapaTiled {
	@Test
	public void testIniciar() {
		MapaTiled mapa = new MapaTiled("/mapas/MapaTank03.csv");
		assertNotNull(mapa);
	}
}

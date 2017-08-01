package mapas;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import app.mapa.MapaTiled;

public class TestCargarMapas {
	@Test
	public void testIniciar() {
		CargarMap mapa = new CargarMap("/mapas/MapaTank03.csv");
		mapa.cargarMapa();
		assertNotNull(mapa);
	}
}

package mapas;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import app.mapa.MapaTiled;

public class TestCargarMapas {
	@Test
	public void testIniciar() {
		//String mapaAJugar ="/mapas/MapaTank03.csv";
		MapaTiled mapa = new MapaTiled("/mapas/MapaTank03.csv");
		mapa.inicializar();
		assertNotNull(mapa);
	}
}

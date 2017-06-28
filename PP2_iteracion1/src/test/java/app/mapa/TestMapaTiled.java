package app.mapa;

/*import static org.junit.Assert.*;  

import java.awt.Point;

import org.junit.Test;

import app.object.ListStructures;*/

public class TestMapaTiled {
	/*@Test
	public void testIniciar() {
		MapaTiled mapa = new MapaTiled("/mapas/MapaTank03.csv");
		mapa.inicializar();
		assertNotNull(mapa);
	}*/
	
	/*@Test
	public void testObtenerCapas(){
		MapaTiled mapa = new MapaTiled("/mapas/MapaTank03.csv");
		mapa.inicializar();
		mapa.obtenerCapas();
		assertTrue(mapa.getCapasDeSprites().size() >= 1);
	}

	@Test
	public void testTraerImagenDesdeJSON(){
		MapaTiled mapa = new MapaTiled("/mapas/MapaTank03.csv");
		mapa.inicializar();
		assertTrue(!mapa.traerImagenDesdeJSON(1).equals("-1"));
	}
	
	@Test
	public void testObtenerCoordenada(){
		MapaTiled mapa = new MapaTiled("/mapas/MapaTank03.csv");
		mapa.inicializar();
		assertTrue(mapa.obtenerCoordenada(40, 15, 25, 5).equals(new Point(200,0)));
	}
	
	@Test
	public void testCrearEstructuras(){
		MapaTiled mapa = new MapaTiled("/mapas/MapaTank03.csv");
		mapa.inicializar();
		ListStructures estructuras = new ListStructures();
		mapa.crearEstructuras(estructuras);
		assertTrue(estructuras.getLista().size() >= 200);
	}*/
}

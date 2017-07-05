package app.mapa;

import static org.junit.Assert.*; 
import java.awt.Point;
import org.junit.Test;
import app.object.ListStructures;

public class TestMapaTiled {
	@Test
	public void testIniciar() {
		String mapaAJugar ="/mapas/MapaTank03.csv";
		MapaTiled mapa = new MapaTiled(mapaAJugar);
		mapa.inicializar();
		assertNotNull(mapa);
	}
	
	@Test
	public void testObtenerCapas(){
		MapaTiled mapa = new MapaTiled("/mapas/MapaTank03.csv");
		mapa.inicializar();
		mapa.obtenerCapas();
		assertNotNull(mapa.getCapasDeSprites().size());
	}

	@Test
	public void testTraerImagenDesdeJSON(){
		MapaTiled mapa = new MapaTiled("/mapas/MapaTank03.csv");
		mapa.inicializar();
		assertNotNull(mapa.traerImagenDesdeJSON(1));
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
		assertNotNull(estructuras.getLista().size());
	}
}

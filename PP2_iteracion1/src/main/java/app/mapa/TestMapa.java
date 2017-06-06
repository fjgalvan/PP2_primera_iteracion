package app.mapa;

import app.modelo.ObjetoGrafico;
import app.object.ListStructures;
import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class TestMapa extends InterfaceJuego {
	private Entorno entorno;
	private ListStructures estructuras;

	public TestMapa() {
		this.entorno = new Entorno(this, "test", 1000, 600);
		this.estructuras = new ListStructures();
		
		MapaTiled mapa = new MapaTiled("/mapas/MapaTank01.csv");
		mapa.crearEstructuras(estructuras);
		
	}

	public void tick() {
		for (ObjetoGrafico e : estructuras.getLista()) {
			dibujarEstructura(e);
		}
	}

	public void dibujarEstructura(ObjetoGrafico e) {
		this.entorno.dibujarImagen(Herramientas.cargarImagen(e.getImagen()),
				e.getCoordinate().getX() + (e.getSize().getAncho() / 2),
				e.getCoordinate().getY() + e.getSize().getAlto() / 2, 0);
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		TestMapa test = new TestMapa();
	}
}

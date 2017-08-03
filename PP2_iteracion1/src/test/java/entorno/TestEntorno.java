package entorno;

import java.awt.Color;
import java.awt.Image;

import org.junit.Test;

public class TestEntorno {
	
	@Test
	public void testIniciarEntorno() {
		InterfaceJuego juego= new InterfaceJuego();
		//Entorno(InterfaceJuego juego, String titulo, int ancho, int alto)
		Entorno entorno = new Entorno(juego, "tank", 30, 30);
		
		entorno.ancho();
		entorno.alto();
		Image imagen= Herramientas.cargarImagen("imagen/tank.png");
		entorno.dibujarImagenConCentro(imagen, 20, 20, 20, 20, 0, 2);
		entorno.dibujarCirculo(20, 20, 30, Color.blue);
		entorno.dibujarRectangulo(20, 20, 30, 30, 0, Color.green);
		entorno.dibujarTriangulo(20, 20, 30, 30, 0, Color.red);
		entorno.escribirTexto("texto", 30, 30);
		entorno.cambiarFont("font", 30, Color.CYAN);
		entorno.estaPresionada('1');
	}

}

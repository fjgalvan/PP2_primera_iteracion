package app.object;

import java.awt.Point;

import org.junit.Test;

import app.enums.Orientation;
import app.state_tank.StateMoveTank;
import entorno.Entorno;
import entorno.InterfaceJuego;

public class TestListenerPlayer2 {
	@Test
	public void testIniciar() {
		
		InterfaceJuego juego= new InterfaceJuego();
		//Entorno(InterfaceJuego juego, String titulo, int ancho, int alto)
		Entorno entorno = new Entorno(juego, "tank", 30, 30);
		StateMoveTank estado;
		
		ListenerPlayer2 lp1= new ListenerPlayer2(entorno);
		
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size, 2);
		
		lp1.seMovio(tank);
		lp1.seActivoDisparo();
	}
}

package app.object;

import java.awt.Point;

import org.junit.Test;

import app.enums.Orientation;
import app.state_tank.StateMoveTank;
import entorno.Entorno;

public class TestListenerPlaye1 {
	@Test
	public void testIniciar() {
		
		Entorno entorno = new Entorno(null, null, 0, 0);
		StateMoveTank estado;
		
		ListenerPlayer1 lp1= new ListenerPlayer1(entorno);
		
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size, 2);
		
		lp1.seMovio(tank);
		lp1.seActivoDisparo();
	}
}

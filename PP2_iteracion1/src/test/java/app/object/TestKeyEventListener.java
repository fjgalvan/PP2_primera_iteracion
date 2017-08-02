package app.object;

import java.awt.Point;

import org.junit.Test;

import app.enums.Orientation;
import app.state_tank.StateMoveTank;
import entorno.Entorno;

public class TestKeyEventListener {
	protected Entorno entorno;
	protected StateMoveTank estado;
	
	@Test
	public void testIniciar() {
		ListenerPlayer1 lp1= new ListenerPlayer1(entorno);
		
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size, 2);
		
		ListenerPlayer1 key= new ListenerPlayer1(entorno);
		key.existeEstadoDeMovimiento();
		key.getEstado();
		key.borrarEstado();
		key.existeEstadoDeMovimiento();
	}
	
}

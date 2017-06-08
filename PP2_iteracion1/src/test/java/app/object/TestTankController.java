package app.object;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import app.enums.Orientation;
import app.modelo.Colisionador;
import app.object.Tank;
import app.object.TankController;
import entorno.Entorno;

public class TestTankController {

	
	/**moverse*/
	@Test
	public void testMoversePorIzquierda() {
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size);
		TankController tankC = new TankController(tank,new ListenerPlayer1(new Entorno(null, null, 0, 0)),Colisionador.getColisionador()); // ver como meter el entorno con la otra clase
		//tankC.ControlLeft(); esta funcion se paso al statemovetankleft
		assertNotEquals(400.50,tank.getCoordinate().getX());
	}
	
	@Test
	public void testMoversePorDerecha() {
		Orientation orientation = Orientation.RIGHT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size);
		TankController tankC = new TankController(tank,new ListenerPlayer1(new Entorno(null, null, 0, 0)),Colisionador.getColisionador());
		//tankC.ControlRigth(); se paso asu estado correspondiente
		assertNotEquals(400.50,tank.getCoordinate().getX());
	}
	
	@Test
	public void testMoversePorAbajo() {
		Orientation orientation = Orientation.DOWN;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size);
		TankController tankC = new TankController(tank,new ListenerPlayer1(new Entorno(null, null, 0, 0)),Colisionador.getColisionador());
	//	tankC.ControlDown(); se paso asu estado correspondiente
		assertNotEquals(400.50,tank.getCoordinate().getY());
	}
	
	@Test
	public void testMoversePorArriba() {
		Orientation orientation = Orientation.UP;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size);
		TankController tankC = new TankController(tank,new ListenerPlayer1(new Entorno(null, null, 0, 0)),Colisionador.getColisionador());
		//tankC.ControlUp(); se paso asu estado correspondiente
		assertNotEquals(400.50,tank.getCoordinate().getY());
	}
	
	/**disparar*/
	@Test
	public void testDisparar() {
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size);
		TankController tankC = new TankController(tank,new ListenerPlayer1(new Entorno(null, null, 0, 0)),Colisionador.getColisionador());
		tankC.getTank().disparar();
		assertNotEquals(null,tankC.getTank().getBullet());
	}

}

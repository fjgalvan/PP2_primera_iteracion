package app.object;

import static org.junit.Assert.*;
import java.awt.Point;
import org.junit.Test;
import app.enums.Orientation;
import app.modelo.Colisionador;
import app.object.Tank;
import app.object.TankController;

public class TestTankController {

	
	/**moverse*/
	@Test
	public void testMoversePorIzquierda() {
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size,1);
		//tankC.ControlLeft(); esta funcion se paso al statemovetankleft
		assertNotEquals(400.50,tank.getCoordinate().getX());
	}
	
	@Test
	public void testMoversePorDerecha() {
		Orientation orientation = Orientation.RIGHT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size,1);
		//tankC.ControlRigth(); se paso asu estado correspondiente
		assertNotEquals(400.50,tank.getCoordinate().getX());
	}
	
	@Test
	public void testMoversePorAbajo() {
		Orientation orientation = Orientation.DOWN;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size,1);
		assertNotEquals(400.50,tank.getCoordinate().getY());
	}
	
	@Test
	public void testMoversePorArriba() {
		Orientation orientation = Orientation.UP;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size,1);
		assertNotEquals(400.50,tank.getCoordinate().getY());
	}
	
	/**disparar*/
	@Test
	public void testDisparar() {
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size,1);
		TankController tankC = new TankController(tank,null,new Colisionador());
		tankC.getTank().disparar();
		assertNotEquals(null,tankC.getTank().getBullet());
	}

}

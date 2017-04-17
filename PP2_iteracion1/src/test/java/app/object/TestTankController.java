package app.object;

import static org.junit.Assert.*;

import org.junit.Test;

import app.enums.Orientation;
import app.object.Coordinate;
import app.object.Size;
import app.object.Tank;
import app.object.TankController;

public class TestTankController {

	
	/**moverse*/
	@Test
	public void testMoversePorIzquierda() {
		Orientation orientation = Orientation.LEFT;
		Coordinate coordinate = new Coordinate(400, 400);
		Size size = new Size(40, 40);
		Tank tank = new Tank(orientation, coordinate, size);
		TankController tankC = new TankController(tank,null); // ver como meter el entorno con la otra clase
		//tankC.ControlLeft(); esta funcion se paso al statemovetankleft
		assertNotEquals(400.0,tank.getCoordinate().getX());
	}
	
	@Test
	public void testMoversePorDerecha() {
		Orientation orientation = Orientation.RIGHT;
		Coordinate coordinate = new Coordinate(400, 400);
		Size size = new Size(40, 40);
		Tank tank = new Tank(orientation, coordinate, size);
		TankController tankC = new TankController(tank, null);
		//tankC.ControlRigth(); se paso asu estado correspondiente
		assertNotEquals(400.0,tank.getCoordinate().getX());
	}
	
	@Test
	public void testMoversePorAbajo() {
		Orientation orientation = Orientation.DOWN;
		Coordinate coordinate = new Coordinate(400, 400);
		Size size = new Size(40, 40);
		Tank tank = new Tank(orientation, coordinate, size);
		TankController tankC = new TankController(tank,null);
	//	tankC.ControlDown(); se paso asu estado correspondiente
		assertNotEquals(400.0,tank.getCoordinate().getY());
	}
	
	@Test
	public void testMoversePorArriba() {
		Orientation orientation = Orientation.UP;
		Coordinate coordinate = new Coordinate(400, 400);
		Size size = new Size(40, 40);
		Tank tank = new Tank(orientation, coordinate, size);
		TankController tankC = new TankController(tank,null);
		//tankC.ControlUp(); se paso asu estado correspondiente
		assertNotEquals(400.0,tank.getCoordinate().getY());
	}
	
	/**disparar*/
	@Test
	public void testDisparar() {
		Orientation orientation = Orientation.LEFT;
		Coordinate coordinate = new Coordinate(400, 400);
		Size size = new Size(40, 40);
		Tank tank = new Tank(orientation, coordinate, size);
		TankController tankC = new TankController(tank,null);
		tankC.getTank().disparar();
		assertNotEquals(null,tankC.getTank().getBullet());
	}

}

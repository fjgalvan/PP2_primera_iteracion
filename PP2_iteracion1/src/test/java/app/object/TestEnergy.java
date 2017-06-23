package app.object;

import static org.junit.Assert.*;
import java.awt.Point;
import org.junit.Test;
import app.enums.Orientation;
import app.object.Tank;

public class TestEnergy {
	
	@Test
	public void testRevisarEnergia() {
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size, 2);
		assertTrue(tank.getEnergyVal().equals(2));
	}
	
	@Test
	public void testReducirEnergia() {
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size, 2);
		tank.decreaseHP();
		assertTrue(tank.getEnergyVal().equals(1));
	}
	
	@Test
	public void testSubirEnergia() {
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size, 1);
		tank.increaseHP();
		assertTrue(tank.getEnergyVal().equals(2));
	}
	
	@Test
	public void testRevisarSinEnergia() {
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size, 1);
		tank.decreaseHP();
		assertTrue(tank.getEnergyVal().equals(0));
	}
	
	@Test
	public void testRevisarSinEnergiaFalso() {
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size, 2);
		tank.decreaseHP();
		assertFalse(tank.getEnergyVal().equals(0));
	}
}

package app.object;

import static org.junit.Assert.*;

import org.junit.Test;

import app.enums.Orientation;
import app.object.Coordinate;
import app.object.Size;
import app.object.Tank;

public class TestEnergy {
	
	@Test
	public void testRevisarEnergia() {
		Orientation orientation = Orientation.LEFT;
		Coordinate coordinate = new Coordinate(400, 400);
		Size size = new Size(40, 40);
		Energy energy= new Energy(2);
		Tank tank = new Tank(orientation, coordinate, size, energy);
		assertTrue(tank.getEnergyVal().equals(2));
	}
	
	@Test
	public void testReducirEnergia() {
		Orientation orientation = Orientation.LEFT;
		Coordinate coordinate = new Coordinate(400, 400);
		Size size = new Size(40, 40);
		Energy energy= new Energy(2);
		Tank tank = new Tank(orientation, coordinate, size, energy);
		tank.decreaseHP();
		assertTrue(tank.getEnergyVal().equals(1));
	}
	
	@Test
	public void testSubirEnergia() {
		Orientation orientation = Orientation.LEFT;
		Coordinate coordinate = new Coordinate(400, 400);
		Size size = new Size(40, 40);
		Energy energy= new Energy(1);
		Tank tank = new Tank(orientation, coordinate, size, energy);
		tank.increaseHP();
		assertTrue(tank.getEnergyVal().equals(2));
	}
	
	@Test
	public void testRevisarSinEnergia() {
		Orientation orientation = Orientation.LEFT;
		Coordinate coordinate = new Coordinate(400, 400);
		Size size = new Size(40, 40);
		Energy energy= new Energy(1);
		Tank tank = new Tank(orientation, coordinate, size, energy);
		tank.decreaseHP();
		assertTrue(tank.getEnergyVal().equals(0));
	}
	
	@Test
	public void testRevisarSinEnergiaFalso() {
		Orientation orientation = Orientation.LEFT;
		Coordinate coordinate = new Coordinate(400, 400);
		Size size = new Size(40, 40);
		Energy energy= new Energy(2);
		Tank tank = new Tank(orientation, coordinate, size, energy);
		tank.decreaseHP();
		assertFalse(tank.getEnergyVal().equals(0));
	}
}

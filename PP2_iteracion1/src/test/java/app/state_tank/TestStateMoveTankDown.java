package app.state_tank;

import static org.junit.Assert.*;
import java.awt.Point;
import org.junit.Test;
import app.enums.Orientation;
import app.object.Tank;

public class TestStateMoveTankDown {

	@Test
	public void testHayColision() 
	{
		Tank tank = new Tank(Orientation.DOWN, new Point(100, 100), new Point(50,50), 2);
		StateMoveTankLeft state = new StateMoveTankLeft();
		state.setTank(tank);
		Tank otro = new Tank(Orientation.DOWN, new Point(300, 225), new Point(50,50), 2);
		assertFalse(tank.getStateMove().hayColision(otro));
		tank.setCoordinate(new Point(300, 175));
		assertTrue(tank.getStateMove().hayColision(otro));
		state.control();
	} 
	
	@Test
	public void testControl() 
	{
		Tank tank = new Tank(Orientation.DOWN, new Point(100, 100), new Point(30,30), 2);
		StateMoveTankLeft state = new StateMoveTankLeft();
		state.setTank(tank);
		assertTrue(tank.getCoordinate().equals(new Point(100,100)));
		tank.getStateMove().control();
		assertFalse(tank.getCoordinate().equals(new Point(100,100)));
	}

	@Test
	public void testGetOrientacion() 
	{
		StateMoveTankLeft state = new StateMoveTankLeft();
		//assertTrue(state.getOrientacion()==Orientation.DOWN);
		assertFalse(state.getOrientacion()==Orientation.UP);
	}

	@Test
	public void testSetTank() 
	{
		StateMoveTankLeft state = new StateMoveTankLeft();
		assertTrue(state.tank==null);
		state.setTank(new Tank(Orientation.DOWN, new Point(100, 100), new Point(30,30), 2));
		assertTrue(state.tank!=null);
	}
}

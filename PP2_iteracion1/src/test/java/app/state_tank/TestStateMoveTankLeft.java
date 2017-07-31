package app.state_tank;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import app.enums.Orientation;
import app.object.Tank;

public class TestStateMoveTankLeft {

	@Test
	public void testHayColision() 
	{
		Tank tank = new Tank(Orientation.LEFT, new Point(100, 100), new Point(50,50), 2);
		StateMoveTankLeft state = new StateMoveTankLeft();
		state.setTank(tank);
		tank.setStateMove(state);
		Tank otro = new Tank(Orientation.LEFT, new Point(275, 225), new Point(50,50), 2);
		assertFalse(tank.getStateMove().hayColision(otro));
		tank.setCoordinate(new Point(325, 225));
		assertTrue(tank.getStateMove().hayColision(otro));
		state.control();
	} 
	
	@Test
	public void testControl() 
	{
		Tank tank = new Tank(Orientation.LEFT, new Point(200, 100), new Point(30,30), 2);
		StateMoveTankLeft state = new StateMoveTankLeft();
		state.setTank(tank);
		tank.setStateMove(state);
		assertTrue(tank.getCoordinate().equals(new Point(200,100)));
		tank.getStateMove().control();
		assertFalse(tank.getCoordinate().getX()==200.0);
	}

	@Test
	public void testGetOrientacion() 
	{
		StateMoveTankLeft state = new StateMoveTankLeft();
		assertTrue(state.getOrientacion()==Orientation.LEFT);
		assertFalse(state.getOrientacion()==Orientation.RIGHT);
	}

	@Test
	public void testSetTank() 
	{
		StateMoveTankLeft state = new StateMoveTankLeft();
		assertTrue(state.tank==null);
		state.setTank(new Tank(Orientation.LEFT, new Point(100, 100), new Point(30,30), 2));
		assertTrue(state.tank!=null);
	}

}

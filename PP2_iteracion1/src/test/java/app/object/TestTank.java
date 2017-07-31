package app.object;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import app.enums.Orientation;
import app.enums.TankShot;

public class TestTank {
	
	@Test
	public void crearTank(){
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size, 2);
		//return tank;
	}
	
	
	@Test
	public void testSetearMovimiento()
	{
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank t = new Tank(orientation, coordinate, size, 2);
		assertTrue(t.getCoordinate().getX() == 400);
		assertTrue(t.getCoordinate().getY() == 400);
		
		t.setearMovimiento(Orientation.UP);
		assertTrue(t.getCoordinate().getX() == 400);
		assertFalse(t.getCoordinate().getX() == 400 - Configuracion.VelocidadTanque);
		
		t.setearMovimiento(Orientation.DOWN);
		assertTrue(t.getCoordinate().getX() == 400);
		assertTrue(t.getCoordinate().getY() == 400);
		
		t.setearMovimiento(Orientation.RIGHT);
		assertTrue(t.getCoordinate().getX() == 400 + Configuracion.VelocidadTanque);
		assertTrue(t.getCoordinate().getY() == 400);
		
		t.setearMovimiento(Orientation.LEFT);
		assertTrue(t.getCoordinate().getX() == 400);
		assertTrue(t.getCoordinate().getY() == 400);
	}
	
	@Test
	public void testValidarEnergia()
	{
		//Tank t = this.crearTank();
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank t = new Tank(orientation, coordinate, size, 2);
		assertTrue(t.getEnergyVal() == 2); //test get energy
		t.increaseHP();
		assertTrue(t.getEnergyVal() == 2); //test increaseHP y validar (>2)
		assertFalse(t.sinEnergy()); //test sinEnergy false
		t.decreaseHP();
		assertFalse(t.getEnergyVal() == 2); // test decreaseHP (verifica q el valor ha cambiado)
		t.decreaseHP();
		assertTrue(t.getEnergyVal() == 0);  // test decreaseHP (verifica el valor esperado)
		t.decreaseHP();
		assertFalse(t.getEnergyVal() == -1); // test validar (<0) true 
		assertTrue(t.getEnergyVal() == 0); // test verifica el resultado de validar(<0)
		assertTrue(t.sinEnergy());		// test sinEnergy true
	}
	
	@Test
	public void testDisparar()
	{
		//Tank t = this.crearTank();
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank t = new Tank(orientation, coordinate, size, 2);
		TankShot ts = TankShot.NO_EXISTS;
		assertEquals(t.getTankBullet(), ts); // se comprueba el estado inicial de TS
		t.disparar();
		assertNotEquals(t.getTankBullet(), ts); // luego de disparar el TS cambia
		t.disparar();
		assertNotEquals(t.getTankBullet(), ts); // si se intenta disparar sin cambiar TS
		t.impactBullet();
		assertEquals(t.getTankBullet(), ts); // se regresa el TS al estado anterior
		
	}
	
	@Test
	public void testGetAngulo()
	{
		//Tank t = this.crearTank();
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank t = new Tank(orientation, coordinate, size, 2);
		assertTrue(t.getAngulo() == Math.PI * 1.5);
		t.setOrientation(Orientation.UP);
		assertFalse(t.getAngulo() == Math.PI * 1.5);
		assertTrue(t.getAngulo() == 0);
		
		t.setOrientation(Orientation.DOWN);
		assertFalse(t.getAngulo() == 0);
		assertTrue(t.getAngulo() == Math.PI);
		
		t.setOrientation(Orientation.LEFT);
		assertFalse(t.getAngulo() == Math.PI);
		assertTrue(t.getAngulo() == Math.PI * 1.5);
		
		t.setOrientation(Orientation.RIGHT);
		assertFalse(t.getAngulo() == Math.PI * 1.5);
		assertFalse(t.getAngulo() == Math.PI * 2.5);
	}
	
}

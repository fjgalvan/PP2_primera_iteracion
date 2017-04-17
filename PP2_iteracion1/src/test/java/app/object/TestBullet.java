package app.object;

import static org.junit.Assert.*;

import org.junit.Test;

import app.enums.Orientation;
import app.object.Coordinate;
import app.util.Util;

public class TestBullet {

	@Test
	public void testColisionBullet(){
		Orientation orientation = Orientation.LEFT;
		Coordinate coordinate = new Coordinate(30, 50);
		assertTrue(Util.estaEnElLimiteDeTablero(orientation, coordinate));
		
		Orientation orientation2 = Orientation.LEFT;
		Coordinate coordinate2 = new Coordinate(31, 50);
		assertFalse(Util.estaEnElLimiteDeTablero(orientation2, coordinate2));
		
		Orientation orientation3 = Orientation.RIGHT;
		Coordinate coordinate3 = new Coordinate(980, 50);
		assertTrue(Util.estaEnElLimiteDeTablero(orientation3, coordinate3));
		
		Orientation orientation4 = Orientation.RIGHT;
		Coordinate coordinate4 = new Coordinate(979, 50);
		assertFalse(Util.estaEnElLimiteDeTablero(orientation4, coordinate4));
		
		Orientation orientation5 = Orientation.UP;
		Coordinate coordinate5 = new Coordinate(50, 30);
		assertTrue(Util.estaEnElLimiteDeTablero(orientation5, coordinate5));
		
		Orientation orientation6 = Orientation.UP;
		Coordinate coordinate6 = new Coordinate(50, 31);
		assertFalse(Util.estaEnElLimiteDeTablero(orientation6, coordinate6));
		
		Orientation orientation7 = Orientation.DOWN;
		Coordinate coordinate7 = new Coordinate(50, 580);
		assertTrue(Util.estaEnElLimiteDeTablero(orientation7, coordinate7));
		
		Orientation orientation8 = Orientation.DOWN;
		Coordinate coordinate8 = new Coordinate(50, 579);
		assertFalse(Util.estaEnElLimiteDeTablero(orientation8, coordinate8));
	}
	
	@Test
	public void testAvanzarBullet(){
		double velocidadDeMovimiento = 2;
		
		Orientation orientation1 = Orientation.LEFT;
		Coordinate coordinate1 = new Coordinate(50, 579);
		Coordinate coordinate2 = new Coordinate(50, 579);
		Util.moverse(orientation1, coordinate2, velocidadDeMovimiento);
		assertNotEquals(coordinate1, coordinate2);
		
		Orientation orientation11 = Orientation.RIGHT;
		Coordinate coordinate11 = new Coordinate(50, 579);
		Coordinate coordinate22 = new Coordinate(50, 579);
		Util.moverse(orientation11, coordinate22, velocidadDeMovimiento);
		assertNotEquals(coordinate11, coordinate22);
		
		Orientation orientation111 = Orientation.UP;
		Coordinate coordinate111 = new Coordinate(50, 579);
		Coordinate coordinate222 = new Coordinate(50, 579);
		Util.moverse(orientation111, coordinate222, velocidadDeMovimiento);
		assertNotEquals(coordinate111, coordinate222);
		
		Orientation orientation1111 = Orientation.DOWN;
		Coordinate coordinate1111 = new Coordinate(50, 579);
		Coordinate coordinate2222 = new Coordinate(50, 579);
		Util.moverse(orientation1111, coordinate2222, velocidadDeMovimiento);
		assertNotEquals(coordinate1111, coordinate2222);
	}
	

}

package app.object;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;
import app.enums.Orientation;
import app.util.Util;

public class TestBullet {

	@Test
	public void testColisionBullet(){
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(30, 50);
		assertTrue(Util.estaEnElLimiteDeTablero(orientation, coordinate));
		
		Orientation orientation2 = Orientation.LEFT;
		Point coordinate2 = new Point(31, 50);
		assertFalse(Util.estaEnElLimiteDeTablero(orientation2, coordinate2));
		
		Orientation orientation3 = Orientation.RIGHT;
		Point coordinate3 = new Point(980, 50);
		assertTrue(Util.estaEnElLimiteDeTablero(orientation3, coordinate3));
		
		Orientation orientation4 = Orientation.RIGHT;
		Point coordinate4 = new Point(979, 50);
		assertFalse(Util.estaEnElLimiteDeTablero(orientation4, coordinate4));
		
		Orientation orientation5 = Orientation.UP;
		Point coordinate5 = new Point(50, 30);
		assertTrue(Util.estaEnElLimiteDeTablero(orientation5, coordinate5));
		
		Orientation orientation6 = Orientation.UP;
		Point coordinate6 = new Point(50, 31);
		assertFalse(Util.estaEnElLimiteDeTablero(orientation6, coordinate6));
		
		Orientation orientation7 = Orientation.DOWN;
		Point coordinate7 = new Point(50, 580);
		assertTrue(Util.estaEnElLimiteDeTablero(orientation7, coordinate7));
		
		Orientation orientation8 = Orientation.DOWN;
		Point coordinate8 = new Point(50, 579);
		assertFalse(Util.estaEnElLimiteDeTablero(orientation8, coordinate8));
	}
	
	@Test
	public void testAvanzarBullet(){
		double velocidadDeMovimiento = 2;
		
		Orientation orientation1 = Orientation.LEFT;
		Point coordinate1 = new Point(50, 579);
		Point coordinate2 = new Point(50, 579);
		Util.moverse(orientation1, coordinate2, velocidadDeMovimiento);
		assertNotEquals(coordinate1, coordinate2);
		
		Orientation orientation11 = Orientation.RIGHT;
		Point coordinate11 = new Point(50, 579);
		Point coordinate22 = new Point(50, 579);
		Util.moverse(orientation11, coordinate22, velocidadDeMovimiento);
		assertNotEquals(coordinate11, coordinate22);
		
		Orientation orientation111 = Orientation.UP;
		Point coordinate111 = new Point(50, 579);
		Point coordinate222 = new Point(50, 579);
		Util.moverse(orientation111, coordinate222, velocidadDeMovimiento);
		assertNotEquals(coordinate111, coordinate222);
		
		Orientation orientation1111 = Orientation.DOWN;
		Point coordinate1111 = new Point(50, 579);
		Point coordinate2222 = new Point(50, 579);
		Util.moverse(orientation1111, coordinate2222, velocidadDeMovimiento);
		assertNotEquals(coordinate1111, coordinate2222);
	}
	

}

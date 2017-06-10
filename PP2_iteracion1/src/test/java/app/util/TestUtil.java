package app.util;

import static org.junit.Assert.*;  

import org.junit.Test;

import app.enums.Orientation;
import app.object.Coordinate;
import app.util.Util;

public class TestUtil {
	
	/**EstaEnElLimiteDeTablero*/
	@Test
	public void testEstaEnElLimiteDeTableroPorIzquierda() {
		Orientation orientation = Orientation.LEFT;
		Coordinate coordinate = new Coordinate(30, 50);
		assertTrue(Util.estaEnElLimiteDeTablero(orientation, coordinate));
	}

	@Test
	public void testNoEstaEnElLimiteDeTableroPorIzquierda() {
		Orientation orientation = Orientation.LEFT;
		Coordinate coordinate = new Coordinate(31, 50);
		assertFalse(Util.estaEnElLimiteDeTablero(orientation, coordinate));
	}
	
	@Test
	public void testEstaEnElLimiteDeTableroPorDerecha() {
		Orientation orientation = Orientation.RIGHT;
		Coordinate coordinate = new Coordinate(980, 50);
		assertTrue(Util.estaEnElLimiteDeTablero(orientation, coordinate));
	}
	
	@Test
	public void testNoEstaEnElLimiteDeTableroPorDerecha() {
		Orientation orientation = Orientation.RIGHT;
		Coordinate coordinate = new Coordinate(779, 50);
		assertFalse(Util.estaEnElLimiteDeTablero(orientation, coordinate));
	}
	
	@Test
	public void testEstaEnElLimiteDeTableroPorArriba() {
		Orientation orientation = Orientation.UP;
		Coordinate coordinate = new Coordinate(50, 30);
		assertTrue(Util.estaEnElLimiteDeTablero(orientation, coordinate));
	}
	
	@Test
	public void testNoEstaEnElLimiteDeTableroPorArriba() {
		Orientation orientation = Orientation.UP;
		Coordinate coordinate = new Coordinate(50, 31);
		assertFalse(Util.estaEnElLimiteDeTablero(orientation, coordinate));
	}
	
	@Test
	public void testEstaEnElLimiteDeTableroPorAbajo() {
		Orientation orientation = Orientation.DOWN;
		Coordinate coordinate = new Coordinate(50, 580);
		assertTrue(Util.estaEnElLimiteDeTablero(orientation, coordinate));
	}
	
	@Test
	public void testNoEstaEnElLimiteDeTableroPorAbajo() {
		Orientation orientation = Orientation.DOWN;
		Coordinate coordinate = new Coordinate(50, 579);
		assertFalse(Util.estaEnElLimiteDeTablero(orientation, coordinate));
	}
	
	/**moverse*/
	@Test
	public void testMoversePorIzquierda() {
//		double velocidadDeMovimiento = 2;
//		Orientation orientation = Orientation.DOWN;
//		Coordinate coordinate = new Coordinate(50, 579);
		//assertTrue(Util.moverse(orientation, coordinate, velocidadDeMovimiento));
	}
	
}

package app.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.Point;
import org.junit.Test;
import app.enums.Orientation;

public class TestUtil {

	/** EstaEnElLimiteDeTablero */
	@Test
	public void testEstaEnElLimiteDeTableroPorIzquierda() {
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(30, 50);
		assertTrue(Util.estaEnElLimiteDeTablero(orientation, coordinate));
	}

	@Test
	public void testNoEstaEnElLimiteDeTableroPorIzquierda() {
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(31, 50);
		assertFalse(Util.estaEnElLimiteDeTablero(orientation, coordinate));
	}

	@Test
	public void testEstaEnElLimiteDeTableroPorDerecha() {
		Orientation orientation = Orientation.RIGHT;
		Point coordinate = new Point(980, 50);
		assertTrue(Util.estaEnElLimiteDeTablero(orientation, coordinate));
	}

	@Test
	public void testNoEstaEnElLimiteDeTableroPorDerecha() {
		Orientation orientation = Orientation.RIGHT;
		Point coordinate = new Point(779, 50);
		assertFalse(Util.estaEnElLimiteDeTablero(orientation, coordinate));
	}

	@Test
	public void testEstaEnElLimiteDeTableroPorArriba() {
		Orientation orientation = Orientation.UP;
		Point coordinate = new Point(50, 30);
		assertTrue(Util.estaEnElLimiteDeTablero(orientation, coordinate));
	}

	@Test
	public void testNoEstaEnElLimiteDeTableroPorArriba() {
		Orientation orientation = Orientation.UP;
		Point coordinate = new Point(50, 31);
		assertFalse(Util.estaEnElLimiteDeTablero(orientation, coordinate));
	}

	@Test
	public void testEstaEnElLimiteDeTableroPorAbajo() {
		Orientation orientation = Orientation.DOWN;
		Point coordinate = new Point(50, 580);
		assertTrue(Util.estaEnElLimiteDeTablero(orientation, coordinate));
	}

	@Test
	public void testNoEstaEnElLimiteDeTableroPorAbajo() {
		Orientation orientation = Orientation.DOWN;
		Point coordinate = new Point(50, 579);
		assertFalse(Util.estaEnElLimiteDeTablero(orientation, coordinate));
	}

	/** moverse */
	@Test
	public void testMoversePorIzquierda() {
		double velocidadDeMovimiento = 2;
		Orientation orientation = Orientation.DOWN;
		Point coordinate = new Point(50, 579);
		// assertTrue(Util.moverse(orientation, coordinate,
		// velocidadDeMovimiento));
	}

}

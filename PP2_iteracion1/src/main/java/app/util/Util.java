package app.util;

import java.awt.Point;

import app.enums.Orientation;

public class Util {

	// controla la posicion del objeto a traves de las coordenadas, para
	// asegurarse que no salga del limite del mapa
	public static boolean estaEnElLimiteDeTablero(Orientation orientation, Point coordinate) { // ,Posicion
																								// posicion
		if (orientation.equals(Orientation.LEFT) && coordinate.getX() <= 40) {
			return true; // izquierda
		}
		if (orientation.equals(Orientation.RIGHT) && coordinate.getX() >= 920) {
			return true; // derecha
		}
		if (orientation.equals(Orientation.UP) && coordinate.getY() <= 40) {
			return true;// arriba
		}
		if (orientation.equals(Orientation.DOWN) && coordinate.getY() >= 560) {
			return true; // abajo
		}
		return false;
	}

	public static void moverse(Orientation orientation, Point coordinate, double velocidadDeMovimiento) {
		if (orientation.equals(Orientation.UP)) {
			coordinate.setLocation(coordinate.getX(), coordinate.getY() - velocidadDeMovimiento);
		}
		if (orientation.equals(Orientation.DOWN)) {
			coordinate.setLocation(coordinate.getX(), coordinate.getY() + velocidadDeMovimiento);
		}
		if (orientation.equals(Orientation.LEFT)) {
			coordinate.setLocation(coordinate.getX() - velocidadDeMovimiento, coordinate.getY());
		}
		if (orientation.equals(Orientation.RIGHT)) {
			coordinate.setLocation(coordinate.getX() + velocidadDeMovimiento, coordinate.getY());
		}
	}
}

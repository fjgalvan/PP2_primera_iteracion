package app.object;

import java.awt.Point;

import app.enums.Orientation;
import app.modelo.ObjetoGrafico;
import app.util.Util;

public class Bullet extends ObjetoGrafico {
	private Orientation orientation;
	private double velocidadDeMovimiento = 5;

	public Bullet(Orientation orientation, Point coordinate, Point size) {
		super(coordinate, size);
		this.orientation = orientation;
	}

	public void avanzarBullet() {
		Util.moverse(orientation, coordinate, velocidadDeMovimiento);
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

}

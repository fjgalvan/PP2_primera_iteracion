package app.mapa;

import java.awt.Point;

public abstract class CapaTiled {
	protected Point size;
	protected Point coordinate;

	public CapaTiled(Point size, Point coordinate) {
		this.size = size;
		this.coordinate = coordinate;
	}
	
}

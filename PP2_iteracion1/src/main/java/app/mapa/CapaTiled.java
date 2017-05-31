package app.mapa;

import app.object.Coordinate;
import app.object.Size;

public abstract class CapaTiled {
	protected Size size;
	protected Coordinate coordinate;
	
	public CapaTiled(Size size, Coordinate coordinate){
		this.size = size;
		this.coordinate = coordinate;
	}
}

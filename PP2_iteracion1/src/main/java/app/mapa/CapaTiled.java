package app.mapa;

import app.object.Coordinate;
import app.object.Size;

public abstract class CapaTiled {
	protected String nombre;
	protected Size size;
	protected Coordinate coordinate;
	
	public CapaTiled(String nombre,Size size, Coordinate coordinate){
		this.nombre = nombre;
		this.size = size;
		this.coordinate = coordinate;
	}

	public String getNombre() {
		return nombre;
	}
}

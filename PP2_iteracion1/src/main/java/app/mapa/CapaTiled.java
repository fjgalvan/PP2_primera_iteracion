package app.mapa;

import java.awt.Point;


public abstract class CapaTiled {
	protected String nombre;
	protected Point coordinate;
	protected Point size;
	
	public CapaTiled(String nombre,Point size, Point coordinate){
		this.nombre = nombre;
		this.size = size;
		this.coordinate = coordinate;
	}

	public String getNombre() {
		return nombre;
	}
}

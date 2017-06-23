package app.modelo;

import java.awt.Color;
import java.awt.Point;

public abstract class ObjetoGrafico {
	protected Point coordinate;
	protected Point size;
	protected Color color;
	protected String imagen;
	protected double radio;

	public ObjetoGrafico() {
		this.radio = 0;
	}
	
	public ObjetoGrafico(Point coordinate, Point size){
		this.radio = 0;
		this.coordinate = coordinate;
		this.size = size;
	}
	
	public ObjetoGrafico(String imagen, Color color){
		this.imagen = imagen;
		this.color = color;
		this.radio = 0;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getImagen() {
		return this.imagen;
	}

	public Point getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Point coordinate) {
		this.coordinate = coordinate;
	}

	public Point getSize() {
		return size;
	}

	public void setSize(Point size) {
		this.size = size;
	}
	
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	// public abstract void dibujar(Entorno ent);
	// public abstract void dibujar(Entorno ent, Coordenada c);

}
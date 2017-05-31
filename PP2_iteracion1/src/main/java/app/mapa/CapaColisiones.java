package app.mapa;

import java.awt.Rectangle;

import app.object.Coordinate;
import app.object.Size;

public class CapaColisiones extends CapaTiled{
	private Rectangle[] colisionables;
	
	public CapaColisiones(Size size, Coordinate coordinate, Rectangle[] colisionables){
		super(size, coordinate);
		this.colisionables = colisionables;
	}

	public Rectangle[] getColisionables() {
		return colisionables;
	}
}

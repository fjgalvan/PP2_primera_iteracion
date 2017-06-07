package app.mapa;

import java.awt.Point;
import java.awt.Rectangle;

public class CapaColisiones extends CapaTiled{
	private Rectangle[] colisionables;
	
	public CapaColisiones(Point size, Point coordinate, Rectangle[] colisionables){
		super(size, coordinate);
		this.colisionables = colisionables;
	}

	public Rectangle[] getColisionables() {
		return colisionables;
	}
}

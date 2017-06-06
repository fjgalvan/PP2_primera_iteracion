package app.mapa;

import app.object.Coordinate;
import app.object.Size;

public class CapaSprites extends CapaTiled{
	private int[] sprites;
	
	public CapaSprites(String nombre, Size size, Coordinate coordinate, int []sprites){
		super(nombre, size, coordinate);
		this.sprites = sprites;
	}

	public int[] getSprites() {
		return sprites;
	}
	
}

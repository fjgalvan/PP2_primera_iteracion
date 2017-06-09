package app.mapa;

import app.object.Coordinate;
import app.object.Size;

public class CapaSprites extends CapaTiled{
	private String imagenCapa;
	private int[] sprites;
	
	public CapaSprites(String nombre, String imagenCapa, Size size, Coordinate coordinate, int []sprites){
		super(nombre, size, coordinate);
		this.imagenCapa = imagenCapa;
		this.sprites = sprites;
	}

	public int[] getSprites() {
		return sprites;
	}

	public String getImagenCapa() {
		return imagenCapa;
	}
}

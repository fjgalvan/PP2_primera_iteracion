package app.mapa;

import app.object.Coordinate;
import app.object.Size;

public class CapaSprites extends CapaTiled{
	private String imagenCapa;
	private int[] sprites;
	private String[] spritesImagenes;
	
	public CapaSprites(String nombre, String imagenCapa, Size size, Coordinate coordinate, int []sprites, String[] spritesCapaDeImagenes){
		super(nombre, size, coordinate);
		this.imagenCapa = imagenCapa;
		this.sprites = sprites;
		this.spritesImagenes = spritesCapaDeImagenes;
	}

	public int[] getSprites() {
		return sprites;
	}

	public String getImagenCapa() {
		return imagenCapa;
	}

	public String[] getSpritesImagenes() {
		return spritesImagenes;
	}
}

package app.mapa;

import java.awt.Point;

public class CapaSprites extends CapaTiled {
	private int[] sprites;

	public CapaSprites(Point size, Point coordinate, int[] sprites) {
		super(size, coordinate);
		this.sprites = sprites;
	}

	public int[] getSprites() {
		return sprites;
	}

}

package app.object;

import app.enums.Orientation;
import app.util.Util;

public class Bullet {
	private Orientation orientation;
	private Coordinate coordinate;
	private Size size;
	private double velocidadDeMovimiento = 5;
	
	public Bullet(Orientation orientation, Coordinate coordinate, Size size){
		this.orientation = orientation;
		this.coordinate = coordinate;
		this.size = size;
	}
	
	//seria si colisiona con una estructura o con el limite del tablero
	public boolean colisionBullet(){
		if(Util.estaEnElLimiteDeTablero(orientation, coordinate)){
			return true;
		}
		return false;
	}
	
	public void avanzarBullet(){
		Util.moverse(orientation, coordinate, velocidadDeMovimiento);
	}
	
	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}
}

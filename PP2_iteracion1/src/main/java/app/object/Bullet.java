package app.object;

import java.util.List;

import app.enums.Orientation;
import app.modelo.Colisionador;
import app.modelo.ObjetoGrafico;
import app.util.Util;

public class Bullet extends ObjetoGrafico{
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
	public boolean hayColisionConUnObjeto(List<ObjetoGrafico> lista)
	{

		Colisionador col = new Colisionador();
		boolean ret = false;
		for(ObjetoGrafico obj : lista)
		{
			ret = ret || col.chocaConEstructura(this, obj); // dependiendo el estado va atener una colision !=
		}
		return ret;
	}
	
	public boolean colisionBullet(List<ObjetoGrafico> objetos){
		if(Util.estaEnElLimiteDeTablero(orientation, coordinate)){
			return true;
		}
		return hayColisionConUnObjeto(objetos);
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

package app.util;

import java.awt.Image;

import javax.swing.ImageIcon;

import app.enums.Orientation;
import app.object.Coordinate;

public class Util {

	//controla la posicion del objeto a traves de las coordenadas, para asegurarse que no salga del limite del mapa
		public static boolean estaEnElLimiteDeTablero(Orientation orientation, Coordinate coordinate){ //,Posicion posicion
			if( orientation.equals(Orientation.LEFT) && coordinate.getX() <= 30){
				return  true; //izquierda
			}if(orientation.equals(Orientation.RIGHT) && coordinate.getX() >= 980){
				return true; //derecha 
			}if(orientation.equals(Orientation.UP) && coordinate.getY() <= 30){
				return true;//arriba 
			}if(orientation.equals(Orientation.DOWN) && coordinate.getY() >= 580){
				return true; //abajo 
			}
			return false;
		}
		
	public static void moverse(Orientation orientation, Coordinate coordinate, double velocidadDeMovimiento){
		if(orientation.equals(Orientation.UP)){
			coordinate.setY(coordinate.getY() - velocidadDeMovimiento);
		}
		if(orientation.equals(Orientation.DOWN)){
			coordinate.setY(coordinate.getY() + velocidadDeMovimiento);
		}
		if(orientation.equals(Orientation.LEFT)){
			coordinate.setX(coordinate.getX() - velocidadDeMovimiento);
		}
		if(orientation.equals(Orientation.RIGHT)){
			coordinate.setX(coordinate.getX() + velocidadDeMovimiento);
		}
	}
}

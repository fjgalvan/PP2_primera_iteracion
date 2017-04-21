package app.modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import app.enums.Orientation;
import app.object.Bullet;
import app.object.Coordinate;
import app.object.GraphicMap;
import app.object.ListStructures;
import app.object.Map;
import app.object.Size;
import app.object.Tank;

public class TestColisionador {
	
	@Test
	public void colisionBulletConEstructura() {
		Colisionador colisionador = new Colisionador();
		GraphicMap mapa = new GraphicMap(new Map(new Size(280, 280)), new Size(20, 20));
		ListStructures estructuras = new ListStructures(mapa, 10);
				
		Size size = new Size(10, 10);
		Coordinate coordinate = new Coordinate(200, 200);
		Bullet bullet = new Bullet(Orientation.RIGHT,coordinate, size);
		
		List<ObjetoGrafico> objetos = new ArrayList<ObjetoGrafico>();
		objetos.addAll(estructuras.getLista());
		assertTrue(colisionador.colisionBullet(bullet, objetos));
	}
	
	@Test
	public void noColisionBulletConEstructura() {
		Colisionador colisionador = new Colisionador();
		GraphicMap mapa = new GraphicMap(new Map(new Size(1000, 600)), new Size(20, 20));
		ListStructures estructuras = new ListStructures(mapa, 10);
		List<ObjetoGrafico> objetos = new ArrayList<ObjetoGrafico>();
		objetos.addAll(estructuras.getLista());
		
		Size size = new Size(10, 10);
		Coordinate coordinate = new Coordinate(200, 200);
		Bullet bullet = new Bullet(Orientation.RIGHT,coordinate, size);
		
		assertFalse(colisionador.colisionBullet(bullet, objetos));
	}

	@Test
	public void colisionBulletConTank() {
		Colisionador colisionador = new Colisionador();

		Size size = new Size(10, 10);
		Coordinate coordinate = new Coordinate(200, 200);
		Bullet bullet = new Bullet(Orientation.RIGHT,coordinate, size);
		
		Size sizeTank = new Size(40, 40);
		Coordinate coordinateTank = new Coordinate(200, 200);
		Tank tank = new Tank(Orientation.LEFT, coordinateTank, sizeTank);

		List<Tank> objetos = new ArrayList<Tank>();
		objetos.add(tank);
		
		assertTrue(colisionador.colisionBulletConTank(bullet, objetos));
	}
	
	@Test
	public void noColisionBulletConTank() {
		Colisionador colisionador = new Colisionador();

		Size size = new Size(10, 10);
		Coordinate coordinate = new Coordinate(200, 200);
		Bullet bullet = new Bullet(Orientation.RIGHT,coordinate, size);
		
		Size sizeTank = new Size(40, 40);
		Coordinate coordinateTank = new Coordinate(200, 250);
		Tank tank = new Tank(Orientation.LEFT, coordinateTank, sizeTank);

		List<Tank> objetos = new ArrayList<Tank>();
		objetos.add(tank);
		
		assertFalse(colisionador.colisionBulletConTank(bullet, objetos));
	}
	
	
	@Test
	public void hayColision(){
		Colisionador colisionador = new Colisionador();
		GraphicMap mapa = new GraphicMap(new Map(new Size(280, 280)), new Size(20, 20));
		ListStructures estructuras = new ListStructures(mapa, 10);
		List<ObjetoGrafico> objetos = new ArrayList<ObjetoGrafico>();
		objetos.addAll(estructuras.getLista());
		
		Size sizeTank = new Size(40, 40);
		Coordinate coordinateTank = new Coordinate(200, 220);
		Tank tank = new Tank(Orientation.LEFT, coordinateTank, sizeTank);
		
		boolean ret = false;
		for(ObjetoGrafico obj : objetos)
		{
			ret = ret || colisionador.hayColision(tank, obj); // dependiendo el estado va atener una colision !=
		}
		
		assertTrue(ret);
	}

	@Test
	public void hayColisionArriba(){
		Colisionador colisionador = new Colisionador();
		GraphicMap mapa = new GraphicMap(new Map(new Size(280, 280)), new Size(20, 20));
		ListStructures estructuras = new ListStructures(mapa, 10);
		List<ObjetoGrafico> objetos = new ArrayList<ObjetoGrafico>();
		objetos.addAll(estructuras.getLista());
		
		Size sizeTank = new Size(40, 40);
		Coordinate coordinateTank = new Coordinate(200, 220);
		Tank tank = new Tank(Orientation.UP, coordinateTank, sizeTank);

		boolean ret = false;
		for(ObjetoGrafico obj : objetos)
		{
			ret = ret || colisionador.hayColisionArriba(tank, obj); // dependiendo el estado va atener una colision !=
		}
		
		assertTrue(ret);
		
	}
}

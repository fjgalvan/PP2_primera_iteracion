package app.modelo;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import app.enums.Orientation;
import app.mapa.MapaTiled;
import app.object.Bullet;
import app.object.Configuracion;
import app.object.Tank;

public class TestColisionador {
	
	@Test
	public void colisionBulletConEstructura() {
		Colisionador colisionador = new Colisionador();
		//ListStructures estructuras = new ListStructures();
		List<ObjetoGrafico> estructuras= new ArrayList<>();
		String mapaAJugar = Configuracion.MapaTank;
		MapaTiled mapaTiled= new MapaTiled(mapaAJugar);
		mapaTiled.inicializar();
		mapaTiled.crearEstructuras(estructuras);
		
		
		Point size = new Point(10, 10);
		Point coordinate = new Point(881, 200);
		Bullet bullet = new Bullet(Orientation.RIGHT,coordinate, size);
		List<ObjetoGrafico> objetos = new ArrayList<ObjetoGrafico>();
		//objetos.addAll(estructuras.getLista());
		assertFalse(colisionador.colisionBullet(bullet, objetos));
	}
	
	@Test
	public void noColisionBulletConEstructura() {
		Colisionador colisionador = new Colisionador();
		List<ObjetoGrafico> estructuras = new ArrayList<>();
		List<ObjetoGrafico> objetos = new ArrayList<ObjetoGrafico>();
		objetos.addAll(estructuras);
		
		Point size = new Point(10, 10);
		Point coordinate = new Point(200, 200);
		Bullet bullet = new Bullet(Orientation.RIGHT,coordinate, size);
		
		assertFalse(colisionador.colisionBullet(bullet, objetos));
	}

	@Test
	public void colisionBulletConTank() {
		Colisionador colisionador = new Colisionador();

		Point size = new Point(10, 10);
		Point coordinate = new Point(200, 200);
		Bullet bullet = new Bullet(Orientation.RIGHT,coordinate, size);
		
		Point sizeTank = new Point(40, 40);
		Point coordinateTank = new Point(200, 200);
		Tank tank = new Tank(Orientation.LEFT, coordinateTank, sizeTank,1);

		List<Tank> objetos = new ArrayList<Tank>();
		objetos.add(tank);
		
		assertTrue(colisionador.colisionBulletConTank(bullet, objetos));
	}
	
	@Test
	public void noColisionBulletConTank() {
		Colisionador colisionador = new Colisionador();

		Point size = new Point(10, 10);
		Point coordinate = new Point(200, 200);
		Bullet bullet = new Bullet(Orientation.RIGHT,coordinate, size);
		
		Point sizeTank = new Point(40, 40);
		Point coordinateTank = new Point(200, 250);
		Tank tank = new Tank(Orientation.LEFT, coordinateTank, sizeTank,1);

		List<Tank> objetos = new ArrayList<Tank>();
		objetos.add(tank);
		
		assertFalse(colisionador.colisionBulletConTank(bullet, objetos));
	}
	
	//ERROR TEST
	@Test
	public void hayColision(){
		Colisionador colisionador = new Colisionador();
		List<ObjetoGrafico> estructuras= new ArrayList<>();
		MapaTiled mapaTiled = new MapaTiled("/mapas/MapaTank04.csv");
		mapaTiled.inicializar();
		mapaTiled.crearEstructuras(estructuras);
		List<ObjetoGrafico> objetos = new ArrayList<ObjetoGrafico>();
		//objetos.addAll(estructuras.getLista());
		
		Point sizeTank = new Point(40, 40);
		Point coordinateTank = new Point(200, 220);
		Tank tank = new Tank(Orientation.LEFT, coordinateTank, sizeTank,1);
		
		boolean ret = false;
		for(ObjetoGrafico obj : objetos)
		{
			ret = ret || colisionador.hayColision(tank, obj); // dependiendo el estado va atener una colision !=
		}
		
		assertFalse(ret);
	}

	/*@Test
	public void hayColisionArriba(){
		Colisionador colisionador = new Colisionador();
		ListStructures estructuras = new ListStructures();
		MapaTiled mapaTiled = new MapaTiled("/mapas/MapaTank04.csv");
		mapaTiled.inicializar();
		mapaTiled.crearEstructuras(estructuras);
		List<ObjetoGrafico> objetos = new ArrayList<ObjetoGrafico>();
		objetos.addAll(estructuras.getLista());
		
		Point sizeTank = new Point(40, 40);
		Point coordinateTank = new Point(40, 80);
		Tank tank = new Tank(Orientation.UP, coordinateTank, sizeTank,1);

		boolean ret = false;
		for(ObjetoGrafico obj : objetos)
		{
			ret = ret || colisionador.hayColisionArriba(tank, obj); // dependiendo el estado va atener una colision !=
		}
		
		assertTrue(ret);
		
	}*/
	
	@Test
	public void hayCoilision(){
		Colisionador colisionador = new Colisionador();
		
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(120, 120);
		Point size = new Point(40, 40);
		Point coordinate2 = new Point(140, 160);
		
		ObjetoGrafico objGraf1= new Tank(orientation,coordinate,size,1);
		ObjetoGrafico objGraf2= new Tank(orientation,coordinate2,size,1);
		
		assertTrue(colisionador.hayColision(objGraf1,objGraf2));
	}
	@Test
	public void hayCoilisionAbajo(){
		Colisionador colisionador = new Colisionador();
		
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(120, 120);
		Point size = new Point(40, 40);
		Point coordinate2 = new Point(140, 160);
		
		ObjetoGrafico objGraf1= new Tank(orientation,coordinate,size,1);
		ObjetoGrafico objGraf2= new Tank(orientation,coordinate2,size,1);
		
		assertTrue(colisionador.hayColisionAbajo(objGraf1,objGraf2));
	}
	@Test
	public void hayCoilisionArriba(){
		Colisionador colisionador = new Colisionador();
		
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(120, 120);
		Point size = new Point(40, 40);
		Point coordinate2 = new Point(140, 160);
		
		ObjetoGrafico objGraf1= new Tank(orientation,coordinate,size,1);
		ObjetoGrafico objGraf2= new Tank(orientation,coordinate2,size,1);
		
		assertFalse(colisionador.hayColisionArriba(objGraf1,objGraf2));
	}
	@Test
	public void hayCoilisionDerecha(){
		Colisionador colisionador = new Colisionador();
		
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(120, 120);
		Point size = new Point(40, 40);
		Point coordinate2 = new Point(140, 160);
		
		ObjetoGrafico objGraf1= new Tank(orientation,coordinate,size,1);
		ObjetoGrafico objGraf2= new Tank(orientation,coordinate2,size,1);
		
		assertFalse(colisionador.hayColisionDerecha(objGraf1,objGraf2));
	}
	@Test
	public void hayCoilisionIzquierda(){
		Colisionador colisionador = new Colisionador();
		
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(120, 120);
		Point size = new Point(40, 40);
		Point coordinate2 = new Point(140, 160);
		
		ObjetoGrafico objGraf1= new Tank(orientation,coordinate,size,1);
		ObjetoGrafico objGraf2= new Tank(orientation,coordinate2,size,1);
		
		assertFalse(colisionador.hayColisionIzquierda(objGraf1,objGraf2));
	}
}

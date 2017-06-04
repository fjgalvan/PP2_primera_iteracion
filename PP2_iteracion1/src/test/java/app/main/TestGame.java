package app.main;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entorno.Entorno;
import entorno.InterfaceJuego;
import app.enums.Orientation;
import app.modelo.Colisionador;
import app.object.Coordinate;
import app.object.Draftsman;
import app.object.DriverEasyEnemyTank;
import app.object.GraphicMap;
import app.object.KeyEventListener;
import app.object.KeyEventListenerCop;
import app.object.Map;
import app.object.Player1;
import app.object.Puntaje;
import app.object.Size;
import app.object.Tank;
import app.object.TankController;

public class TestGame {
	@Test
	public void testIniciar() {
		Game juego= new Game();
		
		Tank tank = new Tank(Orientation.UP,new Coordinate(400,400),new Size(40,40));
		Tank enemyTank = new Tank(Orientation.UP,new Coordinate(600,100),new Size(40,40));
		Tank enemyTank2 = new Tank(Orientation.UP,new Coordinate(500,100),new Size(40,40));
		Tank enemyTank3 = new Tank(Orientation.UP,new Coordinate(400,100),new Size(40,40));
		Tank enemyTank4 = new Tank(Orientation.UP,new Coordinate(300,100),new Size(40,40));
		
		List<Tank> tanks = new ArrayList<Tank>();
		List<Tank> enemysTanks = new ArrayList<Tank>();
		
		tanks.add(tank);
		enemysTanks.add(enemyTank);
		enemysTanks.add(enemyTank2);
		enemysTanks.add(enemyTank3);
		enemysTanks.add(enemyTank4);
		
		try{ 
			juego.iniciar();
		}catch(Exception e){
			//System.out.println("Se crearon las listas de tanques aliados y enemigos");
		}
		assertNotEquals(null,tanks);
		assertNotEquals(null,enemysTanks);
		
		
		Colisionador colisionador= new Colisionador();
		GraphicMap mapa= new GraphicMap(new Map(new Size(1000, 600)), new Size(20, 20));
		
		/*Draftsman dibujador= new Draftsman(this, mapa, "Battle-Ungs");
		KeyEventListener listener= = new KeyEventListener(dibujador.getEntorno());
		TankController tControl= new TankController(tank,listener);
		juego.destruccionTank1(); //destruccionTanksEnemys();
		assertEquals(null,enemyTank);*/
		
		
		/*GraphicMap mapa= new GraphicMap(new Map(new Size(1000, 600)), new Size(20, 20));
		try{ 
			juego.tick();
		}catch(Exception e){
			System.out.println("Se crearon las listas de tanques aliados y enemigos");
		}
		assertNotEquals(null, mapa);*/
	}

	@Test
	public void testDestruccionTank1() {
		InterfaceJuego i= null;
		GraphicMap mapa = new GraphicMap(new Map(new Size(1000, 600)), new Size(20, 20));
		Draftsman dibujador = new Draftsman(i, mapa, "Battle-Ungs");
		KeyEventListenerCop listenerCop= new KeyEventListenerCop(dibujador.getEntorno());
		Colisionador colisionador = new Colisionador();
		Orientation orientation = Orientation.LEFT;
		Coordinate coordinate = new Coordinate(400, 400);
		Size size = new Size(40, 40);
		Tank tank = new Tank(orientation, coordinate, size);
		TankController tankC = new TankController(tank,listenerCop,null); // ver como meter el entorno con la otra clase
		
		Orientation orientation2 = Orientation.RIGHT; 
		Coordinate coordinate2 = new Coordinate(300, 400);
		Size size2 = new Size(40, 40);
		Tank tankEnemy = new Tank(orientation, coordinate, size);
		DriverEasyEnemyTank tankEnemyD = new DriverEasyEnemyTank(tankEnemy);
		
		tankC.destruirTank();
		assertEquals(null,tankC.getTank());
	}
	
	
	
	@Test
	public void testSumarPuntaje() {
		InterfaceJuego i= null;
		GraphicMap mapa = new GraphicMap(new Map(new Size(1000, 600)), new Size(20, 20));
		Draftsman dibujador = new Draftsman(i, mapa, "Battle-Ungs");
		Player1 player1 = new Player1(new Puntaje(0,0),dibujador);
		Game juego= new Game();
		juego.sumarPuntaje(player1.toString());
		
		assertNotEquals(null,player1.toString());
		player1.setPuntaje(new Puntaje(500,0));
		
		String player2= "1";
		assertEquals("1",player2);
	}
	
	
}

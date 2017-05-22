package app.main;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import app.enums.Orientation;
import app.modelo.Colisionador;
import app.object.Coordinate;
import app.object.Draftsman;
import app.object.DriverEasyEnemyTank;
import app.object.GraphicMap;
import app.object.KeyEventListener;
import app.object.Map;
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
	
	
	//@Test
	/*public void testDestruccionTank1() {
		Orientation orientation = Orientation.LEFT;
		Coordinate coordinate = new Coordinate(400, 400);
		Size size = new Size(40, 40);
		Tank tank = new Tank(orientation, coordinate, size);
		TankController tankC = new TankController(tank,null); // ver como meter el entorno con la otra clase
		
		Orientation orientation2 = Orientation.RIGHT; 
		Coordinate coordinate2 = new Coordinate(300, 400);
		Size size2 = new Size(40, 40);
		Tank tankEnemy = new Tank(orientation, coordinate, size);
		DriverEasyEnemyTank tankEnemyD = new DriverEasyEnemyTank(tankEnemy);
		
		tankC.destruirTank();
		assertEquals(null,tankC.getTank());
	}*/
	
	
}

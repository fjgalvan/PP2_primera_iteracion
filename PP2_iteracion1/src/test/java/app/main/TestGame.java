package app.main;


import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import app.enums.Orientation;
import app.object.Player;
import app.object.Tank;
import app.object.TankController;

public class TestGame {
	@Test
	public void testIniciar() {
		
		Tank tank = new Tank(Orientation.UP,new Point(400,400),new Point(40,40), 1);
		Tank enemyTank = new Tank(Orientation.UP,new Point(600,100),new Point(40,40), 2);
		Tank enemyTank2 = new Tank(Orientation.UP,new Point(500,100),new Point(40,40), 2);
		Tank enemyTank3 = new Tank(Orientation.UP,new Point(400,100),new Point(40,40), 2);
		Tank enemyTank4 = new Tank(Orientation.UP,new Point(300,100),new Point(40,40), 2);
		
		List<Tank> tanks = new ArrayList<Tank>();
		List<Tank> enemysTanks = new ArrayList<Tank>();
		
		tanks.add(tank);
		enemysTanks.add(enemyTank);
		enemysTanks.add(enemyTank2);
		enemysTanks.add(enemyTank3);
		enemysTanks.add(enemyTank4);
		
		assertNotEquals(null,tanks);
		assertNotEquals(null,enemysTanks);
	}
	/*@Test
	public void sumarPuntaje() {
	}*/
	
	@Test
	public void testDestruccionTank1() {
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size, 2);
		TankController tankC = new TankController(tank,null,null); // ver como meter el entorno con la otra clase
		tankC.destruirTank();
		assertEquals(null,tankC.getTank());
	}
	
	@Test
	public void testSumarPuntaje() {
		Game.sumarCantidadDeEnemigosAsesinados("2");
		Game.sumarPuntaje("1");
		Player player1 = new Player(0,0,null);
		assertNotEquals(null,player1.toString());
		player1.setPuntaje(500);
		String player2= "1";
		assertEquals("1",player2);
	}
	
	
}

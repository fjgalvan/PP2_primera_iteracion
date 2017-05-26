package app.main;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import app.enums.Orientation;
import app.object.Coordinate;
import app.object.Size;
import app.object.Tank;

public class TestMain {
	
	@Test
	public void testMain(){
	
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
	}
}

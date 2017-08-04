package app.modelo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import app.enums.Orientation;
import app.levels.DataLevelGame;
import app.levels.LevelEasy;
import app.object.Bullet;
import app.object.DriverEasyEnemyTank;
import app.object.Player;
import app.object.Tank;

public class TestDestructor {
	@Test
	public void testIniciar() {
		
		DataLevelGame data = new DataLevelGame();
		Tank tank = new Tank(Orientation.LEFT, new Point(300, 200), new Point(40, 40), 2);
		//DriverEasyEnemyTank driverEasy= new DriverEasyEnemyTank(tank);
		//driverEasy.cargarMovimientos();
		data.cargarClavesNiveles();
		Destructor destructor= new Destructor();
		Colisionador colisionador= new Colisionador();
		List<ObjetoGrafico> estructuras = new ArrayList<>();
		List<ObjetoGrafico> objetos = new ArrayList<ObjetoGrafico>();
		objetos.addAll(estructuras);
		
		Point size = new Point(10, 10);
		Point coordinate = new Point(200, 200);
		Bullet bullet = new Bullet(Orientation.RIGHT,coordinate, size);
		
		Tank tank_1 = new Tank(Orientation.UP,new Point(200,200),new Point(40,40), 1);
		Tank enemyTank = new Tank(Orientation.UP,new Point(600,100),new Point(40,40), 2);
		Tank enemyTank2 = new Tank(Orientation.UP,new Point(500,100),new Point(40,40), 2);
		Tank enemyTank3 = new Tank(Orientation.UP,new Point(400,100),new Point(40,40), 2);
		Tank enemyTank4 = new Tank(Orientation.UP,new Point(300,100),new Point(40,40), 2);
		
		List<Tank> tanks_1 = new ArrayList<Tank>();
		List<Tank> enemysTanks = new ArrayList<Tank>();
		
		tanks_1.add(tank_1);
		enemysTanks.add(enemyTank);
		enemysTanks.add(enemyTank2);
		enemysTanks.add(enemyTank3);
		enemysTanks.add(enemyTank4);
		boolean colicion= colisionador.colisionBulletConTank(bullet, tanks_1);
		System.out.println("colicion: " + colicion);
		destructor.setColisionador(colisionador);
		LevelEasy levelGame = new LevelEasy(data);
		Player player1 = new Player(0, 0, levelGame.getTankController().getListener());
		
		levelGame.setPlayers(enemysTanks);
		
		Tank tank2 = levelGame.getTankPlayer1();
		
		destructor.destruccionTank(tank, levelGame);
		
		destructor.destruccionTanksEnemys(tank_1, levelGame, player1.toString());
		//(colisionador.colisionBulletConTank(tank.getBullet(), level.getEnemigos())
		
		
		List<ObjetoGrafico> estructuras2= new ArrayList<>();
		destructor.destruirEstructuras(estructuras2);
		
		destructor.getColisionador();
		
		//destructor.debilitarEnemyTank(levelGame, player1.toString());
	}
	
	@Test
	public void testDestruccionTank() {
		Destructor destructor= new Destructor();
		DataLevelGame data = new DataLevelGame();
		Tank tank = new Tank(Orientation.LEFT, new Point(300, 200), new Point(40, 40), 2);
		//DriverEasyEnemyTank driverEasy= new DriverEasyEnemyTank(tank);
		//driverEasy.cargarMovimientos();
		data.cargarClavesNiveles();
		LevelEasy levelGame = new LevelEasy(data);
		Player player1 = new Player(0, 0, levelGame.getTankController().getListener());
		Tank tank2 = levelGame.getTankPlayer1();
		destructor.destruccionTank(tank, levelGame);
		
	}
	
	@Test
	public void testDestruccionTankEnemys() {
		Destructor destructor= new Destructor();
		DataLevelGame data = new DataLevelGame();
		Tank tank = new Tank(Orientation.LEFT, new Point(300, 200), new Point(40, 40), 2);
		//DriverEasyEnemyTank driverEasy= new DriverEasyEnemyTank(tank);
		//driverEasy.cargarMovimientos();
		data.cargarClavesNiveles();
		LevelEasy levelGame = new LevelEasy(data);
		Player player1 = new Player(0, 0, levelGame.getTankController().getListener());
		Tank tank2 = levelGame.getTankPlayer1();
		destructor.destruccionTank(tank, levelGame);
		List<ObjetoGrafico> estructuras= new ArrayList<>();
		destructor.destruirEstructuras(estructuras);
	}
}

package app.modelo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import app.enums.Orientation;
import app.levels.DataLevelGame;
import app.levels.LevelEasy;
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
		LevelEasy levelGame = new LevelEasy(data);
		Player player1 = new Player(0, 0, levelGame.getTankController().getListener());
		
		
		
		Tank tank2 = levelGame.getTankPlayer1();
		
		destructor.destruccionTank(tank, levelGame);
		
		destructor.destruccionTanksEnemys(tank, levelGame, player1.toString());
		
		List<ObjetoGrafico> estructuras= new ArrayList<>();
		destructor.destruirEstructuras(estructuras);
		
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

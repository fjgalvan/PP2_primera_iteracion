package app.modelo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import app.levels.DataLevelGame;
import app.levels.LevelEasy;
import app.object.Player;
import app.object.Tank;

public class TestDestructor {
	@Test
	public void testIniciar() {
		
		DataLevelGame data = new DataLevelGame(2, 4, 2, "facil");
		//data.cargarClavesNiveles();
		Destructor destructor= new Destructor();
		LevelEasy levelGame = new LevelEasy(data);
		Player player1 = new Player(0, 0, levelGame.getTankController().getListener());
		
		
		
		Tank tank = levelGame.getTankPlayer1();
		
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
		DataLevelGame data = new DataLevelGame(2, 4, 2, "facil");
		//data.cargarClavesNiveles();
		LevelEasy levelGame = new LevelEasy(data);
		Player player1 = new Player(0, 0, levelGame.getTankController().getListener());
		Tank tank = levelGame.getTankPlayer1();
		destructor.destruccionTank(tank, levelGame);
		
	}
	
	@Test
	public void testDestruccionTankEnemys() {
		Destructor destructor= new Destructor();
		DataLevelGame data = new DataLevelGame(2, 4, 2, "facil");
		//data.cargarClavesNiveles();
		LevelEasy levelGame = new LevelEasy(data);
		Player player1 = new Player(0, 0, levelGame.getTankController().getListener());
		Tank tank = levelGame.getTankPlayer1();
		destructor.destruccionTank(tank, levelGame);
		List<ObjetoGrafico> estructuras= new ArrayList<>();
		destructor.destruirEstructuras(estructuras);
	}
}

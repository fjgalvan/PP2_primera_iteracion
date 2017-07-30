package app.levels;

import java.awt.Point;

import org.junit.Test;

import app.enums.Orientation;
import app.object.DriverEnemyTank;
import app.object.Tank;

public class TestLevelEasy {
	@Test
	public void testLevelEasy() 
	{
		DataLevelGame data = new DataLevelGame(2, 4, 2, "facil");
		LevelEasy easy= new LevelEasy(data);
		
		//easy.inicializar(objetos);
	}
	@Test
	public void testInicializar() 
	{
		DataLevelGame data = new DataLevelGame();
		Tank tank = new Tank(Orientation.LEFT, new Point(300, 200), new Point(40, 40), 2);
		data.cargarClavesNiveles();
		DriverEnemyTank driver = data.getNewDriverEnemy(tank);
		LevelEasy easy= new LevelEasy(data);
		easy.containsPlayer1();
		easy.containsPlayer2();
		easy.cargarCoordenadasValidas();
		easy.crearDriverEnemyTank(tank);
		easy.crearTanquesPlayers();
		easy.destruirDriverEnemy(driver);
		easy.destruirTankEnemy(tank);
		easy.destruirTankPlayer(tank);
		easy.destruirTankPlayer1(tank);
		//easy.destruirTankPlayer2(tank);
		easy.finishLevel();
	}
	
}

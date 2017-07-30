package app.levels;

import java.awt.Point;

import org.junit.Test;

import app.enums.Orientation;
import app.object.DriverEasyEnemyTank;
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
		DriverEasyEnemyTank driverEasy= new DriverEasyEnemyTank();
		driverEasy.cargarMovimientos();
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
		easy.getDrives();
		easy.getEnemigos();
		easy.getEnergyPlayer();
		easy.getNextCoordinate();
		easy.getPlayers();
		easy.getTankController();
		easy.getTankCopController();
		easy.getTankPlayer1();
		easy.getTankPlayer2();
		//easy.destruirTankPlayer2(tank);
		easy.finishLevel();
	}
	
	@Test
	public void testlevelE() 
	{
		
		DriverEasyEnemyTank driverEasy= new DriverEasyEnemyTank();
		driverEasy.cargarMovimientos();
		
		Tank tank = new Tank(Orientation.LEFT, new Point(300, 200), new Point(40, 40), 2);
		DataLevelGame data = new DataLevelGame();
		LevelEasy easy= new LevelEasy(data);
		easy.containsPlayer1();
		easy.containsPlayer2();
		easy.cargarCoordenadasValidas();
		easy.crearDriverEnemyTank(tank);
		easy.crearTanquesPlayers();
		//easy.destruirDriverEnemy(driver);
		easy.destruirTankEnemy(tank);
		easy.destruirTankPlayer(tank);
		easy.destruirTankPlayer1(tank);
		easy.getDrives();
		easy.getEnemigos();
		easy.getEnergyPlayer();
		easy.getNextCoordinate();
		easy.getPlayers();
		easy.getTankController();
		easy.getTankCopController();
		easy.getTankPlayer1();
		easy.getTankPlayer2();
		//easy.destruirTankPlayer2(tank);
		easy.finishLevel();
	}
	
	
}

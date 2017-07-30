package app.main;


import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entorno.InterfaceJuego;
import app.enums.Orientation;
import app.levels.DataLevelGame;
import app.levels.LevelEasy;
import app.mapa.MapaTiled;
import app.modelo.Destructor;
import app.modelo.ObjetoGrafico;
import app.object.Configuracion;
import app.object.Draftsman;
import app.object.ListenerPlayer2;
import app.object.Player;
import app.object.Tank;
import app.object.TankController;

public class TestGame extends InterfaceJuego{
	/*@Test
	public void testIniciar() {
		
		Tank tank_1 = new Tank(Orientation.UP,new Point(400,400),new Point(40,40), 1);
		Tank enemyTank = new Tank(Orientation.UP,new Point(600,100),new Point(40,40), 2);
		Tank enemyTank2 = new Tank(Orientation.UP,new Point(500,100),new Point(40,40), 2);
		Tank enemyTank3 = new Tank(Orientation.UP,new Point(400,100),new Point(40,40), 2);
		Tank enemyTank4 = new Tank(Orientation.UP,new Point(300,100),new Point(40,40), 2);
		
		List<Tank> tanks_1 = new ArrayList<Tank>();
		List<Tank> enemysTanks_1 = new ArrayList<Tank>();
		
		tanks_1.add(tank_1);
		enemysTanks_1.add(enemyTank);
		enemysTanks_1.add(enemyTank2);
		enemysTanks_1.add(enemyTank3);
		enemysTanks_1.add(enemyTank4);
		
		assertNotEquals(null,tanks_1);
		assertNotEquals(null,enemysTanks_1);
		
		DataLevelGame data = new DataLevelGame(2, 4, 2, "facil");
		data.cargarClavesNiveles();
		Game juego= new Game(data);
		
		String mapaAJugar = Configuracion.MapaTank;
		Draftsman dibujador= new Draftsman(this, new Point(1000, 600), "Battle-Ungs");
		List<ObjetoGrafico> estructuras= new ArrayList<>(); 
		MapaTiled mapaTiled= new MapaTiled(mapaAJugar);
		mapaTiled.inicializar();
		mapaTiled.crearEstructuras(estructuras);
		LevelEasy levelGame = new LevelEasy(data);
		boolean modoJuegoCop = true;
		modoJuegoCop = levelGame.isModeCopActivate();
		Tank tank = levelGame.getTankPlayer1();
		Destructor destructor = new Destructor();
		Player player1 = new Player(0, 0, levelGame.getTankController().getListener());
		TankController tControl = levelGame.getTankController();
		List<Tank> tanks = new ArrayList<Tank>();
		List<Tank> enemysTanks = new ArrayList<Tank>();
		
		if (modoJuegoCop) {
			Player player2 = new Player(0, 0, new ListenerPlayer2(dibujador.getEntorno()));
			// ver como ubicar el tanque
			Tank tankCop = levelGame.getTankPlayer2();
			TankController tControlCop = new TankController(tankCop, player2.getListener(), destructor.getColisionador());
			tanks.add(tankCop);
		}
		
		levelGame.finishLevel();
		juego.iniciar();
		juego.tick();
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
		Player player1 = new Player(0,0,null);
		player1.setPuntaje(500);
		assertNotEquals(0,player1.getPuntaje());
	}
}

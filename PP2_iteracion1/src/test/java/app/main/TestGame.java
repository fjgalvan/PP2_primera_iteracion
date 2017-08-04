package app.main;


import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import clase_properties.Principal;
import entorno.Entorno;
import entorno.InterfaceJuego;
import app.enums.Orientation;
import app.enums.TipoEstructura;
import app.estructura.Estructura;
import app.estructura.TipoDeEstructura;
import app.levels.DataLevelGame;
import app.levels.LevelEasy;
import app.levels.ManagerLevelGameMain;
import app.mapa.MapaTiled;
import app.modelo.Destructor;
import app.modelo.ObjetoGrafico;
import app.object.Configuracion;
import app.object.Draftsman;
import app.object.ListenerPlayer1;
import app.object.ListenerPlayer2;
import app.object.Player;
import app.object.Tank;
import app.object.TankController;

public class TestGame extends InterfaceJuego{
	
	@Test
	public void testIniciarGameCompleto() {
		String mapaAJugar = Configuracion.MapaBomberman;
		Draftsman dibujador= new Draftsman(this, new Point(1000, 600), "Bomberman-Ungs");
		List<ObjetoGrafico> estructuras= new ArrayList<>();
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		TipoDeEstructura tipo= new TipoDeEstructura(TipoEstructura.DESTRUCTIBLE, false, false);
		Estructura est= new Estructura(coordinate, size, "src/main/java/imagen/tank.png", tipo);
		estructuras.add(est);
		MapaTiled mapaTiled= new MapaTiled(mapaAJugar);
		mapaTiled.inicializar();
		mapaTiled.crearEstructuras(estructuras);
		Tank tank= new Tank(Orientation.UP ,new Point(440,200), new Point(36,36), 2);
		Destructor destructor= new Destructor();
		Player player1= new Player(0,0,new ListenerPlayer1(dibujador.getEntorno()));
		TankController tControl= new TankController(tank,player1.getListener(),destructor.getColisionador());
		
		
		try{
			
			InterfaceJuego juego= new InterfaceJuego();
			//Entorno(InterfaceJuego juego, String titulo, int ancho, int alto)
			Entorno entorno = new Entorno(juego, "tank", 30, 30);
			ListenerPlayer1 listener= new ListenerPlayer1(entorno);
			tank.moverse(Orientation.DOWN);
			boolean esPresionada= entorno.estaPresionada(entorno.TECLA_IZQUIERDA);
			System.out.println("esPresionada: "+esPresionada);
			//listener.seMovio(tank);
	        
			//simular que una tecla está presionada
			try{
				    Robot robot = new Robot();
				    robot.keyPress(KeyEvent.VK_LEFT);
				    System.out.println("KeyEvent.VK_LEFT: "+ KeyEvent.VK_LEFT);
				    //entorno.keyUp(KeyEvent.VK_LEFT), 37);
				    boolean esPresionada2= entorno.estaPresionada(entorno.TECLA_IZQUIERDA);
					System.out.println("esPresionada2: "+esPresionada2);
		   }catch(AWTException a){
				    a.printStackTrace();
		    }
			
				
			player1.setListener(listener); 
			entorno.presionarTeclaIzquierda();
			
			Principal principal= new Principal();
			//principal.ModificarArchivo(this.menu.getEleccion());
			
			DataLevelGame data = new ManagerLevelGameMain(principal).buildDataGame();
			Game tanques = new Game(data);
			entorno.presionarTeclaIzquierda();
			tanques.getDibujador();
			tanques.getLevelGame();
			tanques.iniciar();
			tanques.iniciar();
			tanques.setLevelGame(tanques.getLevelGame());
		} catch(Exception e){
	        System.out.println("No se pudo getTank()!!");
	    }
		
	}
	
	
	
	
	
	
	
	@Test
	public void testIniciarGame() {
		/*Principal principal= new Principal();
		//principal.ModificarArchivo(this.menu.getEleccion());
		DataLevelGame data = new ManagerLevelGameMain(principal).buildDataGame();
		Game game = new Game(data);
		game.iniciar();*/	
		
		ControlGame game = new ControlGame();
		game.iniciar();
		
		DataLevelGame data = new DataLevelGame(2, 4, 2, "facil");
		data.cargarClavesNiveles();
		/*Game juego= new Game(data);
		LevelEasy levelGame = new LevelEasy(data);
		levelGame.cargarCoordenadasValidas();
		levelGame.crearTanquesPlayers();
		juego.setLevelGame(levelGame);
		Tank tankPlayer1 = new Tank(Orientation.UP,new Point(400,400),new Point(40,40), 1);
		juego.getLevelGame().setTankPlayer1(tankPlayer1);
		System.out.println(juego.getLevelGame().finishLevel());
		juego.iniciar();
		juego.tick();*/
		//juego.setLevelGame(levelGame);
		
	}
				
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
		//data.cargarClavesNiveles();
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
		//juego.iniciar();
		//juego.tick();
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

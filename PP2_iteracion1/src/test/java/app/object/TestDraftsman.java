package app.object;

import java.awt.Point;  
//import java.util.ArrayList;
//import java.util.List;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import app.enums.Orientation;
import app.levels.DataLevelGame;
import app.levels.LevelEasy;
import app.main.Game;
import app.mapa.MapaTiled;
import app.modelo.Destructor;
import app.modelo.ObjetoGrafico;
//import app.levels.DataLevelGame;
//import app.levels.LevelEasy;
//import app.levels.ManagerLevelGameMain;
//import app.main.Game;
//import app.modelo.ObjetoGrafico;
//import clase_properties.Principal;
import entorno.InterfaceJuego;

public class TestDraftsman extends InterfaceJuego{
	//ERROR DE TEST CON MAVEN
	@Test
	public void testDibujarMapa(){
		
		List<ObjetoGrafico> estructuras = new ArrayList<>();
		String mapaAJugar = Configuracion.MapaTank;
		MapaTiled mapaTiled = new MapaTiled(mapaAJugar);
		mapaTiled.inicializar();
		mapaTiled.crearEstructuras(estructuras);
		Draftsman dibujador = new Draftsman(this, new Point(1000, 600), "Battle-Ungs");
		//prueba de apoco el lector de datos del combo .. 1 test modo cop
		DataLevelGame data = new DataLevelGame();
		Tank tank = new Tank(Orientation.LEFT, new Point(300, 200), new Point(40, 40), 2);
		DriverEasyEnemyTank driverEasy= new DriverEasyEnemyTank(tank);
		driverEasy.cargarMovimientos();
		data.cargarClavesNiveles();
		LevelEasy levelGame = new LevelEasy(data);
		// ver como ubicar el tanque
		boolean modoJuegoCop = true;
		modoJuegoCop = levelGame.isModeCopActivate();
		Tank tank2 = levelGame.getTankPlayer1();
		Destructor destructor = new Destructor();
		
		//Game.player1 = new Player(0, 0, levelGame.getTankController().getListener());
		TankController tControl = levelGame.getTankController();
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		List<Tank> tanks = new ArrayList<Tank>();
		Tank enemyTank= new Tank(orientation, coordinate, size,1);
		Tank enemyTank2= new Tank(orientation, coordinate, size,1);
		Tank enemyTank3= new Tank(orientation, coordinate, size,1);
		Tank enemyTank4= new Tank(orientation, coordinate, size,1);
		tanks.add(enemyTank);
		tanks.add(enemyTank2);
		tanks.add(enemyTank3);
		tanks.add(enemyTank4);
		
		List<Tank> enemysTanks = new ArrayList<Tank>();
		enemysTanks.add(enemyTank);
		enemysTanks.add(enemyTank2);
		enemysTanks.add(enemyTank3);
		enemysTanks.add(enemyTank4);
		
		Orientation orientation1 = Orientation.LEFT;
		Point coordinate2222 = new Point(50, 579);
		
		Bullet bala= new Bullet(orientation1, coordinate2222, coordinate2222);
		//Principal principal= new Principal();
		//DataLevelGame data = new ManagerLevelGameMain(principal).getDataLevelGame();
		//Game juegoPrueba= new Game(data);
		//GraphicMap mapa = new GraphicMap(new Map(new Point(1000, 600)), new Point(20, 20));
		
		/*Draftsman dibujador = new Draftsman(null, mapa, "Battle-Ungs");
		Tank tank = new Tank(Orientation.UP,new Point(560,520),new Point(40,40),2);
		Point coordinate = new Point(30, 50);
		Point size= new Point(20,20);
		Bullet bullet= new Bullet(Orientation.UP, coordinate, size);*/
		
		//LevelEasy level= new LevelEasy(data);
		//Tank tankPlayer1 = new Tank(Orientation.UP,new Point(560,520),new Point(40,40),level.getEnergyPlayer());
		//List<Tank> players= new ArrayList<Tank>();;
		//players.add(tankPlayer1);
		//level.setPlayers(players);
		
		//juegoPrueba.iniciar();
		
		/*InterfaceJuego interfaz= new InterfaceJuego();
		Draftsman dibujador= new Draftsman(interfaz, size, null);
		try{
			//juegoPrueba.getDibujador().dibujarMapa(100, 100, 100, 1, "");
			dibujador.dibujarMapa(100, 100, 100, 1, "");
		} catch(Exception e){
	        System.out.println("No se pudo dibujar Mapa!!");
	    }*/
		
		/*try{
			//juegoPrueba.getDibujador().dibujarEstructura(tank);
			 dibujador.dibujarEstructura(tankPlayer1);
		} catch(Exception e){
	        System.out.println("No se pudo dibujar estructura!!");
	    }*/
		
		try{
			//juegoPrueba.getDibujador().dibujarBomberman(tank);
			dibujador.dibujarBomberman(tank);//(tankPlayer1);
		} catch(Exception e){
	        System.out.println("No se pudo dibujar Bomberman!!");
	    }
		
		try{
			//juegoPrueba.getDibujador().dibujarTank(tank);
			dibujador.dibujarTank(tank);
		} catch(Exception e){
	        System.out.println("No se pudo dibujar Tank!");
	    }
		
		try{
			dibujador.dibujarBullet(bala);
		} catch(Exception e){
	        System.out.println("No se pudo dibujar Tank!");
	    }
		
		try{
			dibujador.dibujarBomberman(tank);
		} catch(Exception e){
	        System.out.println("No se pudo dibujar Bomberman!!");
	    }
		
		try{
			dibujador.dibujarPacman(tank);
		} catch(Exception e){
	        System.out.println("No se pudo dibujar Pacman!!");
	    }
		
		try{
			dibujador.dibujarTankCop(tank);
		} catch(Exception e){
	        System.out.println("No se pudo dibujar TankCop!!");
	    }
		
		try{
			dibujador.dibujarEnemyTank(tank);
		} catch(Exception e){
	        System.out.println("No se pudo dibujar EnemyTank!!");
	    }
		
		try{
			dibujador.dibujarEnemyTankIntermediate(tank);
		} catch(Exception e){
	        System.out.println("No se pudo dibujar EnemyTankIntermediate!!");
	    }
		
		try{
			dibujador.dibujarFinDeJuego();
		} catch(Exception e){
	        System.out.println("No se pudo dibujar finDeJuego!!");
	    }
		
		try{
			dibujador.dibujarPuntaje("tank", 100, 1, 50, 50);;
		} catch(Exception e){
	        System.out.println("No se pudo dibujar puntaje!!");
	    }
		
		try{
			dibujador.dibujarFantasma(tank);
		} catch(Exception e){
	        System.out.println("No se pudo dibujarFantasma!!");
	    }
		
		try{
			dibujador.getEntorno();
		} catch(Exception e){
	        System.out.println("No se pudo dibujarFantasma!!");
	    }
	}
	
	
}

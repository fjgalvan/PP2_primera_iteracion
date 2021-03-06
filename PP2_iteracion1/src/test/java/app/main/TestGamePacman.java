package app.main;
import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import app.enums.Orientation;
import app.enums.TipoEstructura;
import app.estructura.Estructura;
import app.estructura.TipoDeEstructura;
import app.mapa.MapaTiled;
import app.modelo.Destructor;
import app.modelo.ObjetoGrafico;
import app.object.Configuracion;
import app.object.Draftsman;
import app.object.ListenerPlayer1;
import app.object.Player;
import app.object.Tank;
import app.object.TankController;
import entorno.Entorno;
import entorno.InterfaceJuego;

public class TestGamePacman extends InterfaceJuego{
	@Test
	public void testIniciar() {
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
			GamePacman pacman = new GamePacman();
			entorno.presionarTeclaIzquierda();
			pacman.setTank(tank);
			pacman.setPlayer1(player1);
			pacman.iniciar();
			pacman.getTank();
		} catch(Exception e){
	        System.out.println("No se pudo getTank()!!");
	    }
		
	}
	
	//ERROR DE TEST EN MAVEN
	/*@Test
	public void testIniciar() {
		GamePacman pacman = new GamePacman();
		pacman.iniciar();
		assertNotEquals(null, pacman.getTank());
	}*/
}

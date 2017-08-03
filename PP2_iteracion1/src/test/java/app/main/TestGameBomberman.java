package app.main;

import static org.junit.Assert.assertNotEquals;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entorno.Entorno;
import entorno.InterfaceJuego;
import app.enums.Orientation;
import app.mapa.MapaTiled;
import app.modelo.Destructor;
import app.modelo.ObjetoGrafico;
import app.object.Configuracion;
import app.object.Draftsman;
import app.object.ListenerPlayer1;
import app.object.Player;
import app.object.Tank;
import app.object.TankController;

public class TestGameBomberman extends InterfaceJuego{
	
	@Test
	public void testIniciar() {
		//GameBomberman bomberman = new GameBomberman();
		//bomberman.iniciar();
		//bomberman.getTank();
		//assertNotEquals(null, bomberman.getTank());
		String mapaAJugar = Configuracion.MapaBomberman;
		Draftsman dibujador= new Draftsman(this, new Point(1000, 600), "Bomberman-Ungs");
		List<ObjetoGrafico> estructuras= new ArrayList<>();
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
			listener.seMovio(tank);
			entorno.estaPresionada(entorno.TECLA_ABAJO);
			player1.setListener(listener); 
			//GameBomberman bomberman = new GameBomberman();
			//bomberman.setTank(tank);
			//bomberman.setPlayer1(player1);
			//bomberman.iniciar();
			//bomberman.getTank();
		} catch(Exception e){
	        System.out.println("No se pudo getTank()!!");
	    }
		
	}
}

package app.object;

import java.awt.Point;

import org.junit.Test;

import app.enums.Orientation;
import app.levels.DataLevelGame;
import app.levels.LevelEasy;
import app.main.Game;
import app.modelo.Destructor;
import app.state_tank.StateMoveTank;
import entorno.Entorno;

public class TestPlayer {
	@Test
	public void testPuntaje() {
		Entorno entorno;
		StateMoveTank estado;
		//KeyEventListener listener= new KeyEventListener(entorno);
		;
		
		DataLevelGame data = new DataLevelGame();
		Tank tank = new Tank(Orientation.LEFT, new Point(300, 200), new Point(40, 40), 2);
		data.cargarClavesNiveles();
		Destructor destructor= new Destructor();
		LevelEasy levelGame = new LevelEasy(data);
		Player player1 = new Player(0, 0, levelGame.getTankController().getListener());
		player1.getCantidadDeEnemigosAsesinados();
		player1.getPuntaje();
		player1.setCantidadDeEnemigosAsesinados(player1.getCantidadDeEnemigosAsesinados());
		player1.setPuntaje(player1.getPuntaje());
		
		// ver como ubicar el tanque
		/*this.modoJuegoCop = levelGame.isModeCopActivate();
		this.tank = levelGame.getTankPlayer1();
		this.destructor = new Destructor();
		Game.player1 = new Player(0, 0, levelGame.getTankController().getListener());
		Player jugador= new Player(0, 0, null);*/
	}
}

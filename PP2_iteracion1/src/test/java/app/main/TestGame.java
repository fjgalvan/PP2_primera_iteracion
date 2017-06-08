package app.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import app.enums.Orientation;
import app.modelo.Colisionador;
import app.object.Draftsman;
import app.object.DriverEasyEnemyTank;
import app.object.GraphicMap;
<<<<<<< HEAD
import app.object.ListenerPlayer2;
=======
import app.object.KeyEventListener;
>>>>>>> origin/mejoras_diseño
import app.object.Map;
import app.object.Player;
import app.object.Tank;
import app.object.TankController;
import entorno.InterfaceJuego;

public class TestGame {
	@Test
	public void testIniciar() {
		Game juego = new Game();

		Tank tank = new Tank(Orientation.UP, new Point(400, 400), new Point(40, 40));
		Tank enemyTank = new Tank(Orientation.UP, new Point(600, 100), new Point(40, 40));
		Tank enemyTank2 = new Tank(Orientation.UP, new Point(500, 100), new Point(40, 40));
		Tank enemyTank3 = new Tank(Orientation.UP, new Point(400, 100), new Point(40, 40));
		Tank enemyTank4 = new Tank(Orientation.UP, new Point(300, 100), new Point(40, 40));

		List<Tank> tanks = new ArrayList<Tank>();
		List<Tank> enemysTanks = new ArrayList<Tank>();

		tanks.add(tank);
		enemysTanks.add(enemyTank);
		enemysTanks.add(enemyTank2);
		enemysTanks.add(enemyTank3);
		enemysTanks.add(enemyTank4);

		try {
			juego.iniciar();
		} catch (Exception e) {
			// System.out.println("Se crearon las listas de tanques aliados y
			// enemigos");
		}
		assertNotEquals(null, tanks);
		assertNotEquals(null, enemysTanks);

		Colisionador colisionador = new Colisionador();
		GraphicMap mapa = new GraphicMap(new Map(new Point(1000, 600)), new Point(20, 20));

		/*
		 * Draftsman dibujador= new Draftsman(this, mapa, "Battle-Ungs");
		 * KeyEventListener listener= = new
		 * KeyEventListener(dibujador.getEntorno()); TankController tControl=
		 * new TankController(tank,listener); juego.destruccionTank1();
		 * //destruccionTanksEnemys(); assertEquals(null,enemyTank);
		 */

		/*
		 * GraphicMap mapa= new GraphicMap(new Map(new Size(1000, 600)), new
		 * Size(20, 20)); try{ juego.tick(); }catch(Exception e){
		 * System.out.println(
		 * "Se crearon las listas de tanques aliados y enemigos"); }
		 * assertNotEquals(null, mapa);
		 */
	}

	@Test
	public void testDestruccionTank1() {
		InterfaceJuego i = null;
		GraphicMap mapa = new GraphicMap(new Map(new Point(1000, 600)), new Point(20, 20));
		Draftsman dibujador = new Draftsman(i, mapa, "Battle-Ungs");
<<<<<<< HEAD
		ListenerPlayer2 listenerCop = new ListenerPlayer2(dibujador.getEntorno());
=======
		KeyEventListener listenerCop = new KeyEventListener(dibujador.getEntorno());
>>>>>>> origin/mejoras_diseño
		Colisionador colisionador = new Colisionador();
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size);
		// ver como meter el entorno con la otra clase
		TankController tankC = new TankController(tank, listenerCop, null);

		Orientation orientation2 = Orientation.RIGHT;
		Point coordinate2 = new Point(300, 400);
		Point size2 = new Point(40, 40);
		Tank tankEnemy = new Tank(orientation, coordinate, size);
		DriverEasyEnemyTank tankEnemyD = new DriverEasyEnemyTank(tankEnemy);

		tankC.destruirTank();
		assertEquals(null, tankC.getTank());
	}

	@Test
	public void testSumarPuntaje() {
		InterfaceJuego i = null;
		GraphicMap mapa = new GraphicMap(new Map(new Point(1000, 600)), new Point(20, 20));
		Draftsman dibujador = new Draftsman(i, mapa, "Battle-Ungs");
		Player player1 = new Player(0, 0, dibujador);
		Game juego = new Game();
		juego.sumarPuntaje(player1.toString());

		assertNotEquals(null, player1.toString());
		player1.setPuntaje(500);
		player1.setCantidadDeEnemigosAsesinados(0);

		String player2 = "1";
		assertEquals("1", player2);
	}

}

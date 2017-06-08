package criteriosUser06;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import app.enums.Orientation;
import app.enums.TankShot;
import app.modelo.Colisionador;
import app.object.Draftsman;
import app.object.GraphicMap;
<<<<<<< HEAD
import app.object.ListenerPlayer1;
import app.object.ListenerPlayer2;
import app.object.ListStructures;
import app.object.Map;
import app.object.Player;
import app.object.Player2;
=======
import app.object.KeyEventListener;
import app.object.ListStructures;
import app.object.Map;
import app.object.Player1;
>>>>>>> origin/mejoras_diseño
import app.object.Tank;
import app.object.TankController;
import entorno.InterfaceJuego;

// Si los 2 jugadores se disparan entre ellos, no tendrán efecto en su nivel
// de vida y las balas desaparecerán.
public class Criterio01Coop extends InterfaceJuego {
	private Draftsman dibujador;
	private GraphicMap mapa;
	private Colisionador colisionador;

	private Player player1;
	private Tank tank;
	private ListenerPlayer1 listener;
	private TankController tControl;

	private Player player2;
	private Tank tankCop;
	private TankController tControlCop;
<<<<<<< HEAD
	private ListenerPlayer2 listenerCop;
=======
	private KeyEventListener listenerCop;
>>>>>>> origin/mejoras_diseño

	private ListStructures estructuras;
	private List<Tank> tanks;
	private List<Tank> enemysTanks;

	public Criterio01Coop() {
		this.mapa = new GraphicMap(new Map(new Point(250, 600)), new Point(20, 20));
		this.dibujador = new Draftsman(this, mapa, "Battle-Ungs");
		this.colisionador = new Colisionador();
		this.player1 = new Player(0, 0, dibujador);
		this.tank = new Tank(Orientation.DOWN, new Point(100, 50), new Point(40, 40), 2);
		this.listener = new ListenerPlayer1(dibujador.getEntorno());
		this.tControl = new TankController(tank, listener, colisionador);
		this.player2 = new Player(0, 0, dibujador);
		this.tankCop = new Tank(Orientation.UP, new Point(100, 300), new Point(40, 40), 2);
<<<<<<< HEAD
		this.listenerCop = new ListenerPlayer2(dibujador.getEntorno());
=======
		this.listenerCop = new KeyEventListener(dibujador.getEntorno());
>>>>>>> origin/mejoras_diseño
		this.tControlCop = new TankController(tankCop, listenerCop, colisionador);
		try {
			this.estructuras = new ListStructures(mapa, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.tanks = new ArrayList<Tank>();
		this.enemysTanks = new ArrayList<Tank>();
		this.tanks.add(tank);
		this.tanks.add(tankCop);
	}

	public void tick() {
		if (!this.tanks.isEmpty()) {
			if (this.tanks.contains(tank)) {
				this.listener.inicializar(tank);
				this.dibujador.dibujarTank(tank);
				this.tControl.ControlTank(estructuras.getLista());
				this.tControl.control_bullet(dibujador.getEntorno(), estructuras.getLista(), this.enemysTanks);
				destruccionTanksEnemys(tank, tanks, enemysTanks, "1");
			}
			if (this.tanks.contains(tankCop)) {
				this.listenerCop.inicializar(tankCop);
				this.dibujador.dibujarTank(tankCop);
				this.tControlCop.ControlTank(estructuras.getLista());
				this.tControlCop.control_bullet(dibujador.getEntorno(), estructuras.getLista(), this.enemysTanks);
				destruccionTanksEnemys(tankCop, tanks, enemysTanks, "2");
			}
		} else {
			this.dibujador.dibujarFinDeJuego();
		}
	}

	private void destruccionTanksEnemys(Tank tank, List<Tank> tanks, List<Tank> enemysTanks, String player) {
		if (colisionador.colisionBulletConTank(tank.getBullet(), enemysTanks)) {
			tank.setTankBullet(TankShot.NO_EXISTS);
			tank.setBullet(null);
			sumarPuntaje(tank, player);
		}
		tanks.remove(tank);
		if (colisionador.colisionBulletConTank(tank.getBullet(), tanks)) {
			tank.setTankBullet(TankShot.NO_EXISTS);
			tank.setBullet(null);
		}
		tanks.add(tank);
	}

	private void sumarPuntaje(Tank tank, String player) {
		if (player.equals("1")) {
			player1.setPuntaje(500);
			player1.setCantidadDeEnemigosAsesinados(0);
		} else {
			player2.setPuntaje(500);
			player2.setCantidadDeEnemigosAsesinados(0);
		}
	}

	public void destruccionTank(Tank enemyTank, List<Tank> tanks) {
		if (colisionador.colisionBulletConTank(enemyTank.getBullet(), tanks)) {
			enemyTank.setTankBullet(TankShot.NO_EXISTS);
			enemyTank.setBullet(null);
			debilitarTankPlayer(tanks);
		}
	}

	private void destruirTankPlayer(List<Tank> tanksPlayers) {
		tanksPlayers.remove(colisionador.getTankADestruir());
		if (!tanksPlayers.contains(tank))
			this.tControl.destruirTank();
		else
			this.tControlCop.destruirTank();
	}

	private void debilitarTankPlayer(List<Tank> tankList) {
		Tank t = colisionador.getTankADestruir();
		t.decreaseHP();
		if (t.getEnergyVal() == 0) {
			destruirTankPlayer(tankList);
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Criterio01Coop user6 = new Criterio01Coop();
	}

}

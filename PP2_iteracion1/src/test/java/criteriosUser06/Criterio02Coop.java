package criteriosUser06;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import app.enums.Orientation;
import app.enums.TankShot;
import app.modelo.Colisionador;
import app.modelo.ObjetoGrafico;
import app.object.Draftsman;
import app.object.DriverEasyEnemyTank;
import app.object.DriverIntermediateEnemyTank;
import app.object.GraphicMap;
import app.object.KeyEventListener;
import app.object.KeyEventListenerCop;
import app.object.ListStructures;
import app.object.Map;
import app.object.Player1;
import app.object.Player2;
import app.object.Tank;
import app.object.TankController;
import entorno.InterfaceJuego;

// Se debe de llevar la cuenta de cuantos tanques enemigos elimino cada
// player, sin resetearse al pasar de nivel.
public class Criterio02Coop extends InterfaceJuego {
	private Player1 player1;
	private Tank tank;
	private Draftsman dibujador;
	private GraphicMap mapa;
	private ListStructures estructuras;
	private TankController tControl;
	private Colisionador colisionador;
	private KeyEventListener listener;
	private Tank enemyTank;
	private DriverEasyEnemyTank enemyTankControl;
	private Tank enemyTank2;
	private DriverEasyEnemyTank enemyTankControl2;
	private Tank enemyTank3;
	private DriverEasyEnemyTank enemyTankControl3;

	private Tank enemyTank4;
	private DriverIntermediateEnemyTank enemyTankControl4;

	private List<Tank> tanks;
	private List<Tank> enemysTanks;

	private boolean modoJuegoCop = true;
	private Player2 player2;
	private Tank tankCop;
	private TankController tControlCop;
	private KeyEventListenerCop listenerCop;

	public Criterio02Coop() {
		this.mapa = new GraphicMap(new Map(new Point(1000, 600)), new Point(20, 20));
		this.dibujador = new Draftsman(this, mapa, "Battle-Ungs");
		this.colisionador = new Colisionador();
		this.tank = new Tank(Orientation.DOWN, new Point(100, 50), new Point(40, 40), 2);
		this.listener = new KeyEventListener(dibujador.getEntorno());
		try {
			this.estructuras = new ListStructures(mapa, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.enemyTank = new Tank(Orientation.UP, new Point(200, 100), new Point(40, 40), 1);
		this.enemyTankControl = new DriverEasyEnemyTank(enemyTank);
		this.enemyTank2 = new Tank(Orientation.UP, new Point(50, 300), new Point(40, 40), 1);
		this.enemyTankControl2 = new DriverEasyEnemyTank(enemyTank2);
		this.enemyTank3 = new Tank(Orientation.UP, new Point(600, 500), new Point(40, 40), 1);
		this.enemyTankControl3 = new DriverEasyEnemyTank(enemyTank3);
		this.enemyTank4 = new Tank(Orientation.UP, new Point(300, 300), new Point(40, 40), 2);
		this.enemyTankControl4 = new DriverIntermediateEnemyTank(enemyTank4);

		this.player1 = new Player1(0, 0, dibujador);
		this.tControl = new TankController(tank, listener, colisionador);
		this.tanks = new ArrayList<Tank>();
		this.enemysTanks = new ArrayList<Tank>();
		// COP
		this.tanks.add(tank);
		if (modoJuegoCop) {
			this.player2 = new Player2(0, 0, dibujador);
			// ver como ubicar el tanque
			this.tankCop = new Tank(Orientation.UP, new Point(400, 400), new Point(40, 40), 2);
			this.listenerCop = new KeyEventListenerCop(dibujador.getEntorno());
			this.tControlCop = new TankController(tankCop, listenerCop, colisionador);
			this.tanks.add(tankCop);
		}

	}

	public void iniciar() {
		this.enemysTanks.add(enemyTank);
		this.enemysTanks.add(enemyTank2);
		this.enemysTanks.add(enemyTank3);
		this.enemysTanks.add(enemyTank4);
	}

	public void tick() {
		this.dibujador.dibujarMarco(mapa);
		if (!this.tanks.isEmpty() && !this.enemysTanks.isEmpty()) {
			for (ObjetoGrafico e : estructuras.getLista()) {
				this.dibujador.dibujarEstructura(e);
			}
			if (this.tanks.contains(tank)) {
				this.listener.inicializar(tank);
				this.dibujador.dibujarTank(tank);
				this.tControl.ControlTank(estructuras.getLista());
				this.tControl.control_bullet(dibujador.getEntorno(), estructuras.getLista(), this.enemysTanks);
				destruccionTanksEnemys(tank, tanks, enemysTanks, "1");
			}
			// COOP
			if (this.tanks.contains(tankCop)) {
				this.listenerCop.inicializar(tankCop);
				this.dibujador.dibujarTankCop(tankCop);
				this.tControlCop.ControlTankCop(estructuras.getLista());
				this.tControlCop.control_bullet(dibujador.getEntorno(), estructuras.getLista(), this.enemysTanks);
				destruccionTanksEnemys(tankCop, tanks, enemysTanks, "2");
			}

			if (!(enemyTankControl.getTank() == null)) {
				this.dibujador.dibujarEnemyTank(enemyTank);
				this.enemyTankControl.ControlEnemyTank(dibujador.getEntorno(), estructuras.getLista());
				// this.enemyTankControl.control_bullet(dibujador.getEntorno(),estructuras.getLista());
				// destruccionTank(enemyTank,tanks);
			}
			if (!(enemyTankControl2.getTank() == null)) {
				this.dibujador.dibujarEnemyTank(enemyTank2);
				this.enemyTankControl2.ControlEnemyTank(dibujador.getEntorno(), estructuras.getLista());
				// this.enemyTankControl2.control_bullet(dibujador.getEntorno(),estructuras.getLista());
				// destruccionTank(enemyTank2,tanks);
			}
			if (!(enemyTankControl3.getTank() == null)) {
				this.dibujador.dibujarEnemyTank(enemyTank3);
				this.enemyTankControl3.ControlEnemyTank(dibujador.getEntorno(), estructuras.getLista());
				// this.enemyTankControl3.control_bullet(dibujador.getEntorno(),estructuras.getLista());
				// destruccionTank(enemyTank3,tanks);
			}
			if (!(enemyTankControl4.getTank() == null)) {
				this.dibujador.dibujarEnemyTankIntermediate(enemyTank4);
				this.enemyTankControl4.ControlEnemyTank(dibujador.getEntorno(), estructuras.getLista());
				// this.enemyTankControl4.control_bullet(dibujador.getEntorno(),estructuras.getLista());
				// destruccionTank(enemyTank4,tanks);
			}
		} else {
			this.dibujador.dibujarFinDeJuego();
			this.dibujador.dibujarPuntaje("Player 1: ", this.player1.getPuntaje(),
					this.player1.getCantidadDeEnemigosAsesinados(), 200, 400);
			if (this.player2 != null)
				this.dibujador.dibujarPuntaje("Player 2: ", this.player2.getPuntaje(),
						this.player2.getCantidadDeEnemigosAsesinados(), 200, 430);
		}
	}

	private void destruccionTanksEnemys(Tank tank, List<Tank> tanks, List<Tank> enemysTanks, String player) {
		if (colisionador.colisionBulletConTank(tank.getBullet(), enemysTanks)) {
			tank.setTankBullet(TankShot.NO_EXISTS);
			tank.setBullet(null);
			debilitarEnemyTank(enemysTanks, player);
			sumarPuntaje(player);
		}
		tanks.remove(tank);
		if (colisionador.colisionBulletConTank(tank.getBullet(), tanks)) {
			tank.setTankBullet(TankShot.NO_EXISTS);
			tank.setBullet(null);
		}
		tanks.add(tank);
	}

	private void sumarPuntaje(String player) {
		if (player.equals("1")) {
			player1.setPuntaje(500);
			player1.setCantidadDeEnemigosAsesinados(0);
		} else {
			player2.setPuntaje(500);
			player2.setCantidadDeEnemigosAsesinados(0);
		}
	}

	private void sumarCantidadDeEnemigosAsesinados(String player) {
		if (player.equals("1")) {
			player1.setPuntaje(0);
			player1.setCantidadDeEnemigosAsesinados(1);
		}
		else {
			player2.setPuntaje(0);
			player2.setCantidadDeEnemigosAsesinados(1);
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

	private void destruirEnemyTank(List<Tank> enemysTanks, String player) {
		enemysTanks.remove(colisionador.getTankADestruir());
		if (!enemysTanks.contains(enemyTank))
			enemyTankControl.destruirTank();
		if (!enemysTanks.contains(enemyTank2))
			enemyTankControl2.destruirTank();
		if (!enemysTanks.contains(enemyTank3))
			enemyTankControl3.destruirTank();
		if (!enemysTanks.contains(enemyTank4))
			enemyTankControl4.destruirTank();
		sumarCantidadDeEnemigosAsesinados(player);
	}

	private void debilitarEnemyTank(List<Tank> tankList, String player) {
		Tank t = colisionador.getTankADestruir();
		t.decreaseHP();
		if (t.getEnergyVal() == 0) {
			destruirEnemyTank(tankList, player);
		}
	}

	public static void main(String[] args) {
		Criterio02Coop user6 = new Criterio02Coop();
		user6.iniciar();
	}

}

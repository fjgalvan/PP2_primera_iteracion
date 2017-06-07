package criteriosUser06;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import app.enums.Orientation;
import app.enums.TankShot;
import app.modelo.Colisionador;
import app.object.Draftsman;
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

// Cada uno deberá tener sus controles asignados
public class Criterio04Coop extends InterfaceJuego {

	private Draftsman dibujador;
	private GraphicMap mapa;
	private Colisionador colisionador;

	private Player1 player1;
	private Tank tank;
	private KeyEventListener listener;
	private TankController tControl;

	private Player1 player2;
	private Tank tankCop;
	private TankController tControlCop;
	private KeyEventListenerCop listenerCop;

	private ListStructures estructuras;
	private List<Tank> tanks;
	private List<Tank> enemysTanks;

	public Criterio04Coop() {
		this.mapa = new GraphicMap(new Map(new Point(250, 600)), new Point(20, 20));
		this.dibujador = new Draftsman(this, mapa, "Battle-Ungs");
		this.colisionador = new Colisionador();
		this.player1 = new Player1(0, 0, dibujador);
		this.tank = new Tank(Orientation.DOWN, new Point(100, 50), new Point(40, 40), 2);
		this.listener = new KeyEventListener(dibujador.getEntorno());
		this.tControl = new TankController(tank, listener, colisionador);
		this.player2 = new Player1(0, 0, dibujador);
		this.tankCop = new Tank(Orientation.UP, new Point(100, 300), new Point(40, 40), 2);
		this.listenerCop = new KeyEventListenerCop(dibujador.getEntorno());
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
				this.dibujador.dibujarTankCop(tankCop);
				this.tControlCop.ControlTankCop(estructuras.getLista());
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
		Criterio04Coop user6 = new Criterio04Coop();
	}
}

package criteriosUser06;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import app.enums.Orientation;
import app.enums.TankShot;
import app.modelo.Colisionador;
import app.object.Draftsman;
import app.object.DriverEasyEnemyTank;
import app.object.GraphicMap;
import app.object.ListStructures;
import app.object.ListenerPlayer1;
import app.object.ListenerPlayer2;
import app.object.Map;
import app.object.Tank;
import app.object.TankController;
import entorno.InterfaceJuego;

// El juego termina cuando los dos players no tengan más vidas.
public class Criterio05Coop extends InterfaceJuego {
	private Draftsman dibujador;
	private GraphicMap mapa;
	private Colisionador colisionador;
	private Tank tank;
	private TankController tControl;
	private Tank tankCop;
	private TankController tControlCop;
	private Tank enemyTank;
	private DriverEasyEnemyTank enemyTankControl;
	private Tank enemyTank2;
	private DriverEasyEnemyTank enemyTankControl2;
	private List<Tank> tanks;
	private ListStructures estructuras;

	public void gameOver() {
		this.mapa = new GraphicMap(new Map(new Point(250, 600)), new Point(20, 20));
		this.dibujador = new Draftsman(this, mapa, "Battle-Ungs");
		this.colisionador = new Colisionador();
		this.tank = new Tank(Orientation.UP, new Point(50, 50), new Point(40, 40), 2);
		this.tControl = new TankController(tank, new ListenerPlayer1(dibujador.getEntorno()), colisionador);
		this.tankCop = new Tank(Orientation.UP, new Point(100, 50), new Point(40, 40), 2);
		this.tControlCop = new TankController(tankCop, new ListenerPlayer2(dibujador.getEntorno()), colisionador);
		this.enemyTank = new Tank(Orientation.UP, new Point(50, 550), new Point(40, 40), 2);
		this.enemyTankControl = new DriverEasyEnemyTank(enemyTank);
		this.enemyTank2 = new Tank(Orientation.UP, new Point(100, 550), new Point(40, 40), 2);
		this.enemyTankControl2 = new DriverEasyEnemyTank(enemyTank2);
		this.tanks = new ArrayList<Tank>();
		this.tanks.add(tank);
		this.tanks.add(tankCop);
		try {
			this.estructuras = new ListStructures(mapa, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void tick() {
		if (!this.tanks.isEmpty()) {
			if (this.tanks.contains(tank)) {
				this.dibujador.dibujarTank(tank);
			}
			if (this.tanks.contains(tankCop)) {
				this.dibujador.dibujarTank(tankCop);
			}
			if (!(enemyTankControl.getTank() == null)) {
				this.dibujador.dibujarEnemyTank(enemyTank);
				this.enemyTankControl.ControlEnemyTank(dibujador.getEntorno(), estructuras.getLista());
				this.enemyTankControl.control_bullet(dibujador.getEntorno(), estructuras.getLista());
				destruccionTank(enemyTank, tanks);
			}
			if (!(enemyTankControl2.getTank() == null)) {
				this.dibujador.dibujarEnemyTank(enemyTank2);
				this.enemyTankControl2.ControlEnemyTank(dibujador.getEntorno(), estructuras.getLista());
				this.enemyTankControl2.control_bullet(dibujador.getEntorno(), estructuras.getLista());
				destruccionTank(enemyTank2, tanks);
			}
		} else {
			this.dibujador.dibujarFinDeJuego();
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

	public static void main(String[] args) {
		Criterio05Coop user6 = new Criterio05Coop();
		user6.gameOver();
	}
}

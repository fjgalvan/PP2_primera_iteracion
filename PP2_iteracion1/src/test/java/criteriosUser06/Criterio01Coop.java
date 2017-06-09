package criteriosUser06;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import app.enums.Orientation;
import app.enums.TankShot;
import app.modelo.Colisionador;
import app.object.Draftsman;
import app.object.GraphicMap;
import app.object.ListStructures;
import app.object.ListenerPlayer1;
import app.object.ListenerPlayer2;
import app.object.Map;
import app.object.Player;
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
	private Player player2;
	private Tank tankPlayer1;
	private Tank tankPlayer2;
	private TankController tControlPlayer1;
	private TankController tControlPlayer2;
	private ListStructures estructuras;
	private List<Tank> tanks;
	private List<Tank> enemysTanks;

	public Criterio01Coop() {
		this.mapa = new GraphicMap(new Map(new Point(250, 600)), new Point(20, 20));
		this.dibujador = new Draftsman(this, mapa, "Battle-Ungs");
		this.colisionador = Colisionador.getInstance();
		this.player1 = new Player(0, 0, new ListenerPlayer1(dibujador.getEntorno()));
		this.tankPlayer1 = new Tank(Orientation.DOWN, new Point(100, 50), new Point(40, 40), 2);
		this.tControlPlayer1 = new TankController(tankPlayer1, new ListenerPlayer1(dibujador.getEntorno()), colisionador);
		this.player2 = new Player(0, 0, new ListenerPlayer2(dibujador.getEntorno()));
		this.tankPlayer2 = new Tank(Orientation.UP, new Point(100, 300), new Point(40, 40), 2);
		this.tControlPlayer2 = new TankController(tankPlayer2, new ListenerPlayer2(dibujador.getEntorno()), colisionador);
		try {
			this.estructuras = new ListStructures(mapa, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.tanks = new ArrayList<Tank>();
		this.enemysTanks = new ArrayList<Tank>();
		this.tanks.add(tankPlayer1);
		this.tanks.add(tankPlayer2);
	}

	public void tick() {
		if (!this.tanks.isEmpty()) {
			if (this.tanks.contains(tankPlayer1)) {
				this.dibujador.dibujarTank(tankPlayer1);
				this.tControlPlayer1.ControlTank(estructuras.getLista());
				this.tControlPlayer1.control_bullet(dibujador.getEntorno(), estructuras.getLista(), this.enemysTanks);
				destruccionTanksEnemys(tankPlayer1, tanks, enemysTanks, "1");
			}
			if (this.tanks.contains(tankPlayer2)) {
				this.dibujador.dibujarTank(tankPlayer2);
				this.tControlPlayer2.ControlTank(estructuras.getLista());
				this.tControlPlayer2.control_bullet(dibujador.getEntorno(), estructuras.getLista(), this.enemysTanks);
				destruccionTanksEnemys(tankPlayer2, tanks, enemysTanks, "2");
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
		if (!tanksPlayers.contains(tankPlayer1))
			this.tControlPlayer1.destruirTank();
		else
			this.tControlPlayer2.destruirTank();
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

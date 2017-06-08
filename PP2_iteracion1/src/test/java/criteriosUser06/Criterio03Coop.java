package criteriosUser06;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import app.enums.Orientation;
import app.object.Draftsman;
import app.object.DriverEasyEnemyTank;
import app.object.GraphicMap;
import app.object.ListenerPlayer1;
import app.object.ListenerPlayer2;
import app.object.Map;
import app.object.Tank;
import entorno.InterfaceJuego;

// Los tanques de los players deben tener colores distintos entre sí y entre
// los tanques enemigos.
public class Criterio03Coop extends InterfaceJuego {
	private Draftsman dibujador;
	private GraphicMap mapa;

	private Tank tank;
	private ListenerPlayer1 listener;

	private Tank tankCop;
	private ListenerPlayer2 listenerCop;

	private Tank enemyTank;
	private DriverEasyEnemyTank enemyTankControl;
	private Tank enemyTank2;
	private DriverEasyEnemyTank enemyTankControl2;
	private List<Tank> tanks;

	public Criterio03Coop() {
		this.mapa = new GraphicMap(new Map(new Point(250, 600)), new Point(20, 20));
		this.dibujador = new Draftsman(this, mapa, "Battle-Ungs");
		this.tank = new Tank(Orientation.UP, new Point(50, 50), new Point(40, 40), 2);
		this.listener = new ListenerPlayer1(dibujador.getEntorno());
		this.tankCop = new Tank(Orientation.UP, new Point(100, 50), new Point(40, 40), 2);
		this.listenerCop = new ListenerPlayer2(dibujador.getEntorno());
		this.enemyTank = new Tank(Orientation.UP, new Point(50, 550), new Point(40, 40), 1);
		this.enemyTankControl = new DriverEasyEnemyTank(enemyTank);
		this.enemyTank2 = new Tank(Orientation.UP, new Point(100, 550), new Point(40, 40), 1);
		this.enemyTankControl2 = new DriverEasyEnemyTank(enemyTank2);
		this.tanks = new ArrayList<Tank>();
		this.tanks.add(tank);
		this.tanks.add(tankCop);
	}

	public void tick() {
		if (!this.tanks.isEmpty()) {
			if (this.tanks.contains(tank)) {
				this.listener.inicializar(tank);
				this.dibujador.dibujarTank(tank);
			}
			if (this.tanks.contains(tankCop)) {
				this.listenerCop.inicializar(tankCop);
				this.dibujador.dibujarTankCop(tankCop);
			}
			if (!(enemyTankControl.getTank() == null)) {
				this.dibujador.dibujarEnemyTank(enemyTank);
			}
			if (!(enemyTankControl2.getTank() == null)) {
				this.dibujador.dibujarEnemyTank(enemyTank2);
			}
		} else {
			this.dibujador.dibujarFinDeJuego();
		}
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Criterio03Coop user6 = new Criterio03Coop();
	}
}

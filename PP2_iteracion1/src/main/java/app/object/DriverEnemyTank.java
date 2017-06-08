package app.object;

import java.util.List;
import app.enums.Orientation;
import app.enums.TankShot;
import app.modelo.Colisionador;
import app.modelo.ObjetoGrafico;
import entorno.Entorno;
import entorno.Herramientas;

public abstract class DriverEnemyTank {
	protected Tank enemyTank;
	private Colisionador colisionador;

	public DriverEnemyTank(Tank enemyTank) {
		this.enemyTank = enemyTank;
		this.colisionador = Colisionador.getColisionador();
	}

	public void ControlUp() {
		if (enemyTank.getCoordinate().getY() >= 25)
			enemyTank.moverse(Orientation.UP);
	}

	public void ControlDown() {
		if (enemyTank.getCoordinate().getY() <= 547)
			enemyTank.moverse(Orientation.DOWN);
	}

	public void ControlRigth() {
		if (enemyTank.getCoordinate().getX() <= 946)
			enemyTank.moverse(Orientation.RIGHT);
	}

	public void ControlLeft() {
		if (enemyTank.getCoordinate().getX() >= 25)
			enemyTank.moverse(Orientation.LEFT);
	}

	public void ControlEnemyTank(Entorno ent, List<ObjetoGrafico> objetos) {
		// SIEMPRE EL TANQUE GIRA A LA DERECHA CUANDO LLEGA AL LIMITE DEL MAPA

		controChoqueArribaMap();
		controlChoqueDerechaMap();
		controlChoqueAbajoMap();
		controlChoqueIzquierdaMap();
		controlDisparoTankEnemy(ent, objetos); // FALTARIA UN TEMPORIZADOR PARA
												// QUE NO DISPARE A PENAS
												// bullet==null
		ControlTank(objetos);
	}

	abstract public void controChoqueArribaMap();

	abstract public void controlChoqueDerechaMap();

	abstract public void controlChoqueAbajoMap();

	abstract public void controlChoqueIzquierdaMap();

	public void controlDisparoTankEnemy(Entorno ent, List<ObjetoGrafico> objetos) {
		control_bullet(ent, objetos);
		if (this.enemyTank.getTankBullet().equals(TankShot.NO_EXISTS)) {
			enemyTank.disparar();
		}
	}

	/*
	 * public void controlChoqueConEstructuras(){
	 * 
	 * }
	 * 
	 * 
	 * 
	 * private void ControlCpu(Orientation direction) {
	 * if(direction.equals(Orientation.UP)) ControlUp();
	 * if(direction.equals(Orientation.DOWN)) ControlDown();
	 * if(direction.equals(Orientation.RIGHT)) ControlRigth();
	 * if(direction.equals(Orientation.LEFT)) ControlLeft(); } private
	 * Orientation genDirection() { int pick = new
	 * Random().nextInt(Orientation.values().length); return
	 * Orientation.values()[pick]; } public void ai() { Orientation dir =
	 * this.genDirection(); for(int i=0;i<1;i++) { this.ControlCpu(dir); }
	 * //tank.disparar(); }
	 */
	public void control_bullet(Entorno entorno, List<ObjetoGrafico> objetos) {
		if (this.enemyTank.getTankBullet().equals(TankShot.EXISTS)) {
			this.enemyTank.getBullet().avanzarBullet();
			/*
			 * entorno.dibujarCirculo(this.tank.getBullet().getCoordinate().getX
			 * (), this.tank.getBullet().getCoordinate().getY(), 10,
			 * Color.gray);
			 */
			entorno.dibujarImagen(Herramientas.cargarImagen("imagen/bala_2.png"),
					this.enemyTank.getBullet().getCoordinate().getX(),
					this.enemyTank.getBullet().getCoordinate().getY(), 0);
			if (colisionador.colisionBullet(this.enemyTank.getBullet(), objetos)) {
				this.enemyTank.setTankBullet(TankShot.NO_EXISTS);
				this.enemyTank.setBullet(null);
			}
		}
	}

	public Tank getTank() {
		return enemyTank;
	}

	public void setTank(Tank tank) {
		this.enemyTank = tank;
	}

	public boolean hayColisionConUnObjeto(List<ObjetoGrafico> lista) {
		boolean ret = false;
		for (ObjetoGrafico obj : lista) {
			ret = ret || colisionador.hayColision(enemyTank, obj);// enemyTank.getStateMove().hayColision(obj);
																	// //
																	// dependiendo
																	// el estado
																	// va atener
																	// una
																	// colision
																	// !=
		}
		/*
		 * if(ret == true){ System.out.println("colicion: "+ret); }
		 */
		return ret;
	}

	public int colicionEn(List<ObjetoGrafico> lista) {
		int tipoColicion = 0;
		boolean ret = false;
		for (ObjetoGrafico obj : lista) {
			ret = ret || colisionador.hayColision(enemyTank, obj);// enemyTank.getStateMove().hayColision(obj);
																	// //
																	// dependiendo
																	// el estado
																	// va atener
																	// una
																	// colision
																	// !=
			if (ret == true) {
				if (colisionador.hayColisionArriba(enemyTank, obj)) {
					tipoColicion = 1;
				}
				if (colisionador.hayColisionDerecha(enemyTank, obj)) {
					tipoColicion = 2;
				}
				if (colisionador.hayColisionAbajo(enemyTank, obj)) {
					tipoColicion = 3;
				}
				if (colisionador.hayColisionIzquierda(enemyTank, obj)) {
					tipoColicion = 4;
				}
			}
		}
		return tipoColicion;
	}

	abstract public void ControlTank(List<ObjetoGrafico> objetos);

	public Tank getEnemyTank() {
		return enemyTank;
	}

	public void setEnemyTank(Tank enemyTank) {
		this.enemyTank = enemyTank;
	}

	public void destruirTank() {
		this.enemyTank = null;
	}
}
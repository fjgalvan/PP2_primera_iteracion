package app.object;

import java.util.List;
import app.enums.Orientation;
import app.enums.TankShot;
import app.modelo.Colisionador;
import app.modelo.ObjetoGrafico;
import app.object.Configuracion;
import entorno.Entorno;

public abstract class DriverEnemyTank {
	protected Tank enemyTank;
	private Colisionador colisionador;

	public DriverEnemyTank() 
	{
		this.colisionador = Colisionador.getInstance();
	}
	
	public DriverEnemyTank(Tank enemyTank) {
		this.enemyTank = enemyTank;
		this.colisionador = Colisionador.getInstance();
	}
	
	public boolean CanMoveUp(){
		return (enemyTank.getCoordinate().getY() >= Configuracion.MinimoY);
	}
	
	public boolean CanMoveDown(){
		return (enemyTank.getCoordinate().getY() <= Configuracion.MaximoY);
	}
	
	public boolean CanMoveRight(){
		return (enemyTank.getCoordinate().getX() <= Configuracion.MaximoX);
	}
	
	public boolean CanMoveLeft(){
		return (enemyTank.getCoordinate().getX() >= Configuracion.MinimoX);
	}

	public void ControlUp() {
		if (CanMoveUp())
			enemyTank.moverse(Orientation.UP);
	}

	public void ControlDown() {
		if (CanMoveDown())
			enemyTank.moverse(Orientation.DOWN);
	}

	public void ControlRight() {
		if (CanMoveRight())
			enemyTank.moverse(Orientation.RIGHT);
	}

	public void ControlLeft() {
		if (CanMoveLeft())
			enemyTank.moverse(Orientation.LEFT);
	}
	
	public void ControlEnemyTank(Entorno ent, List<ObjetoGrafico> objetos) {
		// SIEMPRE EL TANQUE GIRA A LA DERECHA CUANDO LLEGA AL LIMITE DEL MAPA

		controlChoque();
		controlDisparoTankEnemy(ent, objetos); // FALTARIA UN TEMPORIZADOR PARA
												// QUE NO DISPARE A PENAS
												// bullet==null
		ControlTank(objetos);
	}

	abstract public void controlChoque();

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
			if (colisionador.colisionBullet(this.enemyTank.getBullet(), objetos)) {
				this.enemyTank.setTankBullet(TankShot.NO_EXISTS);
				this.enemyTank.setBullet(null);
			}
		}
	}

	public boolean hayColisionConUnObjeto(List<ObjetoGrafico> lista) {
		boolean ret = false;
		for (ObjetoGrafico obj : lista) {
			if(obj.getClass().getName()!="app.estructura.EstructuraFondo")
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

	public void setEnemyTank(Tank enemyTank) 
	{
		this.enemyTank = enemyTank;
	}

	public void destruirTank() {
		this.enemyTank = null;
	}
}
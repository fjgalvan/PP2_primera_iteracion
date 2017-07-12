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
	private int contTick;

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
		controlChoque();
		controlDisparoTankEnemy(ent, objetos); // FALTARIA UN TEMPORIZADOR PARA
												// QUE NO DISPARE A PENAS
												// bullet==null
		ControlTank(objetos);
	}

	abstract public void controlChoque();

	public void controlDisparoTankEnemy(Entorno ent, List<ObjetoGrafico> objetos) {
		control_bullet(ent, objetos);
		if (this.enemyTank.getTankBullet().equals(TankShot.NO_EXISTS) && contTick > 30) {
			contTick = 0;
			enemyTank.disparar();
		}
	}

	public void control_bullet(Entorno entorno, List<ObjetoGrafico> objetos) {
		if (this.enemyTank.getTankBullet().equals(TankShot.EXISTS)) {
			this.enemyTank.getBullet().avanzarBullet();
			if (colisionador.colisionBullet(this.enemyTank.getBullet(), objetos)) {
				this.enemyTank.setTankBullet(TankShot.NO_EXISTS);
				this.enemyTank.setBullet(null);
			}
		}
	}

	public boolean hayColisionConUnObjeto(List<ObjetoGrafico> lista) {
		boolean ret = false;
		for (ObjetoGrafico obj : lista) {
			if(!obj.getNombre().equals("Fondo"))
			ret = ret || colisionador.hayColision(enemyTank, obj);
		}
		return ret;
	}

	public int colicionEn(List<ObjetoGrafico> lista) {
		int tipoColicion = 0;
		boolean ret = false;
		for (ObjetoGrafico obj : lista) {
			ret = ret || colisionador.hayColision(enemyTank, obj);
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
	
	public int getContTick() {
		return contTick;
	}

	public void setContTick(int contTick) {
		this.contTick = contTick;
	}
}
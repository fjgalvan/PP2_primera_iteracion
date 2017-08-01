package app.object;

import java.util.List;
import app.enums.Orientation;
import app.enums.TankShot;
import app.estructura.Estructura;
import app.modelo.Colisionador;
import app.modelo.ObjetoGrafico;
import app.object.Configuracion;
import entorno.Entorno;

public abstract class DriverEnemyTank {
	protected Tank enemyTank;
	private Colisionador colisionador;
	private int contTick;

	public DriverEnemyTank() 
	{  this.colisionador = Colisionador.getInstance(); }
	public DriverEnemyTank(Tank enemyTank) {
		this.enemyTank = enemyTank; this.colisionador = Colisionador.getInstance();}
	public void ControlEnemyTank(Entorno ent, List<ObjetoGrafico> objetos) {
		controlDisparoTankEnemy(objetos); ControlTank(objetos);}
	public void controlDisparoTankEnemy(List<ObjetoGrafico> objetos) {
		control_bullet(objetos);
		if (this.enemyTank.getTankBullet().equals(TankShot.NO_EXISTS) && contTick > 30) {
			contTick = 0; enemyTank.disparar();}}
	public void control_bullet(List<ObjetoGrafico> objetos) {
		if (this.enemyTank.getTankBullet().equals(TankShot.EXISTS)) {
			this.enemyTank.getBullet().avanzarBullet();
			if (colisionador.colisionBullet(this.enemyTank.getBullet(), objetos)) {
				this.enemyTank.setTankBullet(TankShot.NO_EXISTS);  this.enemyTank.setBullet(null);}
		} }
	public boolean hayColisionConUnObjeto(List<ObjetoGrafico> lista) {
		boolean ret = false;
		for (ObjetoGrafico obj : lista) {
			if(((Estructura) obj).getTipoDeEstructura().isColisicionTank()){ ret = ret || enemyTank.getStateMove().hayColision(obj);}}return ret;}
	public void ControlTank(List<ObjetoGrafico> objetos) 
	{   if (!enemyTank.estaEnLaMismaOrientacion()) {  this.enemyTank.girar();  }
		else {  if (!hayColisionConUnObjeto(objetos)) {  this.enemyTank.getStateMove().control();	} 
			    else{  this.setNextStateMoveTank();	}  }   }
	public abstract void setNextStateMoveTank();
	public Tank getEnemyTank() {return enemyTank;}
	public void setEnemyTank(Tank enemyTank) {this.enemyTank = enemyTank;}
	public void destruirTank() {this.enemyTank = null;}
	public int getContTick() {return contTick;}
	public void setContTick(int contTick) {this.contTick = contTick;}
}
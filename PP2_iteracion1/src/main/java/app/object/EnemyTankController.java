package app.object;

//import java.awt.Color;  
import java.util.Random;

import entorno.Entorno;
import entorno.Herramientas;
import app.enums.Orientation;
import app.enums.TankShot;
//import app.main.Game;
//import app.util.Util;
//import sonido.Sonido;


public class EnemyTankController {
	private Tank enemyTank;
	
	
	public EnemyTankController(Tank enemyTank){
		this.enemyTank= enemyTank;
	}
	
	
	public void ControlUp()
	{
		if(enemyTank.getCoordinate().getY() >= 25)
			enemyTank.moverseArriba();
	}
	public void ControlDown()
	{
		if(enemyTank.getCoordinate().getY() <= 547)
			enemyTank.moverseAbajo();
	}
	public void ControlRigth()
	{
		if(enemyTank.getCoordinate().getX() <= 946 )
			enemyTank.moverseDerecha();
	}
	public void ControlLeft()
	{
		if(enemyTank.getCoordinate().getX() >= 25)
			enemyTank.moverseIzquierda();
	}
	
	public void ControlEnemyTank(Entorno ent)
	{
		//SIEMPRE EL TANQUE GIRA A LA DERECHA CUANDO LLEGA AL LIMITE DEL MAPA
		
		controChoqueArribaMap();
		controlChoqueDerechaMap();
		controlChoqueAbajoMap();
		controlChoqueIzquierdaMap();
		controlDisparoTankEnemy(ent); // FALTARIA UN TEMPORIZADOR PARA QUE NO DISPARE A PENAS bullet==null
	}
	public void controChoqueArribaMap(){
		if(enemyTank.getOrientation().equals(Orientation.UP)){
			ControlUp();
			if(enemyTank.getCoordinate().getY()==26){//25){
				enemyTank.girar(Orientation.RIGHT);
			}
		}
	}
	public void controlChoqueDerechaMap(){
		if(enemyTank.getOrientation().equals(Orientation.RIGHT)){
			ControlRigth();
			if(enemyTank.getCoordinate().getX()==934){//933){
				enemyTank.girar(Orientation.DOWN);
			}
		}
	}
	public void controlChoqueAbajoMap(){
		if(enemyTank.getOrientation().equals(Orientation.DOWN)){
			ControlDown();
			if(enemyTank.getCoordinate().getY()==544){
				enemyTank.girar(Orientation.LEFT);
			}
		}
	}
	public void controlChoqueIzquierdaMap(){
		if(enemyTank.getOrientation().equals(Orientation.LEFT)){
			ControlLeft();
			if(enemyTank.getCoordinate().getX()==28){//27){
				enemyTank.girar(Orientation.UP);
			}
		}
	}
	public void controlDisparoTankEnemy(Entorno ent){
		control_bullet(ent);
		if(this.enemyTank.getTankBullet().equals(TankShot.NO_EXISTS)){
			enemyTank.disparar();
		}
	}
	public void controlChoqueConEstructuras(){
		
	}
	
	
	
	private void ControlCpu(Orientation direction)
	{
		if(direction.equals(Orientation.UP))
			ControlUp();
		if(direction.equals(Orientation.DOWN))
			ControlDown();
		if(direction.equals(Orientation.RIGHT))
			ControlRigth();
		if(direction.equals(Orientation.LEFT))
			ControlLeft();
	}
	private Orientation genDirection()
	{		
		    int pick = new Random().nextInt(Orientation.values().length);
		    return Orientation.values()[pick];
	}
	public void ai()
	{
		Orientation dir = this.genDirection();
		for(int i=0;i<1;i++)
		{
			this.ControlCpu(dir);
		}
		//tank.disparar();
	}
	public void control_bullet(Entorno entorno){
		if(this.enemyTank.getTankBullet().equals(TankShot.EXISTS)){
			this.enemyTank.getBullet().avanzarBullet();
			/*entorno.dibujarCirculo(this.tank.getBullet().getCoordinate().getX(), 
					this.tank.getBullet().getCoordinate().getY(), 10, Color.gray);*/
			entorno.dibujarImagen(Herramientas.cargarImagen("imagen/bala.png"), this.enemyTank.getBullet().getCoordinate().getX(), 
					this.enemyTank.getBullet().getCoordinate().getY(), 0);
			if(this.enemyTank.getBullet().colisionBullet()){
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
	
}

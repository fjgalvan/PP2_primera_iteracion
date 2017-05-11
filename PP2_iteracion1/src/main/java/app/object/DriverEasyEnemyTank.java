package app.object;

//import java.awt.Color;  
import java.util.List;
import java.util.Random;

import entorno.Entorno;
import entorno.Herramientas;
import app.enums.Orientation;
import app.enums.TankShot;
import app.modelo.Colisionador;
//import app.main.Game;
//import app.util.Util;
//import sonido.Sonido;
import app.modelo.ObjetoGrafico;


public class DriverEasyEnemyTank {
	private Tank enemyTank;
	private Colisionador colisionador;
	
	
	public DriverEasyEnemyTank(Tank enemyTank){
		this.enemyTank= enemyTank;
		this.colisionador = new Colisionador();
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
	
	public void ControlEnemyTank(Entorno ent, List<ObjetoGrafico> objetos)
	{
		//SIEMPRE EL TANQUE GIRA A LA DERECHA CUANDO LLEGA AL LIMITE DEL MAPA
		
		controChoqueArribaMap();
		controlChoqueDerechaMap();
		controlChoqueAbajoMap();
		controlChoqueIzquierdaMap();
		controlDisparoTankEnemy(ent,objetos); // FALTARIA UN TEMPORIZADOR PARA QUE NO DISPARE A PENAS bullet==null
		ControlTank(objetos);
	}
	public void controChoqueArribaMap(){
		if(enemyTank.getOrientation().equals(Orientation.UP)){
			ControlUp();
			if(enemyTank.getCoordinate().getY()<=26){//25){
				enemyTank.girar(Orientation.RIGHT);
			}
		}
	}
	public void controlChoqueDerechaMap(){
		if(enemyTank.getOrientation().equals(Orientation.RIGHT)){
			ControlRigth();
			if(enemyTank.getCoordinate().getX()>=934){//933){
				enemyTank.girar(Orientation.DOWN);
			}
		}
	}
	public void controlChoqueAbajoMap(){
		if(enemyTank.getOrientation().equals(Orientation.DOWN)){
			ControlDown();
			if(enemyTank.getCoordinate().getY()>=544){
				enemyTank.girar(Orientation.LEFT);
			}
		}
	}
	public void controlChoqueIzquierdaMap(){
		if(enemyTank.getOrientation().equals(Orientation.LEFT)){
			ControlLeft();
			if(enemyTank.getCoordinate().getX()<=28){//27){
				enemyTank.girar(Orientation.UP);
			}
		}
	}
	public void controlDisparoTankEnemy(Entorno ent, List<ObjetoGrafico> objetos){
		control_bullet(ent,objetos);
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
	public void control_bullet(Entorno entorno, List<ObjetoGrafico> objetos){
		if(this.enemyTank.getTankBullet().equals(TankShot.EXISTS)){
			this.enemyTank.getBullet().avanzarBullet();
			/*entorno.dibujarCirculo(this.tank.getBullet().getCoordinate().getX(), 
					this.tank.getBullet().getCoordinate().getY(), 10, Color.gray);*/
			entorno.dibujarImagen(Herramientas.cargarImagen("imagen/bala_2.png"), this.enemyTank.getBullet().getCoordinate().getX(), 
					this.enemyTank.getBullet().getCoordinate().getY(), 0);
			if(colisionador.colisionBullet(this.enemyTank.getBullet(), objetos)){
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
	
	
	public boolean hayColisionConUnObjeto(List<ObjetoGrafico> lista)
	{
		boolean ret = false;
		for(ObjetoGrafico obj : lista)
		{
			ret = ret || colisionador.hayColision(enemyTank, obj);//enemyTank.getStateMove().hayColision(obj); // dependiendo el estado va atener una colision !=
		}
		/*if(ret == true){
			System.out.println("colicion: "+ret);
		}*/
		return ret;
	}
	public int colicionEn(List<ObjetoGrafico> lista){
		int tipoColicion=0;
		boolean ret = false;
		for(ObjetoGrafico obj : lista)
		{
			ret = ret || colisionador.hayColision(enemyTank, obj);//enemyTank.getStateMove().hayColision(obj); // dependiendo el estado va atener una colision !=
			if(ret == true){
				if(colisionador.hayColisionArriba(enemyTank, obj)){
					tipoColicion=1;
				}
				if(colisionador.hayColisionDerecha(enemyTank, obj)){
					tipoColicion=2;
				}
				if(colisionador.hayColisionAbajo(enemyTank, obj)){
					tipoColicion=3;
				}
				if(colisionador.hayColisionIzquierda(enemyTank, obj)){
					tipoColicion=4;
				}
			}
		}
		return tipoColicion;
	}
	public void ControlTank(List<ObjetoGrafico> objetos){
		if(hayColisionConUnObjeto(objetos)){
			//girarRandom();
			if(colicionEn(objetos)==1){//colicion arriba
				//System.out.println("colicion arriba");
				enemyTank.girar(Orientation.DOWN);
				enemyTank.moverseAbajo();
				enemyTank.girar(Orientation.RIGHT);
			}
			if(colicionEn(objetos)==2){//colicion derecha
				//System.out.println("colicion derecha");
				enemyTank.girar(Orientation.LEFT);
				enemyTank.moverseIzquierda();
				enemyTank.girar(Orientation.DOWN);
			}
			if(colicionEn(objetos)==3){//colicion abajo
				//System.out.println("colicion abajo");
				enemyTank.girar(Orientation.UP);
				enemyTank.moverseArriba();
				enemyTank.girar(Orientation.LEFT);
			}
			if(colicionEn(objetos)==4){//colicion izquierda
				//System.out.println("colicion izquierda");
				enemyTank.girar(Orientation.RIGHT);
				enemyTank.moverseDerecha();
				enemyTank.girar(Orientation.UP);
			}
		}
	}


	public Tank getEnemyTank() {
		return enemyTank;
	}


	public void setEnemyTank(Tank enemyTank) {
		this.enemyTank = enemyTank;
	}
	
	/*public void girarRandom(){
		//generador de numeros aleatorios
	    Random generadorAleatorios = new Random();

	    //genera un numero entre 1 y 4 y lo guarda en la variable numeroAleatorio
	    int numeroAleatorio = 1+generadorAleatorios.nextInt(4);
	   // System.out.println("numeroAleatorio: "+ numeroAleatorio);
	    if((numeroAleatorio == 1) && (!enemyTank.getOrientation().equals(Orientation.UP) )){
	    	enemyTank.girar(Orientation.UP);
	    	enemyTank.moverseArriba();
	    }
	    if((numeroAleatorio == 1) && (enemyTank.getOrientation().equals(Orientation.UP) )){
	    	enemyTank.girar(Orientation.DOWN);
	    	enemyTank.moverseAbajo();
	    }
	    
	    if((numeroAleatorio == 2) && (!enemyTank.getOrientation().equals(Orientation.RIGHT) )){
	    	enemyTank.girar(Orientation.RIGHT);
	    	enemyTank.moverseDerecha();
	    }
	    if((numeroAleatorio == 2) && (enemyTank.getOrientation().equals(Orientation.RIGHT) )){
	    	enemyTank.girar(Orientation.LEFT);
	    	enemyTank.moverseIzquierda();
	    }
	    
	    if((numeroAleatorio == 3) && (!enemyTank.getOrientation().equals(Orientation.DOWN) )){
	    	enemyTank.girar(Orientation.DOWN);
	    	enemyTank.moverseAbajo();
	    }
	    if((numeroAleatorio == 3) && (enemyTank.getOrientation().equals(Orientation.DOWN) )){
	    	enemyTank.girar(Orientation.UP);
	    	enemyTank.moverseArriba();
	    }
	    
	    if((numeroAleatorio == 4) && (!enemyTank.getOrientation().equals(Orientation.LEFT) )){
	    	enemyTank.girar(Orientation.LEFT);
	    	enemyTank.moverseIzquierda();
	    }
	    if((numeroAleatorio == 4) && (enemyTank.getOrientation().equals(Orientation.LEFT) )){
	    	enemyTank.girar(Orientation.RIGHT);
	    	enemyTank.moverseDerecha();
	    }
	}*/
	public void destruirTank(){
		this.enemyTank = null;
	}
}

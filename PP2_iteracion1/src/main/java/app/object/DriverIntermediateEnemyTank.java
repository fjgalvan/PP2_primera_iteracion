package app.object;

//import java.awt.Color;  
import java.util.List;
import java.util.Random;

import app.enums.Orientation;
//import app.main.Game;
//import app.util.Util;
//import sonido.Sonido;
import app.modelo.ObjetoGrafico;


public class DriverIntermediateEnemyTank extends DriverEnemyTank{
	
	public DriverIntermediateEnemyTank(Tank enemyTank){
		super(enemyTank);
	}
	
	public void controChoqueArribaMap(){
		if(enemyTank.getOrientation().equals(Orientation.UP)){
			ControlUp();
			if(enemyTank.getCoordinate().getY()<=26){//25){
				//enemyTank.girar(Orientation.RIGHT);
				girarRandom();
			}
		}
	}
	public void controlChoqueDerechaMap(){
		if(enemyTank.getOrientation().equals(Orientation.RIGHT)){
			ControlRigth();
			if(enemyTank.getCoordinate().getX()>=934){//933){
				//enemyTank.girar(Orientation.DOWN);
				girarRandom();
			}
		}
	}
	public void controlChoqueAbajoMap(){
		if(enemyTank.getOrientation().equals(Orientation.DOWN)){
			ControlDown();
			if(enemyTank.getCoordinate().getY()>=544){
				//enemyTank.girar(Orientation.LEFT);
				girarRandom();
			}
		}
	}
	public void controlChoqueIzquierdaMap(){
		if(enemyTank.getOrientation().equals(Orientation.LEFT)){
			ControlLeft();
			if(enemyTank.getCoordinate().getX()<=28){//27){
				//enemyTank.girar(Orientation.UP);
				girarRandom();
			}
		}
	}
	
	public void ControlTank(List<ObjetoGrafico> objetos){
		if(hayColisionConUnObjeto(objetos)){
			
			if(colicionEn(objetos)==1){//colicion arriba
				//System.out.println("colicion arriba");
				enemyTank.girar(Orientation.DOWN);
				enemyTank.moverseAbajo();
				enemyTank.girar(Orientation.RIGHT);
				girarRandom();
			}
			if(colicionEn(objetos)==2){//colicion derecha
				//System.out.println("colicion derecha");
				enemyTank.girar(Orientation.LEFT);
				enemyTank.moverseIzquierda();
				enemyTank.girar(Orientation.DOWN);
				girarRandom();
			}
			if(colicionEn(objetos)==3){//colicion abajo
				//System.out.println("colicion abajo");
				enemyTank.girar(Orientation.UP);
				enemyTank.moverseArriba();
				enemyTank.girar(Orientation.LEFT);
				girarRandom();
			}
			if(colicionEn(objetos)==4){//colicion izquierda
				//System.out.println("colicion izquierda");
				enemyTank.girar(Orientation.RIGHT);
				enemyTank.moverseDerecha();
				enemyTank.girar(Orientation.UP);
				girarRandom();
			}
		}
	}

	/*** RANDOM GIRO ***/
	public void girarRandom(){
		//generador de numeros aleatorios
	    Random generadorAleatorios = new Random();

	    //genera un numero entre 1 y 4 y lo guarda en la variable numeroAleatorio
	    int numeroAleatorio = 1+generadorAleatorios.nextInt(4);
	   // System.out.println("numeroAleatorio: "+ numeroAleatorio);
	    if((numeroAleatorio == 1) && (!enemyTank.getOrientation().equals(Orientation.UP) )){
	    	enemyTank.moverseArriba();
	    	enemyTank.girar(Orientation.UP);
	    	
	    }
	    if((numeroAleatorio == 1) && (enemyTank.getOrientation().equals(Orientation.UP) )){
	    	enemyTank.moverseAbajo();
	    	enemyTank.girar(Orientation.DOWN);
	    	
	    }
	    
	    if((numeroAleatorio == 2) && (!enemyTank.getOrientation().equals(Orientation.RIGHT) )){
	    	enemyTank.moverseDerecha();
	    	enemyTank.girar(Orientation.RIGHT);
	    	
	    }
	    if((numeroAleatorio == 2) && (enemyTank.getOrientation().equals(Orientation.RIGHT) )){
	    	enemyTank.moverseIzquierda();
	    	enemyTank.girar(Orientation.LEFT);
	    	
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
	}
}
package app.object;

//import java.awt.Color;  
import java.util.List;
import app.enums.Orientation;
//import app.main.Game;
//import app.util.Util;
//import sonido.Sonido;
import app.modelo.ObjetoGrafico;


public class DriverEasyEnemyTank extends DriverEnemyTank{
	
	public DriverEasyEnemyTank(Tank enemyTank){
		super(enemyTank);
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
}

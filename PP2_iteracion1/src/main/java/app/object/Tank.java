package app.object;

import app.enums.*;
import app.modelo.ObjetoGrafico;
import app.state_tank.StateMoveTank;
import app.util.Util;

public class Tank extends ObjetoGrafico {
	private Orientation orientation;
	private TankShot tankShot;
	private Bullet bullet;
	private StateMoveTank stateMove;
	private double velocidadDeMovimiento = 2;
	private Energy energy;
	
	
	
	public Tank(Orientation orientation, Coordinate coordinate,	Size size){
		this.orientation = orientation;
		this.coordinate = coordinate;
		this.size = size;
		this.tankShot = TankShot.NO_EXISTS;
		//this.energy = energy;
		//this.stateMove = new StateMoveTankUp(this); // el tanque como posicion inicial va empezar mirando hacia arriba
	}
	
	public Tank(Orientation orientation, Coordinate coordinate,	Size size,Energy energy){
		this(orientation, coordinate, size);
		this.energy = energy;
	}
	
	//dependiendo del estado en que se encuentre se gira
	//le paso una nueva orientacion que reemplaza a la anterior, y cuando lo dibuje girara el tanque
	public void girar(Orientation orientation)
	{
		this.setOrientation(orientation);
	}
	
	//dependiendo del estado en que se encuentre se mueve
	public void moverse(Orientation o){
		if(getOrientation().equals(o)) setearMovimiento(o);  
		this.girar(o);
	}
	
	public void setearMovimiento(Orientation o){
		if(o.equals(Orientation.RIGHT)) this.coordinate.setX(this.coordinate.getX()+this.velocidadDeMovimiento);
		else if(o.equals(Orientation.LEFT))	this.coordinate.setX(this.coordinate.getX()-this.velocidadDeMovimiento);
		else if(o.equals(Orientation.UP)) this.coordinate.setY(this.coordinate.getY()-this.velocidadDeMovimiento);
		else this.coordinate.setY(this.coordinate.getY()+this.velocidadDeMovimiento);
	}

	public void disparar(){
		if(tankShot.equals(TankShot.NO_EXISTS)){
			bullet = new Bullet(orientation, 
					new Coordinate(this.coordinate.getX()+20,this.coordinate.getY()+20),
					new Size(10, 10));
			tankShot = TankShot.EXISTS;
		}
	}
	
	//dependiendo del estado en que se encuentre se mueve en esa posicion
	public void moverse(){
		//controlar que no choque con las estructuras o el limite del mapa
		if(!Util.estaEnElLimiteDeTablero(orientation, coordinate)){					// esta funcion no se utiliza
			Util.moverse(orientation, coordinate, velocidadDeMovimiento);
		}
	}
	
	public double getAngulo() {
		if(this.orientation.equals(Orientation.UP)){
			return 0;
		}if(this.orientation.equals(Orientation.DOWN)){
			return Math.PI;
		}if(this.orientation.equals(Orientation.LEFT)){
			return Math.PI*1.5;
		}if(this.orientation.equals(Orientation.RIGHT)){
			return Math.PI/2;
		}
	return 0;
	}
	
	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public TankShot getTankBullet() {
		return tankShot;
	}

	public void setTankBullet(TankShot tankShot) {
		this.tankShot = tankShot;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Bullet getBullet() {
		return bullet;
	}

	public void setBullet(Bullet bullet) {
		this.bullet = bullet;
	}

	public StateMoveTank getStateMove()
	{
		return stateMove;
	}
	
	public void setStateMove(StateMoveTank state)
	{
		this.stateMove = state;
	}

	public boolean existeDisparoEnEjecucion() 
	{
		return getTankBullet().equals(TankShot.EXISTS);	
	}
	
	public Integer getEnergyVal()
	{
		return energy.getValor();
	}
	
	public void increaseHP()
	{
		energy.subirEnergy();
	}
	
	public void decreaseHP()
	{
		energy.bajarEnergy();
	}
	
	public boolean sinEnergy()
	{
		return energy.getValor().equals(0);
	}
}

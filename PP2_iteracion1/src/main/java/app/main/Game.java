package main;

import entorno.*;
import java.util.ArrayList;
import java.util.List;
import enums.Orientation;
import enums.TankShot;
import modelo.Colisionador;
import modelo.ObjetoGrafico;
import object.*;

public class Game extends InterfaceJuego {
   
    private Tank tank;
    private Draftsman dibujador;
    private GraphicMap mapa;
	private ListStructures estructuras;
	private TankController tControl;
	private Colisionador colisionador;
	private KeyEventListener listener;
	private Tank enemyTank;
    private EnemyTankController enemyTankControl;
    private Tank enemyTank2;
    private EnemyTankController enemyTankControl2;
    private Tank enemyTank3;
    private EnemyTankController enemyTankControl3;
	private List<Tank> tanks;
	private List<Tank> enemysTanks;
	private boolean modoJuegoCooperativo = true;
    private Tank tankCop;
	private TankController tControlCop;
	private KeyEventListenerCop listenerCop;
	public Game() 
	{
		this.mapa = new GraphicMap(new Map(new Size(1000, 600)), new Size(20, 20));
		this.dibujador = new Draftsman(this, mapa, "Battle-Ungs");
		this.estructuras = new ListStructures(mapa, 10); // cantidad de tipos de estructuras -- num * 3 
		this.tank = new Tank(Orientation.UP,new Coordinate(400,400),new Size(40,40)); // ver como ubicar el tanqe
		this.listener = new KeyEventListener(dibujador.getEntorno());
		this.colisionador = new Colisionador();
		this.enemyTank = new Tank(Orientation.UP,new Coordinate(600,100),new Size(40,40));
		this.enemyTankControl= new EnemyTankController(enemyTank);
		this.enemyTank2 = new Tank(Orientation.UP,new Coordinate(50,500),new Size(40,40));
		this.enemyTankControl2= new EnemyTankController(enemyTank2);
		this.enemyTank3 = new Tank(Orientation.UP,new Coordinate(600,500),new Size(40,40));
		this.enemyTankControl3= new EnemyTankController(enemyTank3);
		this.tControl = new TankController(tank,listener,colisionador);
		this.tanks = new ArrayList<Tank>();
		this.enemysTanks = new ArrayList<Tank>();
		//COP
		this.tankCop = new Tank(Orientation.UP,new Coordinate(800,400),new Size(40,40)); // ver como ubicar el tanqe
		this.listenerCop = new KeyEventListenerCop(dibujador.getEntorno());
		this.tControlCop = new TankController(tankCop,listenerCop,colisionador);
	}
	
	public void iniciar()
	{
		this.tanks.add(tank);
		this.tanks.add(tankCop);
    	this.enemysTanks.add(enemyTank);
    	this.enemysTanks.add(enemyTank2);
    	this.enemysTanks.add(enemyTank3);
	}
	
    public void tick() 
    {   	
    	this.dibujador.dibujarMarco(mapa); 
    	if(!(tControl.getTank() == null) || !(tControlCop.getTank() == null))
    	{
    	for (ObjetoGrafico e:estructuras.getLista()) 
    	{
			this.dibujador.dibujarEstructura(e);
		}
    	
    	if(!(tControl.getTank() == null)){
    	this.listener.inicializar(tank); 
    	
        	this.dibujador.dibujarTank(tank);
    		this.tControl.ControlTank(estructuras.getLista());
    		this.tControl.control_bullet(dibujador.getEntorno(),estructuras.getLista(),this.enemysTanks);
    	}
        	//COOP
        	if(!(tControlCop.getTank() == null)){
        		this.listenerCop.inicializar(tankCop); 
        		this.dibujador.dibujarTank(tankCop);
        		this.tControlCop.ControlTankCop(estructuras.getLista());
        		this.tControlCop.control_bullet(dibujador.getEntorno(),estructuras.getLista(),this.enemysTanks);
        	}
        	destruccionTanksEnemys();
        	
    	if(!(enemyTankControl.getTank() == null))
    	{
        	this.dibujador.dibujarEnemyTank(enemyTank);
        	this.enemyTankControl.ControlEnemyTank(dibujador.getEntorno(), estructuras.getLista());
        	this.enemyTankControl.control_bullet(dibujador.getEntorno(),estructuras.getLista());
        	destruccionTank1();
    	}
    	
    	if(!(enemyTankControl2.getTank() == null))
    	{
        	this.dibujador.dibujarEnemyTank(enemyTank2);
        	this.enemyTankControl2.ControlEnemyTank(dibujador.getEntorno(), estructuras.getLista());
        	this.enemyTankControl2.control_bullet(dibujador.getEntorno(),estructuras.getLista());
        	destruccionTank2();
    	}
    	if(!(enemyTankControl3.getTank() == null))
    	{
        	this.dibujador.dibujarEnemyTank(enemyTank3);
        	this.enemyTankControl3.ControlEnemyTank(dibujador.getEntorno(), estructuras.getLista());
        	this.enemyTankControl3.control_bullet(dibujador.getEntorno(),estructuras.getLista());
        	destruccionTank3();
    	}
    	}
    	else{
    		this.dibujador.dibujarFinDeJuego();
    	}
    }

	private void destruccionTanksEnemys() {
		if(colisionador.colisionBulletConTank(this.tank.getBullet(), enemysTanks)){
			this.tank.setTankBullet(TankShot.NO_EXISTS);
			this.tank.setBullet(null);
			destruirEnemyTank(enemysTanks);
		} 
		if(colisionador.colisionBulletConTank(this.tankCop.getBullet(), enemysTanks)){
			this.tankCop.setTankBullet(TankShot.NO_EXISTS);
			this.tankCop.setBullet(null);
			destruirEnemyTank(enemysTanks);
		}
	}
	
	public void destruccionTank1(){
		if(colisionador.colisionBulletConTank(this.enemyTank.getBullet(), tanks)){
			this.enemyTank.setTankBullet(TankShot.NO_EXISTS);
			this.enemyTank.setBullet(null);
			destruirTankPlayer(tanks);
		}
	}

	public void destruccionTank2(){
		if(colisionador.colisionBulletConTank(this.enemyTank2.getBullet(), tanks)){
			this.enemyTank2.setTankBullet(TankShot.NO_EXISTS);
			this.enemyTank2.setBullet(null);
			this.tControl.destruirTank();
			destruirTankPlayer(tanks);
		}
	}

	public void destruccionTank3(){
		if(colisionador.colisionBulletConTank(this.enemyTank3.getBullet(), tanks)){
			this.enemyTank3.setTankBullet(TankShot.NO_EXISTS);
			this.enemyTank3.setBullet(null);
			this.tControl.destruirTank();
			destruirTankPlayer(tanks);
		}
	}
	
	private void destruirTankPlayer(List<Tank> tanksPlayers) {
		tanksPlayers.remove(colisionador.getTankADestruir());
		if(!tanksPlayers.contains(tank))
			this.tControl.destruirTank();
		if(!tanksPlayers.contains(tankCop))
			this.tControlCop.destruirTank();
	}
	
	private void destruirEnemyTank(List<Tank> enemysTanks) {
		enemysTanks.remove(colisionador.getTankADestruir());
		if(!enemysTanks.contains(enemyTank))
			enemyTankControl.destruirTank();
		if(!enemysTanks.contains(enemyTank2))
			enemyTankControl2.destruirTank();
		if(!enemysTanks.contains(enemyTank3))
			enemyTankControl3.destruirTank();
	}
	
	public void destruirEstrcuturas(){
		
	}
}

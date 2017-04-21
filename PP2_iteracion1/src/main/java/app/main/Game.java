package app.main;

import entorno.*;

import java.util.ArrayList;
import java.util.List;

import app.enums.Orientation;
import app.enums.TankShot;
import app.modelo.Colisionador;
import app.modelo.ObjetoGrafico;
import app.object.*;

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
		this.tControl = new TankController(tank,listener);
		this.tanks = new ArrayList<Tank>();
		this.enemysTanks = new ArrayList<Tank>();
	}
	
	public void iniciar()
	{
		this.tanks.add(tank);
    	this.enemysTanks.add(enemyTank);
    	this.enemysTanks.add(enemyTank2);
    	this.enemysTanks.add(enemyTank3);
		// ver que mandar -- el profe no queria que solo se cree el objeto game en el main x eso
	}
	
    public void tick() 
    {
    	//this.listener.inicializar(tank);    	
    	this.dibujador.dibujarMarco(mapa); 

    	for (ObjetoGrafico e:estructuras.getLista()) 
    	{
			this.dibujador.dibujarEstructura(e);
		}
    	
    	this.listener.inicializar(tank); 
    	if(!(tControl.getTank() == null))
    	{
        	this.dibujador.dibujarTank(tank);
    		this.tControl.ControlTank(estructuras.getLista());
    		this.tControl.control_bullet(dibujador.getEntorno(),estructuras.getLista(),this.enemysTanks);
    	}
    	
    	if(!(enemyTankControl.getTank() == null))
    	{
        	this.dibujador.dibujarEnemyTank(enemyTank);
        	this.enemyTankControl.ControlEnemyTank(dibujador.getEntorno(), estructuras.getLista());
        	this.enemyTankControl.control_bullet(dibujador.getEntorno(),estructuras.getLista());
    	}
    	
    	if(!(enemyTankControl2.getTank() == null))
    	{
        	this.dibujador.dibujarEnemyTank(enemyTank2);
        	this.enemyTankControl2.ControlEnemyTank(dibujador.getEntorno(), estructuras.getLista());
        	this.enemyTankControl2.control_bullet(dibujador.getEntorno(),estructuras.getLista());
    	}
    	if(!(enemyTankControl3.getTank() == null))
    	{
        	this.dibujador.dibujarEnemyTank(enemyTank3);
        	this.enemyTankControl3.ControlEnemyTank(dibujador.getEntorno(), estructuras.getLista());
        	this.enemyTankControl3.control_bullet(dibujador.getEntorno(),estructuras.getLista());
    	}
    	destruccionTanks();
    }

	private void destruccionTanks() {
		if(colisionador.colisionBulletConTank(this.tank.getBullet(), enemysTanks)){
			this.tank.setTankBullet(TankShot.NO_EXISTS);
			this.tank.setBullet(null);
			destruirEnemyTank(enemysTanks);
		}
		if(colisionador.colisionBulletConTank(this.enemyTank.getBullet(), tanks)){
			this.enemyTank.setTankBullet(TankShot.NO_EXISTS);
			this.enemyTank.setBullet(null);
			this.tControl.destruirTank();
		}
		if(colisionador.colisionBulletConTank(this.enemyTank2.getBullet(), tanks)){
			this.enemyTank2.setTankBullet(TankShot.NO_EXISTS);
			this.enemyTank2.setBullet(null);
			this.tControl.destruirTank();
		}
		if(colisionador.colisionBulletConTank(this.enemyTank3.getBullet(), tanks)){
			this.enemyTank3.setTankBullet(TankShot.NO_EXISTS);
			this.enemyTank3.setBullet(null);
			this.tControl.destruirTank();
		}
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
}

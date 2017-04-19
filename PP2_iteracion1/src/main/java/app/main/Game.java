package app.main;

import entorno.*;
import app.enums.Orientation;
import app.modelo.ObjetoGrafico;
import app.object.*;

public class Game extends InterfaceJuego {
   
    private Tank tank;
    private Draftsman dibujador;
    private GraphicMap mapa;
	private ListStructures estructuras;
	private TankController tControl;
	private KeyEventListener listener;
	private Tank enemyTank;
    private EnemyTankController enemyTankControl;
    private Tank enemyTank2;
    private EnemyTankController enemyTankControl2;
    private Tank enemyTank3;
    private EnemyTankController enemyTankControl3;
	
	public Game() 
	{
		this.mapa = new GraphicMap(new Map(new Size(1000, 600)), new Size(20, 20));
		this.dibujador = new Draftsman(this, mapa, "Battle-Ungs");
		this.estructuras = new ListStructures(mapa, 10); // cantidad de tipos de estructuras -- num * 3 
		this.tank = new Tank(Orientation.UP,new Coordinate(400,400),new Size(40,40)); // ver como ubicar el tanqe
		this.listener = new KeyEventListener(dibujador.getEntorno());
		this.enemyTank = new Tank(Orientation.UP,new Coordinate(600,100),new Size(40,40));
		this.enemyTankControl= new EnemyTankController(enemyTank);
		this.enemyTank2 = new Tank(Orientation.UP,new Coordinate(50,500),new Size(40,40));
		this.enemyTankControl2= new EnemyTankController(enemyTank2);
		this.enemyTank3 = new Tank(Orientation.UP,new Coordinate(600,500),new Size(40,40));
		this.enemyTankControl3= new EnemyTankController(enemyTank3);
		
		this.tControl = new TankController(tank,listener);
	}
	
	public void iniciar()
	{
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
    	
    	this.dibujador.dibujarTank(tank);
    	this.dibujador.dibujarEnemyTank(enemyTank);
    	this.dibujador.dibujarEnemyTank(enemyTank2);
    	this.dibujador.dibujarEnemyTank(enemyTank3);
    	this.listener.inicializar(tank); 
    	this.tControl.ControlTank(estructuras.getLista());
    	this.tControl.control_bullet(dibujador.getEntorno());
    	
    	this.enemyTankControl.ControlEnemyTank(dibujador.getEntorno(), estructuras.getLista());
    	this.enemyTankControl.control_bullet(dibujador.getEntorno());
    	
    	this.enemyTankControl2.ControlEnemyTank(dibujador.getEntorno(), estructuras.getLista());
    	this.enemyTankControl2.control_bullet(dibujador.getEntorno());
    	
    	this.enemyTankControl3.ControlEnemyTank(dibujador.getEntorno(), estructuras.getLista());
    	this.enemyTankControl3.control_bullet(dibujador.getEntorno());
    }
    
    

}

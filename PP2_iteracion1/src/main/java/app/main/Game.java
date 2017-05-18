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
    private DriverEasyEnemyTank enemyTankControl;
    private Tank enemyTank2;
    private DriverEasyEnemyTank enemyTankControl2;
    private Tank enemyTank3;
    private DriverEasyEnemyTank enemyTankControl3;
    
    private Tank enemyTank4;
    private DriverIntermediateEnemyTank enemyTankControl4;
    
	private List<Tank> tanks;
	private List<Tank> enemysTanks;
    private Tank tankCop;
	private TankController tControlCop;
	private KeyEventListenerCop listenerCop;
	public Game() 
	{
		this.mapa = new GraphicMap(new Map(new Size(1000, 600)), new Size(20, 20));
		this.dibujador = new Draftsman(this, mapa, "Battle-Ungs");
		this.estructuras = new ListStructures(mapa, 10); // cantidad de tipos de estructuras -- num * 3 
		this.tank = new Tank(Orientation.UP,new Coordinate(800,400),new Size(40,40)); // ver como ubicar el tanqe
		this.listener = new KeyEventListener(dibujador.getEntorno());
		this.colisionador = new Colisionador();
		this.enemyTank = new Tank(Orientation.UP,new Coordinate(600,100),new Size(40,40));
		this.enemyTankControl= new DriverEasyEnemyTank(enemyTank);
		this.enemyTank2 = new Tank(Orientation.UP,new Coordinate(50,500),new Size(40,40));
		this.enemyTankControl2= new DriverEasyEnemyTank(enemyTank2);
		this.enemyTank3 = new Tank(Orientation.UP,new Coordinate(600,500),new Size(40,40));

		this.enemyTankControl3= new DriverEasyEnemyTank(enemyTank3);
		
		this.enemyTank4 = new Tank(Orientation.UP,new Coordinate(300,300),new Size(40,40));
		this.enemyTankControl4= new DriverIntermediateEnemyTank(enemyTank4);
		
		this.tControl = new TankController(tank,listener,colisionador);
		this.tanks = new ArrayList<Tank>();
		this.enemysTanks = new ArrayList<Tank>();
		//COP
		this.tankCop = new Tank(Orientation.UP,new Coordinate(400,400),new Size(40,40)); // ver como ubicar el tanqe
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
    	
    	this.enemysTanks.add(enemyTank4);
	}
	
    public void tick() 
    {   	
    	this.dibujador.dibujarMarco(mapa); 
    	if(!(tControl.getTank() == null) || !(tControlCop.getTank() == null))//ACA TIRA ERROR DE CONSOLA
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
        	destruccionTanksEnemys(tank,enemysTanks);
    	}
        	//COOP
        	if(!(tControlCop.getTank() == null)){
        		this.listenerCop.inicializar(tankCop); 
        		this.dibujador.dibujarTank(tankCop);
        		this.tControlCop.ControlTankCop(estructuras.getLista());
        		this.tControlCop.control_bullet(dibujador.getEntorno(),estructuras.getLista(),this.enemysTanks);
        	}
        	destruccionTanksEnemys(tankCop,enemysTanks);
        	
    	if(!(enemyTankControl.getTank() == null))
    	{
        	this.dibujador.dibujarEnemyTank(enemyTank);
        	this.enemyTankControl.ControlEnemyTank(dibujador.getEntorno(), estructuras.getLista());
        	this.enemyTankControl.control_bullet(dibujador.getEntorno(),estructuras.getLista());
        	destruccionTank(enemyTank,tanks);
        	//destruccionTank1();
    	}
    	
    	if(!(enemyTankControl2.getTank() == null))
    	{
        	this.dibujador.dibujarEnemyTank(enemyTank2);
        	this.enemyTankControl2.ControlEnemyTank(dibujador.getEntorno(), estructuras.getLista());
        	this.enemyTankControl2.control_bullet(dibujador.getEntorno(),estructuras.getLista());
        	destruccionTank(enemyTank2,tanks);
    	}
    	if(!(enemyTankControl3.getTank() == null))
    	{
        	this.dibujador.dibujarEnemyTank(enemyTank3);
        	this.enemyTankControl3.ControlEnemyTank(dibujador.getEntorno(), estructuras.getLista());
        	this.enemyTankControl3.control_bullet(dibujador.getEntorno(),estructuras.getLista());
        	destruccionTank(enemyTank3,tanks);
    	}
    	
    	
    	if(!(enemyTankControl4.getTank() == null))
    	{
        	this.dibujador.dibujarEnemyTankIntermediate(enemyTank4);
        	this.enemyTankControl4.ControlEnemyTank(dibujador.getEntorno(), estructuras.getLista());
        	this.enemyTankControl4.control_bullet(dibujador.getEntorno(),estructuras.getLista());
        	destruccionTank(enemyTank4,tanks);
    	}
    	}
    	else{
    		this.dibujador.dibujarFinDeJuego();
    	}
    }

	private void destruccionTanksEnemys(Tank tank, List<Tank> enemysTanks) {
		if(colisionador.colisionBulletConTank(tank.getBullet(), enemysTanks)){
			tank.setTankBullet(TankShot.NO_EXISTS);
			tank.setBullet(null);
			destruirEnemyTank(enemysTanks);
		}
	}
	
	public void destruccionTank(Tank enemyTank, List<Tank> tanks){
		if(colisionador.colisionBulletConTank(enemyTank.getBullet(), tanks)){
			enemyTank.setTankBullet(TankShot.NO_EXISTS);
			enemyTank.setBullet(null);
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
		if(!enemysTanks.contains(enemyTank4))
			enemyTankControl4.destruirTank();
	}
	
	public void destruirEstrcuturas(){
		
	}
}

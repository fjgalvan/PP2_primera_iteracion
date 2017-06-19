package app.main;

import entorno.*;
import java.util.ArrayList;
import java.util.List;
import app.enums.Orientation;
import app.mapa.MapaTiled;
import app.modelo.Destructor;
import app.modelo.ObjetoGrafico;
import app.object.*;

public class Game extends InterfaceJuego {
   
	private static Player1 player1;
    private Tank tank;
    private Draftsman dibujador;
    private GraphicMap mapa;
	private ListStructures estructuras;
	private MapaTiled mapaTiled;
	private TankController tControl;
	private Destructor destructor;
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
	
	private boolean modoJuegoCop = true;
	private static Player2 player2;
    private Tank tankCop;
	private TankController tControlCop;

	private String mapaAJugar = "/mapas/MapaTank05.csv";
	
	public Game() 
	{
		this.mapa = new GraphicMap(new Map(new Size(1000, 600)), new Size(20, 20));
		this.dibujador = new Draftsman(this, mapa, "Battle-Ungs");
		this.estructuras = new ListStructures();
		
		this.mapaTiled = new MapaTiled(mapaAJugar);
		this.mapaTiled.crearEstructuras(estructuras);
		
		this.tank = new Tank(Orientation.UP,new Coordinate(560,520),new Size(40,40),new Energy(2)); // ver como ubicar el tanqe
		this.destructor = new Destructor();
		this.enemyTank = new Tank(Orientation.UP,new Coordinate(40,40),new Size(40,40),new Energy(1));
		this.enemyTankControl= new DriverEasyEnemyTank(enemyTank);
		this.enemyTank2 = new Tank(Orientation.UP,new Coordinate(440,40),new Size(40,40),new Energy(1));
		this.enemyTankControl2= new DriverEasyEnemyTank(enemyTank2);
		this.enemyTank3 = new Tank(Orientation.UP,new Coordinate(640,40),new Size(40,40),new Energy(1));

		this.enemyTankControl3= new DriverEasyEnemyTank(enemyTank3);
		
		this.enemyTank4 = new Tank(Orientation.UP,new Coordinate(640,80),new Size(40,40),new Energy(2));
		this.enemyTankControl4= new DriverIntermediateEnemyTank(enemyTank4);

		Game.player1 = new Player1(new Puntaje(0,0),dibujador);
		this.tControl = new TankController(tank,player1.getListener(),destructor.getColisionador());
		this.tanks = new ArrayList<Tank>();
		this.enemysTanks = new ArrayList<Tank>();
		//COP
		if(modoJuegoCop){
			Game.player2 = new Player2(new Puntaje(0,0),dibujador);
			this.tankCop = new Tank(Orientation.UP,new Coordinate(360,520),new Size(40,40),new Energy(2)); // ver como ubicar el tanqe
			this.tControlCop = new TankController(tankCop,player2.getListenerCop(),destructor.getColisionador());
			this.tanks.add(tankCop);
		}
		
	}
	
	public void iniciar()
	{
		this.tanks.add(tank);
    	this.enemysTanks.add(enemyTank);
    	this.enemysTanks.add(enemyTank2);
    	this.enemysTanks.add(enemyTank3);
    	this.enemysTanks.add(enemyTank4);
	}
	
    public void tick() 
    {   	
    	this.dibujador.dibujarMarco(mapa); 
    	if(!this.tanks.isEmpty() && !this.enemysTanks.isEmpty() )
    	{
    		for (ObjetoGrafico e:estructuras.getLista()) 
    		{
    			this.dibujador.dibujarEstructura(e);
    		}
    		if(this.tanks.contains(tank)){
    			player1.getListener().inicializar(tank); 
    			this.dibujador.dibujarTank(tank);
    			this.tControl.ControlTank(estructuras.getLista());
    			this.tControl.control_bullet(dibujador.getEntorno(),estructuras.getLista(),this.enemysTanks);
    			destructor.destruccionTanksEnemys(tank,tanks,enemysTanks,"1",enemyTank, enemyTankControl, enemyTank2, enemyTankControl2,
    					enemyTank3, enemyTankControl3, enemyTank4, enemyTankControl4);
    		}
        	//COOP
        	if(this.tanks.contains(tankCop)){
        		player2.getListenerCop().inicializar(tankCop); 
        		this.dibujador.dibujarTankCop(tankCop);
        		this.tControlCop.ControlTankCop(estructuras.getLista());
        		this.tControlCop.control_bullet(dibujador.getEntorno(),estructuras.getLista(),this.enemysTanks);
        		destructor.destruccionTanksEnemys(tankCop,tanks, enemysTanks,"2",enemyTank, enemyTankControl, enemyTank2, enemyTankControl2,
    					enemyTank3, enemyTankControl3, enemyTank4, enemyTankControl4);
        	}
        	
        	
//        	for(Tank enemyTank : enemysTanks){
//        		if(enemyTank!=null){
//                	this.dibujador.dibujarEnemyTank(enemyTank);
//                	this.enemyTankControl.ControlEnemyTank(dibujador.getEntorno(), estructuras.getLista());
//                	this.enemyTankControl.control_bullet(dibujador.getEntorno(),estructuras.getLista());
//                	destruccionTank(enemyTank,tanks);
//        		}
//        	}
        	if(!(enemyTankControl.getTank() == null))
        	{
        		this.dibujador.dibujarEnemyTank(enemyTank);
        		this.enemyTankControl.ControlEnemyTank(dibujador.getEntorno(), estructuras.getLista());
        		this.enemyTankControl.control_bullet(dibujador.getEntorno(),estructuras.getLista());
        		destructor.destruccionTank(enemyTank,tanks,tank, tControl, tControlCop);
        	}
        	if(!(enemyTankControl2.getTank() == null))
        	{
        		this.dibujador.dibujarEnemyTank(enemyTank2);
        		this.enemyTankControl2.ControlEnemyTank(dibujador.getEntorno(), estructuras.getLista());
        		this.enemyTankControl2.control_bullet(dibujador.getEntorno(),estructuras.getLista());
        		destructor.destruccionTank(enemyTank2,tanks,tank, tControl, tControlCop);
        	}
        	if(!(enemyTankControl3.getTank() == null))
        	{
        		this.dibujador.dibujarEnemyTank(enemyTank3);
        		this.enemyTankControl3.ControlEnemyTank(dibujador.getEntorno(), estructuras.getLista());
        		this.enemyTankControl3.control_bullet(dibujador.getEntorno(),estructuras.getLista());
        		destructor.destruccionTank(enemyTank3,tanks,tank, tControl, tControlCop);
        	}
        	if(!(enemyTankControl4.getTank() == null))
        	{
        		this.dibujador.dibujarEnemyTankIntermediate(enemyTank4);
        		this.enemyTankControl4.ControlEnemyTank(dibujador.getEntorno(), estructuras.getLista());
        		this.enemyTankControl4.control_bullet(dibujador.getEntorno(),estructuras.getLista());
        		destructor.destruccionTank(enemyTank4,tanks,tank, tControl, tControlCop);
        	}
        	destructor.destruirEstructuras(estructuras);
    	}
    	else{
    		this.dibujador.dibujarFinDeJuego();
    		this.dibujador.dibujarPuntaje("Player 1: ", Game.player1.getPuntaje(), 200, 400);
    		if(Game.player2!=null)
    			this.dibujador.dibujarPuntaje("Player 2: ", Game.player2.getPuntaje(), 200, 430);
    	}
    }


	public static void sumarPuntaje(String player) {
		if(player.equals("1"))
			player1.setPuntaje(new Puntaje(500,0));
		else
			player2.setPuntaje(new Puntaje(500,0));
	}

	public static void sumarCantidadDeEnemigosAsesinados(String player) {
		if(player.equals("1"))
			player1.setPuntaje(new Puntaje(0,1));
		else
			player2.setPuntaje(new Puntaje(0,1));
	}

	public Draftsman getDibujador() {
		return dibujador;
	}

	public GraphicMap getMapa() {
		return mapa;
	}

	public MapaTiled getMapaTiled() {
		return mapaTiled;
	}

	public String getMapaAJugar() {
		return mapaAJugar;
	}
	
	
}

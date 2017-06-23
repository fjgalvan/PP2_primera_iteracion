package app.main;

import java.awt.Point;

import app.enums.Orientation;
import app.mapa.MapaTiled;
import app.modelo.*;
import app.object.*;
import entorno.InterfaceJuego;

public class GamePacman extends InterfaceJuego{

	private Player player1;
    private Tank tank;
    private Draftsman dibujador;
    private GraphicMap mapa;
	private ListStructures estructuras;
	private MapaTiled mapaTiled;
	private TankController tControl;
	private Destructor destructor;
	private String mapaAJugar = "/mapas/Pacman01.csv";
	private DriverIntermediateEnemyTank driver1, driver2, driver3, driver4;
	private Tank enemy1, enemy2,enemy3,enemy4;
	
	public GamePacman() 
	{
		this.mapa = new GraphicMap(new Map(new Point(1000, 600)), new Point(20, 20));
		this.dibujador = new Draftsman(this, mapa, "Pacman-Ungs");
		this.estructuras = new ListStructures();
		this.mapaTiled = new MapaTiled(mapaAJugar);
		this.mapaTiled.crearEstructuras(estructuras);
		this.tank = new Tank(Orientation.RIGHT,new Point(440,200),new Point(36,36), 2); 
		this.destructor = new Destructor();
		this.player1 = new Player(0,0,new ListenerPlayer1(dibujador.getEntorno()));
		this.tControl = new TankController(tank,this.player1.getListener(),destructor.getColisionador());
		enemy1 = new Tank(Orientation.DOWN, new Point(40,40), new Point(36,36), 1);
		enemy2 = new Tank(Orientation.UP, new Point(50,500), new Point(36,36), 1);
		enemy3 = new Tank(Orientation.LEFT, new Point(600,500), new Point(36,36), 1);
		enemy4 = new Tank(Orientation.RIGHT, new Point(300,440), new Point(36,36), 1);
		driver1 = new DriverIntermediateEnemyTank(enemy1);
		driver2 = new DriverIntermediateEnemyTank(enemy2);
		driver3 = new DriverIntermediateEnemyTank(enemy3);
		driver4 = new DriverIntermediateEnemyTank(enemy4);
	}
	
	public void iniciar(){}
	
    public void tick() 
    {   	
    	this.dibujador.dibujarMarco(mapa); 
    	for (ObjetoGrafico e:estructuras.getLista()) 
    	{
    		this.dibujador.dibujarEstructura(e);
    	}    	
    	driver1.ControlEnemyTank(dibujador.getEntorno(),estructuras.getLista());
    	driver2.ControlEnemyTank(dibujador.getEntorno(),estructuras.getLista());
    	driver3.ControlEnemyTank(dibujador.getEntorno(),estructuras.getLista());
    	driver4.ControlEnemyTank(dibujador.getEntorno(),estructuras.getLista());
    	dibujador.dibujarFantasma(enemy1);
    	dibujador.dibujarFantasma(enemy2);
    	dibujador.dibujarFantasma(enemy3);
    	dibujador.dibujarFantasma(enemy4);
    	this.dibujador.dibujarPacman(tank); // imple en draftman
    	player1.getListener().seMovio(tank); 
    	this.tControl.ControlTank(estructuras.getLista());
    }

	public Tank getTank() {
		return tank;
	}
}

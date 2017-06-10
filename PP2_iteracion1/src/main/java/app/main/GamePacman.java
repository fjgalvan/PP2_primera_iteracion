package app.main;

import app.enums.Orientation;
import app.mapa.MapaTiled;
import app.modelo.Destructor;
import app.modelo.ObjetoGrafico;
import app.object.Coordinate;
import app.object.Draftsman;
import app.object.Energy;
import app.object.GraphicMap;
import app.object.ListStructures;
import app.object.Map;
import app.object.Player1;
import app.object.Puntaje;
import app.object.Size;
import app.object.Tank;
import app.object.TankController;
import entorno.InterfaceJuego;
import sonido.Sonido;

public class GamePacman extends InterfaceJuego{

	private Player1 player1;
    private Tank tank;
    private Draftsman dibujador;
    private GraphicMap mapa;
	private ListStructures estructuras;
	private MapaTiled mapaTiled;
	private TankController tControl;
	private Destructor destructor;
    
	private String mapaAJugar = "/mapas/Pacman01.csv";
	
	public GamePacman() 
	{
		this.mapa = new GraphicMap(new Map(new Size(1000, 600)), new Size(20, 20));
		this.dibujador = new Draftsman(this, mapa, "Pacman-Ungs");
		this.estructuras = new ListStructures();
		this.mapaTiled = new MapaTiled(mapaAJugar);
		this.mapaTiled.crearEstructuras(estructuras);
		this.tank = new Tank(Orientation.UP,new Coordinate(440,200),new Size(40,40),new Energy(2)); // ver como ubicar el tanqe
		this.destructor = new Destructor();
		this.player1 = new Player1(new Puntaje(0,0),dibujador);
		this.tControl = new TankController(tank,this.player1.getListener(),destructor.getColisionador());
		
	}
	
	public void iniciar()
	{
	}
	
    public void tick() 
    {   	
    	this.dibujador.dibujarMarco(mapa); 
    	for (ObjetoGrafico e:estructuras.getLista()) 
    	{
    		this.dibujador.dibujarEstructura(e);
    	}
    	this.dibujador.dibujarPacman(tank);
    	player1.getListener().inicializar(tank);
    	Sonido.PacmanChomp.loop();
    	this.tControl.ControlTank(estructuras.getLista());

    }
}

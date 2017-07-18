package app.main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import app.enums.Orientation;
import app.mapa.MapaTiled;
import app.modelo.*;
import app.object.*;
import entorno.InterfaceJuego;

public class GameBomberman extends InterfaceJuego{

	private Player player1;
    private Tank tank;
    private Draftsman dibujador;
    private GraphicMap mapa;
	private List<ObjetoGrafico> estructuras;
	private MapaTiled mapaTiled;
	private TankController tControl;
	private Destructor destructor;
	private String mapaAJugar = Configuracion.MapaBomberman;
	
	public GameBomberman() 
	{
		this.mapa = new GraphicMap(new Map(new Point(1000, 600)), new Point(20, 20));
		this.dibujador = new Draftsman(this, mapa, "Bomberman-Ungs");
		estructuras = new ArrayList<>();
		this.mapaTiled = new MapaTiled(mapaAJugar);
		this.mapaTiled.inicializar();
		this.mapaTiled.crearEstructuras(estructuras);
		this.tank = new Tank(Orientation.UP ,new Point(440,200), new Point(36,36), 2); 
		this.destructor = new Destructor();
		this.player1 = new Player(0,0,new ListenerPlayer1(dibujador.getEntorno()));
		this.tControl = new TankController(tank,this.player1.getListener(),destructor.getColisionador());
	}
	
	public void iniciar(){}
	
    public void tick() 
    {   	
    	this.dibujador.dibujarMarco(mapa); 
    	for (ObjetoGrafico e:estructuras) 
    	{
    		this.dibujador.dibujarEstructura(e);
    	}
    	this.player1.getListener().seMovio(tank); 
    	this.dibujador.dibujarBomberman(tank);
    	this.tControl.ControlTank(estructuras);
    }
    

	public Tank getTank() {
		return tank;
	}
}

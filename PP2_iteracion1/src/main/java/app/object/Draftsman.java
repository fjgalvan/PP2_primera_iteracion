package app.object;

import java.awt.Color; 

import app.modelo.ObjetoGrafico;
import entorno.*;

public class Draftsman {
	private Entorno entorno;

	public Draftsman(InterfaceJuego i, GraphicMap gm, String title)
	{
		this.dibujarEscenario(i,gm,title);
	}
	
	public void dibujarEscenario(InterfaceJuego i, GraphicMap gm, String title)
	{
		this.entorno = new Entorno(i, title, (int)gm.getSize().getAncho(), (int)gm.getSize().getAlto());
	}
	
	public void dibujarMapa(int tamañoDeTiles, int altoMapa, int anchoMapa, int lugarDelSprite, String imagen){
		int contador = 0;
		for(int y=0; y < altoMapa;y++){
			for(int x=0; x < anchoMapa; x++){
				contador = contador + 1 ;
				if(contador != lugarDelSprite){
					this.entorno.dibujarImagen(Herramientas.cargarImagen(imagen), x*tamañoDeTiles, y*tamañoDeTiles, 0);
				}
			}
		}
	}
	
	public void dibujarMarco(GraphicMap gm)
	{
		Color color = Color.GRAY;
		// linea de arriba y de lado izquierdo
		this.entorno.dibujarRectangulo(10, 10, gm.getSizeMarco().getAncho(), gm.getSize().getAlto()*2, 0, color);
		this.entorno.dibujarRectangulo(10, 10, gm.getSize().getAncho()*2, gm.getSizeMarco().getAlto(), 0, color);
		// linea de abajo y lado derecho
		this.entorno.dibujarRectangulo(gm.getSize().getAncho(), 0, gm.getSizeMarco().getAncho(), gm.getSize().getAlto()*2+20, 0, color);
		this.entorno.dibujarRectangulo(10, gm.getSize().getAlto(), gm.getSize().getAncho()*2, gm.getSizeMarco().getAlto(), 0, color);
	}
	
	public void dibujarImagen(String rutaImagen, Coordinate coordinate){
		this.entorno.dibujarImagen(Herramientas.cargarImagen(rutaImagen), coordinate.getX(), coordinate.getY(), 0);
	}
	
	public void dibujarImagen(String rutaImagen, Coordinate coordinate, double angulo){
		this.entorno.dibujarImagen(Herramientas.cargarImagen(rutaImagen), coordinate.getX(), coordinate.getY(), angulo);
	}
	
	public void dibujarRectangulo(Coordinate coordinate, Size size, double angulo, Color color){
		this.entorno.dibujarRectangulo(coordinate.getX(), coordinate.getY(), size.getAncho(), 
				size.getAlto(), angulo, color);
	}
	
	public void dibujarCirculo(Coordinate coordinate, double diametro, Color color){
		this.entorno.dibujarCirculo(coordinate.getX(), coordinate.getY(), diametro, color);
	}
	
	public void dibujarEstructura(ObjetoGrafico e)
	{
		this.entorno.dibujarImagen(Herramientas.cargarImagen(e.getImagen()), e.getCoordinate().getX()+(e.getSize().getAncho()/2), e.getCoordinate().getY()+e.getSize().getAlto()/2, 0);
		//this.entorno.dibujarRectangulo(e.getCoordinate().getX()+(e.getSize().getAncho()/2),e.getCoordinate().getY()+e.getSize().getAlto()/2, e.getSize().getAncho(), e.getSize().getAlto(), 0, e.getColor());
	}
	public void dibujarTank(Tank t)
	{
		if(t.getEnergyVal()==1)
		{
			this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/TankA1.png"), t.getCoordinate().getX()+(t.getSize().getAncho()/2), t.getCoordinate().getY()+t.getSize().getAlto()/2, t.getAngulo(),2);
		}
		else if(t.getEnergyVal()==2)
		{
			this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/TankA2.png"), t.getCoordinate().getX()+(t.getSize().getAncho()/2), t.getCoordinate().getY()+t.getSize().getAlto()/2, t.getAngulo(),2);
		}
		//this.entorno.dibujarRectangulo(t.getCoordinate().getX()+(t.getSize().getAncho()/2),t.getCoordinate().getY()+t.getSize().getAlto()/2,t.getSize().getAncho(),t.getSize().getAlto(),t.getAngulo(), Color.green);
		//this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/Tank1.png"), t.getCoordinate().getX()+(t.getSize().getAncho()/2), t.getCoordinate().getY()+t.getSize().getAlto()/2, t.getAngulo());
		//	this.entorno.dibujarRectangulo(x, y, ancho, alto, angulo, color);
	}

	public void dibujarBomberman(Tank t){
		this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/bombermanUP.png"), t.getCoordinate().getX()+(t.getSize().getAncho()/2), t.getCoordinate().getY()+t.getSize().getAlto()/2, t.getAngulo(),2);
	}
	
	public void dibujarTankCop(Tank t)
	{
		if(t.getEnergyVal()==1)
		{
			this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/TankB2.png"), t.getCoordinate().getX()+(t.getSize().getAncho()/2), t.getCoordinate().getY()+t.getSize().getAlto()/2, t.getAngulo(),2);
		}
		else if(t.getEnergyVal()==2)
		{
			this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/TankB1.png"), t.getCoordinate().getX()+(t.getSize().getAncho()/2), t.getCoordinate().getY()+t.getSize().getAlto()/2, t.getAngulo(),2);
		}
	}
	
	/**/public void dibujarEnemyTank(Tank t){
		
		if(t.getEnergyVal()==1)
		{
			this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/Enemy1.png"), t.getCoordinate().getX()+(t.getSize().getAncho()/2), t.getCoordinate().getY()+t.getSize().getAlto()/2, t.getAngulo(),2);
		}
		else if(t.getEnergyVal()==2)
		{
			this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/Enemy2.png"), t.getCoordinate().getX()+(t.getSize().getAncho()/2), t.getCoordinate().getY()+t.getSize().getAlto()/2, t.getAngulo(),2);
		}
		//this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/EnemyTank1.png"), t.getCoordinate().getX()+(t.getSize().getAncho()/2), t.getCoordinate().getY()+t.getSize().getAlto()/2, t.getAngulo());
	}
	
	
	/**/public void dibujarEnemyTankIntermediate(Tank t){
		if(t.getEnergyVal()==1)
		{
			this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/enemyB1.png"), t.getCoordinate().getX()+(t.getSize().getAncho()/2), t.getCoordinate().getY()+t.getSize().getAlto()/2, t.getAngulo(),2);
		}
		else if(t.getEnergyVal()==2)
		{
			this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/enemyB2.png"), t.getCoordinate().getX()+(t.getSize().getAncho()/2), t.getCoordinate().getY()+t.getSize().getAlto()/2, t.getAngulo(),2);
		}
		//this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/EnemyTank2.png"), t.getCoordinate().getX()+(t.getSize().getAncho()/2), t.getCoordinate().getY()+t.getSize().getAlto()/2, t.getAngulo());
	}
	
	public void dibujarFinDeJuego(){
			String mensaje;
		    mensaje = "GAME OVER";
		    this.entorno.cambiarFont("Arial", 70, Color.red);
		    this.entorno.escribirTexto(mensaje, this.entorno.ancho() / 2-250,
		    							this.entorno.alto() / 2-75);
		    this.entorno.cambiarFont("Arial", 24, Color.green);
		    this.entorno.escribirTexto("Puntajes:", 200,
		    		370);
	}
	
	public void dibujarPuntaje(String nombre, Puntaje puntaje,int posicionX,int posicionY){
		String mensaje;
	    mensaje = nombre + puntaje.getPuntaje() + "  Enemigos Destruidos: " + puntaje.getCantidadDeEnemigosAsesinados();
	    this.entorno.cambiarFont("Arial", 24, Color.green);
	    this.entorno.escribirTexto(mensaje, posicionX,
	    		posicionY);
	}
	
	public Entorno getEntorno(){
		return this.entorno;
	}
}

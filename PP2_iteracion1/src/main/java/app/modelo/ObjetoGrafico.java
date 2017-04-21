package app.modelo;

import java.awt.Color;
import app.object.Coordinate;
import app.object.Size;

public abstract class ObjetoGrafico {
	
	protected Coordinate coordinate;
	protected Size size;
	protected Color color;
	protected String imagen;
	protected double radio;
	public ObjetoGrafico()
	{
		this.radio = 0;
	}
	//public abstract void dibujar(Entorno ent);

	//public abstract void dibujar(Entorno ent, Coordenada c);
	
	public boolean hayColision(ObjetoGrafico objGraf)
	{
		//izquierda
		boolean colisionIzq = this.getCoordinate().getX() == objGraf.getCoordinate().getX()+objGraf.getSize().getAncho() &&		
							  this.getCoordinate().getY() < objGraf.getCoordinate().getY()+objGraf.getSize().getAlto() &&
							  this.getCoordinate().getY()+this.getSize().getAlto() > objGraf.getCoordinate().getY();
	
		//derecha
		boolean colisionDer = this.getCoordinate().getX()+this.getSize().getAncho() == objGraf.getCoordinate().getX() &&
							  this.getCoordinate().getY() < objGraf.getCoordinate().getY()+objGraf.getSize().getAlto() &&
							  this.getCoordinate().getY()+this.getSize().getAlto() > objGraf.getCoordinate().getY();		
		//arriba
		boolean colisionArr = this.getCoordinate().getY() == objGraf.getCoordinate().getY()+objGraf.getSize().getAlto() &&
							  this.getCoordinate().getX() < objGraf.getCoordinate().getX()+objGraf.getSize().getAncho() &&
							  this.getCoordinate().getX()+this.getSize().getAncho() > objGraf.getCoordinate().getX();
				
		//abajo
		boolean colisionAbj = this.getCoordinate().getY()+this.getSize().getAlto() == objGraf.getCoordinate().getY() &&
							  this.getCoordinate().getX() < objGraf.getCoordinate().getX()+objGraf.getSize().getAncho() &&
							  this.getCoordinate().getX()+this.getSize().getAncho() > objGraf.getCoordinate().getX();
							  
		return (colisionIzq || colisionDer || colisionArr || colisionAbj);
	}
	
	public boolean hayColisionArriba(ObjetoGrafico objGraf)
	{
		boolean colisionArr = this.getCoordinate().getY() == objGraf.getCoordinate().getY()+objGraf.getSize().getAlto() &&
				  			  this.getCoordinate().getX() < objGraf.getCoordinate().getX()+objGraf.getSize().getAncho() &&
				  			  this.getCoordinate().getX()+this.getSize().getAncho() > objGraf.getCoordinate().getX();
		return colisionArr;		  
	}
	
	public boolean hayColisionAbajo(ObjetoGrafico objGraf)
	{
		boolean colisionAbj = this.getCoordinate().getY()+this.getSize().getAlto() == objGraf.getCoordinate().getY() &&
							  this.getCoordinate().getX() < objGraf.getCoordinate().getX()+objGraf.getSize().getAncho() &&
							  this.getCoordinate().getX()+this.getSize().getAncho() > objGraf.getCoordinate().getX();
		return colisionAbj;		  
	}
	
	public boolean hayColisionDerecha(ObjetoGrafico objGraf)
	{
		boolean colisionDer = this.getCoordinate().getX()+this.getSize().getAncho() == objGraf.getCoordinate().getX() &&
							  this.getCoordinate().getY() < objGraf.getCoordinate().getY()+objGraf.getSize().getAlto() &&
							  this.getCoordinate().getY()+this.getSize().getAlto() > objGraf.getCoordinate().getY();		

		return colisionDer;
	}
	
	public boolean hayColisionIzquierda(ObjetoGrafico objGraf)
	{
		boolean colisionIzq = this.getCoordinate().getX() == objGraf.getCoordinate().getX()+objGraf.getSize().getAncho() &&		
							  this.getCoordinate().getY() < objGraf.getCoordinate().getY()+objGraf.getSize().getAlto() &&
							  this.getCoordinate().getY()+this.getSize().getAlto() > objGraf.getCoordinate().getY();
		return colisionIzq;
	}
	
	public Color getColor() {
		return color;
	}

	public Coordinate getCoordinate() 
	{
		return coordinate;
	}

	public void setCoordinate(Coordinate coordenada) 
	{
		this.coordinate = coordenada;
	}

	public Size getSize() 
	{
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	public String getImagen()
	{
		return this.imagen;
	}
	
}
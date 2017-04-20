package app.modelo;

public class Colisionador {
	
	public Colisionador (){
		
	}
	public boolean hayColision(ObjetoGrafico objGraf1, ObjetoGrafico objGraf2)
	{
		//izquierda
		boolean colisionIzq = 	objGraf1.getCoordinate().getX() == objGraf2.getCoordinate().getX()+objGraf2.getSize().getAncho() &&		
								objGraf1.getCoordinate().getY() < objGraf2.getCoordinate().getY()+objGraf2.getSize().getAlto() &&
								objGraf1.getCoordinate().getY() + objGraf2.getSize().getAlto() > objGraf2.getCoordinate().getY();
	
		//derecha
		boolean colisionDer = 	objGraf1.getCoordinate().getX()+objGraf1.getSize().getAncho() == objGraf2.getCoordinate().getX() &&
								objGraf1.getCoordinate().getY() < objGraf2.getCoordinate().getY()+objGraf2.getSize().getAlto() &&
								objGraf1.getCoordinate().getY()+objGraf1.getSize().getAlto() > objGraf2.getCoordinate().getY();		
		//arriba
		boolean colisionArr =	objGraf1.getCoordinate().getY() == objGraf2.getCoordinate().getY()+objGraf2.getSize().getAlto() &&
								objGraf1.getCoordinate().getX() < objGraf2.getCoordinate().getX()+objGraf2.getSize().getAncho() &&
								objGraf1.getCoordinate().getX()+objGraf1.getSize().getAncho() > objGraf2.getCoordinate().getX();
				
		//abajo
		boolean colisionAbj = 	objGraf1.getCoordinate().getY() + objGraf1.getSize().getAlto() == objGraf2.getCoordinate().getY() &&
								objGraf1.getCoordinate().getX() < objGraf2.getCoordinate().getX()+objGraf2.getSize().getAncho() &&
								objGraf1.getCoordinate().getX() + objGraf1.getSize().getAncho() > objGraf2.getCoordinate().getX();
							  
		return (colisionIzq || colisionDer || colisionArr || colisionAbj);
	}
	
	public boolean hayColisionArriba(ObjetoGrafico objGraf1, ObjetoGrafico objGraf2)
	{
		boolean colisionArr = 	objGraf1.getCoordinate().getY() == objGraf2.getCoordinate().getY()+objGraf2.getSize().getAlto() &&
								objGraf1.getCoordinate().getX() < objGraf2.getCoordinate().getX()+objGraf2.getSize().getAncho() &&
								objGraf1.getCoordinate().getX() + objGraf1.getSize().getAncho() > objGraf2.getCoordinate().getX();
		return colisionArr;		  
	}
	
	public boolean hayColisionAbajo(ObjetoGrafico objGraf1, ObjetoGrafico objGraf2)
	{
		boolean colisionAbj = 	objGraf1.getCoordinate().getY()+objGraf1.getSize().getAlto() == objGraf2.getCoordinate().getY() &&
								objGraf1.getCoordinate().getX() < objGraf2.getCoordinate().getX()+objGraf2.getSize().getAncho() &&
								objGraf1.getCoordinate().getX()+objGraf1.getSize().getAncho() > objGraf2.getCoordinate().getX();
		return colisionAbj;		  
	}
	
	public boolean hayColisionDerecha(ObjetoGrafico objGraf1, ObjetoGrafico objGraf2)
	{
		boolean colisionDer = 	objGraf1.getCoordinate().getX()+objGraf1.getSize().getAncho() == objGraf2.getCoordinate().getX() &&
								objGraf1.getCoordinate().getY() < objGraf2.getCoordinate().getY()+objGraf2.getSize().getAlto() &&
								objGraf1.getCoordinate().getY()+objGraf1.getSize().getAlto() > objGraf2.getCoordinate().getY();		

		return colisionDer;
	}
	
	public boolean hayColisionIzquierda(ObjetoGrafico objGraf1, ObjetoGrafico objGraf2)
	{
		boolean colisionIzq = 	objGraf1.getCoordinate().getX() == objGraf2.getCoordinate().getX()+objGraf2.getSize().getAncho() &&		
								objGraf1.getCoordinate().getY() < objGraf2.getCoordinate().getY()+objGraf2.getSize().getAlto() &&
								objGraf1.getCoordinate().getY()+objGraf1.getSize().getAlto() > objGraf2.getCoordinate().getY();
		return colisionIzq;
	}
	
}

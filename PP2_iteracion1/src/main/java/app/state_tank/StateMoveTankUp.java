package app.state_tank;

import app.enums.Orientation;
import app.modelo.Colisionador;
import app.modelo.ObjetoGrafico;
import app.object.Tank;

public class StateMoveTankUp extends StateMoveTank
{
	
	public StateMoveTankUp(Tank tanque) 
	{
		super(tanque);
	}
	
	public boolean hayColision(ObjetoGrafico obj) 
	{
		Colisionador col = new Colisionador();
		return col.hayColisionArriba(tank, obj);
	}

	public void control() 
	{
		if(tank.getCoordinate().getY() >= 20)
			tank.moverseArriba();		
	}

	public Orientation getOrientacion() 
	{
		return Orientation.UP;
	}
}

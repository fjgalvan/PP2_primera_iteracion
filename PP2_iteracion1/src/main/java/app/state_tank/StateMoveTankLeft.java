package app.state_tank;

import app.enums.Orientation;
import app.modelo.Colisionador;
import app.modelo.ObjetoGrafico;
import app.object.Tank;

public class StateMoveTankLeft extends StateMoveTank
{

	public StateMoveTankLeft(Tank tanque) 
	{
		super(tanque);
	}

	@Override
	public boolean hayColision(ObjetoGrafico obj)
	{
		Colisionador col = new Colisionador();
		return col.hayColisionIzquierda(tank, obj);
	}

	@Override
	public void control() 
	{
		if(tank.getCoordinate().getX() >= 20)
			tank.moverseIzquierda();
	}

	@Override
	public Orientation getOrientacion() 
	{
		return Orientation.LEFT;
	}
	
}

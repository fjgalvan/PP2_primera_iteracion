package app.state_tank;

import app.enums.Orientation;
import app.modelo.ObjetoGrafico;
import app.object.Tank;

public class StateMoveTankRight extends StateMoveTank {

	public StateMoveTankRight(Tank tanque) 
	{
		super(tanque);
	}

	@Override
	public boolean hayColision(ObjetoGrafico obj) 
	{
		return tank.hayColisionDerecha(obj);
	}

	@Override
	public void control() 
	{
		if(tank.getCoordinate().getX() <= 946 )
			tank.moverseDerecha();
	}

	@Override
	public Orientation getOrientacion() 
	{
		return Orientation.RIGHT;
	}	
	
}

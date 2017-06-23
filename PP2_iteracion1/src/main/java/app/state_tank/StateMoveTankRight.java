package app.state_tank;

import app.enums.Orientation;
import app.modelo.Colisionador;
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
		Colisionador col = Colisionador.getInstance();
		return col.hayColisionDerecha(tank, obj);
	}

	@Override
	public void control() 
	{
		if(tank.getCoordinate().getX() <= 946 )
			tank.moverse(Orientation.RIGHT);
	}

	@Override
	public Orientation getOrientacion() 
	{
		return Orientation.RIGHT;
	}	
	
}

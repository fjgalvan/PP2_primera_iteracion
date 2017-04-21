package app.state_tank;

import app.enums.Orientation;
import app.modelo.Colisionador;
import app.modelo.ObjetoGrafico;
import app.object.Tank;

public class StateMoveTankDown extends StateMoveTank
{
	
	public StateMoveTankDown(Tank tanque) 
	{
		super(tanque);
	}

	@Override
	public boolean hayColision(ObjetoGrafico obj) 
	{
		Colisionador col = new Colisionador();
		return col.hayColisionAbajo(tank, obj);
	}

	@Override
	public void control() 
	{
		if(tank.getCoordinate().getY() <= 547)
			tank.moverseAbajo();
	}

	@Override
	public Orientation getOrientacion() 
	{
		return Orientation.DOWN;
	}

}

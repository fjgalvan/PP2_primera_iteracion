package app.state_tank;

import app.enums.Orientation;
import app.modelo.Colisionador;
import app.modelo.ObjetoGrafico;
import app.object.Configuracion;
import app.object.Tank;

public class StateMoveTankDown extends StateMoveTank
{
	public StateMoveTankDown(){}
	
	public StateMoveTankDown(Tank tanque) 
	{
		super(tanque);
	}

	@Override
	public boolean hayColision(ObjetoGrafico obj) 
	{
		Colisionador col = Colisionador.getInstance();
		return col.hayColisionAbajo(tank, obj);
	}

	@Override
	public void control() 
	{
		if(tank.getCoordinate().getY() <= Configuracion.MaxCoordinateY)//547)
			tank.moverse(getOrientacion());
	}

	@Override
	public Orientation getOrientacion() 
	{
		return Orientation.DOWN;
	}

}

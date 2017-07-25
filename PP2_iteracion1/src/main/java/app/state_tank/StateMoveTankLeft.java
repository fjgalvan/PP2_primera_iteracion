package app.state_tank;

import app.enums.Orientation;
import app.modelo.Colisionador;
import app.modelo.ObjetoGrafico;
import app.object.Configuracion;
import app.object.Tank;

public class StateMoveTankLeft extends StateMoveTank
{
	public StateMoveTankLeft(){}
	
	public StateMoveTankLeft(Tank tanque) 
	{
		super(tanque);
	}

	@Override
	public boolean hayColision(ObjetoGrafico obj)
	{
		Colisionador col = Colisionador.getInstance();
		return col.hayColisionIzquierda(tank, obj);
	}

	@Override
	public void control() 
	{
		if(tank.getCoordinate().getX() >= Configuracion.MinCoordinateX)//20)
			tank.moverse(getOrientacion());
	}

	@Override
	public Orientation getOrientacion() 
	{
		return Orientation.LEFT;
	}
	
}

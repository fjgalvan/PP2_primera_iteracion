package app.state_tank;

import app.enums.Orientation;
import app.modelo.ObjetoGrafico;
import app.object.Tank;

public abstract class StateMoveTank
{
	protected Tank tank;
	
	public StateMoveTank(Tank tanque)
	{
		this.tank = tanque;
	}
	
	public abstract boolean hayColision(ObjetoGrafico obj);
	public abstract void control();
	public abstract Orientation getOrientacion();
}

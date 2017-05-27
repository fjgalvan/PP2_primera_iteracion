package app.object;

import entorno.Entorno;
import app.state_tank.StateMoveTank;
import app.state_tank.StateMoveTankDown;
import app.state_tank.StateMoveTankLeft;
import app.state_tank.StateMoveTankRight;
import app.state_tank.StateMoveTankUp;

public class KeyEventListenerCop {
	private Entorno entorno;
	private StateMoveTank estado;
	
	public KeyEventListenerCop(Entorno e)
	{
		this.entorno = e;
	}
	
	public void inicializar(Tank tanque)
	{
		if(this.entorno.estaPresionada(entorno.TECLA_s))
		{
			this.estado = new StateMoveTankDown(tanque);
		}
		else if (this.entorno.estaPresionada(entorno.TECLA_w))
		{
			this.estado = new StateMoveTankUp(tanque);
		}
		else if (this.entorno.estaPresionada(entorno.TECLA_d))
		{
			this.estado = new StateMoveTankRight(tanque);
		}
		else if (this.entorno.estaPresionada(entorno.TECLA_a))
		{
			this.estado = new StateMoveTankLeft(tanque);
		}
		else 
		{
		//	this.estado = new StateMoveTankUp(tanque); // por defecto
		}
	}
	
	
	public StateMoveTank getEstado()
	{
		return estado;
	}

	public void borrarEstado() 
	{
		this.estado = null;
	}

	public boolean existeEstadoDeMovimiento() 
	{
		return (this.estado!=null);
	}

	public boolean seActivoDisparo() 
	{
		return entorno.estaPresionada(entorno.TECLA_ESPACIO);
	}
	
}

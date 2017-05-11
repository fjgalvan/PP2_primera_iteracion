package app.object;

import entorno.Entorno;
import state_tank.StateMoveTank;
import state_tank.StateMoveTankDown;
import state_tank.StateMoveTankLeft;
import state_tank.StateMoveTankRight;
import state_tank.StateMoveTankUp;

public class KeyEventListenerCop {
	private Entorno entorno;
	private StateMoveTank estado;
	
	public KeyEventListenerCop(Entorno e)
	{
		this.entorno = e;
	}
	
	public void inicializar(Tank tanque)
	{
		if(this.entorno.estaPresionada(entorno.TECLA_S))
		{
			this.estado = new StateMoveTankDown(tanque);
		}
		else if (this.entorno.estaPresionada(entorno.TECLA_W))
		{
			this.estado = new StateMoveTankUp(tanque);
		}
		else if (this.entorno.estaPresionada(entorno.TECLA_D))
		{
			this.estado = new StateMoveTankRight(tanque);
		}
		else if (this.entorno.estaPresionada(entorno.TECLA_A))
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

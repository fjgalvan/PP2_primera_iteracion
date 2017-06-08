package app.object;

import app.state_tank.*;
import entorno.Entorno;

public class KeyEventListener 
{
	private Entorno entorno;
	private StateMoveTank estado;
	
	public KeyEventListener(Entorno e)
	{
		this.entorno = e;
	}
	
	public void inicializar(Tank tanque)
	{
		if(this.entorno.estaPresionada(entorno.TECLA_ABAJO))
		{
			this.estado = new StateMoveTankDown(tanque);
		}
		else if (this.entorno.estaPresionada(entorno.TECLA_ARRIBA))
		{
			this.estado = new StateMoveTankUp(tanque);
		}
		else if (this.entorno.estaPresionada(entorno.TECLA_DERECHA))
		{
			this.estado = new StateMoveTankRight(tanque);
		}
		else if (this.entorno.estaPresionada(entorno.TECLA_IZQUIERDA))
		{
			this.estado = new StateMoveTankLeft(tanque);
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
		return entorno.estaPresionada(entorno.TECLA_ENTER);
	}
	
	public boolean seActivoDisparoCop() 
	{
		return entorno.estaPresionada(entorno.TECLA_ESPACIO);
	}

	public void inicializarCooperativo(Tank tankCop) {
		if(this.entorno.estaPresionada(entorno.TECLA_S))
		{
			this.estado = new StateMoveTankDown(tankCop);
		}
		else if (this.entorno.estaPresionada(entorno.TECLA_W))
		{
			this.estado = new StateMoveTankUp(tankCop);
		}
		else if (this.entorno.estaPresionada(entorno.TECLA_D))
		{
			this.estado = new StateMoveTankRight(tankCop);
		}
		else if (this.entorno.estaPresionada(entorno.TECLA_A))
		{
			this.estado = new StateMoveTankLeft(tankCop);
		}
		
	}
	
}

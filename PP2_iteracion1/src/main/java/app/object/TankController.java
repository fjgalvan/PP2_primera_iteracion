package object;

import java.awt.Color;
import java.util.List;
import java.util.Random;
import entorno.Entorno;
import entorno.Herramientas;
import enums.Orientation;
import enums.TankShot;
import modelo.Colisionador;
import modelo.ObjetoGrafico;
import state_tank.StateMoveTankUp;
import util.Util;
import sonido.Sonido;

@SuppressWarnings("unused")
public class TankController {
	private Tank tank;
	private KeyEventListener listener;
	private KeyEventListenerCop listenerCop;
	private Colisionador colisionador;
	
	public TankController(Tank tank, KeyEventListener kel,Colisionador colisionador)
	{
		this.tank = tank;
		this.listener = kel;
		this.colisionador = colisionador;
	}
	
	public TankController(Tank tank, KeyEventListenerCop kel,Colisionador colisionador)
	{
		this.tank = tank;
		this.listenerCop = kel;
		this.colisionador = colisionador;
	}
	
	public boolean hayColisionConUnObjeto(List<ObjetoGrafico> lista)
	{
		boolean ret = false;
		for(ObjetoGrafico obj : lista)
		{
			ret = ret || tank.getStateMove().hayColision(obj); // dependiendo el estado va atener una colision !=
		}
		return ret;
	}
	
	public void ControlTank(List<ObjetoGrafico> objetos)
	{
		if(listener.existeEstadoDeMovimiento())
		{
			tank.setStateMove(listener.getEstado());			
			tank.girar(tank.getStateMove().getOrientacion());
			if(!hayColisionConUnObjeto(objetos))
			{
				tank.getStateMove().control();
				listener.borrarEstado();
			}
		}
		if(listener.seActivoDisparo() && !tank.existeDisparoEnEjecucion())
		{
			Sonido.TanqueDisparo.stop();
			Sonido.TanqueDisparo.play();
			this.tank.disparar();
		}
	}
	
	public void ControlTankCop(List<ObjetoGrafico> objetos)
	{
		if(listenerCop.existeEstadoDeMovimiento())
		{
			tank.setStateMove(listenerCop.getEstado());			
			tank.girar(tank.getStateMove().getOrientacion());
			if(!hayColisionConUnObjeto(objetos))
			{
				tank.getStateMove().control();
				listenerCop.borrarEstado();
			}
		}
		if(listenerCop.seActivoDisparo() && !tank.existeDisparoEnEjecucion())
		{
			Sonido.TanqueDisparo.stop();
			Sonido.TanqueDisparo.play();
			this.tank.disparar();
		}
	}
	
//	private void ControlCpu(Orientation direction)
//	{
//		if(direction.equals(Orientation.UP))
//			ControlUp();
//		if(direction.equals(Orientation.DOWN))
//			ControlDown();
//		if(direction.equals(Orientation.RIGHT))
//			ControlRigth();
//		if(direction.equals(Orientation.LEFT))
//			ControlLeft();
//	}
	private Orientation genDirection()
	{		
		    int pick = new Random().nextInt(Orientation.values().length);
		    return Orientation.values()[pick];
	}
	public void ai()
	{
		Orientation dir = this.genDirection();
		for(int i=0;i<1;i++)
		{
		//	this.ControlCpu(dir);
		}
		//tank.disparar();
	}
	public void control_bullet(Entorno entorno,List<ObjetoGrafico> objetos, List<Tank> enemysTanks){
		if(this.tank.getTankBullet().equals(TankShot.EXISTS)){
			this.tank.getBullet().avanzarBullet();
			entorno.dibujarImagen(Herramientas.cargarImagen("imagen/bala_2.png"), this.tank.getBullet().getCoordinate().getX(), 
					this.tank.getBullet().getCoordinate().getY(), 0);
			if(colisionador.colisionBullet(this.tank.getBullet(), objetos)){
				this.tank.setTankBullet(TankShot.NO_EXISTS);
				this.tank.setBullet(null);
			}
		}
	}

	public Tank getTank() 
	{
		return tank;
	}

	public void setTank(Tank tank)  // si este set no se usa , quitar!
	{
		this.tank = tank;
	}
	
	public void destruirTank(){
		this.tank = null;
	}
}

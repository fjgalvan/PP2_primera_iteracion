package app.object;

import java.awt.Color;
import java.util.List;
import java.util.Random;

import entorno.Entorno;
import entorno.Herramientas;
import app.enums.Orientation;
import app.enums.TankShot;
import app.modelo.ObjetoGrafico;
import app.state_tank.StateMoveTankUp;
import app.util.Util;
import sonido.Sonido;

@SuppressWarnings("unused")
public class TankController {
	private Tank tank;
	private KeyEventListener listener;
	
	public TankController(Tank tank, KeyEventListener kel)
	{
		this.tank = tank;
		this.listener = kel;
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
	public void control_bullet(Entorno entorno,List<ObjetoGrafico> objetos){
		if(this.tank.getTankBullet().equals(TankShot.EXISTS)){
			this.tank.getBullet().avanzarBullet();
			/*entorno.dibujarCirculo(this.tank.getBullet().getCoordinate().getX(), 
					this.tank.getBullet().getCoordinate().getY(), 10, Color.gray);*/
			entorno.dibujarImagen(Herramientas.cargarImagen("imagen/bala_2.png"), this.tank.getBullet().getCoordinate().getX(), 
					this.tank.getBullet().getCoordinate().getY(), 0);
			if(this.tank.getBullet().colisionBullet(objetos)){
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
}

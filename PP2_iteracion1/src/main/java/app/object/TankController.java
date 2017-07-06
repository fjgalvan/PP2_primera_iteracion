package app.object;

import java.awt.Color;
import java.util.*;
import entorno.*;
import app.enums.*;
import app.modelo.*;
import app.state_tank.StateMoveTankUp;
import app.util.Util;
import sonido.Sonido;

@SuppressWarnings("unused")
public class TankController {
	private Tank tank;
	private KeyEventListener listener;
	private Colisionador colisionador;
	private int contTick;

	public TankController(Tank tank, KeyEventListener listener, Colisionador colisionador) {
		this.tank = tank;
		this.listener = listener;
		this.colisionador = colisionador;
	}

	public boolean hayColisionConUnObjeto(List<ObjetoGrafico> lista) {
		boolean ret = false;
		for (ObjetoGrafico obj : lista) {
			// dependiendo del estado va a tener una colision
			if(obj.getClass().getName()!="app.estructura.EstructuraFondo")
				ret = ret || tank.getStateMove().hayColision(obj);
		}
		return ret;
	}

	public void ControlTank(List<ObjetoGrafico> objetos) {
		if (listener.existeEstadoDeMovimiento()) {
			tank.setStateMove(listener.getEstado());
			tank.girar(tank.getStateMove().getOrientacion());
			if (!hayColisionConUnObjeto(objetos)) {
				tank.getStateMove().control();
				listener.borrarEstado();
			}
		}

		if (listener.seActivoDisparo() && !tank.existeDisparoEnEjecucion() && contTick > 30) {
			contTick = 0;
			Sonido.TanqueDisparo.stop();
			Sonido.TanqueDisparo.play();
			this.tank.disparar();
		}
	}

	public void control_bullet(List<ObjetoGrafico> objetos, List<Tank> enemysTanks) {
		if (this.tank.getTankBullet().equals(TankShot.EXISTS)) {
			this.tank.getBullet().avanzarBullet();
			// aca se sibuja la bala
			if (colisionador.colisionBullet(this.tank.getBullet(), objetos)) {
				this.tank.impactBullet();
			}
		}
	}

	public KeyEventListener getListener()
	{
		return listener;
	}
	
	public Tank getTank() {
		return tank;
	}

	public void destruirTank() {
		this.tank = null;
	}

	public int getContTick() {
		return contTick;
	}

	public void setContTick(int contTick) {
		this.contTick = contTick;
	}
}

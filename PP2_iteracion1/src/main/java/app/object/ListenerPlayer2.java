package app.object;

import entorno.Entorno;
import app.state_tank.StateMoveTank;
import app.state_tank.StateMoveTankDown;
import app.state_tank.StateMoveTankLeft;
import app.state_tank.StateMoveTankRight;
import app.state_tank.StateMoveTankUp;

public class ListenerPlayer2 implements IKeyEventListener {
	private Entorno entorno;
	private StateMoveTank estado;

	public ListenerPlayer2(Entorno e) {
		this.entorno = e;
	}

	@Override
	public void inicializar(Tank tanque) {
		if (this.entorno.estaPresionada(entorno.TECLA_S)) {
			this.estado = new StateMoveTankDown(tanque);
		} else if (this.entorno.estaPresionada(entorno.TECLA_W)) {
			this.estado = new StateMoveTankUp(tanque);
		} else if (this.entorno.estaPresionada(entorno.TECLA_D)) {
			this.estado = new StateMoveTankRight(tanque);
		} else if (this.entorno.estaPresionada(entorno.TECLA_A)) {
			this.estado = new StateMoveTankLeft(tanque);
		}
	}

	@Override
	public boolean seActivoDisparo() {
		return entorno.estaPresionada(entorno.TECLA_ESPACIO);
	}

	public StateMoveTank getEstado() {
		return estado;
	}

	public void borrarEstado() {
		this.estado = null;
	}

	public boolean existeEstadoDeMovimiento() {
		return (this.estado != null);
	}

}

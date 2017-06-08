package app.object;

import app.state_tank.*;
import entorno.Entorno;

public class ListenerPlayer1 implements IKeyEventListener {
	private Entorno entorno;
	private StateMoveTank estado;

	public ListenerPlayer1(Entorno e) {
		this.entorno = e;
	}

	@Override
	public void inicializar(Tank tanque) {
		if (this.entorno.estaPresionada(entorno.TECLA_ABAJO)) {
			this.estado = new StateMoveTankDown(tanque);
		} else if (this.entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
			this.estado = new StateMoveTankUp(tanque);
		} else if (this.entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			this.estado = new StateMoveTankRight(tanque);
		} else if (this.entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			this.estado = new StateMoveTankLeft(tanque);
		}
	}

	@Override
	public boolean seActivoDisparo() {
		return entorno.estaPresionada(entorno.TECLA_ENTER);
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

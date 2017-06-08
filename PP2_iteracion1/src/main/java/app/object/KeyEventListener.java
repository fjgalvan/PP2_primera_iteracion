package app.object;

import app.state_tank.StateMoveTank;
import entorno.Entorno;

public abstract class KeyEventListener {
	protected Entorno entorno;
	protected StateMoveTank estado;
	
	public KeyEventListener(Entorno e) {
		this.entorno = e ;
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
	
	abstract public void inicializar(Tank tanque);

	abstract public boolean seActivoDisparo();

}

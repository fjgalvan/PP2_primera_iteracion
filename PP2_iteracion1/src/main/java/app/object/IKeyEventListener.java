package app.object;

import app.state_tank.StateMoveTank;

public interface IKeyEventListener {

	public void inicializar(Tank tanque);

	public boolean seActivoDisparo();
	
	public StateMoveTank getEstado();
	
	public void borrarEstado();
	
	public boolean existeEstadoDeMovimiento();

}

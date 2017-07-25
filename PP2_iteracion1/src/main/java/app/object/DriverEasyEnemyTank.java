package app.object;

import java.util.HashMap;
import app.enums.Orientation;
import app.state_tank.*;

public class DriverEasyEnemyTank extends DriverEnemyTank {
	
	private HashMap<Orientation, StateMoveTank> movimientos;
	
	public DriverEasyEnemyTank() 
	{
		super();
		this.movimientos = new HashMap<Orientation, StateMoveTank>();
		this.cargarMovimientos();
	}
	
	public DriverEasyEnemyTank(Tank enemyTank) {
		super(enemyTank);
		this.movimientos = new HashMap<Orientation, StateMoveTank>();
		this.cargarMovimientos();
	}

	public void cargarMovimientos()
	{
		this.movimientos.clear();
		this.movimientos.put(Orientation.UP, new StateMoveTankRight());
		this.movimientos.put(Orientation.DOWN, new StateMoveTankLeft());
		this.movimientos.put(Orientation.LEFT, new StateMoveTankUp());
		this.movimientos.put(Orientation.RIGHT, new StateMoveTankDown());
	}
	
	@Override
	public void setNextStateMoveTank()
	{
		StateMoveTank aux = movimientos.get(enemyTank.getOrientation());
		aux.setTank(enemyTank);
		this.enemyTank.setStateMove(aux);
	}
}

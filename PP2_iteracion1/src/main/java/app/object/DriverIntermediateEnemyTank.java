package app.object;

import java.util.*;
import java.util.Random;
import app.enums.Orientation;
import app.state_tank.*;

public class DriverIntermediateEnemyTank extends DriverEnemyTank {

	private HashMap<Orientation, StateMoveTank> movimientos	= new HashMap<Orientation, StateMoveTank>();;
	private Random generador = new Random();
		
	public DriverIntermediateEnemyTank() 
	{
		super();
		this.cargarMovimientos();
	}
	
	public DriverIntermediateEnemyTank(Tank enemyTank) {
		super(enemyTank);
		this.cargarMovimientos();
	}

	public void cargarMovimientos()
	{
		this.movimientos.clear();
		this.movimientos.put(Orientation.RIGHT, new StateMoveTankRight());
		this.movimientos.put(Orientation.LEFT, new StateMoveTankLeft());
		this.movimientos.put(Orientation.UP, new StateMoveTankUp());
		this.movimientos.put(Orientation.DOWN, new StateMoveTankDown());
	}

	@Override
	public void setNextStateMoveTank() 
	{
		/*** RANDOM GIRO ***/
		Orientation azar = Orientation.values()[generador.nextInt(Orientation.values().length)];
		StateMoveTank aux = this.movimientos.get(azar);
		aux.setTank(enemyTank);
		enemyTank.setStateMove(aux);
	}
	
}
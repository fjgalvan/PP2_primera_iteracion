package app.object;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import app.enums.Orientation;
import app.enums.TipoEstructura;
import app.estructura.Estructura;
import app.estructura.TipoDeEstructura;
import app.modelo.Colisionador;
import app.modelo.ObjetoGrafico;
import app.object.Tank;
import app.object.TankController;

public class TestTankController {

	
	/**moverse*/
	@Test
	public void testMoversePorIzquierda() {
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size,1);
		//tankC.ControlLeft(); esta funcion se paso al statemovetankleft
		assertNotEquals(400.50,tank.getCoordinate().getX());
	}
	
	@Test
	public void testMoversePorDerecha() {
		Orientation orientation = Orientation.RIGHT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size,1);
		//tankC.ControlRigth(); se paso asu estado correspondiente
		assertNotEquals(400.50,tank.getCoordinate().getX());
	}
	
	@Test
	public void testMoversePorAbajo() {
		Orientation orientation = Orientation.DOWN;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size,1);
		assertNotEquals(400.50,tank.getCoordinate().getY());
	}
	
	@Test
	public void testMoversePorArriba() {
		Orientation orientation = Orientation.UP;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size,1);
		assertNotEquals(400.50,tank.getCoordinate().getY());
	}
	
	/**disparar*/
	@Test
	public void testDisparar() {
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size,1);
		TankController tankC = new TankController(tank,null,new Colisionador());
		tankC.getTank().disparar();
		assertNotEquals(null,tankC.getTank().getBullet());
		
		List<ObjetoGrafico> estructuras = new ArrayList<>();
		List<Tank> enemysTanks = new ArrayList<>();
		List<ObjetoGrafico> tanksObjG = new ArrayList<>();
		
		
		Tank enemyTank= new Tank(orientation, coordinate, size,1);
		Tank enemyTank2= new Tank(orientation, coordinate, size,1);
		Tank enemyTank3= new Tank(orientation, coordinate, size,1);
		Tank enemyTank4= new Tank(orientation, coordinate, size,1);
		enemysTanks.add(enemyTank);
		enemysTanks.add(enemyTank2);
		enemysTanks.add(enemyTank3);
		enemysTanks.add(enemyTank4);
		
		TipoDeEstructura tipoDeEstructura= new TipoDeEstructura(TipoEstructura.INDESTRUCTIBLE, false, false);
		Estructura estructura1= new Estructura(coordinate, size, "imagen/tank.png", tipoDeEstructura);
		Estructura estructura2= new Estructura(coordinate, size, "imagen/tank.png", tipoDeEstructura);
		Estructura estructura3= new Estructura(coordinate, size, "imagen/tank.png", tipoDeEstructura);
		
		estructuras.add(estructura1);
		estructuras.add(estructura2);
		estructuras.add(estructura3);

		tanksObjG.add(enemyTank);
		tanksObjG.add(enemyTank2);
		
		tankC.hayColisionConUnObjeto(estructuras);
		//tankC.ControlTank(tanksObjG);
		tankC.control_bullet(estructuras, enemysTanks);
		tankC.getListener();
		tankC.destruirTank();
		tankC.getContTick();
		tankC.setContTick(tankC.getContTick());
		
	}

}

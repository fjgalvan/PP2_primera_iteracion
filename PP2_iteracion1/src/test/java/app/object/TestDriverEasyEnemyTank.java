package app.object;

import static org.junit.Assert.assertNotEquals;

import java.awt.Point;
import org.junit.Test;
import app.enums.Orientation;
import app.modelo.Colisionador;

public class TestDriverEasyEnemyTank {
	
	/**moverse*/
	@Test
	public void testMoversePorIzquierda() {
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size,1);
		//TankController tankC = new TankController(tank,null); // ver como meter el entorno con la otra clase
		//tankC.ControlLeft(); esta funcion se paso al statemovetankleft
		assertNotEquals(400.50,tank.getCoordinate().getX());
	}
	
	@Test
	public void testMoversePorDerecha() {
		Orientation orientation = Orientation.RIGHT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank enemyTank = new Tank(orientation, coordinate, size,1);
		//TankController tankC = new TankController(enemyTank, null);
		//tankC.ControlRigth(); se paso asu estado correspondiente
		assertNotEquals(400.50,enemyTank.getCoordinate().getX());
	}
	
	@Test
	public void testMoversePorAbajo() {
		Orientation orientation = Orientation.DOWN;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank enemyTank = new Tank(orientation, coordinate, size,1);
	//	TankController tankC = new TankController(enemyTank,null);
	//	tankC.ControlDown(); se paso asu estado correspondiente
		assertNotEquals(400.50,enemyTank.getCoordinate().getY());
	}
	
	@Test
	public void testMoversePorArriba() {
		Orientation orientation = Orientation.UP;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank enemyTank = new Tank(orientation, coordinate, size,1);
		//TankController tankC = new TankController(enemyTank,null);
		//tankC.ControlUp(); se paso asu estado correspondiente
		assertNotEquals(400.50,enemyTank.getCoordinate().getY());
	}
	
	/**disparar*/
	@Test
	public void testDisparar() {
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank enemyTank = new Tank(orientation, coordinate, size,1);
		TankController tankC = new TankController(enemyTank,null,new Colisionador());//new KeyEventListener(new Entorno(null, null, 0, 0))
		tankC.getTank().disparar();
		assertNotEquals(null,tankC.getTank().getBullet());
	}
	
	/**girar cuando choca con el limite del mapa -inicio- **/
	/*@Test
	public void testControlChoqueArribaMap(){
		Orientation orientation = Orientation.UP;
		Point coordinate = new Point(400, 50);//(400, 26);
		Point size = new Point(40, 40);
		Tank enemyTank = new Tank(orientation, coordinate, size,1);
		//DriverEasyEnemyTank enemyTankC= new DriverEasyEnemyTank(enemyTank);
		while(enemyTank.getOrientation().equals(Orientation.UP)){
			enemyTank.moverse(orientation);
			
		}
		
		assertNotEquals(orientation, enemyTank.getOrientation());
		//assertNotEquals(26.0, enemyTankC.getTank().getCoordinate().getY());
		//System.out.println("Y ARRIBA: "+enemyTankC.getTank().getCoordinate().getY());
	}
	
	@Test
	public void testControlChoqueDerechaMap(){
		Orientation orientation = Orientation.RIGHT;
		Point coordinate = new Point(900,400);//(943, 400);
		Point size = new Point(40, 40);
		Tank enemyTank = new Tank(orientation, coordinate, size,1);
		//DriverEasyEnemyTank enemyTankC= new DriverEasyEnemyTank(enemyTank);
		System.out.println("Orientacion Antes del limite: "+enemyTank.getOrientation());
		while(enemyTank.getOrientation().equals(Orientation.RIGHT)){
			enemyTank.moverse(orientation);
			
		}
		assertNotEquals(orientation, enemyTank.getOrientation());
	}
	
	@Test
	public void testControlChoqueAbajoMap(){
		Orientation orientation = Orientation.DOWN;
		Point coordinate = new Point(400,500);//(400, 544);
		Point size = new Point(40, 40);
		Tank enemyTank = new Tank(orientation, coordinate, size,1);
		//DriverEasyEnemyTank enemyTankC= new DriverEasyEnemyTank(enemyTank);
		while(enemyTank.getOrientation().equals(Orientation.DOWN)){
			enemyTank.moverse(orientation);
			
		}
		assertNotEquals(orientation, enemyTank.getOrientation());
	}
	
	@Test
	public void testControlChoqueIzquierdaMap(){
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(50,400);//(28, 400);
		Point size = new Point(40, 40);
		Tank enemyTank = new Tank(orientation, coordinate, size,1);
		//DriverEasyEnemyTank enemyTankC= new DriverEasyEnemyTank(enemyTank);
		while(enemyTank.getOrientation().equals(Orientation.LEFT)){
			enemyTank.moverse(orientation);
			
		}
		assertNotEquals(orientation, enemyTank.getOrientation());
	}*/
	/**girar cuando choca con el limite del mapa -fin- **/
	
	
	
}

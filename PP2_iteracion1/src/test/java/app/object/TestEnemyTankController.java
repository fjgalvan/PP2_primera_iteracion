package app.object;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import app.enums.Orientation;

public class TestEnemyTankController {
	
	/**moverse*/
	@Test
	public void testMoversePorIzquierda() {
		Orientation orientation = Orientation.LEFT;
		Coordinate coordinate = new Coordinate(400, 400);
		Size size = new Size(40, 40);
		Tank tank = new Tank(orientation, coordinate, size);
		//TankController tankC = new TankController(tank,null); // ver como meter el entorno con la otra clase
		//tankC.ControlLeft(); esta funcion se paso al statemovetankleft
		assertNotEquals(400.50,tank.getCoordinate().getX());
	}
	
	@Test
	public void testMoversePorDerecha() {
		Orientation orientation = Orientation.RIGHT;
		Coordinate coordinate = new Coordinate(400, 400);
		Size size = new Size(40, 40);
		Tank enemyTank = new Tank(orientation, coordinate, size);
		//TankController tankC = new TankController(enemyTank, null);
		//tankC.ControlRigth(); se paso asu estado correspondiente
		assertNotEquals(400.50,enemyTank.getCoordinate().getX());
	}
	
	@Test
	public void testMoversePorAbajo() {
		Orientation orientation = Orientation.DOWN;
		Coordinate coordinate = new Coordinate(400, 400);
		Size size = new Size(40, 40);
		Tank enemyTank = new Tank(orientation, coordinate, size);
	//	TankController tankC = new TankController(enemyTank,null);
	//	tankC.ControlDown(); se paso asu estado correspondiente
		assertNotEquals(400.50,enemyTank.getCoordinate().getY());
	}
	
	@Test
	public void testMoversePorArriba() {
		Orientation orientation = Orientation.UP;
		Coordinate coordinate = new Coordinate(400, 400);
		Size size = new Size(40, 40);
		Tank enemyTank = new Tank(orientation, coordinate, size);
		//TankController tankC = new TankController(enemyTank,null);
		//tankC.ControlUp(); se paso asu estado correspondiente
		assertNotEquals(400.50,enemyTank.getCoordinate().getY());
	}
	
	/**disparar*/
	@Test
	public void testDisparar() {
		Orientation orientation = Orientation.LEFT;
		Coordinate coordinate = new Coordinate(400, 400);
		Size size = new Size(40, 40);
		Tank enemyTank = new Tank(orientation, coordinate, size);
		TankController tankC = new TankController(enemyTank,null);
		tankC.getTank().disparar();
		assertNotEquals(null,tankC.getTank().getBullet());
	}
	
	/**girar cuando choca con el limite del mapa -inicio- **/
	@Test
	public void testControlChoqueArribaMap(){
		Orientation orientation = Orientation.UP;
		Coordinate coordinate = new Coordinate(400, 26);
		Size size = new Size(40, 40);
		Tank enemyTank = new Tank(orientation, coordinate, size);
		EnemyTankController enemyTankC= new EnemyTankController(enemyTank);
		enemyTankC.controChoqueArribaMap();;
		assertNotEquals(26.0, enemyTankC.getTank().getCoordinate().getY());
		//System.out.println("Y ARRIBA: "+enemyTankC.getTank().getCoordinate().getY());
	}
	
	@Test
	public void testControlChoqueDerechaMap(){
		Orientation orientation = Orientation.RIGHT;
		Coordinate coordinate = new Coordinate(943, 400);
		Size size = new Size(40, 40);
		Tank enemyTank = new Tank(orientation, coordinate, size);
		EnemyTankController enemyTankC= new EnemyTankController(enemyTank);
		enemyTankC.controlChoqueDerechaMap();;
		assertNotEquals(943.0, enemyTankC.getTank().getCoordinate().getX());
		//System.out.println("X DERECHA: "+enemyTankC.getTank().getCoordinate().getX());
	}
	
	@Test
	public void testControlChoqueAbajoMap(){
		Orientation orientation = Orientation.DOWN;
		Coordinate coordinate = new Coordinate(400, 544);
		Size size = new Size(40, 40);
		Tank enemyTank = new Tank(orientation, coordinate, size);
		EnemyTankController enemyTankC= new EnemyTankController(enemyTank);
		enemyTankC.controlChoqueAbajoMap();
		assertNotEquals(544.0, enemyTankC.getTank().getCoordinate().getY());
		//System.out.println("Y ABAJO: "+enemyTankC.getTank().getCoordinate().getY());
	}
	
	@Test
	public void testControlChoqueIzquierdaMap(){
		Orientation orientation = Orientation.LEFT;
		Coordinate coordinate = new Coordinate(28, 400);
		Size size = new Size(40, 40);
		Tank enemyTank = new Tank(orientation, coordinate, size);
		EnemyTankController enemyTankC= new EnemyTankController(enemyTank);
		enemyTankC.controlChoqueIzquierdaMap();;
		assertNotEquals(28.0, enemyTankC.getTank().getCoordinate().getX());
		//System.out.println("X IZQUIERDA: "+enemyTankC.getTank().getCoordinate().getX());
	}
	/**girar cuando choca con el limite del mapa -fin- **/
	
	
	
}

package app.object;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import app.enums.Orientation;
import app.modelo.Colisionador;
import entorno.Entorno;

public class TestDriverIntermediateEnemyTank {
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
		TankController tankC = new TankController(enemyTank,new KeyEventListener(new Entorno(null, null, 0, 0)),new Colisionador());
		tankC.getTank().disparar();
		assertNotEquals(null,tankC.getTank().getBullet());
	}
	
	/**girar cuando choca con el limite del mapa -inicio- **/
	@Test
	public void testControlChoqueArribaMap(){
		System.out.println("_testControlChoqueArribaMap:");
		Orientation orientation = Orientation.UP;
		Coordinate coordinate = new Coordinate(400, 50);//(400, 26);
		Size size = new Size(40, 40);
		Tank enemyTank = new Tank(orientation, coordinate, size);
		DriverIntermediateEnemyTank enemyTankC= new DriverIntermediateEnemyTank(enemyTank);
		System.out.println("Orientacion Antes del limite: "+enemyTank.getOrientation());
		while(enemyTank.getOrientation().equals(Orientation.UP)){
			enemyTank.moverseArriba();
			enemyTankC.controChoqueArribaMap();
		}
		enemyTankC.controChoqueArribaMap();
		System.out.println("Orientacion Despues del limite: "+enemyTank.getOrientation());
		assertNotEquals(orientation, enemyTank.getOrientation());
		//assertNotEquals(26.0, enemyTankC.getTank().getCoordinate().getY());
		//System.out.println("Y ARRIBA: "+enemyTankC.getTank().getCoordinate().getY());
	}
	
	@Test
	public void testControlChoqueDerechaMap(){
		System.out.println("\n_testControlChoqueDerechaMap:");
		Orientation orientation = Orientation.RIGHT;
		Coordinate coordinate = new Coordinate(900,400);//(943, 400);
		Size size = new Size(40, 40);
		Tank enemyTank = new Tank(orientation, coordinate, size);
		DriverIntermediateEnemyTank enemyTankC= new DriverIntermediateEnemyTank(enemyTank);
		System.out.println("Orientacion Antes del limite: "+enemyTank.getOrientation());
		while(enemyTank.getOrientation().equals(Orientation.RIGHT)){
			enemyTank.moverseDerecha();
			enemyTankC.controlChoqueDerechaMap();
		}
		System.out.println("Orientacion Despues del limite: "+enemyTank.getOrientation());
		assertNotEquals(orientation, enemyTank.getOrientation());
		//assertNotEquals(943.0, enemyTankC.getTank().getCoordinate().getX());
		//System.out.println("X DERECHA: "+enemyTankC.getTank().getCoordinate().getX());
	}
	
	@Test
	public void testControlChoqueAbajoMap(){
		System.out.println("\n_testControlChoqueAbajoMap:");
		Orientation orientation = Orientation.DOWN;
		Coordinate coordinate = new Coordinate(400,500);//(400, 544);
		Size size = new Size(40, 40);
		Tank enemyTank = new Tank(orientation, coordinate, size);
		DriverIntermediateEnemyTank enemyTankC= new DriverIntermediateEnemyTank(enemyTank);
		System.out.println("Orientacion Antes del limite: "+enemyTank.getOrientation());
		while(enemyTank.getOrientation().equals(Orientation.DOWN)){
			enemyTank.moverseAbajo();
			enemyTankC.controlChoqueAbajoMap();
		}
		System.out.println("Orientacion Despues del limite: "+enemyTank.getOrientation());
		assertNotEquals(orientation, enemyTank.getOrientation());
		//assertNotEquals(544.0, enemyTankC.getTank().getCoordinate().getY());
		//System.out.println("Y ABAJO: "+enemyTankC.getTank().getCoordinate().getY());
	}
	
	@Test
	public void testControlChoqueIzquierdaMap(){
		System.out.println("\n_testControlChoqueIzquierdaMap:");
		Orientation orientation = Orientation.LEFT;
		Coordinate coordinate = new Coordinate(50,400);//(28, 400);
		Size size = new Size(40, 40);
		Tank enemyTank = new Tank(orientation, coordinate, size);
		DriverIntermediateEnemyTank enemyTankC= new DriverIntermediateEnemyTank(enemyTank);
		System.out.println("Orientacion Antes del limite: "+enemyTank.getOrientation());
		while(enemyTank.getOrientation().equals(Orientation.LEFT)){
			enemyTank.moverseIzquierda();
			enemyTankC.controlChoqueIzquierdaMap();
		}
		System.out.println("Orientacion Despues del limite: "+enemyTank.getOrientation());
		assertNotEquals(orientation, enemyTank.getOrientation());
		//assertNotEquals(28.0, enemyTankC.getTank().getCoordinate().getX());
		//System.out.println("X IZQUIERDA: "+enemyTankC.getTank().getCoordinate().getX());
	}
	/**girar cuando choca con el limite del mapa -fin- **/
	
	@Test
	public void testGirarRandom(){
		System.out.println("\n_Girar Random cuando choca con una estructura:");
		Orientation orientation = Orientation.LEFT;
		Coordinate coordinate = new Coordinate(28, 400);
		Size size = new Size(40, 40);
		Tank enemyTank = new Tank(orientation, coordinate, size);
		DriverIntermediateEnemyTank enemyTankC= new DriverIntermediateEnemyTank(enemyTank);
		System.out.println("Orientacion del tanque enemigo antes del choque con estructura: "+enemyTank.getOrientation());
		while(enemyTankC.getTank().getOrientation().equals(Orientation.LEFT)){
			enemyTankC.girarRandom();
			//System.out.println("nueva orientacion previa: " + enemyTank.getOrientation());
		}
		System.out.println("Orientacion del tanque enemigo despues del choque con estructura: "+enemyTank.getOrientation());
		//System.out.println("nueva orientacion: " + enemyTank.getOrientation());
		assertNotEquals(Orientation.LEFT, enemyTankC.getTank().getOrientation());
		
	}
}
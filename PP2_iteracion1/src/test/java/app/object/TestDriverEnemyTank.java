package app.object;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import app.enums.Orientation;
import app.enums.TipoEstructura;
import app.estructura.Estructura;
import app.estructura.TipoDeEstructura;
import app.modelo.ObjetoGrafico;
import app.state_tank.StateMoveTank;
import entorno.Entorno;

public class TestDriverEnemyTank {
	
	@Test
	public void testIniciar() {
		//Entorno entorno = new Entorno(null, null, 0, 0);
		//StateMoveTank estado;
		//ListenerPlayer1 lp1= new ListenerPlayer1(entorno);
		
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size, 2);
		Tank tank2 = new Tank(Orientation.RIGHT, coordinate, size, 2);
		DriverEasyEnemyTank driver= new DriverEasyEnemyTank();
		
		List<ObjetoGrafico> objetos= new ArrayList<>(); 
		
		TipoDeEstructura tipo= new TipoDeEstructura(TipoEstructura.DESTRUCTIBLE, false, false);
		Estructura est= new Estructura(coordinate, size, "src/main/java/imagen/tank.png", tipo);
		
		objetos.add(est);
		
		List<ObjetoGrafico> objetosTank= new ArrayList<>();
		objetosTank.add(tank);
		objetosTank.add(tank2);
		
		//driver.ControlEnemyTank(entorno, objetos);
		//driver.controlDisparoTankEnemy(objetos);
		/*driver.control_bullet(objetos);
		driver.hayColisionConUnObjeto(objetos);
		driver.ControlTank(objetos);
		driver.setNextStateMoveTank();
		driver.getEnemyTank();
		driver.setEnemyTank(driver.getEnemyTank());
		driver.destruirTank();
		driver.getContTick();
		driver.setContTick(driver.getContTick());*/
	}
}

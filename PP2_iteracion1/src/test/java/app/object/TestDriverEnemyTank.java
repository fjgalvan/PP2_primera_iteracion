package app.object;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import app.enums.Orientation;
import app.enums.TankShot;
import app.enums.TipoEstructura;
import app.estructura.Estructura;
import app.estructura.TipoDeEstructura;
import app.modelo.Colisionador;
import app.modelo.ObjetoGrafico;
import app.state_tank.StateMoveTank;
import entorno.Entorno;
import entorno.InterfaceJuego;

public class TestDriverEnemyTank {
	
	@Test
	public void testIniciar() {
		InterfaceJuego juego= new InterfaceJuego();
		//Entorno(InterfaceJuego juego, String titulo, int ancho, int alto)
		Entorno entorno = new Entorno(juego, "tank", 30, 30);
		//StateMoveTank estado;
		//ListenerPlayer1 lp1= new ListenerPlayer1(entorno);
		
		Orientation orientation = Orientation.LEFT;
		Point coordinate = new Point(400, 400);
		Point size = new Point(40, 40);
		Tank tank = new Tank(orientation, coordinate, size, 2);
		Tank tank2 = new Tank(Orientation.RIGHT, coordinate, size, 2);
		DriverEasyEnemyTank driver= new DriverEasyEnemyTank();
		tank.disparar();
		tank2.disparar();
		TankShot tankShot= TankShot.EXISTS;
		tank.setTankBullet(tankShot);
		System.out.println(tank.getTankBullet());
		
		
		List<ObjetoGrafico> objetos= new ArrayList<>(); 
		Colisionador colisionador= new Colisionador();
		colisionador.bulletChocaConEstructura(tank, tank2);
		driver.setColisionador(colisionador);
		
		TipoDeEstructura tipo= new TipoDeEstructura(TipoEstructura.DESTRUCTIBLE, false, false);
		Estructura est= new Estructura(coordinate, size, "src/main/java/imagen/tank.png", tipo);
		
		objetos.add(est);
		
		List<ObjetoGrafico> objetosTank= new ArrayList<>();
		objetosTank.add(tank);
		objetosTank.add(tank2);
		
		Orientation orientation1 = Orientation.LEFT;
		Point coordinate2222 = new Point(50, 579);
		Bullet bala= new Bullet(orientation1, coordinate2222, coordinate2222);
		bala.avanzarBullet();
		List<ObjetoGrafico> objetosBullet= new ArrayList<>();
		objetosBullet.add(bala);
		
		
		driver.setEnemyTank(tank);
		driver.getEnemyTank();
		
		driver.ControlEnemyTank(entorno, objetos);
		//driver.control_bullet(objetosTank);
		driver.hayColisionConUnObjeto(objetos);
		driver.ControlTank(objetos);
		driver.setNextStateMoveTank();
		driver.destruirTank();
		driver.getContTick();
		driver.setContTick(driver.getContTick());
	}
}

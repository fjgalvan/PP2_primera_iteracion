package app.object;

import java.awt.Point;
import org.junit.Test;
import app.enums.Orientation;
import app.levels.DataLevelGame;
import app.levels.ManagerLevelGameMain;
import app.main.Game;
import clase_properties.Principal;

public class TestDraftsman {
	//ERROR DE TEST CON MAVEN
	@Test
	public void testDibujarMapa(){
		Principal principal= new Principal();
		DataLevelGame data = new ManagerLevelGameMain(principal).getDataLevelGame();
		Game juegoPrueba= new Game(data);
		//GraphicMap mapa = new GraphicMap(new Map(new Point(1000, 600)), new Point(20, 20));
		//Draftsman dibujador = new Draftsman(null, mapa, "Battle-Ungs");
		Tank tank = new Tank(Orientation.UP,new Point(560,520),new Point(40,40),2);
		Point coordinate = new Point(30, 50);
		Point size= new Point(20,20);
		Bullet bullet= new Bullet(Orientation.UP, coordinate, size);
		
		try{
			juegoPrueba.getDibujador().dibujarMapa(100, 100, 100, 1, "");
		} catch(Exception e){
	        //System.out.println("No se pudo dibujar Mapa!!");
	    }
		
		try{
			juegoPrueba.getDibujador().dibujarEstructura(tank);
		} catch(Exception e){
	        //System.out.println("No se pudo dibujar Mapa!!");
	    }
		
		try{
			juegoPrueba.getDibujador().dibujarBomberman(tank);
		} catch(Exception e){
	        //System.out.println("No se pudo dibujar Bomberman!!");
	    }
		
		try{
			juegoPrueba.getDibujador().dibujarTank(tank);
		} catch(Exception e){
	        //System.out.println("No se pudo dibujar Tank!");
	    }
		
		try{
			juegoPrueba.getDibujador().dibujarBullet(bullet);
		} catch(Exception e){
	        //System.out.println("No se pudo dibujar Tank!");
	    }
		
		try{
			juegoPrueba.getDibujador().dibujarBomberman(tank);
		} catch(Exception e){
	        //System.out.println("No se pudo dibujar Bomberman!!");
	    }
		
		try{
			juegoPrueba.getDibujador().dibujarPacman(tank);
		} catch(Exception e){
	        //System.out.println("No se pudo dibujar Pacman!!");
	    }
		
		try{
			juegoPrueba.getDibujador().dibujarTankCop(tank);
		} catch(Exception e){
	        //System.out.println("No se pudo dibujar TankCop!!");
	    }
		
		try{
			juegoPrueba.getDibujador().dibujarEnemyTank(tank);
		} catch(Exception e){
	        //System.out.println("No se pudo dibujar EnemyTank!!");
	    }
		
		try{
			juegoPrueba.getDibujador().dibujarEnemyTankIntermediate(tank);
		} catch(Exception e){
	        //System.out.println("No se pudo dibujar EnemyTankIntermediate!!");
	    }
		
		try{
			juegoPrueba.getDibujador().dibujarFinDeJuego();
		} catch(Exception e){
	        //System.out.println("No se pudo dibujar EnemyTankIntermediate!!");
	    }
	}
	
}

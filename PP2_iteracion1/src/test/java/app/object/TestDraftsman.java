package app.object;

import org.junit.Test;

import app.enums.Orientation;
import app.main.Game;
import entorno.Entorno;

public class TestDraftsman {
	private Entorno entorno;
	
	@Test
	public void testDibujarMapa(){
		Game juegoPrueba= new Game();
		GraphicMap mapa = new GraphicMap(new Map(new Size(1000, 600)), new Size(20, 20));
		juegoPrueba.getClass();
		Tank tank= tank = new Tank(Orientation.UP,new Coordinate(560,520),new Size(40,40),new Energy(2));
		Coordinate coordinate = new Coordinate(30, 50);
		Size size= new Size(20,20);
		try{
			juegoPrueba.getMapa();
		} catch(Exception e){
	        //System.out.println("No se pudo dibujar Mapa!!");
	    }
		
		try{
			juegoPrueba.getDibujador().dibujarMapa(100, 100, 100, 1, "");
		} catch(Exception e){
	        //System.out.println("No se pudo dibujar Mapa!!");
	    }
		
		try{
			juegoPrueba.getDibujador().dibujarBomberman(tank);
		} catch(Exception e){
	        //System.out.println("No se pudo dibujar Bomberman!!");
	    }
		
		
		try{
		juegoPrueba.getDibujador().dibujarImagen("imagen/bala_2.png", coordinate);
		} catch(Exception e){
	        //System.out.println("No se pudo dibujar Imagen1!!");
	    }
		
		try{
		juegoPrueba.getDibujador().dibujarImagen("imagen/bala_2.png", coordinate, 0);
		} catch(Exception e){
	        //System.out.println("No se pudo dibujar Imagen2!!");
	    }
		
		try{
		juegoPrueba.getDibujador().dibujarRectangulo(coordinate, size, 0, null);
		} catch(Exception e){
	        //System.out.println("No se pudo dibujar Rectangulo!!");
	    }
		
		try{
		juegoPrueba.getDibujador().dibujarCirculo(coordinate, 20, null);
		} catch(Exception e){
	        //System.out.println("No se pudo dibujar Circulo!!");
	    }
		
		try{
		juegoPrueba.getDibujador().dibujarTank(tank);
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
	}
	
}

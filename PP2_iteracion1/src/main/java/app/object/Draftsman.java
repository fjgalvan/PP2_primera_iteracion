package app.object;

import java.awt.*;
import app.enums.Orientation;
import app.modelo.ObjetoGrafico;
import entorno.*;

public class Draftsman {
	private Entorno entorno;

	public Draftsman(InterfaceJuego i, GraphicMap gm, String title) {
		this.dibujarEscenario(i, gm, title);
	}

	public void dibujarEscenario(InterfaceJuego i, GraphicMap gm, String title) 
	{
		this.entorno = new Entorno(i, title, (int) gm.getSize().getX(), (int) gm.getSize().getY());
		Configuracion.ENTORNO = entorno;
	}

	public void dibujarMapa(int tamañoDeTiles, int altoMapa, int anchoMapa, int lugarDelSprite, String imagen) {
		int contador = 0;
		for (int y = 0; y < altoMapa; y++) {
			for (int x = 0; x < anchoMapa; x++) {
				contador = contador + 1;
				if (contador != lugarDelSprite) {
					this.entorno.dibujarImagen(Herramientas.cargarImagen(imagen), x * tamañoDeTiles, y * tamañoDeTiles,
							0);
				}
			}
		}
	}

	public void dibujarMarco(GraphicMap gm) {
		Color color = Color.GRAY;
		// linea de arriba y de lado izquierdo
		this.entorno.dibujarRectangulo(10, 10, gm.getSizeMarco().getX(), gm.getSize().getY() * 2, 0, color);
		this.entorno.dibujarRectangulo(10, 10, gm.getSize().getX() * 2, gm.getSizeMarco().getY(), 0, color);
		// linea de abajo y lado derecho
		this.entorno.dibujarRectangulo(gm.getSize().getX(), 0, gm.getSizeMarco().getX(), gm.getSize().getY() * 2 + 20,
				0, color);
		this.entorno.dibujarRectangulo(10, gm.getSize().getY(), gm.getSize().getX() * 2, gm.getSizeMarco().getY(), 0,
				color);
	}

	public void dibujarEstructura(ObjetoGrafico e) {
		this.entorno.dibujarImagen(Herramientas.cargarImagen(e.getImagen()),
				e.getCoordinate().getX() + (e.getSize().getX() / 2), e.getCoordinate().getY() + e.getSize().getY() / 2,
				0);
	}

	public void dibujarTank(Tank t) {
		if(t!=null)
		{
			if (t.getEnergyVal() == 1) {
				this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/TankA1.png"),
						t.getCoordinate().getX() + (t.getSize().getX() / 2),
						t.getCoordinate().getY() + t.getSize().getY() / 2, t.getAngulo(), 2);
			} else if (t.getEnergyVal() == 2) {
				this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/TankA2.png"),
						t.getCoordinate().getX() + (t.getSize().getX() / 2),
						t.getCoordinate().getY() + t.getSize().getY() / 2, t.getAngulo(), 2);
			}
		}
	}
	
	public void dibujarBullet(Bullet bullet)
	{
		entorno.dibujarImagen(Herramientas.cargarImagen("imagen/bala_2.png"), bullet.getCoordinate().getX(), bullet.getCoordinate().getY(), 0);
	}
	
	public void dibujarTankCop(Tank t) {
		if (t.getEnergyVal() == 1) {
			this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/TankB1.png"),
					t.getCoordinate().getX() + (t.getSize().getX() / 2),
					t.getCoordinate().getY() + t.getSize().getY() / 2, t.getAngulo(), 2);
		} else if (t.getEnergyVal() == 2) {
			this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/TankB2.png"),
					t.getCoordinate().getX() + (t.getSize().getX() / 2),
					t.getCoordinate().getY() + t.getSize().getY() / 2, t.getAngulo(), 1);
		}
	}

	/**/public void dibujarEnemyTank(Tank t) {
		if(t!=null)
		{
			if (t.getEnergyVal() == 1) {
				this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/Enemy1.png"),
						t.getCoordinate().getX() + (t.getSize().getX() / 2),
						t.getCoordinate().getY() + t.getSize().getY() / 2, t.getAngulo(), 2);
			} else if (t.getEnergyVal() == 2) {
				this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/Enemy2.png"),
						t.getCoordinate().getX() + (t.getSize().getX() / 2),
						t.getCoordinate().getY() + t.getSize().getY() / 2, t.getAngulo(), 2);
			}
		}
	}

	/**/public void dibujarEnemyTankIntermediate(Tank t) {
		if (t.getEnergyVal() == 1) {
			this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/enemyB1.png"),
					t.getCoordinate().getX() + (t.getSize().getX() / 2),
					t.getCoordinate().getY() + t.getSize().getY() / 2, t.getAngulo(), 2);
		} else if (t.getEnergyVal() == 2) {
			this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/enemyB2.png"),
					t.getCoordinate().getX() + (t.getSize().getX() / 2),
					t.getCoordinate().getY() + t.getSize().getY() / 2, t.getAngulo(), 2);
		}
	}

	public void dibujarBomberman(Tank t){
		if(t.getOrientation().equals(Orientation.UP))
			this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/bombermanUP.png"), t.getCoordinate().getX()+(t.getSize().getX()/2), t.getCoordinate().getY()+t.getSize().getY()/2, t.getAngulo(),2);
		if(t.getOrientation().equals(Orientation.DOWN))
			this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/bombermanDOWN.png"), t.getCoordinate().getX()+(t.getSize().getX()/2), t.getCoordinate().getY()+t.getSize().getY()/2, 0,2);
		if(t.getOrientation().equals(Orientation.LEFT))
			this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/bombermanLEFT.png"), t.getCoordinate().getX()+(t.getSize().getX()/2), t.getCoordinate().getY()+t.getSize().getY()/2, 0,2);
		if(t.getOrientation().equals(Orientation.RIGHT))
			this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/bombermanRIGHT.png"), t.getCoordinate().getX()+(t.getSize().getX()/2), t.getCoordinate().getY()+t.getSize().getY()/2, 0,2);
	}
	
	public void dibujarFinDeJuego() 
	{
		String mensaje = "GAME OVER";
		this.entorno.cambiarFont("Arial", 70, Color.red);
		this.entorno.escribirTexto(mensaje, this.entorno.ancho() / 2 - 250, this.entorno.alto() / 2 - 75);
		this.entorno.cambiarFont("Arial", 24, Color.green);
		this.entorno.escribirTexto("Puntajes:", 200, 370);
	}

	public void dibujarPuntaje(String nombre, double puntaje, int cantidadDeEnemigosAsesinados, int posicionX,
			int posicionY) {
		String mensaje;
		mensaje = nombre + puntaje + "  Enemigos Destruidos: " + cantidadDeEnemigosAsesinados;
		this.entorno.cambiarFont("Arial", 24, Color.green);
		this.entorno.escribirTexto(mensaje, posicionX, posicionY);
	}

	public Entorno getEntorno() {
		return this.entorno;
	}

	public void dibujarPacman(Tank t) 
	{
		this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/pacman.gif"), t.getCoordinate().getX()+(t.getSize().getX()/2), t.getCoordinate().getY()+t.getSize().getY()/2, t.getAngulo(),1);		
	}

	public void dibujarFantasma(Tank t) 
	{
		this.entorno.dibujarImagen(Herramientas.cargarImagen(Configuracion.IMGFANTASMA), t.getCoordinate().getX()+(t.getSize().getX()/2), t.getCoordinate().getY()+t.getSize().getY()/2,0,1);		
	}
}

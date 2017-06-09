package app.object;

import java.util.List;
import java.util.Random;
import app.enums.Orientation;
import app.modelo.ObjetoGrafico;

public class DriverIntermediateEnemyTank extends DriverEnemyTank {

	public DriverIntermediateEnemyTank(Tank enemyTank) {
		super(enemyTank);
	}

	public void controlChoque() {
		switch(enemyTank.getOrientation()){
			case UP:
				ControlUp();
				if (!CanMoveUp()) {
					girarRandom();
				}
				break;
			case RIGHT:
				ControlRight();
				if (!CanMoveRight()) {
					girarRandom();
				}
				break;
			case DOWN:
				ControlDown();
				if (!CanMoveDown()) {
					girarRandom();
				}
				break;
			case LEFT:
				ControlLeft();
				if (!CanMoveLeft()) {
					girarRandom();
				}
				break;
		}
	}

	public void ControlTank(List<ObjetoGrafico> objetos) {
		if (hayColisionConUnObjeto(objetos)) {

			if (colicionEn(objetos) == 1) {// colicion arriba
				// System.out.println("colicion arriba");
				enemyTank.girar(Orientation.DOWN);
				enemyTank.moverse(Orientation.DOWN);
				enemyTank.girar(Orientation.RIGHT);
				girarRandom();
			}
			if (colicionEn(objetos) == 2) {// colicion derecha
				// System.out.println("colicion derecha");
				enemyTank.girar(Orientation.LEFT);
				enemyTank.moverse(Orientation.LEFT);
				enemyTank.girar(Orientation.DOWN);
				girarRandom();
			}
			if (colicionEn(objetos) == 3) {// colicion abajo
				// System.out.println("colicion abajo");
				enemyTank.girar(Orientation.UP);
				enemyTank.moverse(Orientation.UP);
				enemyTank.girar(Orientation.LEFT);
				girarRandom();
			}
			if (colicionEn(objetos) == 4) {// colicion izquierda
				// System.out.println("colicion izquierda");
				enemyTank.girar(Orientation.RIGHT);
				enemyTank.moverse(Orientation.RIGHT);
				enemyTank.girar(Orientation.UP);
				girarRandom();
			}
		}
	}

	/*** RANDOM GIRO ***/
	public void girarRandom() {
		// generador de numeros aleatorios
		Random generadorAleatorios = new Random();

		// genera un numero entre 1 y 4 y lo guarda en la variable
		// numeroAleatorio
		int numeroAleatorio = 1 + generadorAleatorios.nextInt(4);
		// System.out.println("numeroAleatorio: "+ numeroAleatorio);
		if ((numeroAleatorio == 1) && (!enemyTank.getOrientation().equals(Orientation.UP))) {
			enemyTank.moverse(Orientation.UP);
			enemyTank.girar(Orientation.UP);
		}
		if ((numeroAleatorio == 1) && (enemyTank.getOrientation().equals(Orientation.UP))) {
			enemyTank.moverse(Orientation.DOWN);
			enemyTank.girar(Orientation.DOWN);
		}
		if ((numeroAleatorio == 2) && (!enemyTank.getOrientation().equals(Orientation.RIGHT))) {
			enemyTank.moverse(Orientation.RIGHT);
			enemyTank.girar(Orientation.RIGHT);
		}
		if ((numeroAleatorio == 2) && (enemyTank.getOrientation().equals(Orientation.RIGHT))) {
			enemyTank.moverse(Orientation.LEFT);
			enemyTank.girar(Orientation.LEFT);
		}
		if ((numeroAleatorio == 3) && (!enemyTank.getOrientation().equals(Orientation.DOWN))) {
			enemyTank.girar(Orientation.DOWN);
			enemyTank.moverse(Orientation.DOWN);
		}
		if ((numeroAleatorio == 3) && (enemyTank.getOrientation().equals(Orientation.DOWN))) {
			enemyTank.girar(Orientation.UP);
			enemyTank.moverse(Orientation.UP);
		}
		if ((numeroAleatorio == 4) && (!enemyTank.getOrientation().equals(Orientation.LEFT))) {
			enemyTank.girar(Orientation.LEFT);
			enemyTank.moverse(Orientation.LEFT);
		}
		if ((numeroAleatorio == 4) && (enemyTank.getOrientation().equals(Orientation.LEFT))) {
			enemyTank.girar(Orientation.RIGHT);
			enemyTank.moverse(Orientation.RIGHT);
		}
	}
	
}
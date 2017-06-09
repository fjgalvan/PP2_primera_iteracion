package app.object;

import java.util.List;
import app.enums.Orientation;
import app.modelo.ObjetoGrafico;

public class DriverEasyEnemyTank extends DriverEnemyTank {

	public DriverEasyEnemyTank(Tank enemyTank) {
		super(enemyTank);
	}

	public void controlChoque() {
		switch(enemyTank.getOrientation()){
			case UP:
				ControlUp();
				if (CanMoveUp()) {
					enemyTank.girar(Orientation.RIGHT);
				}
				break;
			case RIGHT:
				ControlRight();
				if (CanMoveRight()) {
					enemyTank.girar(Orientation.DOWN);
				}
				break;
			case DOWN:
				ControlDown();
				if (CanMoveDown()) {
					enemyTank.girar(Orientation.LEFT);
				}
				break;
			case LEFT:
				ControlLeft();
				if (CanMoveLeft()) {
					enemyTank.girar(Orientation.UP);
				}
				break;
		}
	}

	public void ControlTank(List<ObjetoGrafico> objetos) {
		if (hayColisionConUnObjeto(objetos)) {
			// girarRandom();
			if (colicionEn(objetos) == 1) {// colicion arriba
				// System.out.println("colicion arriba");
				enemyTank.girar(Orientation.DOWN);
				enemyTank.moverse(Orientation.DOWN);
				enemyTank.girar(Orientation.RIGHT);
			}
			if (colicionEn(objetos) == 2) {// colicion derecha
				// System.out.println("colicion derecha");
				enemyTank.girar(Orientation.LEFT);
				enemyTank.moverse(Orientation.LEFT);
				enemyTank.girar(Orientation.DOWN);
			}
			if (colicionEn(objetos) == 3) {// colicion abajo
				// System.out.println("colicion abajo");
				enemyTank.girar(Orientation.UP);
				enemyTank.moverse(Orientation.UP);
				enemyTank.girar(Orientation.LEFT);
			}
			if (colicionEn(objetos) == 4) {// colicion izquierda
				// System.out.println("colicion izquierda");
				enemyTank.girar(Orientation.RIGHT);
				enemyTank.moverse(Orientation.RIGHT);
				enemyTank.girar(Orientation.UP);
			}
		}
	}
}

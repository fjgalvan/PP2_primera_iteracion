package app.estructura;

import java.awt.Point;

import org.junit.Test;

import app.enums.TipoEstructura;

public class TestEstructura {
	@Test
	public void testEstructura() {
		Point coordinate = new Point(30, 50);
		Point size= new Point(20,20);
		TipoEstructura tipo2 = null;
		TipoDeEstructura tipo= new TipoDeEstructura(tipo2, false, false);
		Estructura est= new Estructura(coordinate, size, "/imagen/tank.png", null);
		tipo.getTipo();
		tipo.setTipo(tipo2);
		tipo.isColisicionBullet();
		tipo.isColisicionTank();
		tipo.setColisicionBullet(false);
		tipo.setColisicionTank(false);
		est.getTipoDeEstructura();
		est.setTipoDeEstructura(est.getTipoDeEstructura());
	}
}

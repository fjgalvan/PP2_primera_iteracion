package app.estructura;

import java.awt.Color;

import app.interfaces.Estructura;
import app.modelo.ObjetoGrafico;

public class EstructuraAgua extends ObjetoGrafico implements Estructura {

	public EstructuraAgua() {
		super("imagen/agua.png", Color.BLUE);
	}

	@Override
	public void colisionBala() {
		// TODO Auto-generated method stub

	}

	@Override
	public void destruir() {
		// TODO Auto-generated method stub

	}

}

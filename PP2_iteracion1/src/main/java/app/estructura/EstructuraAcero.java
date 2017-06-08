package app.estructura;

import java.awt.Color;

import app.interfaces.Estructura;
import app.modelo.ObjetoGrafico;

public class EstructuraAcero extends ObjetoGrafico implements Estructura {

	public EstructuraAcero() {
		super("imagen/acero.png", Color.ORANGE);
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
